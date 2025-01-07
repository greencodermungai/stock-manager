package com.example;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.Person;

public class MainPageController {
  

    @FXML
    public void backToLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene2 = new Scene(loader.load());
        Stage stage = (Stage) searchbutton.getScene().getWindow();
        stage.setScene(scene2);
       
    }
    @FXML
    private Button searchbutton;

    @FXML
    public void getSearchResults() {
        try {
            // Load Scene 2
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchresults.fxml"));
            Scene scene2 = new Scene(loader.load());

            // Get Scene2Controller to update the button text
            searchresultsController scene2Controller = loader.getController();
            scene2Controller.setButtonText();
            
        
            // Switch to Scene 2
            Stage stage = (Stage) searchbutton.getScene().getWindow();
            stage.setScene(scene2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }
