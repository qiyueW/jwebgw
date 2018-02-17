package configuration.file;

import system.web.file.FileModel;

public class OfficeFileModel extends FileModel {

    @Override
    public void configuration(system.web.file.temp.FileConfig fc) {
        fc.path_web_real = system.web.WebContext.getWebContext().WEB_PATH; //web根目录的绝对路径
        fc.path_save = "upload/office/";            //上传的目录
        fc.fileNameSuffix_alloy = "doc,docx,xls";//类型后缀
        fc.fileSize_max = 2 * 1024 * 1024;      //文件大小
        fc.fileSizeThreshold = 2 * 1024 * 1024; //文件缓冲，及写入硬盘临时文件的临界值
        //等其他参数。
    }
}
