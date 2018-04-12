/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.Animation;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import com.lynden.gmapsfx.shapes.Circle;
import com.lynden.gmapsfx.shapes.CircleOptions;
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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Association;
import models.User;
import services.AssociationService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class AjouterAssociationFrontController implements Initializable,MapComponentInitializedListener {

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
    
    private File file;
    @FXML
    private Button affiche;
    @FXML
    private GoogleMapView mapView;
    
    
     private StringProperty address = new SimpleStringProperty(); 
          
    private GoogleMap map;
    
    private GeocodingService geocodingService;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mapView.addMapInializedListener((MapComponentInitializedListener) this);
        address.bind(addresse.textProperty());
        
        
        
        // TODO
    }    
    
    IAssociationService service = new AssociationService();

    @FXML
    private void backAcceuil(MouseEvent event) {
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/Acceuil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
          
    }

    @FXML
    private void frontAssociationettoilitages(MouseEvent event) {
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AssociationetToilitages.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
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

    @FXML
    private void AjouterAssociation(ActionEvent event) {
        
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
        
        
        if (ControleSaisie()) {
            
            
            geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {
        String lieuName = address.getValue();
        double latitude = results[0].getGeometry().getLocation().getLatitude();
       
        double longitude = results[0].getGeometry().getLocation().getLongitude();
            User u = new User(1);
         Association  a  = new Association(2,nomassociation.getText(),latitude,longitude,addresse.getText(),email.getText(),Integer.parseInt(numtel.getText()),myimg)
              
                   ;
      service.ajouterAssociation(a);
      
      viderText();
      
      
       
     });
        }
    }
     private boolean ControleSaisie(){
       boolean valide = true ;
               if(nomassociation.getText().equals("")||addresse.getText().equals("")||email.getText().equals("")||numtel.getText().equals("")){
                   valide = false ;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champ obligatoire");
            alert.setContentText("veuiller remplir tous les champs!");

            alert.showAndWait();
               }
              
        return valide;
                
     

    
    }
     
       private void viderText(){
           nomassociation.setText("");
           email.setText("");
           numtel.setText("");
           addresse.setText("");
           
    }

    @FXML
    private void affichageAssociation(ActionEvent event) {
        
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AfficherFrontAssociation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void addressTextFieldAction(ActionEvent event) {
        
        geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {
            
            LatLong latLong = null;
            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
           //Add markers to the map
               LatLong tunisLocation = new LatLong(results[0].getGeometry().getLocation().getLatitude(),results[0].getGeometry().getLocation().getLongitude());
                MarkerOptions markerOptions1 = new MarkerOptions();
                markerOptions1.position(tunisLocation).title("Hello to "+address.getValue())
                //.icon("/utils.assets/ASSOCIATION.jpg")
                .animation(Animation.DROP)
                .visible(true);
                
                Marker tunisMarker = new Marker(markerOptions1);
                map.addMarker( tunisMarker );
                
              LatLong centreC = new LatLong(results[0].getGeometry().getLocation().getLatitude(),results[0].getGeometry().getLocation().getLongitude());
        CircleOptions cOpts = new CircleOptions()
                .center(centreC)
                .radius(1200)
                .strokeColor("red")
                .strokeWeight(2)
            //    .fillColor("orange")
                .fillOpacity(0.3);

        Circle c = new Circle(cOpts);
        map.addMapShape(c);
             
            
         
      
            
            
            
            
            
            }
            
            map.setCenter(latLong);
        });
    }

    @Override
    public void mapInitialized() {
        geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        /*LatLong tunisLocation = new LatLong(36.7948624,10.0732371);*/
        
        mapOptions.center(new LatLong(37.2751263,9.8277269))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(9);

        map = mapView.createMap(mapOptions);
    }

    
}
