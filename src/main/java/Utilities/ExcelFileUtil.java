package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
Workbook wb;
//Constructor for reading excel path
public ExcelFileUtil(String excelpath)throws Throwable
{
	FileInputStream fi = new FileInputStream(excelpath);
	wb= WorkbookFactory.create(fi);
}
//counting no of rows in a sheet
public int rowCount(String sheetname)
{
	return wb.getSheet(sheetname).getLastRowNum();
}
//counting no of cells in row
public int celCount(String sheetname)
{
	return wb.getSheet(sheetname).getRow(0).getLastCellNum();
}
//get cell data from sheet
public String getCellData(String sheetname,int row,int column)
{
	String data="";
if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
{
int celldata =(int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
data=String.valueOf(celldata);
}
else
{
data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();	
}
return data;
}
//method for set status
public void setCellData(String sheetname,int row,int column,String status,String writeexcel)
throws Throwable{
	//get sheet from wb
	Sheet ws= wb.getSheet(sheetname);
	//get row from sheet
	Row rownum=ws.getRow(row);
	//Create cell
	Cell cell=rownum.createCell(column);
	//write staus in a cell
	cell.setCellValue(status);
	if(status.equalsIgnoreCase("Pass"))
	{
		//create cell style
		CellStyle style= wb.createCellStyle();
		//create font
		Font font =wb.createFont();
		///Apply color To The Text
		font.setColor(IndexedColors.GREEN.getIndex());
		//Apply Bold To The Text
		font.setBold(true);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	}
	else if(status.equalsIgnoreCase("Fail"))
	{
		//create cell style
				CellStyle style= wb.createCellStyle();
				//create font
				Font font =wb.createFont();
				///Apply color To The Text
				font.setColor(IndexedColors.RED.getIndex());
				//Apply Bold To The Text
				font.setBold(true);
				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				style.setFont(font);
				rownum.getCell(column).setCellStyle(style);
	}
	else if(status.equalsIgnoreCase("Blocked"))
	{
		//create cell style
				CellStyle style= wb.createCellStyle();
				//create font
				Font font =wb.createFont();
				///Apply color To The Text
				font.setColor(IndexedColors.BLUE.getIndex());
				//Apply Bold To The Text
				font.setBold(true);
				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				style.setFont(font);
				rownum.getCell(column).setCellStyle(style);
	}
	FileOutputStream fo= new FileOutputStream(writeexcel);
	wb.write(fo);
	fo.close();
}
}







