package com.thetestingacademy.task_25Feb24;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelLoginData {

    static Workbook workbook;
    static Sheet sheet;

    public static String FILE_NAME="src/test/resource/VwoLoginData1.xlsx";

    public static Object[][] getLoginData(String sheetName) throws IOException {
        FileInputStream file=null;

        file=new FileInputStream(FILE_NAME);

        workbook= WorkbookFactory.create(file);
        sheet=workbook.getSheet(sheetName);

       Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum() ; i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return data;
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        return getLoginData("sheet1");
    }


}
