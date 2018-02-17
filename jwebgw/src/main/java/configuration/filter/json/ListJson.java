package configuration.filter.json;

import java.util.List;

import system.base.beanjson.JCJSON;
import system.web.JWeb;
import system.web.filter.chain.FilterModel;

/**
 *ligerui过滤器
 * @author wangchunzi
 */
public class ListJson extends FilterModel {

    {
        super.setLocation(LOCATION_BUTTOM);
    }
    @Override
    public void doFilter(JWeb jw) {
        Object list;
        list= jw.request.getAttribute("ListJson");
        if (null != list) {
            List str = (List)list;
            jw.request.removeAttribute("ListJson");
            jw.printOne(JCJSON.toSimpleJSON(str));
//            System.out.println("in the there:"+JCJSON.toSimpleJSON(str));
            jw.endFilter();
        }
    }
}
