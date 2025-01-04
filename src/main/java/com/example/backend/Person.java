package com.example.backend;
import java.sql.*;
public class Person {

   /*person object is created using a database quary */
   public Person(int id) throws SQLException {
      final String url = "jdbc:mysql://localhost:3306/portfoliomanagmentuserdatabase";
      final String DBusername = "root";
      final String password = "Qazxsw#781!";
      /*this try statement estableshes a connection to a database */
      try {
         Connection DBconnection = DriverManager.getConnection(url, DBusername, password);
         String query = "SELECT * FROM person_information WHERE id = ?";
         PreparedStatement preparedStatement = DBconnection.prepareStatement(query);
         preparedStatement.setInt(1, id);
         ResultSet results = preparedStatement.executeQuery();
         /*this block is to get the results of the quary call and assign them to varibles that the object will hold */
            if (results.next()) {
            this.first_name = results.getString(2);
            this.last_name = results.getString(3);
            this.passkey = results.getString(4);
            this.user_name = results.getString(5);
            } else {System.out.println("doesnt have next ");}
            } catch (SQLClientInfoException e) {
            System.out.println("connection to DB could not be established");
            }
   }
      /*since this constructor has a try catch exeption creating an instance of this object will also require one. since we dont
      want to do that everytime we need The person object i created a static method that can create a person object
      from any were in the project as long as an id is provided */     
      public static Person createPerson(int id)  {
         try {
         Person person = new Person(id);
         return person; 
         } catch (Exception e) {
         System.out.println("person was not found in database " + e.getMessage());
         }
      return null;
      }
      
      /*maby this isnt the best way to do this but when some one tries to create an account this method adds there information to the database
       * and returns the persons id so that i can use that id to make the person object
       */
      public static int  createAccount(String firstname, String lastname, String passkey, String username) throws SQLException {
            final String url = "jdbc:mysql://localhost:3306/portfoliomanagmentuserdatabase";
            final String DBusername = "root";
            final String password = "Qazxsw#781!";
            /*this try statement estableshes a connection to a database
             * security is weak here since im not checking the value of the variabls, will fix once i figure
             * out how to insert variables into tables
             */
            try {
               Connection DBconnection = DriverManager.getConnection(url, DBusername, password);
               String query = "INSERT INTO person_information (first_name, last_name, passkey, user_name) VALUES (?, ?, ?, ?)";
               PreparedStatement preparedStatement = DBconnection.prepareStatement(query);
               preparedStatement.setString(1, firstname);
               preparedStatement.setString(2, lastname);
               preparedStatement.setString(3, passkey);
               preparedStatement.setString(4, username);
               preparedStatement.executeUpdate();
               String query2 = "SELECT id  FROM person_information WHERE first_name = ? AND last_name = ? AND passkey = ? AND user_name = ?";
               PreparedStatement preparedStatement2 = DBconnection.prepareStatement(query2);
               preparedStatement2.setString(1, firstname);
               preparedStatement2.setString(2, lastname);
               preparedStatement2.setString(3, passkey);
               preparedStatement2.setString(4, username);
               ResultSet results = preparedStatement2.executeQuery();
               if (results.next()) {
                  return results.getInt("id"); 
                  } else {System.out.println("doesnt have next ");}
                  return results.getInt("id");
            }  catch (SQLException e) {
               System.out.println("connection to DB could not be established");
               }
            return -1;
      }

      /*this method is an existing user logging in */
      public static int  login(String passkey, String username) throws SQLException {
         final String url = "jdbc:mysql://localhost:3306/portfoliomanagmentuserdatabase";
         final String DBusername = "root";
         final String password = "Qazxsw#781!";
         try {
            Connection DBconnection = DriverManager.getConnection(url, DBusername, password);
            String query2 = "SELECT id  FROM person_information WHERE passkey = ? AND user_name = ?";
            PreparedStatement preparedStatement = DBconnection.prepareStatement(query2);
            preparedStatement = DBconnection.prepareStatement(query2);
            preparedStatement.setString(1, passkey);
            preparedStatement.setString(2, username);
            ResultSet results = preparedStatement.executeQuery();
            if (results.next()) {
               return results.getInt("id"); 
               } else {System.out.println("doesnt have next ");}
               return results.getInt("id");
         }  catch (SQLException e) {
            System.out.println("connection to DB could not be established");
            }
         return -1;
   }
      /* get persons first name */
      
      public String getFirstName() {
         return this.first_name;
      }

      /*get persons last name */
      public String getLastName() {
         return this.last_name;
      }

      /*public strong get user name */

      public String getUserNmae() {
         return this.user_name;
      }
public static int id;                        
public String first_name;
public String last_name;
public String passkey;
public String user_name;
public static Person person;
}
