package com.myfirstproject.day_10_WebTables_Screenshots;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
 https://the-internet.herokuapp.com/tables
Create a class: Day10_WebTables
Task 1 : Print the entire table
Task 2 : Print All Rows
Task 3 : Print Last row data only
Task 4 : Print column 5 data in the table body
Task 5 : Write a method that accepts 2 parameters
Parameter 1 = row number
Parameter 2 = column number
printData(2,3);  => prints data in 2nd row 3rd column
*/

public class Web_Tables extends Test_Base {
    @Test
    public void printTable() {
        // print the entire table
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("*** Print table ***");
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachData : tableData) {
            System.out.println(eachData.getText());
        }

        //        Getting 10th data from the table
        System.out.println("10th Table Data => " + tableData.get(10).getText());

//        for(WebElement eachTabel : tableData){
//            if(!eachTabel.getText().equals("Tim")){
//                System.out.println("tim is not in the table: " + eachTabel.getText());
//                Assert.assertTrue(false);
//            }
//        }
    }

    @Test
    public void getRows() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("*** each table rows ***");
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        for (WebElement eachRow : tableRows) {
            System.out.println(eachRow.getText());
        }
    }

    @Test
    public void lastRow() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("*** last table row ***");
        WebElement lastRow = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[last()]"));
        System.out.println(lastRow.getText());
    }

    @Test
    public void getColumn5() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print Column 5***");
        List<WebElement> column5Data = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        for (WebElement eachColumn : column5Data) {
            System.out.println(eachColumn.getText());
        }
    }

    // write reusable method that  can give specific column data with row and column number
    public void printData(int row, int column){
        driver.get("https://the-internet.herokuapp.com/tables");
        //table[@id='table1']//tbody//tr[2]//td[3]
        //table[@id='table1']//tbody//tr[1]//td[4]
        //table[@id='table1']//tbody//tr[4]//td[2]
        String xPath = "//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]";
        WebElement cellData = driver.findElement(By.xpath(xPath));
        System.out.println(cellData.getText());
    }

    // **** method overloading, using same method name (printData) with different parameter ****

    // write reusable method that  can give specific column data with row, column number and table ID
    public void printData(int row, int column,String tableID){
        driver.get("https://the-internet.herokuapp.com/tables");
        //table[@id='table1']//tbody//tr[2]//td[3]
        //table[@id='table1']//tbody//tr[1]//td[4]
        //table[@id='table1']//tbody//tr[4]//td[2]
        String xPath = "//table[@id='"+tableID+"']//tbody//tr["+row+"]//td["+column+"]";
        WebElement cellData = driver.findElement(By.xpath(xPath));
        System.out.println(cellData.getText());
    }

    @Test
    public void printDataTest(){
        printData(2,3);//fbach@yahoo.com
        printData(4,6);//edit delete
        printData(2,4,"table1");//$51.00
        printData(2,5,"table2");//http://www.frank.com
    }
}
