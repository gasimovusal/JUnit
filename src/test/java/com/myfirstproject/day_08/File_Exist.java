package com.myfirstproject.day_08;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File_Exist {
    /*
    Class: FileExistTest
    Method: isExist
    Pick a file on your desktop
    And verify if that file exist on your computer or not
     */
    @Test
    public void isExistTest(){
        // Pick a file on your desktop
        String homeDirectory = System.getProperty("user.home");
        System.out.println(homeDirectory); // /Users/VG ==> this is my home directory

        // path of the image
        String pathOfFile = homeDirectory + "/Desktop/Views/dumbo.jpeg";
        System.out.println(pathOfFile); // /Users/VG/Desktop/Views/dumbo.jpeg
        boolean isFileExists = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isFileExists); // path is exists, Fail is not exists
    }
}
