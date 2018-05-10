package plugins.easyui;

import java.util.List;

import plugins.easyui.vo.EasyuiPage;

import system.base.beanjson.JCJSON;
import system.web.JWeb;

/**
 *
 * @author wangchunzi
 */
final public class EasyuiService {

    private static final String EMPTYDATA = "{\"total\": \"0\",\"rows\":[]}";
    public final static String KEY_GRID_LIST = "#KEY_GRID_LIST";
    public final static String KEY_GRID_COUNT = "#KEY_GRID_COUNT";

    final public static String formatGrid(List<?> rsList, int count) {
        return null == rsList || rsList.isEmpty() ? EMPTYDATA : "{\"total\": \"" + count + "\",\"rows\":" + JCJSON.toSimpleJSON(rsList) + "}";
    }

    final public static String formatGrid(List<?> rsList) {
        return null == rsList || rsList.isEmpty() ? EMPTYDATA : "{\"total\": \"" + rsList.size() + "\",\"rows\":" + JCJSON.toSimpleJSON(rsList) + "}";
    }

    /**
     * 取得 easyui传来的分页数据
     *
     * @param jw
     * @return EasyuiPage
     */
    final public static EasyuiPage getPage(JWeb jw) {
        return new EasyuiPage(jw.getInt("page", 1), jw.getInt("rows", 10));
    }

    final public static String getOrderBy(JWeb jw) {
        String sortname = jw.request.getParameter("sort");
        if (null == sortname) {
            return "";
        }
        String sortorder = jw.request.getParameter("order");
        return "order by " + sortname + " " + (null == sortorder ? "ASC" : sortorder);
    }
}
