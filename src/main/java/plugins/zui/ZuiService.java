package plugins.zui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import system.base.beanjson.JCJSON;

/**
 *
 * @author wangchunzi
 */
final public class ZuiService {

	final public static String zuiConfig(HttpServletRequest req,List<?> rsList) {
		String fm="{\"result\": \"success\",\r\n" + 
				"\"data\":"+JCJSON.toSimpleJSON(rsList)+"," +
				"\"message\": \"error\"," + 
				"\"pager\": {" + 
				" \"page\": 1, " + //          // 当前数据对应的页码\r\n
				" \"recTotal\": 1001," +     // 总的数据数目\r\n
				" \"recPerPage\": 10" +     // 每页数据数目\r\n
				" }" + 
				"}";
		return fm;
	}
}
