package configuration.filter.json;

import java.util.List;

import plugins.ligerui.LigeruiConfig;
import plugins.ligerui.LigeruiKey;
import system.base.beanjson.JCJSON;
import system.web.JWeb;
import system.web.filter.chain.FilterModel;

/**
 *ligerui过滤器
 * @author wangchunzi
 */
public class ObjectJSON_BUTTOM extends FilterModel {

    {
        super.setLocation(LOCATION_BUTTOM);
    }

    @Override
    public void doFilter(JWeb jw) {
        Object list,total;
        list= jw.request.getAttribute(LigeruiKey.ligerui_grid.key);
        if (null != list) {
            List str = (List)list;
            jw.request.removeAttribute(LigeruiKey.ligerui_grid.key);
            String count="}";
            total=jw.request.getAttribute(LigeruiKey.ligerui_grid_count.key);
            if(null!=total){
                count=",\""+LigeruiConfig.record+"\":\""+total.toString()+"\"}";
                jw.request.removeAttribute(LigeruiKey.ligerui_grid_count.key);
            }
            jw.printOne("{\"Rows\":"+JCJSON.toSimpleJSON(str)+count);
            jw.endFilter();
        }
    }

}
