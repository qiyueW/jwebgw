package wx.web.cc.bean;

@system.base.annotation.Table
public class Mybean {

    @system.base.annotation.ID
    private String mybean_zj;// 主键
    private Integer mybean_px;// 排序
    private String mypackage_id;// 外键（归属包）
    private String mybean_mc;// 类名
    private String mybean_bz;// 备注
    private String package_bean;// bean类包
    private String package_soo;// soo/dao 类包
    private String name_soo;// soo/dao 类
    private String package_service;// service类包
    private String name_service;// service类
    private String package_hm;// hm类包
    private String name_hmA;// hmA类
    private String name_hmD;// hmD类
    private String name_hmU;// hmU类
    private String name_hmS;// hmS类
    private String package_validate;// validate类包
    private String name_validate;// validate类
    private String package_cache;// cache类包
    private String name_cache;// cache类
    private String package_vo;// vo类包
    private String name_vo;// vo类
    private String vpackage_admin;// jsp/html包
//    private String vname_admin;// jsp/html包
    private String vname_adminA;// jsp/html_A
    private String vname_adminD;// jsp/html_D
    private String vname_adminS;// jsp/html_S
    private String vname_adminU;// jsp/html_U
    private String vpackage_admin_js;// js包
    private String vname_admin_js;// js
    private String vpackage_admin_css;// css包
    private String vname_admin_css;// css
    private String power_code;// 模块权限代码
    private String power_codeA;// 权限代码A
    private String power_codeD;// 权限代码D
    private String power_codeS;// 权限代码S
    private String power_codeU;// 权限代码U

