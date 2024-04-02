package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;


public class surveyController {

    @FXML
    Text errorText;

    @FXML Button submitButton;

    @FXML
    RadioButton yes1;

    @FXML RadioButton no1;

    @FXML
    RadioButton yes2;

    @FXML RadioButton no2;

    @FXML
    RadioButton yes3;

    @FXML RadioButton no3;

    @FXML
    RadioButton yes4;

    @FXML RadioButton no4;

    int []choices = new int[4];

    printingOptions printingOptions=new printingOptions();


    LinkedList llist;
    public void setLinkList(LinkedList<FXMLLoader> llist){
        this.llist = llist;
    }


    public void change(){
        FXMLLoader loader = (FXMLLoader) llist.get(2);
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

        addMenuController controller = loader.getController();
        controller.setLinkList(llist);
        controller.initChoiceBox();

        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



    public void submitPressed() throws IOException {


        if(!yes1.isSelected()&&!no1.isSelected()){

            errorText.setText("Please Complete The Survey!");
        } else if (!yes2.isSelected()&&!no2.isSelected()){
            errorText.setText("Please Complete The Survey!");
        }else if (!yes3.isSelected()&&!no3.isSelected()){
            errorText.setText("Please Complete The Survey!");
        }else if (!yes4.isSelected()&&!no4.isSelected()){
            errorText.setText("Please Complete The Survey!");
        }



        else{
            printingOptions.printingChoices(choices);
            change();
        }

    }

    public void yes1Selected(){
        choices[0]=1;
        no1.setSelected(false);
    }
    public void no1Selected(){
        choices[0]=0;
        yes1.setSelected(false);
    }

    public void yes2Selected(){
        choices[1]=1;
        no2.setSelected(false);
    }
    public void no2Selected(){
        choices[1]=0;
        yes2.setSelected(false);
    }
    public void yes3Selected(){
        choices[2]=1;
        no3.setSelected(false);
    }
    public void no3Selected(){
        choices[2]=0;
        yes3.setSelected(false);
    } public void yes4Selected(){
        choices[3]=1;
        no4.setSelected(false);
    }
    public void no4Selected(){
        choices[3]=0;
        yes4.setSelected(false);
    }


}
