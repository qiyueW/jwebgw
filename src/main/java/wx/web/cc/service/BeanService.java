package wx.web.cc.service;

import configuration.DBO;
import java.util.List;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;
import wx.web.cc.service.svo.BeanFieldStrngVO;
import wx.web.cc.service.svo.BeanSVO;

/**
 *
 * @author adm.wangchunzi
 */
public class BeanService {
	
	private static String toFormatClassName_(String str) {
        if (!str.startsWith("?")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        BeanFieldStrngVO vo = new BeanFieldStrngVO(str);
        String[] cha = vo.value.split("");
        System.out.println("this key:" + vo.key);
        String ll;
        int i=0;
        for (String c : cha) {
            ll = c.toLowerCase();
            if (c.equals(ll)) {
                sb.append(c);
            } else {
            	if(i==0) {
            		sb.append(ll);
            		i++;
            	}else {
            		sb.append(vo.key).append(ll);
            	}
            }
        }
        System.out.println("this v:" + sb);
        return sb.toString();
    }
//	public static void main(String args[]) {
//		String str="?_MySubjectCommon";
//		System.out.println("翻译后的："+toFormatClassName_(str));
//	}
	
//=============================翻译区==============================================    
    /**
     * bean属性（表头，表体） 添加时，进行自我翻译
     *
     * @param bean bean-表头
     * @param list bean-表体
     * @return BeanSVO
     */
    public static BeanSVO engineToAdd(Bean bean, List<Bean2> list) {
        Map<String, String> mapkv = EngineService.getDefaultEngineData();
        mapkv.put("&#39;", "'");
        mapkv.put("[?_CcC]", "?_"+toFormatClassName_(bean.getBean_mc()));// 把 MySubjectCommon 变成 my_subject_common 这种类名
        mapkv.put("[?c?]", bean.getBean_mc().toLowerCase());//小写bean名
        mapkv.put("[?c?1]", bean.getBean_mc().substring(0, 1).toLowerCase() + bean.getBean_mc().substring(1));//小写第1个字符 bean名
        //bean 参加翻译
        VelocityContext context = EngineService.getVelocityContext();
        //bean-表头 参加翻译
        EngineService.setMyself(context, bean);//设置自我翻译
        bean = EngineService.toWorkT(bean, context, mapkv);//表头自我翻译
//------------------------------------------------------
        context = EngineService.getVelocityContext();//自我翻译后，重新来过-给表体进行翻译
        //bean-表头 翻译后，再度参与表体的翻译
        EngineService.setMyself(context, bean);//设置自我翻译
        //bean-表体 参加自我翻译
        EngineService.setMyself(context, list, "getBean2_key", "getBean2_value");
        //翻译后的对象
        list = EngineService.toWorkT(list, context, mapkv);
//        String str = modelData.replace("&#39;", "'").replace("&#34;", "\"").replace("&#60;", "<").replace("&#62;", ">");//.replace("&#92;", "\\")
        return new BeanSVO(bean, list);
    }

//=============================DB业务区==============================================    
    /**
     * 通过分类key（包含式）方式取得相关模板的预设值的表头。
     *
     * @param flkey
     * @return List
     */
    public static List<Bean> getHead(String flkey) {
        return DBO.service.S.selectByCondition(Bean.class, "WHERE mypackage_id IN('" + flkey + "') ORDER BY bean_px ASC");
    }

    /**
     * 通过主键取得Bean对象
     *
     * @param bean_zj
     * @return
     */
    public static Bean getBean(String bean_zj) {
        return DBO.service.S.selectOneByID(Bean.class, bean_zj);
    }

    /**
     * 通过表头ID,取得表体ID
     *
     * @param bean_zj
     * @return
     */
    public static List<Bean2> getBody(String bean_zj) {
        return DBO.service.S.selectByCondition(Bean2.class, "WHERE bean_zj IN('" + bean_zj + "')");
    }

    public static int[] topx(String[] ids) {
        String[] sqldata = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            sqldata[i] = "UPDATE Bean SET bean_px=" + i + " WHERE bean_zj='" + ids[i] + "'";
        }
        return DBO.service.ADUS.executeBatch(sqldata);
    }

//    public static Bean selectOne(final String zj) {
//        return DBO.service.S.selectOneByID(Bean.class, zj);
//    }
//=============================方案引用业务区============================================== 
    
    
}
