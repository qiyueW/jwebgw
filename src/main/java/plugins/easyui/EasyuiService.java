package plugins.easyui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import plugins.easyui.vo.EasyuiPage;

import system.base.beanjson.JCJSON;
import system.web.JWeb;

/**
 *
 * @author wangchunzi
 */
final public class EasyuiService {

    final public static String formatGrid(List<?> rsList, int count) {
        String fm = "{\"total\": \"" + count + "\",\"rows\":" + JCJSON.toSimpleJSON(rsList) + "}";
        return fm;
    }

    /**
     * 取得 easyui传来的分页数据
     *
     * @param jw
     * @return EasyuiPage
     */
    final public static EasyuiPage getPage(JWeb jw) {
        return new EasyuiPage(jw.getInt("page",1), jw.getInt("rows", 10));
    }
}
