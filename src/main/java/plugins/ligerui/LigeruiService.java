package plugins.ligerui;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import plugins.ligerui.vo.LigerUIPage;
import system.base.beanjson.JCJSON;

/**
 *
 * @author wangchunzi
 */
final public class LigeruiService {

    /**
     * 返回 orderby xx desc|asc 或 空
     *
     * @param req
     * @return
     */
    final public static String getOrderBy(HttpServletRequest req) {
        String sortname = req.getParameter(LigeruiConfig.sortnameParmName);
        if (null == sortname) {
            return "";
        }
        String sortorder = req.getParameter(LigeruiConfig.sortorderParmName);
        return "order by " + sortname + " " + (null == sortorder ? "ASC" : sortorder);
    }

    final public static LigerUIPage getPage(HttpServletRequest req) {
        LigerUIPage obj = new LigerUIPage();
        obj.page = getParam(req.getParameter(LigeruiConfig.pageParmName), 1);
        obj.pagesize = getParam(req.getParameter(LigeruiConfig.pagesizeParmName), LigeruiConfig.pagesizeDefualtValue);
        return obj;
    }

    final public static String toJson(List req) {
        return "{\"Rows\":" + JCJSON.toSimpleJSON(req) + ",\"" + LigeruiConfig.record + "\":\"" + req.size() + "\"}";
    }

    final public static String toJson(List req, final int count) {
        return "{\"Rows\":" + JCJSON.toSimpleJSON(req) + ",\"" + LigeruiConfig.record + "\":\"" + count + "\"}";
    }

    private static int getParam(String paramValue, int i) {
        return Pattern.compile("[0-9]+").matcher(paramValue).matches() ? Integer.parseInt(paramValue) : i;
    }
}
