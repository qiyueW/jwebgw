package wx.web.cc.service;

import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import wx.web.cc.bean.Mybean;
import wx.web.cc.bean.Mybeanfield;

/**
 *
 * @author adm.wangchunzi
 */
public class MybeanService {

    public static String toJSGet(List<Mybeanfield> list, String ClassName) {
        String model
                = "    function get" + ClassName + "FormData() {\n"
                + "        var data = {};\n";
        for (Mybeanfield bf : list) {
            model = model + "        data." + bf.getC_mc() + " = $('#" + bf.getC_mc() + "').val()\n";
        }
        model = model + "        return data;\n    }";
        return model;
    }

    public static String toJSSet(List<Mybeanfield> list, String ClassName) {
        String model
                = "    function set" + ClassName + "FormData() {\n";
        for (Mybeanfield bf : list) {
            model = model + "        $('#" + bf.getC_mc() + "').val('')\n";
        }
        model = model + "    }";
        return model;
    }

    public static String toBeanData(List<Mybeanfield> list, String ClassName) {
        StringBuilder sb = new StringBuilder();
        StringBuilder me = new StringBuilder();
        for (Mybeanfield bf : list) {

            sb
                    .append(bf.getT_sy().equals("zj") ? "@system.base.annotation.ID\n" : "")
                    .append(bf.getC_lx().equalsIgnoreCase("Date") ? "@system.base.annotation.Time(\"" + bf.getMybeanfield_dateformat() + "\")\n" : "")
                    .append(bf.getC_zyy()).append(" ").append(bf.getC_lx()).append(" ").append(bf.getC_mc()).append(";//").append(bf.getC_bz()).append("\n");

            me.append(getInfo("取得 " + bf.getC_bz(), bf.getC_lx()))
                    .append("\npublic ").append(bf.getC_lx()).append(" ").append(bf.getC_getmethod()).append("(){\n")
                    .append("return this.").append(bf.getC_mc()).append(";\n")
                    .append("}\n")
                    .append(getInfo("设置 " + bf.getC_bz(), null, bf.getC_mc() + " " + bf.getC_lx()))
                    .append("\npublic ").append("void ").append(bf.getC_setmethod()).append("(").append(bf.getC_lx()).append(" ").append(bf.getC_mc()).append("){\n")
                    .append(" this.").append(bf.getC_mc()).append("=").append(bf.getC_mc()).append(";\n")
                    .append("}\n");
        }
        sb.append(me);
        return "public class " + ClassName + " {\n" + sb.toString() + "\n}";
    }

    public static String toSQLData(List<Mybeanfield> list, String TableName) {
        if (null == list || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder index = new StringBuilder("\n");
        for (Mybeanfield bf : list) {
            setSQLField(bf, sb, index);
        }
        sb.append(index);
        return "CREATE TABLE IF NOT EXISTS `" + TableName + "`(\n" + sb.substring(2)
                + "\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
    }

    public static String myVelocityEngine(String modelData, List<Mybeanfield> fields,Mybean bean) {
        if (null == fields || fields.isEmpty()) {
            return "";
        }
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("fields",fields);
        context.put("bean",bean);
        StringWriter writer = new StringWriter();
        ve.evaluate(context, writer, "", modelData.replace("&#39;", "'").replace("&#34;", "\"")); // 关键方法
        return writer.toString().replace("#$#", "$");
    }

//================ tool 集合    
    private static void setSQLField(Mybeanfield bf, StringBuilder sb, StringBuilder index) {
        switch (bf.getT_lx()) {
            case "VARCHAR":
            case "CHAR":
                sb.append("\n,`").append(bf.getT_mc()).append("` ").append(bf.getT_lx()).append("(").append(bf.getT_cd()).append(")")
                        .append(bf.getT_yxkong().equalsIgnoreCase("s") ? " DEFAULT NULL" : " NOT NULL")
                        .append("/*").append(bf.getT_bz()).append("*/");
                break;
            default: {
                sb.append("\n,`").append(bf.getT_mc()).append("` ").append(bf.getT_lx()).append("    ")
                        .append(bf.getT_yxkong().equalsIgnoreCase("s") ? " DEFAULT NULL" : " NOT NULL")
                        .append("/*").append(bf.getT_bz()).append("*/");
            }
        }
        switch (bf.getT_sy()) {
            case "s":
                index.append("\n,KEY        `").append(bf.getT_mc()).append("` (`").append(bf.getT_mc()).append("`)");
                break;
            case "wy":
                index.append("\n,UNIQUE KEY `").append(bf.getT_mc()).append("` (`").append(bf.getT_mc()).append("`)");
                break;
            case "zj":
                index.append("\n,PRIMARY KEY (`").append(bf.getT_mc()).append("`)");
                break;
        }
    }

    /**
     * 生成标注
     *
     * @param info 如果之间有;;号，视为换行
     * @param returnLX String .返回的类型 例如传入 String
     * @param param String[] .方法传入的参数。如何传入 param String[]
     * @return String
     */
    private static String getInfo(String info, String returnLX, String... param) {
        StringBuilder sb = new StringBuilder();
        sb.append("/**\n");
        int count = 0;
        for (String istr : info.split(";;")) {
            if (count == 0) {
                sb.append("* ").append(istr).append("\n");
            } else {
                sb.append("* ").append(istr).append("<p>\n");
            }
            count++;
        }
        if (null != param && param.length > 0) {
            for (String pstr : param) {
                sb.append("* @param ").append(pstr).append("\n");
            }
        }
        if (null != returnLX && returnLX.length() > 0) {
            sb.append("* @return ").append(returnLX).append("\n");
        }
        sb.append("*/");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

        // 初始化并取得Velocity引擎
        VelocityEngine ve = new VelocityEngine();
        ve.init();

        // 取得velocity的模版内容, 模板内容来自字符传
        String content = "";
        content += "Welcome  $name  to Javayou.com! ";
        content += " today is  $date.";

        // 取得velocity的上下文context
        VelocityContext context = new VelocityContext();

        // 把数据填入上下文
        context.put("name", "javaboy2012");

        context.put("date", (new Date()).toString());

        // 输出流
        StringWriter writer = new StringWriter();

        // 转换输出
        ve.evaluate(context, writer, "", content); // 关键方法

        System.out.println(writer.toString());

    }
}
