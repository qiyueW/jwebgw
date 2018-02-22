package plugins.easyui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import system.base.beanjson.JCJSON;

/**
 *
 * @author wangchunzi
 */
final public class EasyuiService {

	final public static String formatGrid(HttpServletRequest req,List<?> rsList,int count) {
		String fm="{\"total\": \""+count+"\",\"rows\":"+JCJSON.toSimpleJSON(rsList)+"}";
		return fm;
	}
}
