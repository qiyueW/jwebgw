package plugins.easyui.vo;

/**
 *
 * @author adm.wangchunzi
 */
public class EasyuiPage {

    /**
     * 页码
     */
    public final int page;
    /**
     * 页记录数量
     */
    public final int rows;

    public EasyuiPage(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }
}
