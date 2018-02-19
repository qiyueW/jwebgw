package wx.web.filemanager;

import configuration.file.ImgFileModel;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.file.FI;
import system.web.file.engine.FileEngine;

/**
 *
 * @author wangchunzi
 */
@H("/fileup")
public class ImgUp {

    @M("/one/img")//fileup/one/img
    public static void up(JWeb jw) {
    	
    	System.out.println("====================================================");
    	
        //初始化一个上传引擎（需要传入HttpServletRequest对象
        FileEngine file = new FileEngine(jw.request);
        //执行上传操作。默认上传第一个文件（假如有多个文件的吗)
        FI upOne = file.upOne(ImgFileModel.class);
//        java.util.List<FI> upVast = file.upVast(ImgFileModel.class);//批量上传操作
//        file.upOne(ImgFileModel.class, "file");//指定参数名上传
//        file.upVast(ImgFileModel.class, "file");//指定参数名，批传
        System.out.println(upOne.toString());
        //返回json数据。注意,FI对象重写了toString,此方法现在返回的是json数据
        jw.printOne(upOne.toString());
    }
}
