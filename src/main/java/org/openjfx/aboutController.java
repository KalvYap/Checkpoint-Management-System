package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

public class aboutController {


    InputStream stream = new FileInputStream("src\\main\\resources\\org\\openjfx\\luffyedited.png");
    Image kalv1 = new Image(stream);
    InputStream stream2 = new FileInputStream("src\\main\\resources\\org\\openjfx\\luffyedited2.png");
    Image kalv2 = new Image(stream2);
    InputStream stream3 = new FileInputStream("src\\main\\resources\\org\\openjfx\\minatoedited.png");
    Image raf1 = new Image(stream3);
    InputStream stream4 = new FileInputStream("src\\main\\resources\\org\\openjfx\\minatoedited2.png");
    Image raf2 = new Image(stream4);
    InputStream stream5 = new FileInputStream("src\\main\\resources\\org\\openjfx\\hisokaedited.png");
    Image daine1 = new Image(stream5);
    InputStream stream6 = new FileInputStream("src\\main\\resources\\org\\openjfx\\hisokaedited2.png");
    Image daine2 = new Image(stream6);



    public aboutController() throws FileNotFoundException {
    }


    LinkedList llist;
    public void setLinkList(LinkedList<FXMLLoader> llist){
        this.llist = llist;
    }


    @FXML
    ImageView kalvin,raf,daine;
    @FXML
    Pane paneFinal, paneStart1,paneStart2,paneStart3;
    @FXML
    TextArea textArea;
    @FXML
    Text nameText;
    @FXML
    ImageView exitButton;



    public void exitPressed(){
        FXMLLoader loader = (FXMLLoader) llist.get(0);
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }





    public void kalvinHovered(){
        paneStart1.setVisible(false);
        paneFinal.setVisible(true);
        paneFinal.setStyle("-fx-background-color: INDIGO;");

        textArea.setText("Monkey D. Luffy, also known as \"Straw Hat Luffy\" and \n commonly as \"Straw Hat\", \n is the main protagonist of the manga and anime,\n One Piece. He is the founder and captain of \n the increasingly infamous and powerful Straw Hat ");
        kalvin.setImage(kalv2);
        nameText.setText("KALVIN");
        kalvin.setFitHeight(302);
        kalvin.setFitWidth(278);

    }


    public void rafHovered(){
        paneStart2.setVisible(false);
        paneFinal.setVisible(true);
        paneFinal.setStyle("-fx-background-color: DARKMAGENTA;");


        textArea.setText("Minato Namikaze (波風ミナト, Namikaze Minato)\n was the Fourth Hokage (四代目火影, Yondaime Hokage, \nliterally meaning: Fourth Fire Shadow) of\n Konohagakure. He was renowned all \nover the world as Konoha's Yellow Flash ");
        raf.setImage(raf2);
        nameText.setText("RAFAEL");
        raf.setFitHeight(302);
        raf.setFitWidth(278);

    }
    public void daineHovered(){
        paneStart3.setVisible(false);
        paneFinal.setVisible(true);
        paneFinal.setStyle("-fx-background-color: MEDIUMORCHID;");


        textArea.setText("Hisoka Morow (ヒソカ゠モロウ, Hisoka Morou) \nis a Hunter and former member #4 of the Phantom \nTroupe; his physical strength ranked third in \nthe group. He is always in search for strong \nopponents, and would spare those who have \ngreat potential, such as Gon and Killua in order \nfor them to get strong enough to actually \nchallenge him. ");
        daine.setImage(daine2);
        nameText.setText("DAINE");
        daine.setFitHeight(302);
        daine.setFitWidth(278);

    }




    public void exitHovered(){
        textArea.clear();
        paneFinal.setVisible(false);
        paneFinal.setVisible(false);
        paneStart1.setVisible(true);
        paneStart2.setVisible(true);
        paneStart3.setVisible(true);



        raf.setFitHeight(211);
        raf.setFitWidth(156);
        kalvin.setFitHeight(222);
        kalvin.setFitWidth(192);

        daine.setFitHeight(232);
        daine.setFitWidth(220);

        raf.setImage(raf1);
        kalvin.setImage(kalv1);
        daine.setImage(daine1);






    }



}
