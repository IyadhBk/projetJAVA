/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author didid
 */
public class VetAfterLoginController implements Initializable {

    
    @FXML
    private Hyperlink GestArticle;

    @FXML
    private Hyperlink statistic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    void GestArticle(ActionEvent event) {
        
        try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/insertArticle.fxml"));
                            Region root = (Region) loader.load();
                           InsertArticleController insert = loader.<InsertArticleController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                           
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(InsertArticleController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            }

    @FXML
    private void statistic(ActionEvent event) {
        
        
         try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Stat.fxml"));
                            Region root = (Region) loader.load();
                           StatController stat = loader.<StatController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                           
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(InsertArticleController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            }
    
    
    
    
      @FXML
    void logOut(MouseEvent event) {
        
        
                try {
                            Stage st = new Stage();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/UserDocument.fxml"));
                            Region root = (Region) loader.load();
                        //   LoginController stat = loader.<LoginController>getController();
                           
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.hide();
                           
                            Scene scene = new Scene(root);
                            st.setScene(scene);
                            st.show();

                        } catch (IOException ex) {
                            Logger.getLogger(InsertArticleController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            }
}
        
        

  
    
    
    
       
        
    
    
    

