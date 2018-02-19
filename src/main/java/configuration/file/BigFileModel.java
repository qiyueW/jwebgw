package configuration.file;

public class BigFileModel extends system.web.file.FileModel {

    @Override
    public void configuration(system.web.file.temp.FileConfig fc) {
        fc.path_web_real = system.web.WebContext.getWebContext().WEB_PATH; //web根目录的绝对路径
        fc.path_save = "upload/file/";            //上传的目录
        fc.fileNameSuffix_alloy = "jpg,png,gif,ico,jpge";//类型后缀
        fc.fileSize_max = -1;      //文件大小。-1表示不限制大小
        fc.fileSizeThreshold = 3 * 1024 * 1024; //文件缓冲，及写入硬盘临时文件的临界值
        //等其他参数。
    }
}