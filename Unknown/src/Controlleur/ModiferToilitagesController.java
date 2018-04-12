/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.lynden.gmapsfx.GoogleMapView;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import models.Toilitages;
import services.ToilitageService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class ModiferToilitagesController implements Initializable {

    @FXML
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Label Animaux;
    @FXML
    private TextField NOMToilitages;
    @FXML
    private TextField des;
    @FXML
    private ImageView imgview;
    @FXML
    private Button btntoillitage;
    @FXML
    private TextField numtel;
    @FXML
    private GoogleMapView mapView;
    @FXML
    private TextField addresse;
    @FXML
    private Button affiche;
    
    private File file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        int id = AffichageToilitagesController.id;
        
        IToilitageService service = new ToilitageService();
        Toilitages t  = service.findby(id);
        
        NOMToilitages.setText(t.getNom());
        des.setText(t.getDescription());
        numtel.setText(t.getNum_tel_toilitage()+"");
        addresse.setText(t.getAdresse());
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
    private void modifertoillatages(ActionEvent event) {
        
        
         int id = AffichageToilitagesController.id;
        
        IToilitageService service = new ToilitageService();
        
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
         Toilitages  toilitages  = new Toilitages( id,NOMToilitages.getText(),des.getText(),Integer.parseInt(numtel.getText()),addresse.getText(),myimg);
        
        service.modifierToilitage(toilitages);
    }

    @FXML
    private void addressTextFieldAction(ActionEvent event) {
    }

    @FXML
    private void affiche(ActionEvent event) {
    }

    
}
