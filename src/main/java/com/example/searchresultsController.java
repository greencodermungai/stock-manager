package com.example;

import java.util.ArrayList;

import org.json.JSONObject;
import org.w3c.dom.events.EventException;

import com.example.backend.StockAPI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class searchresultsController {
    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

   private ArrayList<Button> listofButtons = new ArrayList<>();

    public void setButtonText(String ticker) throws Exception{
        try {
            listofButtons.add(Button1);
            listofButtons.add(Button2);
            listofButtons.add(Button3);
            listofButtons.add(Button4);
            listofButtons.add(Button5);
            listofButtons.add(Button6);
            listofButtons.add(Button7);
            listofButtons.add(Button8);
            for (int i = 0; i < listofButtons.size(); i++) {
                //ArrayList<JSONObject> list = StockAPI.getStockTickers(ticker);
                //String builtString = " " + list.get(i).getString("2. name");
                listofButtons.get(i).setText("john" + i);
            }
        } catch (EventException e) {
            System.out.println("Button text injection was unsuccessful");
        }

    }

    @FXML
    public void returntomenue() throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Mainpage.fxml"));
            Scene scene2 = new Scene(loader.load());
            Stage stage = (Stage) Button1.getScene().getWindow();
            stage.setScene(scene2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("this method has been used");
    }

    
}
