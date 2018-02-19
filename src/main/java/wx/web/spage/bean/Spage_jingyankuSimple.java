package wx.web.spage.bean;

import system.base.annotation.ID;

/**
 *
 * @author fly
 */
public class Spage_jingyankuSimple {

    @ID
    private String spage_jingyanku_zj;
    private String spage_jingyanku_biaoti;//标题
    private String spage_jingyanku_gjc;//关键词
//    private String spage_jingyanku_neirong;//内容
    private String spage_jingyanku_fabushijian;//发布时间
    private String spage_jingyanku_zhidanren;//制单人ID
    private String spage_jingyanku_zhidanren_zj;//制单人ID
    private String jingyankufl_id;//主键
    private String jingyankufl_name;//名称
    private String spage_jingyanku_zhidanshijian;//制单时间
    
    public String getSpage_jingyanku_zj() {
        return spage_jingyanku_zj;
    }

    public void setSpage_jingyanku_zj(String spage_jingyanku_zj) {
        this.spage_jingyanku_zj = spage_jingyanku_zj;
    }

    public String getSpage_jingyanku_biaoti() {
        return spage_jingyanku_biaoti;
    }

    public void setSpage_jingyanku_biaoti(String spage_jingyanku_biaoti) {
        this.spage_jingyanku_biaoti = spage_jingyanku_biaoti;
    }

    public String getSpage_jingyanku_gjc() {
        return spage_jingyanku_gjc;
    }

    public void setSpage_jingyanku_gjc(String spage_jingyanku_gjc) {
        this.spage_jingyanku_gjc = spage_jingyanku_gjc;
    }

    public String getSpage_jingyanku_fabushijian() {
        return spage_jingyanku_fabushijian;
    }

    public void setSpage_jingyanku_fabushijian(String spage_jingyanku_fabushijian) {
        this.spage_jingyanku_fabushijian = spage_jingyanku_fabushijian;
    }

    public String getSpage_jingyanku_zhidanren() {
        return spage_jingyanku_zhidanren;
    }

    public void setSpage_jingyanku_zhidanren(String spage_jingyanku_zhidanren) {
        this.spage_jingyanku_zhidanren = spage_jingyanku_zhidanren;
    }

    public String getSpage_jingyanku_zhidanren_zj() {
        return spage_jingyanku_zhidanren_zj;
    }

    public void setSpage_jingyanku_zhidanren_zj(String spage_jingyanku_zhidanren_zj) {
        this.spage_jingyanku_zhidanren_zj = spage_jingyanku_zhidanren_zj;
    }

    public String getJingyankufl_id() {
        return jingyankufl_id;
    }

    public void setJingyankufl_id(String jingyankufl_id) {
        this.jingyankufl_id = jingyankufl_id;
    }

    public String getJingyankufl_name() {
        return jingyankufl_name;
    }

    public void setJingyankufl_name(String jingyankufl_name) {
        this.jingyankufl_name = jingyankufl_name;
    }

    public String getSpage_jingyanku_zhidanshijian() {
        return spage_jingyanku_zhidanshijian;
    }

    public void setSpage_jingyanku_zhidanshijian(String spage_jingyanku_zhidanshijian) {
        this.spage_jingyanku_zhidanshijian = spage_jingyanku_zhidanshijian;
    }
}
