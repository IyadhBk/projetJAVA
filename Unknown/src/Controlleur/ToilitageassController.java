/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.MapStateEventType;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.lynden.gmapsfx.shapes.Circle;
import com.lynden.gmapsfx.shapes.CircleOptions;
import com.lynden.gmapsfx.shapes.Polygon;
import com.lynden.gmapsfx.shapes.PolygonOptions;
import iservices.IToilitageService;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Toilitages;
import services.ToilitageService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class ToilitageassController implements Initializable, MapComponentInitializedListener {

    @FXML
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Label Animaux;
    
    @FXML
    private TextField NOMToilitages;
    @FXML
    private TextField numtel;

    
    @FXML
    private ImageView imgview;
    @FXML
    private Button btntoillitage;
    
    private File file;
    @FXML
    private TextField des;
   
    @FXML
    private TextField addresse;

    /**
     * Initializes the controller class.
     */
    @FXML
    private GoogleMapView mapView;
   
   private StringProperty address = new SimpleStringProperty(); 
          
    private GoogleMap map;
    
    private GeocodingService geocodingService;
    @FXML
    private Button affiche;
   
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
        address.bind(addresse.textProperty());
    }    
   
     IToilitageService service = new ToilitageService();
    
    @FXML
    public void AjouterToillatages(ActionEvent event){
        
        
         String myimg;

        if (file != null) {
            String[] tmp = file.toURI().toString().split("/");
            myimg = (tmp[tmp.length - 1]);

            
            try {
            Path to = Paths.get("C:\\xampp\\htdocs\\Toilitages");
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
        
       
        
       
     Toilitages  toilitages  = new Toilitages(NOMToilitages.getText(),des.getText(),Integer.parseInt(numtel.getText()),addresse.getText(),latitude,longitude,myimg);

        
       
      
      service.ajouterToilitage(toilitages);
      
      viderText();
        System.out.println(lieuName+" ajouter avec succées");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajouter toilitage");
            alert.setHeaderText("Felicitation");
            alert.setContentText("Toilitage ajouté");

            alert.showAndWait();
    
     
       
        
    
    });
            
              
                   
      
      
      
    }
}
    private void viderText(){
        NOMToilitages.setText("");
        des.setText("");
        numtel.setText("");
        
        
        
    }
    
 private boolean ControleSaisie(){
       boolean valide = true ;
               if(NOMToilitages.getText().equals("")||des.getText().equals("")||numtel.getText().equals("")||addresse.getText().equals("")){
                   valide = false ;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champ obligatoire");
            alert.setContentText("veuiller remplir tous les champs!");

            alert.showAndWait();
               }
              
                
                if (!valide) {
            viderText();
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
    private void ClickServices(MouseEvent event) {
        
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AssociationetToilitagesback.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    private void ClickToilitages(MouseEvent event) {
        
           try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/Toilitageass.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

   

    private void backAD(ActionEvent event) {
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

    private void backAdmin(ActionEvent event) {
         try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/HomeAdmin.fxml"));
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
    private void ClickVeterinaire(MouseEvent event) {
    }

    @FXML
    private void ClickProduit(MouseEvent event) {
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

    @FXML
    private void affiche(ActionEvent event) {
        
        
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AffichageToilitages.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
        
        
    }
    
    
   
}
    

