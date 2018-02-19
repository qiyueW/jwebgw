package configuration.filter.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import system.web.JWeb;
import system.web.WebContext;
import system.web.filter.chain.FilterModel;

/**
 *
 * @author wangchunzi
 */
public class BigFileDownload extends FilterModel {

    {
        super.setLocation(LOCATION_BUTTOM);
    }

    public static final int buff = 1024 * 1024 * 3;

    @Override
    public void doFilter(JWeb jw) {
        Object attribute = jw.request.getAttribute("file");
        if (null != attribute) {
            String str = attribute.toString();
            jw.request.removeAttribute("file");
            
            String filename = str.substring(str.lastIndexOf("/")+1);
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(WebContext.getWebContext().WEB_PATH + str);
            } catch (FileNotFoundException ex) {
                jw.printOne("你访问的资源已经失效！");
                return;
            }
            // 设置输出的格式
            jw.response.reset();
            jw.response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            try {
                jw.response.setContentLength(fis.available());
            } catch (IOException ex) {
                jw.printOne("获得文件大小成错!");
                return;
            }
            // 循环取出流中的数据
            byte[] b = new byte[buff];
            int len;
            try {
                while ((len = fis.read(b)) > 0) {
                    jw.response.getOutputStream().write(b, 0, len);
                }
                jw.response.flushBuffer();
                jw.response.getOutputStream().close();
                fis.close();
            } catch (IOException e) {
            }
        }
    }

}
