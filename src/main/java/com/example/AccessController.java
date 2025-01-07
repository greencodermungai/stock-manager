package com.example;

import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import com.example.backend.Person;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccessController {
     /*this methid switches sceens when the sighn up button is pushes, from login page to sighnup page */
    @FXML
    private void switchToSighnup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sighnup.fxml"));
        Scene scene2 = new Scene(loader.load());
        Stage stage = (Stage) username.getScene().getWindow();
        stage.setScene(scene2);
    }
    /*this method is used to go back to the login menu from the sighnup menu */
    @FXML
    private void returnToLogin() throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
      Scene scene2 = new Scene(loader.load());
      Stage stage = (Stage) user_name.getScene().getWindow();
      stage.setScene(scene2);
   }

   /*this method invokes the action of putting costomer information into a database and creating the person object
    * this is done when they click the sighn up button.
    */
   @FXML
   private void sighnupUser() throws Exception{
      try {
        int id = Person.createAccount(first_name.getText(), last_name.getText(), passwordField2.getText(), user_name.getText());
        if (id > 0) {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Mainpage.fxml"));
        Scene scene2 = new Scene(loader.load());
        Stage stage = (Stage) user_name.getScene().getWindow();
        stage.setScene(scene2);
          Person.person = Person.createPerson(id);
        } else {System.out.println("person not found");}
      } catch (SQLClientInfoException e) {
        System.out.println("connection to DB could not be established");
      } 
   }
   
  /*this login method invokes the action of getting costomer information from the database to log them in
   * this id done when they click the login button
   */
  @FXML
  private void Loginperson() throws Exception {
    try {
      int id =  Person.login(passwordField.getText(), username.getText());
      if (id > 0) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mainpage.fxml"));
        Scene scene2 = new Scene(loader.load());
        Stage stage = (Stage) username.getScene().getWindow();
        stage.setScene(scene2);
        Person.person = Person.createPerson(id);
      } else {System.out.println("person not found");}
    } catch (SQLException e) {
      System.out.println("person not found in database");
    }
  }

   /*password feild for login page */
   @FXML
   private PasswordField passwordField;

   /*username feild for login page */
   @FXML
   private TextField username;

   /*first name feild for create account page */
   @FXML
   private TextField first_name;

   /*last name text feild for create account page */
   @FXML
   private TextField last_name;

   /*passkey feild for create account page  */
   @FXML
   private PasswordField passwordField2;

   /*text feild for user name create account */
   @FXML
   private TextField user_name;
   
  
}