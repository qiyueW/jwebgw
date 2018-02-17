package wx.web.base.hm.bm.vo;

import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import wx.web.base.bean.BM;

/**
 *
 * @author fly
 */
public class BMExcelDow {

    private final HSSFSheet sheet;
    private HSSFRow row;
    private int i = 1;
    private final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public BMExcelDow(HSSFSheet sheet) {
        this.sheet = sheet;
    }

    public void setTitle() {
        row = sheet.createRow(0);
        row.createCell(0).setCellValue("序号");
//        row.createCell(1).setCellValue("部门PID");
        row.createCell(1).setCellValue("部门ID");
        row.createCell(2).setCellValue("部门名称");
        row.createCell(3).setCellValue("部门路径");
    }

    public void setRowValue(List<BM> list, BM obj) {
        row = sheet.createRow(i);
        row.createCell(0).setCellValue(i++);
//        row.createCell(1).setCellValue(obj.getBm_pid());//部门PID
        row.createCell(1).setCellValue(obj.getBm_id());//部门ID
        row.createCell(2).setCellValue(obj.getBm_name());//部门名称
        row.createCell(3).setCellValue(getFatherPath(list, obj));//部门路径
    }

    private String getFatherPath(List<BM> list, BM bm) {
        StringBuilder sb = new StringBuilder();
        sb.append(bm.getBm_name());
        BM fobj = findFather(list, bm);
        while (null != fobj) {
            sb.insert(0, fobj.getBm_name() + "/");
            fobj = findFather(list, fobj);
        }
        return sb.toString();
    }

    private BM findFather(final List<BM> list, final BM bm) {
        if (null == bm.getBm_pid() || bm.getBm_pid().equals("0") || bm.getBm_pid().isEmpty()) {
            return null;
        }
        for (BM obj : list) {
            if (bm.getBm_pid().equals(obj.getBm_id())) {
                return obj;
            }
        }
        return null;
    }
}