    /**
     * 设置 主键
     *
     * @param mybean_zj String
     */
    public void setMybean_zj(String mybean_zj) {
        this.mybean_zj = mybean_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getMybean_zj() {
        return this.mybean_zj;
    }

    /**
     * 设置 排序
     *
     * @param mybean_px Integer
     */
    public void setMybean_px(Integer mybean_px) {
        this.mybean_px = mybean_px;
    }

    /**
     * 取得 排序
     *
     * @return Integer
     */
    public Integer getMybean_px() {
        return this.mybean_px;
    }

    /**
     * 设置 外键（归属包）
     *
     * @param mypackage_id String
     */
    public void setMypackage_id(String mypackage_id) {
        this.mypackage_id = mypackage_id;
    }

    /**
     * 取得 外键（归属包）
     *
     * @return String
     */
    public String getMypackage_id() {
        return this.mypackage_id;
    }

    /**
     * 设置 类名
     *
     * @param mybean_mc String
     */
    public void setMybean_mc(String mybean_mc) {
        this.mybean_mc = mybean_mc;
    }

    /**
     * 取得 类名
     *
     * @return String
     */
    public String getMybean_mc() {
        return this.mybean_mc;
    }

    /**
     * 设置 备注
     *
     * @param mybean_bz String
     */
    public void setMybean_bz(String mybean_bz) {
        this.mybean_bz = mybean_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getMybean_bz() {
        return this.mybean_bz;
    }

    /**
     * 设置 bean类包
     *
     * @param package_bean String
     */
    public void setPackage_bean(String package_bean) {
        this.package_bean = package_bean;
    }

    /**
     * 取得 bean类包
     *
     * @return String
     */
    public String getPackage_bean() {
        return this.package_bean;
    }

    /**
     * 设置 soo/dao 类包
     *
     * @param package_soo String
     */
    public void setPackage_soo(String package_soo) {
        this.package_soo = package_soo;
    }

    /**
     * 取得 soo/dao 类包
     *
     * @return String
     */
    public String getPackage_soo() {
        return this.package_soo;
    }

    /**
     * 设置 soo/dao 类
     *
     * @param name_soo String
     */
    public void setName_soo(String name_soo) {
        this.name_soo = name_soo;
    }

    /**
     * 取得 soo/dao 类
     *
     * @return String
     */
    public String getName_soo() {
        return this.name_soo;
    }

    /**
     * 设置 service类包
     *
     * @param package_service String
     */
    public void setPackage_service(String package_service) {
        this.package_service = package_service;
    }

    /**
     * 取得 service类包
     *
     * @return String
     */
    public String getPackage_service() {
        return this.package_service;
    }

    /**
     * 设置 service类
     *
     * @param name_service String
     */
    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    /**
     * 取得 service类
     *
     * @return String
     */
    public String getName_service() {
        return this.name_service;
    }

    /**
     * 设置 hm类包
     *
     * @param package_hm String
     */
    public void setPackage_hm(String package_hm) {
        this.package_hm = package_hm;
    }

    /**
     * 取得 hm类包
     *
     * @return String
     */
    public String getPackage_hm() {
        return this.package_hm;
    }

    /**
     * 设置 hmA类
     *
     * @param name_hmA String
     */
    public void setName_hmA(String name_hmA) {
        this.name_hmA = name_hmA;
    }

    /**
     * 取得 hmA类
     *
     * @return String
     */
    public String getName_hmA() {
        return this.name_hmA;
    }

    /**
     * 设置 hmD类
     *
     * @param name_hmD String
     */
    public void setName_hmD(String name_hmD) {
        this.name_hmD = name_hmD;
    }

    /**
     * 取得 hmD类
     *
     * @return String
     */
    public String getName_hmD() {
        return this.name_hmD;
    }

    /**
     * 设置 hmU类
     *
     * @param name_hmU String
     */
    public void setName_hmU(String name_hmU) {
        this.name_hmU = name_hmU;
    }

    /**
     * 取得 hmU类
     *
     * @return String
     */
    public String getName_hmU() {
        return this.name_hmU;
    }

    /**
     * 设置 hmS类
     *
     * @param name_hmS String
     */
    public void setName_hmS(String name_hmS) {
        this.name_hmS = name_hmS;
    }

    /**
     * 取得 hmS类
     *
     * @return String
     */
    public String getName_hmS() {
        return this.name_hmS;
    }

    /**
     * 设置 validate类包
     *
     * @param package_validate String
     */
    public void setPackage_validate(String package_validate) {
        this.package_validate = package_validate;
    }

    /**
     * 取得 validate类包
     *
     * @return String
     */
    public String getPackage_validate() {
        return this.package_validate;
    }

    /**
     * 设置 validate类
     *
     * @param name_validate String
     */
    public void setName_validate(String name_validate) {
        this.name_validate = name_validate;
    }

    /**
     * 取得 validate类
     *
     * @return String
     */
    public String getName_validate() {
        return this.name_validate;
    }

    /**
     * 设置 cache类包
     *
     * @param package_cache String
     */
    public void setPackage_cache(String package_cache) {
        this.package_cache = package_cache;
    }

    /**
     * 取得 cache类包
     *
     * @return String
     */
    public String getPackage_cache() {
        return this.package_cache;
    }

    /**
     * 设置 cache类
     *
     * @param name_cache String
     */
    public void setName_cache(String name_cache) {
        this.name_cache = name_cache;
    }

    /**
     * 取得 cache类
     *
     * @return String
     */
    public String getName_cache() {
        return this.name_cache;
    }

    /**
     * 设置 vo类包
     *
     * @param package_vo String
     */
    public void setPackage_vo(String package_vo) {
        this.package_vo = package_vo;
    }

    /**
     * 取得 vo类包
     *
     * @return String
     */
    public String getPackage_vo() {
        return this.package_vo;
    }

    /**
     * 设置 vo类
     *
     * @param name_vo String
     */
    public void setName_vo(String name_vo) {
        this.name_vo = name_vo;
    }

    /**
     * 取得 vo类
     *
     * @return String
     */
    public String getName_vo() {
        return this.name_vo;
    }

    /**
     * 设置 jsp/html包
     *
     * @param vpackage_admin String
     */
    public void setVpackage_admin(String vpackage_admin) {
        this.vpackage_admin = vpackage_admin;
    }

    /**
     * 取得 jsp/html包
     *
     * @return String
     */
    public String getVpackage_admin() {
        return this.vpackage_admin;
    }

//    /**
//     * 设置 jsp/html包
//     *
//     * @param vname_admin String
//     */
//    public void setVname_admin(String vname_admin) {
//        this.vname_admin = vname_admin;
//    }
//
//    /**
//     * 取得 jsp/html包
//     *
//     * @return String
//     */
//    public String getVname_admin() {
//        return this.vname_admin;
//    }

    /**
     * 设置 jsp/html_A
     *
     * @param vname_adminA String
     */
    public void setVname_adminA(String vname_adminA) {
        this.vname_adminA = vname_adminA;
    }

    /**
     * 取得 jsp/html_A
     *
     * @return String
     */
    public String getVname_adminA() {
        return this.vname_adminA;
    }

    /**
     * 设置 jsp/html_D
     *
     * @param vname_adminD String
     */
    public void setVname_adminD(String vname_adminD) {
        this.vname_adminD = vname_adminD;
    }

    /**
     * 取得 jsp/html_D
     *
     * @return String
     */
    public String getVname_adminD() {
        return this.vname_adminD;
    }

    /**
     * 设置 jsp/html_S
     *
     * @param vname_adminS String
     */
    public void setVname_adminS(String vname_adminS) {
        this.vname_adminS = vname_adminS;
    }

    /**
     * 取得 jsp/html_S
     *
     * @return String
     */
    public String getVname_adminS() {
        return this.vname_adminS;
    }

    /**
     * 设置 jsp/html_U
     *
     * @param vname_adminU String
     */
    public void setVname_adminU(String vname_adminU) {
        this.vname_adminU = vname_adminU;
    }

    /**
     * 取得 jsp/html_U
     *
     * @return String
     */
    public String getVname_adminU() {
        return this.vname_adminU;
    }

    /**
     * 设置 js包
     *
     * @param vpackage_admin_js String
     */
    public void setVpackage_admin_js(String vpackage_admin_js) {
        this.vpackage_admin_js = vpackage_admin_js;
    }

    /**
     * 取得 js包
     *
     * @return String
     */
    public String getVpackage_admin_js() {
        return this.vpackage_admin_js;
    }

    /**
     * 设置 js
     *
     * @param vname_admin_js String
     */
    public void setVname_admin_js(String vname_admin_js) {
        this.vname_admin_js = vname_admin_js;
    }

    /**
     * 取得 js
     *
     * @return String
     */
    public String getVname_admin_js() {
        return this.vname_admin_js;
    }

    /**
     * 设置 css包
     *
     * @param vpackage_admin_css String
     */
    public void setVpackage_admin_css(String vpackage_admin_css) {
        this.vpackage_admin_css = vpackage_admin_css;
    }

    /**
     * 取得 css包
     *
     * @return String
     */
    public String getVpackage_admin_css() {
        return this.vpackage_admin_css;
    }

    /**
     * 设置 css
     *
     * @param vname_admin_css String
     */
    public void setVname_admin_css(String vname_admin_css) {
        this.vname_admin_css = vname_admin_css;
    }

    /**
     * 取得 css
     *
     * @return String
     */
    public String getVname_admin_css() {
        return this.vname_admin_css;
    }

    /**
     * 设置 模块权限代码
     *
     * @param power_code String
     */
    public void setPower_code(String power_code) {
        this.power_code = power_code;
    }

    /**
     * 取得 模块权限代码
     *
     * @return String
     */
    public String getPower_code() {
        return this.power_code;
    }

    /**
     * 设置 权限代码A
     *
     * @param power_codeA String
     */
    public void setPower_codeA(String power_codeA) {
        this.power_codeA = power_codeA;
    }

    /**
     * 取得 权限代码A
     *
     * @return String
     */
    public String getPower_codeA() {
        return this.power_codeA;
    }

    /**
     * 设置 权限代码D
     *
     * @param power_codeD String
     */
    public void setPower_codeD(String power_codeD) {
        this.power_codeD = power_codeD;
    }

    /**
     * 取得 权限代码D
     *
     * @return String
     */
    public String getPower_codeD() {
        return this.power_codeD;
    }

    /**
     * 设置 权限代码S
     *
     * @param power_codeS String
     */
    public void setPower_codeS(String power_codeS) {
        this.power_codeS = power_codeS;
    }

    /**
     * 取得 权限代码S
     *
     * @return String
     */
    public String getPower_codeS() {
        return this.power_codeS;
    }

    /**
     * 设置 权限代码U
     *
     * @param power_codeU String
     */
    public void setPower_codeU(String power_codeU) {
        this.power_codeU = power_codeU;
    }

    /**
     * 取得 权限代码U
     *
     * @return String
     */
    public String getPower_codeU() {
        return this.power_codeU;
    }
}
