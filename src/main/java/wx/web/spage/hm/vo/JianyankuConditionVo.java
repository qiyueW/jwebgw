package wx.web.spage.hm.vo;

import system.base.StringTool;
import system.base.str.WhereStr;
import system.web.JWeb;

public class JianyankuConditionVo {

    public final String spage_jingyanku_zj;

    public JianyankuConditionVo(JWeb jw) {
        String v;
        v = jw.getString("spage_jingyanku_zj");
        this.spage_jingyanku_zj = null == v ? null :StringTool.replaceDToDDD(v);
    }

    public String getWhere() {
        WhereStr ssq = StringTool.OpenWhereStr();

        ssq
                .putLjf_IN(WhereStr.valueX.notNullAndNotEmpty, "AND", "pd_gdzcpdfa_zj", this.spage_jingyanku_zj);
        return ssq.geteWhereSQL();
    }
}
