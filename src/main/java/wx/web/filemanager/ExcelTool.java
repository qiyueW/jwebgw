package wx.web.filemanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import system.base.jclass.ClassFactory;
import system.base.jclass.ClassInfo;
import system.base.jclass.field.FieldInfo;

/**
 *
 * @author wangchunzi
 */
public class ExcelTool {

    public <T> List<T> readExcelData(Class<T> t, Map<String, String> ec, String FilePath) {
        FileInputStream out = null;
        Row row;
        Cell cell;
        Map<Integer, FieldInfo> cm = new HashMap();
        T obj;
        String fieldName;
        FieldInfo fiobj;
        ClassInfo cli = ClassFactory.get(t);
        List<T> list = new ArrayList<>();
        try {
            out = new FileInputStream(FilePath);
            Workbook wb = new HSSFWorkbook(out);
            Sheet sh = wb.getSheetAt(0);
            int rint = sh.getLastRowNum() + 1;
            System.out.println(rint + "///////////////////////////////////////1");
            for (int i = 0; i < rint; i++) {
                row = sh.getRow(i);
                Iterator<Cell> ci = row.cellIterator();
                if (i == 0) {//第一行
                    while (ci.hasNext()) {
                        cell = ci.next();
                        fieldName = ec.get(cell.toString());
                        if (null != fieldName) {
                            cm.put(cell.getColumnIndex(), cli.getFieldInfo(fieldName));
                        }
                    }
                    continue;
                }
                obj = t.newInstance();
                while (ci.hasNext()) {
                    cell = ci.next();
                    fiobj = cm.get(cell.getColumnIndex());
                    if (null != fiobj) {
                        cell.setCellType(CellType.STRING);
//                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
//                            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));
//                            fiobj.field.set(obj, cell.getDateCellValue());
//                        }else{
                            fiobj.field.set(obj, fiobj.get(cell + ""));
//                        }
                    }
                }
                list.add(obj);
            }
            return list;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExcelTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
