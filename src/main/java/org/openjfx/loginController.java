package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class loginController {
    @FXML
    TextField usernameBox;

    @FXML
    PasswordField password;
    
    @FXML
    Label loginError;

    @FXML
    Button closeButton;

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }



    @FXML
    private void login() throws IOException {
        screenLogin us = new screenLogin();

        String User, Pass;
        int action;

        User = usernameBox.getText();
        Pass = password.getText();

        action = us.CheckUser(User,Pass);

        if((action == 2)){
            App.setRoot("mainMenu");
        }
        else if(action == 0){
            loginError.setText("Wrong Password, Try Again");
        }
        else if(action == 1){
            loginError.setText("User does not exist, Try Again");
        }
    }



}
