package com.soshow.ssi.excel;
 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtilsTest {
     
    /**
     * 将数据写入到Excel文件
     * @param filePath 文件路径
     * @param sheetName 工作表名称
     * @param title 工作表标题栏
     * @param data 工作表数据
     * @throws FileNotFoundException 文件不存在异常
     * @throws IOException IO异常
     */
    public void writeToFile(String filePath,String[] sheetName,List<? extends Object[]> title,
    	List<? extends List<? extends Object[]>> data) throws FileNotFoundException, IOException{
        //创建并获取工作簿对象
        Workbook wb=getWorkBook( sheetName, title, data);
        //写入到文件
        FileOutputStream out=new FileOutputStream(filePath);
        wb.write(out);
        out.close();
    }
     
    /**
     * 创建工作簿对象
     * 工作表名称，工作表标题，工作表数据最好能够对应起来
     * 比如三个不同或相同的工作表名称，三组不同或相同的工作表标题，三组不同或相同的工作表数据
     * 
     * 注意：
     * 需要为每个工作表指定   -- 工作表名称，工作表标题，工作表数据
     * 如果工作表的数目大于工作表数据的集合，那么首先会根据顺序一一创建对应的工作表名称和数据集合，然后创建的工作表里面是没有数据的
     * 如果工作表的数目小于工作表数据的集合，那么多余的数据将不会写入工作表中
     * 
     * @param sheetName 工作表名称的数组
     * @param title 标题的数组集合
     * @param data 每个工作表数据的集合的集合
     * @return Workbook工作簿
     * @throws FileNotFoundException 文件不存在异常
     * @throws IOException IO异常
     */
    public Workbook getWorkBook(String[] sheetName,List<? extends Object[]> title,List<? extends List<? extends Object[]>> data) throws FileNotFoundException, IOException{
        //创建工作簿，支持2007及以后的文档格式
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = null;	 	//创建一个工作表sheet
        Row row = null;			//声明行
        Cell cell = null;		//声明单元格
        //单元格样式
        CellStyle titleStyle=wb.createCellStyle();
        CellStyle cellStyle=wb.createCellStyle();
        
        Font font=wb.createFont();										//字体样式
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);					//粗体
        titleStyle.setFont(font);
        
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);				//水平居中  
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//垂直居中  
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);					//水平居中  
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//垂直居中  
         
        Object[] title_temp=null;	//标题数据
        Object[] rowData=null;		//行数据
        //工作表数据
        List<? extends Object[]> sheetData=null;
         
        //遍历sheet
        for(int sheetNumber=0;sheetNumber<sheetName.length;sheetNumber++){
            //创建工作表
            sheet=wb.createSheet();
            //设置工作表名称
            wb.setSheetName(sheetNumber, sheetName[sheetNumber]);
            
            //设置标题
            title_temp=title.get(sheetNumber);
            row=sheet.createRow(0);
            for(int i=0;i<title_temp.length;i++){
                cell=row.createCell(i);
                cell.setCellStyle(titleStyle);
                cell.setCellValue(title_temp[i].toString());
            }
            
            try {
                sheetData=data.get(sheetNumber);
            } catch (Exception e) {
                continue;
            }
            //写入行数据
            for(int rowNumber=0;rowNumber<sheetData.size();rowNumber++){
                //如果没有标题栏，起始行就是0，如果有标题栏，行号就应该为1
                row=sheet.createRow(title_temp==null?rowNumber:(rowNumber+1));
                rowData=sheetData.get(rowNumber);
                for(int columnNumber=0;columnNumber<rowData.length;columnNumber++){
                    cell=row.createCell(columnNumber);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(rowData[columnNumber].toString());
                }
            }
        }
        return wb;
    }
 
     
    public static void main(String[] args) throws FileNotFoundException, IOException {
         
        String[] title1={"第一列a","第二列b","第三列c"};
        String[] title2={"第一列d","第二列e","第三列f"};
        String[] title3={"第一列h","第二列i","第三列j"};
         
        List<String[]> titles=new ArrayList<String[]>();
        titles.add(title1);
        titles.add(title2);
        titles.add(title3);
         
        String []data1={"i","j","k"};
        String []data2={"m","n","o"};
        String []data3={"x","y","z"};
         
        List<String[]> data=new ArrayList<String[]>();
        data.add(data1);
        data.add(data2);
        data.add(data3);
        List<List<String[]>> data_=new ArrayList<List<String[]>>();
        data_.add(data);
        String[] sheetName={"第一张表","第二张表","第三张表"};
        new ExcelUtilsTest().writeToFile("D:\\xx.xlsx", sheetName, titles, data_);
    }
}