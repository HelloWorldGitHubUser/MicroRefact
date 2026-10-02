package com.central.util;
 import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public class ExcelUtil {

private ExcelUtil() {
    throw new IllegalStateException("Utility class");
}
public List<T> importExcel(MultipartFile file,Integer titleRows,Integer headerRows,Class<T> pojoClass) throws Exception{
    if (file == null) {
        return Collections.emptyList();
    }
    ImportParams params = new ImportParams();
    params.setTitleRows(titleRows);
    params.setHeadRows(headerRows);
    return ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
}


public void exportExcel(List<Map<String,Object>> list,String fileName,HttpServletResponse response) throws IOException{
    defaultExport(list, fileName, response);
}


public void downLoadExcel(String fileName,HttpServletResponse response,Workbook workbook) throws IOException{
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
    workbook.write(response.getOutputStream());
}


public void defaultExport(List<Map<String,Object>> list,String fileName,HttpServletResponse response) throws IOException{
    Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.XSSF);
    if (workbook != null) {
        downLoadExcel(fileName, response, workbook);
    }
}


}