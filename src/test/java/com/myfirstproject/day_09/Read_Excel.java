package com.myfirstproject.day_09;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Read_Excel {
    @Test
    public void readExcel() throws FileNotFoundException {
//        Store the path of the  file in a string
        String pathOfFile = "./src/test/java/resources/Capitals.xlsx";

//        Open the file
        FileInputStream fileInputStream = new FileInputStream(pathOfFile); // FileInputStream used for accessing to file

//        Open the workbook using fileinputstream
       // Workbook

//        Open the first worksheet
//        Go to first row
//        Go to first cell on that first row and print
//        Go to second cell on that first row and print
//        Go to 2nd row first cell  and assert if the data equal to USA
//        Go to 3rd row 2nd cell-chain the row and cell
//        Find the number of row
//        Find the number of used row
//        Print country, capitol key value pairs as map object
    }
}
