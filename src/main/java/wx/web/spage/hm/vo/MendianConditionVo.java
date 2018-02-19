package wx.web.spage.hm.vo;

import system.base.StringTool;
import system.base.str.WhereStr;
import system.web.JWeb;

public class MendianConditionVo {

    public final String diliquyu_id;
    public final String zt;
    public final String key;

    public MendianConditionVo(JWeb jw) {
        String v;
        v = jw.getString("diliquyu_id");
        this.diliquyu_id = null == v ? null : StringTool.replaceDToDDD(v);
        v = jw.getString("zt");
        zt = null == v ? "1" : v;//没有值,填写状态为1 启用
        v = jw.getString("key");
//        spage_mendian_quancheng
        StringBuilder sb = new StringBuilder();
        if (null != v && !v.isEmpty()) {
            for (String str : v.split(" ")) {
                if (str.trim().length() > 0) {
                    sb.append(" AND spage_mendian_quancheng LIKE '%").append(str).append("%'");
                }
            }
        }
        key = sb.length() > 0 ? sb.substring(4) : null;
    }

    public String getWhere() {
        WhereStr ssq = StringTool.OpenWhereStr();

        ssq
                .putLjf_IN(WhereStr.valueX.notNullAndNotEmpty, "AND", "diliquyu_id", this.diliquyu_id)
                .putBjf(WhereStr.valueX.notNullAndNotEmpty, "AND", "spage_mendian_zt", "=", zt)
                .putAND(key);

        return ssq.geteWhereSQL();
    }
}
