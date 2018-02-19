package power.bean;

import system.base.annotation.Table;

@Table
public class JSDJ {

    @system.base.annotation.ID
    private String jsdj_zj;//主键
    private String jsdj_dm;//代号
    private String jsdj_mc;//名称
    private String jsdj_bz;//备注
    
    public String getJsdj_zj() {
        return jsdj_zj;
    }

    public void setJsdj_zj(String jsdj_zj) {
        this.jsdj_zj = jsdj_zj;
    }

    public String getJsdj_dm() {
        return jsdj_dm;
    }

    public void setJsdj_dm(String jsdj_dm) {
        this.jsdj_dm = jsdj_dm;
    }

    public String getJsdj_mc() {
        return jsdj_mc;
    }

    public void setJsdj_mc(String jsdj_mc) {
        this.jsdj_mc = jsdj_mc;
    }

    public String getJsdj_bz() {
        return jsdj_bz;
    }

    public void setJsdj_bz(String jsdj_bz) {
        this.jsdj_bz = jsdj_bz;
    }
    
}
