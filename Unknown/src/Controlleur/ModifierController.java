/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Controlleur.AfficherAnimauxController;
import Controlleur.AnimauxViewController;
import iservices.IAnimauxService;
import iservices.IGardeService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Animaux;
import models.Association;
import models.Garde;
import services.AnimauxService;
import services.AssociationService;
import services.GardeService;

/**
 * FXML Controller class
 *
 * @author s
 */
public class ModifierController implements Initializable {

    @FXML
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Label Animaux;
    @FXML
    private Button btnValider;
    @FXML
    private TextField AgeAnimaux;
    @FXML
    private ChoiceBox GardeAnimaux;
    @FXML
    private ChoiceBox AssociationAnimaux;
    @FXML
    private TextField ColeurAnimaux;
    @FXML
    private TextField NomAnimaux;
    @FXML
    private ChoiceBox TypeAnimaux;
    @FXML
    private ChoiceBox SexeAnimaux;
    
    @FXML
    private ImageView imgview;
     private File file;
     List<Garde> listGarde;
    List<Association> listAssociation;
     IAnimauxService serviceAnimaux =new AnimauxService();
      IGardeService serviceGarde =new GardeService();
      AssociationService associationservice = new AssociationService();
    @FXML
    private Button Retour;
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int id = AfficherAnimauxController.ida;
        Animaux a = serviceAnimaux.findById(id);
//      
         
     ColeurAnimaux.setText(a.getColeur());
     AgeAnimaux.setText(a.getAge());
     
      ObservableList<String> v1;
        v1 = FXCollections.observableArrayList("chien","chat","oiseaux");
        TypeAnimaux.setItems(v1);
        TypeAnimaux.getSelectionModel().select(a.getType());
        
        
        ObservableList<String> v;
        v = FXCollections.observableArrayList();
        listAssociation= associationservice.getAssociation();
        for(Association g: listAssociation) {
           v.add(g.getNom_association());
        }
       AssociationAnimaux.setItems(v);
       AssociationAnimaux.getSelectionModel().select(a.getAssociation());
       
       
       ObservableList<String> v2;
        v2 = FXCollections.observableArrayList("male","Femelle");
       SexeAnimaux.setItems(v2);
       SexeAnimaux.getSelectionModel().select(a.getSexe());
       
        ObservableList<String> value;
       value = FXCollections.observableArrayList();
        listGarde= serviceGarde.getGarde();
        for(Garde g: listGarde) {
           value.add(g.getNom());
        }
        GardeAnimaux.setItems(value);
        GardeAnimaux.getSelectionModel().select(a.getGarde()); }
     @FXML
    private void ModifierAnimaux(ActionEvent event) {
         int id = AfficherAnimauxController.ida;
         Animaux a = serviceAnimaux.findById(id);
        
        String myimg;

        if (file != null) {
            String[] tmp = file.toURI().toString().split("/");
            myimg = (tmp[tmp.length - 1]);
            
            
              try {
            Path to = Paths.get("C:\\xampp\\htdocs\\Animaux_images");
                  System.out.println(file.getName());
            Files.copy(file.toPath(), to.resolve(file.getName()),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(
                AnimauxViewController.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }

        } else {
            myimg = "NONE";
        }
        
     Garde gardeA = null;  
    for(Garde g : listGarde ) {
        if(g.getNom().equals(GardeAnimaux.getSelectionModel().getSelectedItem().toString()))  {
            gardeA=g;
            break;
        }
    } 
        System.out.println("nom formulaire: "+GardeAnimaux.getSelectionModel().getSelectedItem().toString());
        System.out.println("instance " +gardeA);
    
     Association asso = null;  
    for(Association g : listAssociation ) {
        if(g.getNom_association().equals(AssociationAnimaux.getSelectionModel().getSelectedItem().toString()))  {
            asso=g;
            break;
        }
    }
    Animaux A =new Animaux(id,NomAnimaux.getText(),TypeAnimaux.getSelectionModel().getSelectedItem().toString(),ColeurAnimaux.getText(),AgeAnimaux.getText(),SexeAnimaux.getSelectionModel().getSelectedItem().toString(),gardeA,myimg,asso);
         System.out.println(A.toString());
      serviceAnimaux.modifierAnimaux(A); 
      vidertxt();
         
    }
     private void vidertxt(){
       NomAnimaux.setText("");
       ColeurAnimaux.setText("");
       AgeAnimaux.setText("");
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
    private void Retour(ActionEvent event) {
          try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AfficherAnimaux.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
               // app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
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

}
