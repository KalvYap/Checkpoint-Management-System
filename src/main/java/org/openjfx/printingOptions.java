package org.openjfx;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class printingOptions {


    public String[][] printFrom(String filename) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(filename));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        int size = lines.size();
        String[][] tab2d = new String[size][size];

        int count = 0;

        for(int i = 0; i < size/4; i++){
            for(int j = 0; j < 4; j++){
                tab2d[i][j] = lines.get(count);
                count++;
            }

        }
    sc.close();
    return tab2d;
    }



    public ArrayList setArray(Queue q){
        var newList = (ArrayList) q.peek();
        return newList;
    }




    public void printing(ArrayList data) throws IOException {

        Queue<Object> nameQ= new LinkedList();

        for(Object i:data){
            nameQ.add(i);
        }

        FileWriter list = null;


        int len = data.size();
        try {
           list = new FileWriter("peoplelist.txt",true);

            for (int i = 0; i<len;i++){
                if(data.get(i)!=null) {
                    list.write( nameQ.peek() + "\n");
                    nameQ.remove();
                }

            }
            list.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.close();
    }



    public void printingChoices(int [] data) throws IOException {

        Queue<Integer> choiceQ= new LinkedList();

        FileWriter list = null;

        for(int i:data){
            choiceQ.add(i);
        }



        int len = data.length;
        try {
            list = new FileWriter("choices.txt",true);
            for (int i = 0; i<len;i++){

                list.write( choiceQ.peek() + "\n");
                choiceQ.remove();
            }
            list.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public int countLines() throws IOException {
        FileReader input = new FileReader("peoplelist.txt");
        LineNumberReader count = new LineNumberReader(input);

        int lines = (int)count.lines().count() + 1;
        count.close();
        input.close();
        return lines/4;

    }




    public void delete(String lineToRemove) throws IOException {

        boolean cut=true;
        int count=1;
        File inputFile = new File("peoplelist.txt");
        File tempFile = new File("templist.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;


        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();

            if(trimmedLine.equals(lineToRemove)) {
                cut=false;
                continue;
            }
            if (cut==false){
                count++;
                if(count>=4){
                    cut=true;
                }
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        boolean success=tempFile.renameTo(inputFile);

        System.out.println(success);


    }



    public void delete2(int index) throws IOException {

        boolean cut=true;
        int count=1;
        int linecount=-1;
        File inputFile = new File("choices.txt");
        File tempFile = new File("templist2.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;


        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            linecount++;

            if(linecount==index) {
                cut=false;
                continue;
            }
            if (cut==false){
                count++;
                if(count>=4){
                    cut=true;
                }
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        boolean success=tempFile.renameTo(inputFile);

        System.out.println(success);


    }






}
