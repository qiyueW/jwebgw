package wx.web.cc.bean;

@system.base.annotation.Table
public class Mybeanfield {

    @system.base.annotation.ID
    private String mybeanfield_zj;//主键
    private String mybean_zj;//父主键
    private String mybean_mc;//父名称
    private String mybeanfield_bz;//备注
    private String mybeanfield_dateformat;//Date格式

    private String c_zyy;//作用域
    private String c_lx;//类型
    private String c_mc;//属性名
    private String c_bz;//备注
    private String c_setmethod;//set方法
    private String c_getmethod;//get方法

    private String t_mc;//t属性名 锁定等于 c属性名
    private String t_lx;//t类型
    private String t_sy;//t索引
    private String t_yxkong;//是否为空
    private String t_bz;//t备注

    private String v_zzbds;//v正则表达式
    private String v_cuowuxx;//v错误信息
    private String v_bxjiancha;//v必须检查
    
    
    
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//     private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//
//    private String v_AAAA;//

}
