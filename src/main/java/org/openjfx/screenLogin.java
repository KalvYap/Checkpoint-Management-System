package org.openjfx;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.FileNotFoundException;


public class screenLogin {

    public int CheckUser(String User, String Pass) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src\\main\\resources\\org\\openjfx\\usernames.txt"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);

        Scanner sc1 = new Scanner(new File("src\\main\\resources\\org\\openjfx\\passwords.txt"));
        List<String> lines1 = new ArrayList<String>();
        while (sc1.hasNextLine()) {
            lines1.add(sc1.nextLine());
        }

        String[] arr1 = lines1.toArray(new String[0]);



        if (User.equals(arr[0])){
            if(Pass.equals(arr1[0])){
                return 2;
            }
            else{
                return 0;
            }
        }
        else if (User.equals(arr[1])){
            if(Pass.equals(arr1[1])){
                return 2;
            }
            else{
                return 0;
            }
        }
        else if (User.equals(arr[2])){
            if(Pass.equals(arr1[2])){
                return 2;
            }
            else{
                return 0;
            }
        }
        else{
            return 1;
        }
    }

}