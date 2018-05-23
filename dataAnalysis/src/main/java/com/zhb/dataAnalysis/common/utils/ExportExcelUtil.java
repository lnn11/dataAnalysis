package com.zhb.dataAnalysis.common.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

@SuppressWarnings("deprecation")
public class ExportExcelUtil {

	private String[] title; // 标题
	
	private String[] colsName; //列名
	
	private String[] sheetName; //工作表名
	
	private String fileName; // 文件名
	
	private String isCountRow = "0"; // 是否显示添加最低端的合计行(需手动计算后赋值),1 合计  0 不合计
	
	private List<List<Object[]>>  dataList; //数据集合
	
	HttpServletResponse  response;
	
	//构造方法，传入要导出的数据  
    public ExportExcelUtil(HttpServletResponse response,String[] title,String[] colsName,List<List<Object[]>>  dataList,String[] sheetName,String fileName,String isCountRow){  
        this.dataList = dataList;
        this.colsName = colsName;  
        this.title = title; 
        this.response = response;
        this.sheetName = sheetName;
        this.fileName = fileName;
        this.isCountRow = isCountRow;        
    }
    
    public HSSFCellStyle getColumnToStyle(HSSFWorkbook workbook){
    	
    	HSSFFont font = workbook.createFont(); // 设置字体
    	font.setFontHeightInPoints((short) 12); // 设置字体大小
    	font.setFontName("微软雅黑"); // 这是字体样式
    	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    	HSSFCellStyle style = workbook.createCellStyle(); // 设置样式
    	style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置底边框
    	style.setBottomBorderColor(HSSFColor.BLACK.index); // 设置底边框颜色
    	style.setBorderLeft(HSSFCellStyle.BORDER_THIN); // 设置左边框
    	style.setLeftBorderColor(HSSFColor.BLACK.index); // 设置左边框颜色
    	style.setBorderRight(HSSFCellStyle.BORDER_THIN); // 设置右边框
    	style.setRightBorderColor(HSSFColor.BLACK.index); // 设置右边框颜色
    	style.setBorderTop(HSSFCellStyle.BORDER_THIN); // 设置顶边框
    	style.setTopBorderColor(HSSFColor.BLACK.index); // 设置顶边框颜色
    	style.setFont(font); // 在样式中应用字体
    	style.setWrapText(false); // 设置自动换行
    	style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置水平对齐方式为居中对齐
    	style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 设置垂直对齐方式为居中对齐
    	
    	return style;
    }
    
    /*   
     * 列数据信息单元格样式 
     */    
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
    	
          HSSFFont font = workbook.createFont();  // 设置字体  
          font.setFontHeightInPoints((short)11);  //设置字体大小  
          font.setFontName("微软雅黑");   //设置字体名字   
          HSSFCellStyle style = workbook.createCellStyle();  //设置样式
          style.setBorderBottom(HSSFCellStyle.BORDER_THIN);   //设置底边框
          style.setBottomBorderColor(HSSFColor.BLACK.index);  //设置底边框颜色
          style.setBorderLeft(HSSFCellStyle.BORDER_THIN);   //设置左边框
          style.setLeftBorderColor(HSSFColor.BLACK.index);  //设置左边框颜色
          style.setBorderRight(HSSFCellStyle.BORDER_THIN); //设置右边框 
          style.setRightBorderColor(HSSFColor.BLACK.index);  //设置右边框颜色
          style.setBorderTop(HSSFCellStyle.BORDER_THIN);  //设置顶边框
          style.setTopBorderColor(HSSFColor.BLACK.index);  //设置顶边框颜色
          style.setFont(font);   //在样式用应用设置的字体
          style.setWrapText(false);   //设置自动换行
          style.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //设置水平对齐的样式为居中对齐
          style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //设置垂直对齐的样式为居中对齐
          
