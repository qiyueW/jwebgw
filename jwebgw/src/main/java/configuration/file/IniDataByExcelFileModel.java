package configuration.file;

/**
 *
 * @author wangchunzi
 */
public class IniDataByExcelFileModel extends system.web.file.FileModel {

    @Override
    public void configuration(system.web.file.temp.FileConfig fc) {
        //web根目录的绝对路径.直接采用全局配置实例中，取得即可。
        fc.path_web_real = system.web.WebContext.getWebContext().WEB_PATH;
        fc.path_save = "upload/init/";            //上传的目录
        fc.fileNameSuffix_alloy = "xls";
        fc.fileSize_max = 20* 1024 * 1024;      //文件大小
        //文件缓冲，及写入硬盘临时文件的临界值
        //如果采用Servlet原生支持，两处fileSizeThreshold的值都必须一样！
        fc.fileSizeThreshold = 2 * 1024 * 1024; 
        fc.process_fileName=false;
        //等其他参数。
    }

}
