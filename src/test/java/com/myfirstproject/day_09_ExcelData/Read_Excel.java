package com.myfirstproject.day_09_ExcelData;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Read_Excel {
    @Test
    public void readExcel() throws IOException {
//        Store the path of the  file in a string
        String pathOfFile = "./src/test/java/resources/Capitals.xlsx";

//        Open the file
        FileInputStream fileInputStream = new FileInputStream(pathOfFile); // FileInputStream used for accessing to file

//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
        // getSheetAt() accepts integer and is used to get the specific sheet to go to 1st sheet use index of 0
        Sheet sheet1 = workbook.getSheetAt(0);

//        Go to first row
        // getRox() accepts integer and used to get the specific row to go to 1st row, use index 0
        Row row1 = sheet1.getRow(0);
//        Go to first cell on that first row and print
        // getCell() accepts integer and used to get the specific cell to go to 1st row, use index 0
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1.toString().toLowerCase()); // we use toString to print bcs we want to go spring manipulation

//        Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2);

//        Go to 2nd row first cell  and assert if the data equal to USA
        String row2 = sheet1.getRow(1).getCell(0).toString(); // without converting toString, you cannot assert it
        Assert.assertEquals("USA", row2);
//        Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);
//        Find the number of row
        Integer numOfRaw = sheet1.getLastRowNum() + 1; // getLastRowNum will give you total row number by index, we add 1 so we will see total num or rows
        System.out.println(numOfRaw);

//        Find the number of used row
        int numOfRowUsed = sheet1.getPhysicalNumberOfRows(); // this will count numer of rowa are used thats why we dont need to add +1
        System.out.println(numOfRowUsed);

//        Print country, capitol key value pairs as map object
        Map<String, String> countryCapital = new HashMap<>();
        for (int rowNumber = 1; rowNumber < numOfRaw; rowNumber++) {
            String countries = sheet1.getRow(rowNumber).getCell(0).toString();
            System.out.println(countries);

            String capitals = sheet1.getRow(rowNumber).getCell(1).toString();
            System.out.println(capitals);

            countryCapital.put(countries, capitals);
        }
        System.out.println(countryCapital);



    }
}