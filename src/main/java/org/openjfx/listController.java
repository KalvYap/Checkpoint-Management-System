package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;


public class listController {

    @FXML
    ListView listView;
    @FXML
    TextArea informationArea;
    @FXML
    ImageView backMainMenu;
    @FXML
    AnchorPane anchorPane;
    @FXML
    RadioButton yes1,yes2,yes3,yes4,no1,no2,no3,no4;
    @FXML Rectangle alphabeticalSort,entryButton;

    printingOptions printingOptions=new printingOptions();

    String[][] names = new String[100][];
    String[][] choices = new String[100][];


    LinkedList llist;
    public void setLinkList(LinkedList<FXMLLoader> llist){
        this.llist = llist;
    }



    public void backPressed(){
        FXMLLoader loader = (FXMLLoader) llist.get(0);
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) backMainMenu.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }




    public void fillList() throws IOException {
        anchorPane.setVisible(false);

        listView.getItems().clear();
        int nlines = printingOptions.countLines();
        int listindex=0;

        //right now you can put printFrom into a binary search tree at least the first for every piece
       names = printingOptions.printFrom("peoplelist.txt");
        //for loop divided by 4 i think
        //its a 2d array


        for(;listindex<=nlines-1 ;listindex++){
            listView.getItems().add(names[listindex][0]);
        }


    }




    public void setInformation() throws IOException {
        anchorPane.setVisible(true);
        informationArea.clear();

        choices = printingOptions.printFrom("choices.txt");
        //try not to use index here try to use comparison compare the item in
        //the selected item and the first of every item on the 2d array

        int listindex=0;

        boolean found = false;

        StringBuilder areaContent = new StringBuilder("");
        //while loop to find its match

        while(found==false){

            if(listView.getSelectionModel().getSelectedItem()==null){
                found=true;
            }
            if(listView.getSelectionModel().getSelectedItem()==names[listindex][0]){
                areaContent.append("    NAME: \n"+"    "+names[listindex][0]+"\n");
                areaContent.append("    CONTACT NUMBER: \n"+"    "+names[listindex][1]+"\n");
                areaContent.append("    HOUSE VISITED: \n"+"    "+names[listindex][2]+"\n");
                areaContent.append("    TIME OUT: \n"+"    "+names[listindex][3]);

                informationArea.setText(areaContent.toString());


                if (choices[listindex][0].equals("1")){
                    yes1.setSelected(true);
                    no1.setSelected(false);

                }else if (choices[listindex][0].equals("0")) {
                    no1.setSelected(true);
                    yes1.setSelected(false);
                }
                if (choices[listindex][1].equals("1")){
                    yes2.setSelected(true);
                    no2.setSelected(false);

                }else if (choices[listindex][1].equals("0")) {
                    no2.setSelected(true);
                    yes2.setSelected(false);
                }
                if (choices[listindex][2].equals("1")){
                    yes3.setSelected(true);
                    no3.setSelected(false);

                }else if (choices[listindex][2].equals("0")) {
                    no3.setSelected(true);
                    yes3.setSelected(false);
                }
                if (choices[listindex][3].equals("1")){
                    yes4.setSelected(true);
                    no4.setSelected(false);

                }else if (choices[listindex][3].equals("0")) {
                    no4.setSelected(true);
                    yes4.setSelected(false);
                }


                found=true;
            }
            else{
                listindex++;
            }

        }






    }

    public void alphabeticalSort() throws IOException {
        anchorPane.setVisible(false);
        String[] namesArray = new String[100];
        GFG tree = new GFG();


        int listindex = 0;
        int listindex2=0;
        int nlines = printingOptions.countLines();


        //making it into a 1d array that can be put into the tree
        for(;listindex<=nlines-1 ;listindex++){
            namesArray[listindex]= (String) listView.getItems().get(listindex);
        }

        //make the first of the list onto another array so we can put it in the tree
        listView.getItems().clear();


        tree.treeins(namesArray,nlines-1);

        tree.traverseInorder(tree.root,namesArray, 0);




        for(;listindex2<=nlines-1 ;listindex2++){

            listView.getItems().add(namesArray[listindex2]);



        }
        
    }


    public void deletePressed() throws IOException {

        int listindex = 0;
        boolean found=false;


        while(found==false){
            //if selection is the same as the names
            if(listView.getSelectionModel().getSelectedItem()==names[listindex][0]){
                printingOptions.delete(names[listindex][0]);
                if(listindex!=0){
                    listindex=listindex+3;
                }
                printingOptions.delete2(listindex);

                found=true;
            }
            else{
                listindex++;
            }

        }
        fillList();

    }



    public void alphabeticalHovered(){
    alphabeticalSort.setFill(Color.DARKMAGENTA);
    }
    public void entryHovered(){
        entryButton.setFill(Color.DARKMAGENTA);

    }
    public void exitHovered(){
    entryButton.setFill(Color.PLUM);
    alphabeticalSort.setFill(Color.PLUM);

}

}
