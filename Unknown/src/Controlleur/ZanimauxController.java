/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jihen
 */
public class ZanimauxController implements Initializable {

    @FXML
    private MediaView bgVideo;
    @FXML
    private VBox consultBtn;
    @FXML
    private ImageView ajout;
    @FXML
    private VBox sermonButton;
    @FXML
    private ImageView logout;
    @FXML
    private VBox statBtn;
    @FXML
    private ImageView stat;
    @FXML
    private VBox reclbtn;
    @FXML
    private ImageView mod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onconsultBtn(MouseEvent event) throws IOException {
             Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/addreclamation.fxml"));
                Scene scene = new Scene(root);
               // scene.getStylesheets().add("/CSS/Style.css");
                stage = (Stage) consultBtn.getScene().getWindow();
                stage.close();
                stage.setScene(scene);
                //stage.setFullScreen(true);
               stage.centerOnScreen();
                stage.show();
    }

    @FXML
    private void onlogout(MouseEvent event) throws IOException {
         Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));
                Scene scene = new Scene(root);
               // scene.getStylesheets().add("/CSS/Style.css");
                stage = (Stage) consultBtn.getScene().getWindow();
                stage.close();
                stage.setScene(scene);
                //stage.setFullScreen(true);
               stage.centerOnScreen();
                stage.show();
    }

    @FXML
    private void switchTo(MouseEvent event) throws IOException {
         
          
    }

    @FXML
    private void onStat(MouseEvent event) {
    }

    @FXML
    private void onreclbtn(MouseEvent event) throws IOException {
            Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/modifier.fxml"));
                Scene scene = new Scene(root);
               // scene.getStylesheets().add("/CSS/Style.css");
                stage = (Stage) consultBtn.getScene().getWindow();
                stage.close();
                stage.setScene(scene);
                //stage.setFullScreen(true);
               stage.centerOnScreen();
                stage.show();
    }
    
}
