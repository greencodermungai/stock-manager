package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class AccessController {
     /*this methid switches sceens when the sighn up button is pushes, from login page to sighnup page */
    @FXML
    private void switchToSighnup() throws IOException {
        App.setRoot("Sighnup");
    }
    /*this method is used to go back to the login menu from the sighnup menu */
    @FXML
    private void returnToLogin() throws IOException {
        App.setRoot("login");
   }


}