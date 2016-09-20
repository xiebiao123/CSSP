package com.soshow.ssi.util.excel.view;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.soshow.ssi.annotation.Excel;
import com.soshow.ssi.util.excel.ExcelDataFormatter;
import com.soshow.ssi.util.excel.ReflectUtils;

public class ExcelView extends AbstractExcelView {

	public static final String EXCEL_MODEL_VIEW ="excelView"; 
	public static final String EXCEL_MODEL_LIST ="excelModelList";
	public static final String EXCEL_MODEL_FORMAT ="excelModelFormat";
	
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook wb, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Object> list = (List<Object>) model.get(EXCEL_MODEL_LIST);
		ExcelDataFormatter edf = (ExcelDataFormatter) model.get(EXCEL_MODEL_FORMAT);
		
        if (list == null || list.size() == 0)
            return;
        Sheet sheet = wb.createSheet();	 // 创建一个工作表sheet
        Row row = sheet.createRow(0);	 // 创建标题行
        Cell cell = null;				 // 声明单元格
 
        CreationHelper createHelper = wb.getCreationHelper();
        
        // 设置标题样式
        HSSFCellStyle titleStyle =  wb.createCellStyle();
        titleStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        
        // 设置字体
        Font font = wb.createFont();
        font.setColor(HSSFColor.BROWN.index);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        titleStyle.setFont(font);
 
        //获取对象属性及父类属性
        Field[] fields = ReflectUtils.getClassFieldsAndSuperClassFields(list.get(0).getClass());
        
        int columnIndex = 0;
        Excel excel = null;
        for (Field field : fields) {
            field.setAccessible(true);
            excel = field.getAnnotation(Excel.class);
            if (excel == null || excel.skip() == true) {
                continue;
            }
            // 列宽注意乘256
            sheet.setColumnWidth(columnIndex, excel.width() * 256);
            // 写入标题
            cell = row.createCell(columnIndex);
            cell.setCellStyle(titleStyle);
            cell.setCellValue(excel.name());
            columnIndex++;
        }
 
        int rowIndex = 1;
        //设置表格数据样式
        CellStyle cs = wb.createCellStyle();
        for (Object t : list) {
            row = sheet.createRow(rowIndex);
            columnIndex = 0;
            Object o = null;
            for (Field field : fields) {
                field.setAccessible(true);
                // 忽略标记skip的字段
                excel = field.getAnnotation(Excel.class);
                if (excel == null || excel.skip() == true) {
                    continue;
                }
                cell = row.createCell(columnIndex);
                o = field.get(t);
                // 如果数据为空，跳过
                if (o == null)
                    continue;
                // 处理日期类型
                if (o instanceof Date) {
                    cs.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
                    cell.setCellStyle(cs);
                    cell.setCellValue((Date) field.get(t));
                } else if (o instanceof Double || o instanceof Float) {
                    cell.setCellValue((Double) field.get(t));
                } else if (o instanceof Boolean) {
                    Boolean bool = (Boolean) field.get(t);
                    if (edf == null) {
                        cell.setCellValue(bool);
                    } else {
                        Map<Object, Object> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(bool);
                        } else {
                            cell.setCellValue(map.get(bool.toString().toLowerCase())+"");
                        }
                    }
                } else if (o instanceof Integer) {
                    Integer intValue = (Integer) field.get(t);
                    if (edf == null) {
                        cell.setCellValue(intValue);
                    } else {
                        Map<Object, Object> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(intValue);
                        } else {
                            cell.setCellValue(map.get(intValue)+"");
                        }
                    }
                } else {
                    cell.setCellValue(field.get(t).toString());
                }
 
                columnIndex++;
            }
            rowIndex++;
        }
	}
}
