package wx.web.base.hm.bm;

import configuration.DBO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.ann.GG;
import wx.web.base.BCM;
import wx.web.base.bean.BM;
import wx.web.base.hm.bm.cache.BMCache;
import wx.web.base.hm.bm.vo.BMExcelDow;

@H("/base/bm")
@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J51_1")
public class BMSelect {

    @M("/selectVast")
    public static void select(JWeb jw) {
//             System.out.println("-------------------------1");
        jw.printOne(BCM.RY_CACHE.getCacheData(BMCache.class).getJSON());
    }

    @GG
    @M("/selectVast/GRID")
    public static void selectUI(JWeb jw) {//_UIGrid
        jw.printOne(BCM.RY_CACHE.getCacheData(BMCache.class).getLigeruiJSON());
    }

   

     @M("/office/exceldow")/// /base/bm/office/exceldow
    public static void exceldow(JWeb jw) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("部门信息");
            BMExcelDow vo = new BMExcelDow(sheet);
            vo.setTitle();
            List<BM> list =DBO.service.S.select(BM.class);
            if (null != list) {
                for (BM obj : list) {
                    vo.setRowValue(list,obj);
                }
            }
            jw.response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode("部门下载.xls", "UTF-8")
//                    +StringTool.downloadFileName_zhcnCode(jw.request,"部门下载.xls")
            );
            workbook.write(jw.response.getOutputStream());
        } catch (IOException e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
    
    
    private static void fiandBMSon(final List<BM> rs, List<BM> listBM, BM father) {
        List<BM> son = fiandAllSon(rs, listBM, father);
        if (son.isEmpty()) {
            return;
        }
        for (BM b : son) {
            rs.add(b);
            fiandBMSon(rs, listBM, b);
        }
    }

    private static List<BM> fiandAllSon(final List<BM> rs, List<BM> listBM, BM father) {
        List<BM> son = new ArrayList<>();
        for (BM b : listBM) {
            if (father.getBm_id().equals(b.getBm_pid())) {
                son.add(b);
            }
        }
        return son;
    }
}
