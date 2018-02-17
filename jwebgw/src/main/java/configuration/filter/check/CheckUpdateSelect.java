package configuration.filter.check;

import configuration.KeyModel;
import system.web.JWeb;
import system.web.filter.chain.FilterModel;

/**
 *
 * @author wangchunzi
 */
public class CheckUpdateSelect extends FilterModel {

    {
        super.setLocation(LOCATION_TOP);
    }

    @Override
    public void doFilter(JWeb jw) { 
        String sid = jw.request.getParameter(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);
//        System.out.println("接受我的检查吧!!!!!!!!!"+CheckUpdateSelect.class.getName());
        if (null == sid || sid.isEmpty() || sid.length() != 24) {
            jw.endFilter();
        }
    }

}
