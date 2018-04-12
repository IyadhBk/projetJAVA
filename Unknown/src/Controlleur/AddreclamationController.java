/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import static com.google.common.io.Files.copy;
import models.reclamation;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javafx.scene.image.WritableImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.Reclamationservice;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.mail.MessagingException;
import javafx.scene.image.ImageView;
//import static java.awt.PageAttributes.MediaType.A;
//import static java.awt.PageAttributes.MediaType.A;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;

import java.net.MalformedURLException;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import service.upload;

/**
 * FXML Controller class
 *
 * @author jihen
 */
public class AddreclamationController implements Initializable {

    @FXML
    private ImageView outimg;
    @FXML
    private ComboBox<String> cbIdUser;
    @FXML
    private Label LbIdUser;
    @FXML
    private TextArea Tadescription;
    @FXML
    private TextArea jihen;
    @FXML
    private Label LbDescription;
    @FXML
    private Button btConfirmer;
    @FXML
    private Label annimal;
    @FXML
    private Label lab;
    @FXML
    private Button imf;
    private ImageView img;
     static String des;
    static String animal;
    public String  imageUrl;
    
    int file = 0;
    int c ;
     File pDir ;
     File pfile ;
      String lien ;
    @FXML
    private TextField fieldimg;
 
    /**
     * Initializes the controller class.
     */
    
  
   
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lab.setVisible(true);
       file = 0;
       
         c = (int)( Math.random()*( 300000 - 2 + 1 ) ) + 2; 
           pDir = new File("src/Interfaces/images/objet"+c+".jpg");
            lien = "images/objet"+c+".jpg" ;
            // TODO
            Reclamationservice ss = new Reclamationservice ();
            List <String> data ;
            
            try {
                data = ss.listerUser();
                cbIdUser.getItems().addAll(data);
            } catch (ParseException ex) {
                Logger.getLogger(AddreclamationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(AddreclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
    

    @FXML
    private void onOutImage(MouseEvent event) throws IOException {
        
        
        
             Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));
                Scene scene = new Scene(root);
               // scene.getStylesheets().add("/CSS/Style.css");
                stage = (Stage) outimg.getScene().getWindow();
                stage.close();
                stage.setScene(scene);
                //stage.setFullScreen(true);
               stage.centerOnScreen();
                stage.show();
       
    }
    
    
    

    

    @FXML
    private void confirmer(ActionEvent event) throws IOException, ParseException, SQLException, MessagingException {
          Reclamationservice es = new Reclamationservice();
          file = 0;
          
         
        int idUser= es.GetUserIDByName(cbIdUser.getValue());
         if ( validateFields()){
             
       
                       
            reclamation sm = new reclamation(idUser,Tadescription.getText(),jihen.getText(),0,fieldimg.getText());
                    
           
            es.add(sm);
              saveAlert(sm);
         }
              
        Parent p1 = FXMLLoader.load(getClass().getResource("/GUI/zanimaux.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
         //           String contenue="Une nouvelle Reclmamation est en attente de traitement: ";
       // es.sendMail("jihene.yahayoui@esprit.tn", "J09927167", "Admin demandé", contenue);
        
        
    }
        private void saveAlert(reclamation sm) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Service saved successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The service of  "  +sm.getId()+ " has been created");
        alert.showAndWait();
    }
   
  
   
    

   

    
     private boolean validateFields(){
        
        if(Tadescription.getText().isEmpty()){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter  une description");
                alert.showAndWait();
                
                return false;
        }
        
         if(jihen.getText().isEmpty()){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter  animal");
                alert.showAndWait();
                
                return false;
        }
         return true;
          
    }

    @FXML
    private void ParcourirImage(ActionEvent event) throws IOException {
             FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            upload u = new upload();
            u.upload(selectedFile);
            fieldimg.setText(selectedFile.getName());

        }
    }

    @FXML
    private void choose(MouseEvent event) {
    }

    
    //--------------------------------------------------------------------------
        
@FXML
    private void Produit (MouseEvent event) throws IOException
    {
        
        
       try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
    
             
            @FXML
    private void ClickProduit(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
    @FXML
        private void ClickService(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AffichageAccueil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
     @FXML   
   private void ClickVeterinaires(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/afficherArticle.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
   @FXML
      private void ClickEvenements(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/Front.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
      @FXML
            private void ClickEspace(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AssociationetToilitages.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
     @FXML       
 private void logout(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/UserDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
    //--------------------------------------------------------------------------
}

