/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import services.FODUSER_service;

/**
 * FXML Controller class
 *
 * @author jihen
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private TextField rpass;
    @FXML
    private Button register_btnn;
    @FXML
    private TextField numtel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registerAction(ActionEvent event) throws SQLException, IOException { 
        User user = new User();
        boolean verif ;
        FODUSER_service ss = new FODUSER_service();
          if( ss.verifusername(username.getText()) == 0 && ss.verifmail(mail.getText()) == 0 && mail.getText().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{1,4}$") ){
         user.setUsername(username.getText());
          
     
        
        user.setUsername(username.getText());
        user.setEmail(mail.getText());
        user.setPassword(FODUSER_service.hashPassword(pass.getText()));
        user.setRoles("a:1:{i:0;s:9:\"ROLE_ADMIN\";}");
        user.setNum_tel(Integer.parseInt(numtel.getText()));
          
        boolean register = ss.register(user);
              
        System.out.println(register);
        
   
          Stage stage = new Stage();
      
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/UserDocument.fxml"));
                Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/Style.css");
                stage = (Stage) register_btnn.getScene().getWindow();
                stage.close();
                stage.setScene(scene);
                stage.show();
        
         }
    }
     @FXML
    private void color(KeyEvent event) throws SQLException {
        System.out.println("12");
       FODUSER_service ss = new FODUSER_service() ;
       System.out.println(ss.verifmail(mail.getText()));
       // && ss.verifmail(mail.getText()) == 1
       //!mail.getText().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{1,4}$") &&
            if( ss.verifmail(mail.getText()) == 1 || !mail.getText().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{1,4}$") ){
                //when it not matches the pattern (1.0 - 6.0)
                //set the textField empty
                mail.setStyle("-fx-background-color: red");
            }
                else{
                mail.setStyle("-fx-background-color: green");
            }
    
    
}

    @FXML
    private void colorusername(KeyEvent event) throws SQLException {
        System.out.println("ffffffffff");
       //  mail.setStyle("-fx-background-color: red");
        FODUSER_service ss = new FODUSER_service() ;
       // && ss.verifmail(mail.getText()) == 1
       //!mail.getText().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{1,4}$") &&
            if( ss.verifusername(username.getText()) == 1 ){
                //when it not matches the pattern (1.0 - 6.0)
                //set the textField empty
                username.setStyle("-fx-background-color: red");
            }
                else{
                username.setStyle("-fx-background-color: green");
            }
    
    }

    @FXML
    private void checkr(KeyEvent event) {
               // FOSUser_service ss = new FOSUser_service() ;

         if( (pass.getText() == null ? rpass.getText() == null : pass.getText().equals(rpass.getText())) ){
             rpass.setStyle("-fx-background-color: green");
         }
                else{
             //when it not matches the pattern (1.0 - 6.0)
             //set the textField empty
             rpass.setStyle("-fx-background-color: red");
         }
    
    }

    @FXML
    private void numonly(KeyEvent event) {
        String s = new String();
        if (numtel.getText().matches("[0-9]*")){
         s = numtel.getText();
        }else{
        numtel.setText(s);
        numtel.positionCaret(s.length());
        }
        
    }
}
    
        
         
    
    
    

