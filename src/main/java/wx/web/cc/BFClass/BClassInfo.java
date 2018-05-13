package wx.web.cc.BFClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;

/**
 *
 * @author wo
 */
public class BClassInfo {

    public final static String className = "Mybean";
    public final static String classPackage = "wx";
    public final static String classRealPath = "/wx/Mybean.java";

    private final static Field[] beanF;
    private final static Field[] bean2F;
    public final Class<?> myClass;

    static {
        beanF = Bean.class.getDeclaredFields();
        for (Field f : beanF) {
            f.setAccessible(true);
        }
        bean2F = Bean2.class.getDeclaredFields();
        for (Field f : bean2F) {
            f.setAccessible(true);
        }
    }

    public Object getMyBean() {
        //设置编译参数
        ArrayList<String> ops = new ArrayList<>();
        ops.add("-Xlint:unchecked");

        return ClassTool.invoke(this.myClass, null, null, null);
    }

    private final Bean bean;
    private final List<Bean2> list;
    private String classCdoe;

    public BClassInfo(Bean bean, List<Bean2> list) {
        this.bean = bean;
        this.list = list;
        this.iniClassCode();
        this.myClass = loadClass();
        System.out.println(this.myClass);
    }

    private Class<?> loadClass() {
        //设置编译参数
        ArrayList<String> ops = new ArrayList<>();
        ops.add("-Xlint:unchecked");
        //编译代码，返回class
        return ClassTool.loadClass(classRealPath, this.classCdoe, classPackage, ops, true);
    }

    private void iniClassCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(classPackage).append(";\n");
        sb.append("public class " + className + " {\n");

        try {
            for (Field f : beanF) {
                sb.append("    public String ").append(f.getName()).append(" = \"").append(f.get(this.bean)).append("\";\n");
            }
            for (Bean2 obj : this.list) {
                sb.append("    public String ").append(obj.getBean2_key()).append(" = \"").append(obj.getBean2_value()).append("\";\n");
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(BClassInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        sb.append("}\n");
        this.classCdoe = sb.toString();
    }
}
