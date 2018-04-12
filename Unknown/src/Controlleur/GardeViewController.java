/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;


import iservices.IGardeService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Garde;
import services.GardeService;

/**
 * FXML Controller class
 *
 * @author s
 */
public class GardeViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    TextField Nom;
    @FXML
    TextField capacite;
    @FXML
    TextField adresse;
    @FXML
    Button btnValider;
    @FXML
    ChoiceBox choix;
    @FXML
    RadioButton rdChien ;
    @FXML
    RadioButton rdChat;
    @FXML
    private HBox ev;
    
    
    
    @FXML
    private TableView<Garde> AfficherGarde;
    @FXML
    private TableColumn<Garde, Integer> ColonneId;
    @FXML
    private TableColumn<Garde, String> ColonneNom;
    @FXML
    private TableColumn<Garde, Integer> ColonneCapacite;
    @FXML
    private TableColumn<Garde,String> ColonneAdresse;        
    
    
    IGardeService serviceGarde =new GardeService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
//        ObservableList<String> value;
//        value = FXCollections.observableArrayList("v1","v2","v3");
//        List<Garde> listGarde= serviceGarde.getGarde();
//        for(Garde g: listGarde) {
//            value.add(g.getNom());
//        }
        
        
        
        
        //choix.setItems(value);
    } 
     @FXML
    void afficherGarde(ActionEvent event) throws IOException {
    
   ObservableList<Garde> listGarde = 
        serviceGarde.getGarde().stream()
            .collect(collectingAndThen(toList(), l -> FXCollections.observableArrayList(l)));
        
        ColonneId.setCellValueFactory(new PropertyValueFactory<>("id") );
         ColonneNom.setCellValueFactory(new PropertyValueFactory<>("Nom") );
       ColonneCapacite.setCellValueFactory(new PropertyValueFactory<>("Capacité") );
       ColonneAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse") );
        AfficherGarde.setItems(null);
        AfficherGarde.setItems(listGarde);
         //System.out.println(listGarde.toString());

        AfficherGarde.sort();
    
    }
    
   
  
    @FXML
    public void AjouterGarde(ActionEvent event) {
//        System.out.println("inside Action");
//        System.out.println("Nom "+Nom.getText());
//        System.out.println("Capacité " + Integer.parseInt("23"));
//        System.out.println("Adresse "+adresse.getText());
        if (ControleSaisie()) {
        Garde G =new Garde(Nom.getText(),Integer.parseInt(capacite.getText()),adresse.getText());
       
        serviceGarde.ajoutGarde(G);
        vidertxt();
        }
        
    }
   
   
    private void vidertxt(){
        adresse.setText("");
        Nom.setText("");
        capacite.setText("");
    }
    private boolean ControleSaisie() {
        boolean valide = true;
        if(adresse.getText().equals("") ||Nom.getText().equals("") || capacite.getText().equals(""))
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
            int nb = Integer.parseInt(capacite.getText());
            if (nb>10) {
                valide = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champ obligatoire");
            alert.setContentText("capacité max");

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
            alert.setContentText("veuiller saisir un nombre dans capacite");

            alert.showAndWait();
            
        }
        
        }
            
        if (!valide) {
            vidertxt();
        }
        return valide;
    }
      @FXML
    private void ClickStore(MouseEvent event) {
        
       try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/StoreAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void ClickEvenement(MouseEvent event) {
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/EvenementAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
               // app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

  @FXML
    private void ClickEncheres(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AnimauxGarde.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }


    @FXML
    private void ClickServices(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/ServiceAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
            //    app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void ClickVeterinaire(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/VeterinaireAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
               // app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void ClickProduit(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/ProduitAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void HomeClick(ActionEvent event) {
              try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/HomeAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
              //  app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
     @FXML
    private void Garde(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/GardeView.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
}
    
    
    

