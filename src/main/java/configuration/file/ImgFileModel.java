package configuration.file;

public class ImgFileModel extends system.web.file.FileModel {

    @Override
    public void configuration(system.web.file.temp.FileConfig fc) {
        //web根目录的绝对路径.直接采用全局配置实例中，取得即可。
        fc.path_web_real = system.web.WebContext.getWebContext().WEB_PATH;
        fc.path_save = "upload/img/";            //上传的目录
        fc.fileNameSuffix_alloy = "gif,jpg,jpeg,bmp,png";//图片类型后缀
        fc.fileSize_max = 2 * 1024 * 1024;      //文件大小
        //文件缓冲，及写入硬盘临时文件的临界值
        //如果采用Servlet原生支持，两处fileSizeThreshold的值都必须一样！
        fc.fileSizeThreshold = 2 * 1024 * 1024; 
        //等其他参数。
    }

}
