package wx.web.spage.hm.validate;

import java.util.Map;

import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

public class Spage_noticeValidate extends ValidateModel {

    public Spage_noticeValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super.put("spage_notice_zj", "[0-9]{24}", "主键丢失", false)
                .put("spage_notice_biaoti","[\\w\\W]{1,200}", "标题不能为空", true)
//                .put("spage_notice_fabushijian", "[0-9]{4}-[0-9]{2}-[0-9]{2}", "发生日期不正确:请采用 yyyy-MM-dd 时间格式 。如 1988-08-21 ", false)
                .put("spage_notice_neirong", "[\\w\\W]+", "请具体描述下问题", true)
                /* .put("twt_style", "[0|1|2|3]{1}", "状态不对", true) */;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
//        TWT twt = jw.getObject(TWT.class);
//        Date date = new Date();
//        if (null == twt.getTwt_date()) {
//            twt.setTwt_date(date);
//        }
//        twt.setTwt_cdate(date);
//        twt.setTwt_style(0);
//        jw.set("TWT", twt);
        return vr;
    }
}
