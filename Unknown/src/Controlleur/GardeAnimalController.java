/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Controlleur.AnimauxViewController;
import iservices.IAnimauxService;
import iservices.IGardeService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import static java.nio.file.Files.list;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Animaux;
import models.Association;
import models.Garde;
import models.User;
import services.AnimauxService;
import services.AssociationService;
import services.GardeService;

/**
 * FXML Controller class
 *
 * @author s
 */
public class GardeAnimalController implements Initializable {

    @FXML
    private VBox parent;
    @FXML
    private Label acceuil;
    @FXML
    private Label services;
    @FXML
    private Label produits;
    @FXML
    private Label veterinaires;
    @FXML
    private Label evenements;
    @FXML
    private Label espace;
    @FXML
    private Button btnValider;
    @FXML
    private TextField AgeAnimaux;
    @FXML
    private ChoiceBox GardeAnimaux;
    @FXML
    private ChoiceBox  AssociationAnimaux;
    @FXML
    private TextField ColeurAnimaux;
    @FXML
    private TextField NomAnimaux;
    @FXML
    private ChoiceBox TypeAnimaux;
    @FXML
    private ChoiceBox SexeAnimaux;
    @FXML
    private Button Afficher;
    @FXML
    private ImageView imgview;
     @FXML
    private File file;
    
    List<Garde> listGarde;
    List<Association> listAssociation;
    List<User> user;
    IAnimauxService serviceAnimaux =new AnimauxService();
      IGardeService serviceGarde =new GardeService();
      AssociationService associationservice = new AssociationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String> v;
        v = FXCollections.observableArrayList();
        listAssociation= associationservice.getAssociation();
        for(Association g: listAssociation) {
           v.add(g.getNom_association());
        }
       AssociationAnimaux.setItems(v);
       
       
        ObservableList<String> value;
       value = FXCollections.observableArrayList();
        listGarde= serviceGarde.getGarde();
        for(Garde g: listGarde) {
           value.add(g.getNom());
        }
        GardeAnimaux.setItems(value);
        
        
        ObservableList<String> v1;
        v1 = FXCollections.observableArrayList("chien","chat","oiseaux");
        TypeAnimaux.setItems(v1);
        
        ObservableList<String> v2;
        v2 = FXCollections.observableArrayList("male","Femelle");
       SexeAnimaux.setItems(v2);
    }    

    @FXML
    private void AjouterAnimaux(ActionEvent event) {
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
    User U =new User(25);
    if (ControleSaisie()){
    
    Animaux A =new Animaux(NomAnimaux.getText(),TypeAnimaux.getSelectionModel().getSelectedItem().toString(),ColeurAnimaux.getText(),AgeAnimaux.getText(),SexeAnimaux.getSelectionModel().getSelectedItem().toString(),gardeA,U,myimg,asso);
    
    serviceAnimaux.ajoutAnimaux(A);
    vidertxt();
    }
   
    }
    
     private void vidertxt(){
       NomAnimaux.setText("");
       ColeurAnimaux.setText("");
       AgeAnimaux.setText("");
    }
     private boolean ControleSaisie() {
        boolean valide = true;
        if(NomAnimaux.getText().equals("") ||ColeurAnimaux.getText().equals("") || AgeAnimaux.getText().equals(""))
        {
            valide=false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champ obligatoire");
            alert.setContentText("veuiller remplir tous les champs!");

            alert.showAndWait();
        }
        else {
            try 
        {
            int nb = Integer.parseInt(AgeAnimaux.getText());
            if (nb>10) {
                valide = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champ obligatoire");
            alert.setContentText("Age max");

            alert.showAndWait();
                    
            }
            if (nb<1) {
                valide = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champ obligatoire");
            alert.setContentText("la capacité doit eytre positive");

            alert.showAndWait();
            }
            
        }
        catch(NumberFormatException e) {
            valide = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("type erronée");
            alert.setContentText("veuiller saisir un nombre dans l'age");

            alert.showAndWait();
            
        }
        
        }
          if (!valide) {
            vidertxt();
        }
        
        return valide;
    
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
    private void Afficher(ActionEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AfficherUserAnimaux.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
    public void acceuil1(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/Acceuil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
               // app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
          System.out.println(ex); 
        
    }
    }
            
            
            
}
