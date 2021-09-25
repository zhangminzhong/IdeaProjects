package com.example.study;

import com.example.study.bean.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    ApplicationContext applicationContext;



    @Before
    public void contextLoads() {

    }

    @Test
    public void testUser(){
        System.out.println(applicationContext.getId());
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.getUserName());
    }

    /**
     * 读excel2007
     * @throws IOException
     * @throws InvalidFormatException
     */
    @Test
    public void testPoi() throws IOException, InvalidFormatException {
        System.out.println(System.getProperty("user.dir"));
//        System.out.println(this.getClass().getClassLoader().getResource("application.properties").getPath());
//        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/templates/test.xlsx"));
        //得到excel工作簿对象
//        HSSFWorkbook wb = new HSSFWorkbook(fs);
        File file = new File("D:\\IdeaProjects\\study\\study-poi\\src\\main\\resources\\templates\\test.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        //得到excel工作表对象
        XSSFSheet sheet = wb.getSheetAt(0);

        for(int i=0;i<sheet.getLastRowNum();i++){
            //得到excel工作表的行
            XSSFRow row = sheet.getRow(i);
            //得到excel工作表指定单元格
            for(int j=0;j<row.getLastCellNum();j++) {
                XSSFCell cell = row.getCell(j);
                XSSFCellStyle cellStyle = cell.getCellStyle();
//                System.out.printf("%-20s", cell.getStringCellValue());
                System.out.printf("%-20s", cell.getStringCellValue());
//                System.out.print(cell.getStringCellValue()+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 写excel2007
     */
    @Test
    public void testPoiWrite() throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("testSheet");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        //居中
//        XSSFCellStyle cellStyle = cell.getCellStyle();
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        cell.setCellValue("学生资料");
        cell.setCellStyle(style);
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("用户名");
//        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("密码");
//        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("年龄");
//        cell.setCellStyle(style);
        for(int i=2;i<100;i++){
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue("zhangsan");
//            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("123456");
//            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue(20+i);
//            cell.setCellStyle(style);
        }
        //全部居中
        for(int i=0;i<sheet.getLastRowNum();i++){
            row = sheet.getRow(i);
            for(int j=0;j<row.getLastCellNum();j++){
                cell = row.getCell(j);
                cell.setCellStyle(style);
            }
        }
        //合并单元格
        CellRangeAddress rangeAddress = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(rangeAddress);
        wb.write(new FileOutputStream("D:\\IdeaProjects\\study\\study-poi\\src\\main\\resources\\templates\\testOut.xlsx"));

    }

}
