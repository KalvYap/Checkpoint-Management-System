package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;


import java.io.IOException;

public class mainMenuController {

    InputStream stream = new FileInputStream("src\\main\\resources\\org\\openjfx\\whiteScreen.png");
    Image image1 = new Image(stream);

    InputStream stream2 = new FileInputStream("src\\main\\resources\\org\\openjfx\\add.jpg");
    Image image2 = new Image(stream2,920, 610, false, false);

    InputStream stream3 = new FileInputStream("src\\main\\resources\\org\\openjfx\\ToDoList.jpg");
    Image image3 = new Image(stream3,1057, 603, false, false);

    InputStream stream4 = new FileInputStream("src\\main\\resources\\org\\openjfx\\House.png");
    Image image4 = new Image(stream4,1103, 603, false, false);


    @FXML
    ImageView imageView;

    public Rectangle addButton,listButton,homeButton;

    LinkedList<FXMLLoader> llist = new LinkedList<>();

    public mainMenuController() throws FileNotFoundException {
    }

    public void initialize(){

        FXMLLoader aboutUs = new FXMLLoader(getClass().getResource("aboutUs1.fxml"));
        FXMLLoader addScreen = new FXMLLoader(getClass().getResource("addScreen.fxml"));
        FXMLLoader listScreen = new FXMLLoader(getClass().getResource("listScreen_2.fxml"));
        FXMLLoader surveyScreen = new FXMLLoader(getClass().getResource("surveyscreen1.fxml"));
        FXMLLoader finalScreen = new FXMLLoader(getClass().getResource("finalScreen.fxml"));
        FXMLLoader mainMenu = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        FXMLLoader houseScreen = new FXMLLoader(getClass().getResource("houseScreen.fxml"));

        llist.addFirst(aboutUs); //6
        llist.addFirst(houseScreen);//5
        llist.addFirst(surveyScreen);//4
        llist.addFirst(listScreen);//3
        llist.addFirst(addScreen);//2
        llist.addFirst(finalScreen);//1
        llist.addFirst(mainMenu); //0


    }


    public void addPressed(){
        FXMLLoader loader = (FXMLLoader) llist.get(4);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        surveyController controller = loader.getController();
        controller.setLinkList(llist);

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void listPressed() throws IOException {
        FXMLLoader loader = (FXMLLoader) llist.get(3);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listController controller = loader.getController();
        controller.setLinkList(llist);
        controller.fillList();

        Stage stage = (Stage) listButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



    public void housePressed() throws IOException {
        FXMLLoader loader = (FXMLLoader) llist.get(5);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        houseController controller = loader.getController();
        controller.setLinkList(llist);
        controller.initChoiceBox();

        Stage stage = (Stage) listButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



    public void aboutPressed(){
        FXMLLoader loader = (FXMLLoader) llist.get(6);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        aboutController controller = loader.getController();
        controller.setLinkList(llist);

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void addHovered(){
    addButton.setFill(Color.DARKMAGENTA);
    imageView.setImage(image2);

    }
    public void listHovered(){
        listButton.setFill(Color.DARKMAGENTA);
        imageView.setImage(image3);

    }
    public void houseHovered(){
        homeButton.setFill(Color.DARKMAGENTA);
        imageView.setImage(image4);

    }

    public void exitHover(){
        addButton.setFill(Color.INDIGO);
        listButton.setFill(Color.INDIGO);
        homeButton.setFill(Color.INDIGO);
        imageView.setImage(image1);
    }


}