          return style;  
      
    }
    
    /*   
     * 列数据信息单元格样式 
     */    
    public HSSFCellStyle getAloneStyle(HSSFWorkbook workbook) {
    	
    	HSSFCellStyle cellStyle2 = workbook.createCellStyle();
    	HSSFFont font = workbook.createFont();  // 设置字体  
        font.setFontHeightInPoints((short)11);  //设置字体大小  
        font.setFontName("微软雅黑");   //设置字体名字  
    	cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);   //设置底边框
        cellStyle2.setBottomBorderColor(HSSFColor.BLACK.index);  //设置底边框颜色
        cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);   //设置左边框
        cellStyle2.setLeftBorderColor(HSSFColor.BLACK.index);  //设置左边框颜色
        cellStyle2.setBorderRight(HSSFCellStyle.BORDER_THIN); //设置右边框 
        cellStyle2.setRightBorderColor(HSSFColor.BLACK.index);  //设置右边框颜色
        cellStyle2.setBorderTop(HSSFCellStyle.BORDER_THIN);  //设置顶边框
        cellStyle2.setTopBorderColor(HSSFColor.BLACK.index);  //设置顶边框颜色
        cellStyle2.setFont(font);   //在样式用应用设置的字体
        cellStyle2.setWrapText(false);   //设置自动换行
        cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //设置水平对齐的样式为居中对齐
        cellStyle2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //设置垂直对齐的样式为居中对齐
        cellStyle2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle2.setFillForegroundColor(new HSSFColor.YELLOW().getIndex());
    	return cellStyle2;  
    	
    }
    
    /**
     * 导出数据
     *
     */
	public void export(){
    	HSSFWorkbook workbook = new HSSFWorkbook(); // 创建工作簿对象
    	boolean isTopOne = false;
    	
    	for (int t = 0; t < sheetName.length; t++) {
    		HSSFSheet sheet = workbook.createSheet(sheetName[t]); // 创建工作表
    		HSSFCell cellTitle = null;
    		HSSFRow rowm = null;
    		int startIndex = 0;
    		if(title != null && title.length != 0 && startIndex == 0){
    			rowm = sheet.createRow(0);
    			isTopOne = true;
    			startIndex += 1;
    		}
        	// 产生表格标题行
        	HSSFCellStyle style = this.getColumnToStyle(workbook); // 获取列头样式对象
        	HSSFCellStyle cellStyle = this.getStyle(workbook); //单元格样式对象
			int columnNum = colsName.length; // 定义所需列数
			//投资体验，非活动商品和活动商品sheetname与其他多两列，新增或修改导出是注意
        	if(!sheetName[t].equals("投资产品体验奖励")&&!sheetName[t].equals("非活动商品账单")
					&&!sheetName[t].equals("活动商品对账单")&&!sheetName[t].equals("普通商品订单")){
				columnNum=colsName.length-2;
			}

        	HSSFRow rowRowName = sheet.createRow(startIndex); // 在索引2的位置创建行(最顶端的行开始的第二行)
        	
        	for (int i = 0; i < columnNum; i++) {
        		
    			HSSFCell cell = rowRowName.createCell(i); // 创建列头对应个数的单元格
    			cell.setCellType(HSSFCell.CELL_TYPE_STRING); // 设置列头单元格的数据类型
    			
    			HSSFRichTextString text = new HSSFRichTextString(colsName[i]);
    			cell.setCellValue(text); // 设置列头单元格的值
    			cell.setCellStyle(cellStyle);
    		}
        	// 将查询出的数据设置到sheet对应的单元格中
        	for (int i = t; i < dataList.size();) {
        		List<Object[]> list = dataList.get(i);
        		for (int u = 0; u < list.size(); u++) {
        			Object[] objects = list.get(u); // 遍历每个对象
        			if(u == (list.size() - 1) && isCountRow.equals("1")){
    					HSSFRow createRow = sheet.createRow(u+startIndex+1);
        				HSSFCell  cell1 = null;
        				for (int r = 0; r < colsName.length; r++) {
        					cell1 = createRow.createCell(r, HSSFCell.CELL_TYPE_STRING);
        					if(r == 0){
        						cell1.setCellValue(objects[0].toString()); // 设置单元格的值
        					}else if(r == 3){
        						cell1.setCellValue(objects[3].toString()); // 设置单元格的值
        					}else if(r == 5){
        						cell1.setCellValue(objects[5].toString());
        					}
        					cell1.setCellStyle(this.getAloneStyle(workbook));
        				}
        			}else{
        				HSSFRow row = sheet.createRow(u+startIndex+1); //创建所需行数
        				for (int j = 0; j < objects.length; j++) {
        					if(isTopOne && t <= title.length-1){
        						cellTitle = rowm.createCell(j);
        						cellTitle.setCellStyle(style);
        						cellTitle.setCellValue(new HSSFRichTextString(title[t]));
        					}
        					HSSFCell  cell = null;   //设置单元格的数据类型
        					if(j == 0){ // 首列数据序号的数据类型
        						cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
        						if(!"".equals(objects[j]) && objects[j] != null){
        							cell.setCellValue(objects[j].toString()); // 设置单元格的值
        						}
//        						cell.setCellValue(u+1);
        					}else{
        						cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
        						if(!"".equals(objects[j]) && objects[j] != null){
        							cell.setCellValue(objects[j].toString()); // 设置单元格的值
        						}
        					}
							if(!"".equals(objects[j]) && objects[j] != null || j<12){
								cell.setCellStyle(cellStyle); // 设置单元格样式
							}

        				}
        			}
    				
        		}
        		break;
			}
        	
        	for (int i = 0; i < columnNum; i++) {
    			
        		int colsWidth = sheet.getColumnWidth(i) / 256; // 列宽
        		for (int j = 0; j < sheet.getLastRowNum(); j++) {
        			HSSFRow currentRow;
        			//当前行未被使用过
        			if(sheet.getRow(j) == null){
        				currentRow = sheet.createRow(j);
        			}else{
        				currentRow = sheet.getRow(j);
        			}
//        			if(currentRow.getCell(i) != null){
//        				HSSFCell cell = currentRow.getCell(i);
//        				if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
//        					int length = cell.getStringCellValue().getBytes().length;
//        					if(colsWidth < length){
//        						colsWidth = length;
//        					}
//        				}
//        			}
    			}
        		if(i == 0){
        			sheet.setColumnWidth(i, (colsWidth - 2) * 256);
        		}else{
        			sheet.setColumnWidth(i, (colsWidth + 4) * 256);
        		}
    		}
        	if(isTopOne){
        		sheet.addMergedRegion(new CellRangeAddress(0,0,0,colsName.length-1));
        	}
		}
    	if(workbook != null){
			try {
				String fileName1 = fileName+"-"+new SimpleDateFormat("yyyyMMdd").format(new Date());
				response.reset();
				response.setContentType("application/x-download");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName1.getBytes("gbk"), "iso8859-1")+".xls");  
				OutputStream outputStream = response.getOutputStream();
				workbook.write(outputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
}
