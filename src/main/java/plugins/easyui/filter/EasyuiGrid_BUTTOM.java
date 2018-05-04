package plugins.easyui.filter;

import java.util.List;
import plugins.easyui.EasyuiService;

import system.web.JWeb;
import system.web.filter.chain.FilterModel;

/**
 * ligerui过滤器
 *
 * @author wangchunzi
 */
public class EasyuiGrid_BUTTOM extends FilterModel {

    {
        super.setLocation(LOCATION_BUTTOM);
    }

    @Override
    public void doFilter(JWeb jw) {
        Object list, total;
        list = jw.request.getAttribute(EasyuiService.KEY_GRID_LIST);
        if (null != list) {
            List listData = (List) list;
            jw.request.removeAttribute(EasyuiService.KEY_GRID_LIST);
            total = jw.request.getAttribute(EasyuiService.KEY_GRID_COUNT);
            if (null != total) {
                jw.request.removeAttribute(EasyuiService.KEY_GRID_COUNT);
                jw.printOne(EasyuiService.formatGrid(listData, (int) total));
            } else {
                jw.printOne(EasyuiService.formatGrid(listData));
            }
            jw.endFilter();
        }
    }

}
