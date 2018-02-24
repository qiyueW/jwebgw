package wx.web.cc.service;

import java.util.List;
import wx.web.cc.bean.Mybeanfield;

/**
 *
 * @author adm.wangchunzi
 */
public class MybeanService {

    public static String toBeanData(List<Mybeanfield> list) {
        StringBuilder sb = new StringBuilder();
        StringBuilder me = new StringBuilder();
        for (Mybeanfield bf : list) {
            sb.append(bf.getC_zyy()).append(" ").append(bf.getC_lx()).append(" ").append(bf.getC_mc()).append(";\n");

            me.append(getInfo("取得 " + bf.getC_bz(), bf.getC_lx()))
                    .append("\npublic ").append(bf.getC_lx()).append(" ").append(bf.getC_getmethod()).append("(){\n")
                    .append("return this.").append(bf.getC_mc()).append(";\n")
                    .append("}\n")
                    .append(getInfo("设置 " + bf.getC_bz(), null, bf.getC_mc() + " " + bf.getC_lx()))
                    .append("\npublic ").append("void ").append(bf.getC_setmethod()).append("(").append(bf.getC_lx()).append(" ").append(bf.getC_mc()).append("){\n")
                    .append(" this.").append(bf.getC_mc()).append("=").append(bf.getC_mc()).append(";\n")
                    .append("}\n");
        }
        sb.append(me);
        return sb.toString();
    }
    
//    CREATE TABLE IF NOT EXISTS `User` (
//    		  `user_id` char(24) NOT NULL,
//    		  `role_id` varchar(5000) DEFAULT NULL,
//    		  `power_id` varchar(5000) DEFAULT NULL,
//    		  PRIMARY KEY (`user_id`)
//    		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//    
    public static String toSQLData(List<Mybeanfield> list,String TableName) {
    	if(null==list||list.isEmpty()) {
    		return "";
    	}
        StringBuilder sb = new StringBuilder();
        StringBuilder index = new StringBuilder("\n");
        for (Mybeanfield bf : list) {
        	setSQLField(bf,sb,index);
        }
        sb.append(index);
        return 
        		"CREATE TABLE IF NOT EXISTS `"+TableName+"`(\n"+sb.substring(2)
               +"\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
    }
    
    
    public static void setSQLField(Mybeanfield bf,StringBuilder sb,StringBuilder index) {
    	switch(bf.getT_lx()) {
	    	case "VARCHAR":
	    	case "CHAR":
	    		sb.append("\n,`"+bf.getT_mc()+"` ").append(bf.getT_lx()).append("(").append(bf.getT_cd()).append(")")
	    		.append(bf.getT_yxkong().equalsIgnoreCase("s")?" DEFAULT NULL":" NOT NULL");
	    		break;
			default:{
	    		sb.append("\n,`"+bf.getT_mc()+"` ").append(bf.getT_lx()).append("    ")
	    		.append(bf.getT_yxkong().equalsIgnoreCase("s")?" DEFAULT NULL":" NOT NULL");
			}
    	}
    	switch(bf.getT_sy()) {
    	case "s":index .append("\n,KEY        `"+bf.getT_mc()+"` (`"+bf.getT_mc()+"`)");break;
    	case "wy":index.append("\n,UNIQUE KEY `"+bf.getT_mc()+"` (`"+bf.getT_mc()+"`)");break;
    	case "zj":index.append("\n,PRIMARY KEY (`"+bf.getT_mc()+"`)");break;
    	}
    }
    

    /**
     * 生成标注
     *
     * @param info     如果之间有;;号，视为换行
     * @param returnLX String .返回的类型 例如传入 String
     * @param param    String[] .方法传入的参数。如何传入  param String[] 
     * @return String
     */
    public static String getInfo(String info, String returnLX, String... param) {
        StringBuilder sb = new StringBuilder();
        sb.append("/**\n");
        int count = 0;
        for (String istr : info.split(";;")) {
            if (count == 0) {
                sb.append("* ").append(istr).append("\n");
            } else {
                sb.append("* ").append(istr).append("<p>\n");
            }
            count++;
        }
        if (null != param && param.length > 0) {
            for (String pstr : param) {
                sb.append("* @param ").append(pstr).append("\n");
            }
        }
        if (null != returnLX && returnLX.length() > 0) {
            sb.append("* @return ").append(returnLX).append("\n");
        }
        sb.append("*/");
        return sb.toString();
    }
}