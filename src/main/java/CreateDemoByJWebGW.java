
import jwc.*;
import jwc.module.select.Select;
import jwc.module.tree.Tree;

/**
 *
 * @author adm.wangchunzi
 */
public class CreateDemoByJWebGW {

    public static void main(String args[]) {
        //总配置
        JConfig.java_resource_real_path = "D:\\workspace\\workspace-netBeans\\jwebgw\\src\\main\\java";
        JConfig.web_resource_real_path = "D:\\workspace\\workspace-netBeans\\jwebgw\\src\\main\\webapp";
        JConfig.web_request_hz = ".jw";
        //执行生成 tree
//        createTree();
        CreateSelect();
    }

    public static void createTree() {
        Tree sobj = new Tree("MyPackage", "mypackage_id", "mypackage_pid", "mypackage_name", "cc/mypackage");
        sobj.packageConfig.beanPackage = "wx.web.cc.bean";
        sobj.packageConfig.validatePackage = "wx.web.cc.hm.mypackage.validate";
        sobj.packageConfig.cachePackage = "wx.web.cc.hm.mypackage.cache";
        sobj.packageConfig.hmPackage = "wx.web.cc.hm.mypackage";

        sobj.packageConfig.jspPackage = "cc.mypackage";
        sobj.packageConfig.tablePackage = "sql.cc";
        sobj.openCreate(false);
    }

    public static void CreateSelect() {
        Select sobj = new Select(wx.web.cc.bean.Mybean.class, "cc/mybean", true);
        sobj.packageConfig.hmPackage = "wx.web.cc.hm.mybean";
        sobj.packageConfig.validatePackage = "wx.web.cc.hm.mybean.validate";
        sobj.packageConfig.cachePackage = "wx.web.cc.hm.mybean.cache";
        sobj.packageConfig.jspPackage = "cc.mybean";
        sobj.overConfig();
        sobj.doCreateBean(false);
        sobj.doCreateValidate(false);
        sobj.doCreateHM_A(false);
        sobj.doCreateHM_D(false);
        sobj.doCreateHM_U(false);
        sobj.doCreateHM_S(false);

        sobj.doCreateCache(false);

        sobj.doCreateJS_A(false);
        sobj.doCreateJS_U(false);

        sobj.doCreateJSP_S(false);
        sobj.doCreateJSP_A(false);
        sobj.doCreateJSP_U(false);
        sobj.doCreateTable(false);
    }

}
