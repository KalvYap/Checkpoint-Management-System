package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

public class addMenuController {

    printingOptions printOptions = new printingOptions();

    @FXML
    TextField nameField, contactField, timeField;

    @FXML Button addNameButton;
    @FXML Text testingText;
    @FXML
    ChoiceBox houseChoiceBox;

    public Queue q = new LinkedList();





    LinkedList llist;
    public void setLinkList(LinkedList<FXMLLoader> llist){
        this.llist = llist;
    }


    public void initChoiceBox(){

        houseChoiceBox.getItems().add("House 1");
        houseChoiceBox.getItems().add("House 2");
        houseChoiceBox.getItems().add("House 3");
        houseChoiceBox.getItems().add("House 4");
        houseChoiceBox.getItems().add("House 5");
        houseChoiceBox.getItems().add("House 6");

    }

    public void nextScreen(){
        FXMLLoader loader = (FXMLLoader) llist.get(1);
        Parent root = null;
        loader.setRoot(null);
        loader.setController(null);
        loader.setResources(null);
        loader.getNamespace().clear();

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finalController controller = loader.getController();
        controller.setLinkList(llist);


        Stage stage = (Stage) addNameButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }



    public void addName() throws IOException {
        if(nameField.getText().isEmpty()||contactField.getText().isEmpty()||houseChoiceBox.getSelectionModel().getSelectedItem()==null||timeField.getText().isEmpty()){
            //make an error message
            testingText.setText("Information Incomplete!");

        }
        else {
            //change questions name i guess
            ArrayList<String> information = new ArrayList();
            information.add(nameField.getText());
            information.add(contactField.getText());
            information.add((String) houseChoiceBox.getSelectionModel().getSelectedItem());
            information.add(timeField.getText());


            q.add(information);

            nameField.clear();
            contactField.clear();

            timeField.clear();

            testingText.setText("Person has been added!");

            //for loop to front() and push() into a text file for each line
            //idk if we want to have a separate class that will  have all the printing functions in it
            System.out.println(q.peek());


            //firts convrt it into an array list using setArray then you cna uset hat array in printp
            var newArray = printOptions.setArray(q);
            printOptions.printing(newArray);
            q.poll();

            //front just takes every thing because its a queue of array lists

        }

        nextScreen();
    }


}
