/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.reclamation;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.Reclamationservice;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
  

/**
 * FXML Controller class
 *
 * @author jihen
 */
public class AfficheController implements Initializable {

    @FXML
    private TableView<reclamation> TvTraite;
    @FXML
    private TableColumn<reclamation,Integer> ClId;
    @FXML
    private TableColumn<reclamation, String> ClIdUtilisateur;
    @FXML
    private TableColumn<reclamation, String> ClIdService;
    @FXML
    private TableColumn<reclamation, ImageView> ClDescription;
    @FXML
    private Button afficher;
      static String IMAGE;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher(ActionEvent event) throws ParseException {
         Reclamationservice es = new Reclamationservice();
         
       
       ClId.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        ClIdService.setCellValueFactory(new PropertyValueFactory<>("animalConcerné"));
        ClDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        
            

         ClDescription.setCellValueFactory(new PropertyValueFactory<>("image"));
         ObservableList<reclamation> data = es.lister();
     IMAGE =  data.get(0).getImage();
       Image imag = new Image("file:///C:/users/jihen/PII/src/Interfaces/jihen.jpg");

        image.setImage(imag);
      
               TvTraite.setItems(data);

        
    }
    
}
