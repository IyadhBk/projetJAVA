    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.User;
import models.UserDoha;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import technique.DataSource;

/**
 * FXML Controller class
 *
 * @author didid
 */
public class LoginController implements Initializable {
    
    
   @FXML 
    private TextField textUsername;
   @FXML
    private PasswordField textPassword;
   
   Stage dialogStage = new Stage();
   Scene scene;
   
   Connection connection =null;
   PreparedStatement preparedStatement =null;
    ResultSet resultSet =null;
   public static int id;
   
   public LoginController()
   {
       connection=DataSource.getInstance().getConnection();
   }
   
   public void loginAction(ActionEvent event )
   {   String username= textUsername.getText().toString();
       String password =textPassword.getText().toString();
       
       String sql ="SELECT * FROM test_user WHERE username = ? and password = ?  ";
       try {
           preparedStatement  = connection.prepareStatement(sql);
           preparedStatement.setString(1, username);
           preparedStatement.setString(2, password);
           resultSet= preparedStatement.executeQuery();
              User user = new User();
           
           if(!resultSet.next())
           {
               infoBox("Please enter your correct Username and Password", null, "Failed");
              }
           else
           {   id = resultSet.getInt("id_user");
             infoBox("Login Successfull", null, "Success");
             Node node =(Node)event.getSource();
             dialogStage= (Stage) node.getScene().getWindow();
             dialogStage.close();
             scene= new Scene(FXMLLoader.load(getClass().getResource("/GUI/Prdv.fxml")));
             dialogStage.setScene(scene);
             dialogStage.show();
             
               }

           
       } 
       catch(Exception e){
           e.printStackTrace();
       }
      }
   
   public static void infoBox(String infoMessage,String headerText,String title)
   {
       Alert alert =new Alert(AlertType.CONFIRMATION);
       alert.setContentText(infoMessage);
       alert.setTitle(title);
       alert.setHeaderText(headerText);
       alert.showAndWait();
       
      }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
