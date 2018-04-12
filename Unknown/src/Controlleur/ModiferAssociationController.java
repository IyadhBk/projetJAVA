/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.lynden.gmapsfx.GoogleMapView;
import iservices.IAssociationService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Association;
import services.AssociationService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class ModiferAssociationController implements Initializable {

    @FXML
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Label Animaux;
    @FXML
    private TextField nomassociation;
    @FXML
    private TextField email;
    @FXML
    private TextField numtel;
    @FXML
    private TextField addresse;
    @FXML
    private ImageView imgview;
    @FXML
    private Button btnAssociation;
    @FXML
    private Button afiiche;
    
    private File file;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              int id = AffichageAssociationController.id;
       IAssociationService service = new AssociationService();
      Association a = service.findby(id);
        
       
        
         nomassociation.setText(a.getNom_association());
         email.setText(a.getEmail());
          numtel.setText(a.getNum_tel()+"");
         addresse.setText(a.getAdresse());
       
        // TODO
    }    

    @FXML
    private void HomeClick(ActionEvent event) {
    }

    @FXML
    private void ClickStore(MouseEvent event) {
    }

    @FXML
    private void ClickEvenement(MouseEvent event) {
    }

    @FXML
    private void ClickEncheres(MouseEvent event) {
    }

    @FXML
    private void ClickServices(MouseEvent event) {
    }

    @FXML
    private void ClickVeterinaire(MouseEvent event) {
    }

    @FXML
    private void ClickProduit(MouseEvent event) {
    }

   

    @FXML
    private void uploadImage(MouseEvent event) {
         FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString(),
                    100, 150, true, true);
            imgview.imageProperty().unbind();
            imgview.setImage(img);
            imgview.setFitWidth(200);
            imgview.setFitHeight(150);
            
            

        } 
   

    }


    @FXML
    private void affichage(ActionEvent event) {
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AffichageAssociation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
            
    }

    @FXML
    private void modiferAssociation(ActionEvent event) {
        
        int id = AffichageAssociationController.id;
       IAssociationService service = new AssociationService();
       
           String myimg;

        if (file != null) {
            String[] tmp = file.toURI().toString().split("/");
            myimg = (tmp[tmp.length - 1]);
                
            
            try {
            Path to = Paths.get("C:\\xampp\\htdocs\\Association");
                  System.out.println(file.getName());
           Files.copy(file.toPath(), to.resolve(file.getName()),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(
                AjouterAssociationController.class.getName()).log(
                   Level.SEVERE, null, ex
              );
       }
            
        } else {
            myimg = "NONE";
        }
        Association  a  = new Association (id,nomassociation.getText(),addresse.getText(),email.getText(),Integer.parseInt(numtel.getText()),myimg);
        service.modifierAssociation(a);
    }

    @FXML
    private void addressTextFieldAction(ActionEvent event) {
    }
    
}
