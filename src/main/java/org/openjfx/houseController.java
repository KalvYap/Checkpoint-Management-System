package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class houseController {


    @FXML
    ChoiceBox houseChoice;
    @FXML
    Button backMainMenu;
    @FXML
    ListView listView;
    @FXML
    TextField searchField;
    @FXML
    Text errorText;

    printingOptions printingOptions = new printingOptions();

    public ObservableList<String> visitorList;

    public houseProfile profile;
    ArrayList<houseProfile> houses= new ArrayList<>();

    LinkedList llist;

    public void setLinkList(LinkedList<FXMLLoader> llist) {
        this.llist = llist;
    }


    public void backPressed() {
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



    public void initChoiceBox() throws IOException {

        houseChoice.getItems().add("House 1");
        houseChoice.getItems().add("House 2");
        houseChoice.getItems().add("House 3");
        houseChoice.getItems().add("House 4");
        houseChoice.getItems().add("House 5");
        houseChoice.getItems().add("House 6");
        setTable();
    }

    public void searchPressed(){

        //we need to call dfs from house profile however you would already need to activate it through
        //ah we could just cycle through all the houses dfs all the houses until we find it
        //if it returns -1 then it means the visitor is not in that house

        errorText.setText("");

        String searchedName = searchField.getText();
        searchField.clear();

        //make this a while statement so it stops calling the other profiles when it finds the right house

        boolean found = false;
        int index = 0;
        int n;
        while(found==false){
            profile = houses.get(index);

            n = profile.dfs(searchedName);

            if(n>-1){
                houseChoice.getSelectionModel().select(index);
                listView.getSelectionModel().select(n);
                listView.getFocusModel().focus(n);
                errorText.setText("Entry found!");

                found=true;
            }else if (index>=5){
                found = true;
                errorText.setText("Entry not found!");
            }
            else {
                index++;
            }

        }



    }


    public void setTable() throws IOException {

        int listindex=0;
        int nlines = printingOptions.countLines();
        String[][] names;
        houseProfile house1 = new houseProfile("House 1");
        profile = house1;
        profile.addNode("House 1");
        houses.add(house1);

        houseProfile house2 = new houseProfile("House 2");
        profile = house2;
        profile.addNode("House 2");
        houses.add(house2);

        houseProfile house3 = new houseProfile("House 3");
        profile = house3;
        profile.addNode("House 3");
        houses.add(house3);

        houseProfile house4 = new houseProfile("House 4");
        profile = house4;
        profile.addNode("House 4");
        houses.add(house4);

        houseProfile house5= new houseProfile("House 5");
        profile = house5;
        profile.addNode("House 5");
        houses.add(house5);

        houseProfile house6 = new houseProfile("House 6");
        profile = house6;
        profile.addNode("House 6");
        houses.add(house6);


        names = printingOptions.printFrom("peoplelist.txt");

        //this makes a profile for every user thats registered
        for(;listindex<=nlines-1 ;listindex++){
            houseProfile newprofile = new houseProfile(names[listindex][0]);
            profile = newprofile;
            profile.addNode(names[listindex][0]);
        }

        //another set of integers for this for loop
        //this is assigning each visitor a house depening on their choice which is [0][2]
        int listindex2=0;
        int nlines2 = printingOptions.countLines();

        for(;listindex2<=nlines2-1 ;listindex2++){
            if(names[listindex2][2].compareTo("House 1")==0){
                profile =house1;
                profile.writeVisitor(names[listindex2][0]);


            }else if(names[listindex2][2].compareTo("House 2")==0){
                profile = house2;
                profile.writeVisitor(names[listindex2][0]);

            }else if(names[listindex2][2].compareTo("House 3")==0){
                profile = house3;
                profile.writeVisitor(names[listindex2][0]);

            }else if(names[listindex2][2].compareTo("House 4")==0){
                profile = house4;
                profile.writeVisitor(names[listindex2][0]);

            }else if(names[listindex2][2].compareTo("House 5")==0){
                profile = house5;
                profile.writeVisitor(names[listindex2][0]);

            }else if(names[listindex2][2].compareTo("House 6")==0){
                profile = house6;
                profile.writeVisitor(names[listindex2][0]);

            }

        }


        //this is how each housechoice knows if it gets selected
        //this gets the index this may need to change if you want to change the arrangement of the houses in the choicebox
        houseChoice.getSelectionModel().selectedIndexProperty().addListener(
                (ov, oldVal, newVal) -> {
                    int optionSelected = newVal.intValue();
                    errorText.setText("");

                    if (optionSelected == 0) {
                        visitorList = FXCollections.observableArrayList(house1.getVisitors());
                        listView.setItems(visitorList);
                    }
                    else if (optionSelected==1){
                        visitorList = FXCollections.observableArrayList(house2.getVisitors());
                        listView.setItems(visitorList);
                    }else if (optionSelected==2){
                        visitorList = FXCollections.observableArrayList(house3.getVisitors());
                        listView.setItems(visitorList);
                    }else if (optionSelected==3){
                        visitorList = FXCollections.observableArrayList(house4.getVisitors());
                        listView.setItems(visitorList);
                    }else if (optionSelected==4){
                        visitorList = FXCollections.observableArrayList(house5.getVisitors());
                        listView.setItems(visitorList);
                    }else if (optionSelected==5){
                        visitorList = FXCollections.observableArrayList(house6.getVisitors());
                        listView.setItems(visitorList);
                    }
                });




    }



}
