package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;


public class finalController {


    @FXML
    Label addAgain;
    @FXML Label backMainMenu;


    LinkedList llist;
    public void setLinkList(LinkedList<FXMLLoader> llist){
        this.llist = llist;
    }

    //sends you back to the survey form
    public void addagainPressed(){
        FXMLLoader loader = (FXMLLoader) llist.get(4);
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

        surveyController controller = loader.getController();
        controller.setLinkList(llist);

        Stage stage = (Stage) addAgain.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }


    //sends you back to the main menu
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

    public void againHovered(){
        addAgain.setStyle("-fx-background-color: PLUM; -fx-background-radius: 10; -fx-border-color: white;-fx-border-radius: 10;");
    }
    public void backHovered(){
        backMainMenu.setStyle("-fx-background-color: PLUM;-fx-background-radius: 10; -fx-border-color: white;-fx-border-radius: 10;");
    }

    public void exitHover(){
        addAgain.setStyle("-fx-background-color: #2e8ddd;-fx-background-radius: 10; -fx-border-color: white;-fx-border-radius: 10;");
        backMainMenu.setStyle("-fx-background-color: #2e8ddd;-fx-background-radius: 10; -fx-border-color: white;-fx-border-radius: 10;");


    }






}
