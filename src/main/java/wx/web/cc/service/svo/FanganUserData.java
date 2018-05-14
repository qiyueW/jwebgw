package wx.web.cc.service.svo;

/**
 *
 * @author wo
 */
public class FanganUserData {

    /**
     * 相对项目的路径
     */
    public String filepath;
    /**
     * 生成的文件名
     */
    public String filename;
    /**
     * 写是的内容
     */
    public String filecontext;
    /**
     * 执行动作：0 生成，1文件存在则不生成。
     */
    public int zxdz;
    /**
     * 当文件已经存在时：0 覆盖，1追加
     */
    public int xrfs;
}
