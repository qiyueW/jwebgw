package configuration.filter;

import system.web.filter.chain.config.ConfigurationFilter;
import system.web.filter.chain.config.LinkFilters;

public class MyConfigurationFilter extends ConfigurationFilter {

    @Override
    public void configuration(LinkFilters lf) {

//------------------查询操作参数校验过滤-----------------------------------------------------------------
        //使用简要：以CheckUpdate_Select结束的方法名。使用范围：检查发起修改操作的查询id是否为空、为null、长度是否合法...如果不通过，直接中止服务
        lf.addFiltersByMethod(super.regex_endWithX("CheckUpdateSelect"), configuration.filter.check.CheckUpdateSelect.class);
        lf.addFiltersByMethod(super.regex_includeX("ListJSON"), configuration.filter.json.ListJson.class);
        
//------------------插件之视图解析集合-------------------------------------------------------------------
        //(1)  ligerui grid视图解析。【方法名】包含UIGrid字符即可    使用组件解析的key的集合路径所在 : plugins.ligerui.LigeruiKey
        lf.addFiltersByMethod(super.regex_includeX("UIGrid"), plugins.ligerui.filter.LigeruiGrid_BUTTOM.class);

//------------------内置功能开发集合-------------------------------------------------------------------        
        //        第一个参数/x/ss表示以此开头的请求路径，将绑定第二个参数所有的过滤器
        lf.addFiltersByURL(super.regex_startWithX("/filedow/big"), configuration.filter.file.BigFileDownload.class);

    }

}
