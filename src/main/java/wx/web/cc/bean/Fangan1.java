package wx.web.cc.bean;

import java.util.Date;

@system.base.annotation.Table
public class Fangan1 {

    private  String fanganfl_id ;// 分类外键
    private  String fanganfl_name ;// 方案分类
    @system.base.annotation.ID
    private  String fangan1_zj ;// 主键
    private  String fangan1_mc ;// 方案名
    private  String fangan1_bz ;// 备注
    private  String fangan1_zt ;// 状态
    private  String ry_id ;// 方案制定人主键
    private  String ry_name ;// 方案制定人名称
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")  
    private  Date fangan1_zhidanshijian ;// 制单时间
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")  
    private  Date fangan1_shenpishijian ;// 审批时间
    private  Integer fangan1_px ;// 方案分类

    public Integer getFangan1_px() {
        return fangan1_px;
    }

    public void setFangan1_px(Integer fangan1_px) {
        this.fangan1_px = fangan1_px;
    }
    /**
     * 设置 分类外键
     *
     * @param fanganfl_id String
     */
    public void setFanganfl_id(String fanganfl_id) {
        this.fanganfl_id=fanganfl_id;
    }

    /**
     * 取得 分类外键
     *
     * @return String
     */
    public String getFanganfl_id() {
        return this.fanganfl_id;
    }
    /**
     * 设置 方案分类
     *
     * @param fanganfl_name String
     */
    public void setFanganfl_name(String fanganfl_name) {
        this.fanganfl_name=fanganfl_name;
    }

    /**
     * 取得 方案分类
     *
     * @return String
     */
    public String getFanganfl_name() {
        return this.fanganfl_name;
    }
    /**
     * 设置 主键
     *
     * @param fangan1_zj String
     */
    public void setFangan1_zj(String fangan1_zj) {
        this.fangan1_zj=fangan1_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getFangan1_zj() {
        return this.fangan1_zj;
    }
    /**
     * 设置 方案名
     *
     * @param fangan1_mc String
     */
    public void setFangan1_mc(String fangan1_mc) {
        this.fangan1_mc=fangan1_mc;
    }

    /**
     * 取得 方案名
     *
     * @return String
     */
    public String getFangan1_mc() {
        return this.fangan1_mc;
    }
    /**
     * 设置 备注
     *
     * @param fangan1_bz String
     */
    public void setFangan1_bz(String fangan1_bz) {
        this.fangan1_bz=fangan1_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getFangan1_bz() {
        return this.fangan1_bz;
    }
    /**
     * 设置 状态
     *
     * @param fangan1_zt String
     */
    public void setFangan1_zt(String fangan1_zt) {
        this.fangan1_zt=fangan1_zt;
    }

    /**
     * 取得 状态
     *
     * @return String
     */
    public String getFangan1_zt() {
        return this.fangan1_zt;
    }
    /**
     * 设置 方案制定人主键
     *
     * @param ry_id String
     */
    public void setRy_id(String ry_id) {
        this.ry_id=ry_id;
    }

    /**
     * 取得 方案制定人主键
     *
     * @return String
     */
    public String getRy_id() {
        return this.ry_id;
    }
    /**
     * 设置 方案制定人名称
     *
     * @param ry_name String
     */
    public void setRy_name(String ry_name) {
        this.ry_name=ry_name;
    }

    /**
     * 取得 方案制定人名称
     *
     * @return String
     */
    public String getRy_name() {
        return this.ry_name;
    }
    /**
     * 设置 制单时间
     *
     * @param fangan1_zhidanshijian Date
     */
    public void setFangan1_zhidanshijian(Date fangan1_zhidanshijian) {
        this.fangan1_zhidanshijian=fangan1_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getFangan1_zhidanshijian() {
        return this.fangan1_zhidanshijian;
    }
    /**
     * 设置 审批时间
     *
     * @param fangan1_shenpishijian Date
     */
    public void setFangan1_shenpishijian(Date fangan1_shenpishijian) {
        this.fangan1_shenpishijian=fangan1_shenpishijian;
    }

    /**
     * 取得 审批时间
     *
     * @return Date
     */
    public Date getFangan1_shenpishijian() {
        return this.fangan1_shenpishijian;
    }
}