/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;
import models.reclamation;
import services.Reclamationservice;
import services.FODUSER_service;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.WritableImage;

/**
 * FXML Controller class
 *
 * @author jihen
 */
public class AdminreclamationController implements Initializable {

    @FXML
    private TableView<reclamation> TvTraite;

    @FXML
    private TableColumn<reclamation, Integer> ClId;

    @FXML
    private TableColumn<reclamation, Integer> ClIdUtilisateur;

    @FXML
    private TableColumn<reclamation, String> ClIdService;

    @FXML
    private TableColumn<reclamation, String> ClDescription;

    @FXML
    private TableView<reclamation> TvTraite1;

    @FXML
    private TableColumn<reclamation, Integer> ClId1;

    @FXML
    private TableColumn<reclamation, Integer> ClIdUtilisateur1;

    @FXML
    private TableColumn<reclamation, String> ClIdService1;

    @FXML
    private TableColumn<reclamation, String> ClDescription1;

    @FXML
    private Label LbTraite;

    @FXML
    private Label LbTraite1;

    @FXML
    private Button BtTraiter;

    

    @FXML
    private Button BtTraiter11;
    
    static int IdReclamation;
    static int IdUser;
    static int IdService;
    
    @FXML
    private Button BtRetour;
    @FXML
    private ImageView outimg;
    
    @FXML
    void retour(ActionEvent event) throws IOException {
        Parent p1 = FXMLLoader.load(getClass().getResource("/GUI/animaux.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }

    

    @FXML
    void supprimer(ActionEvent event) {
        
        Reclamationservice es = new Reclamationservice();
        es.delete(IdReclamation);
        try {
            buildTableviewData1();
        } catch (ParseException ex) {
            Logger.getLogger(AdminreclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            buildTableviewData2();
        } catch (ParseException ex) {
            Logger.getLogger(AdminreclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void traiter(ActionEvent event) {
        try {
            Reclamationservice es = new Reclamationservice();
            es.accepter(IdReclamation);
            buildTableviewData1();
            buildTableviewData2();
        } catch (ParseException ex) {
            Logger.getLogger(AdminreclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void buildTableviewData1() throws ParseException {
       
     
        ClId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClIdUtilisateur.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        ClIdService.setCellValueFactory(new PropertyValueFactory<>("animalConcerné"));
        ClDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
              
    
        Reclamationservice es = new Reclamationservice();
        
        ObservableList<reclamation> data = es.listerReclamation(1);
        
        TvTraite.setItems(data);
    }
    
    private void buildTableviewData2() throws ParseException {
       
     
        ClId1.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClIdUtilisateur1.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        ClIdService1.setCellValueFactory(new PropertyValueFactory<>("animalConcerné"));
        ClDescription1.setCellValueFactory(new PropertyValueFactory<>("description"));
              
    
        Reclamationservice es = new Reclamationservice();
        
        ObservableList<reclamation> data = es.listerReclamation(0);
        
        TvTraite1.setItems(data);
    }
    
    private void EventGetData1() {
        TvTraite1.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends reclamation> observable,
                reclamation oldValue,
                reclamation newValue) -> {
            
            IdReclamation =newValue.getId();
            IdUser = newValue.getUser_id();
         
            
            
            
        });
    }
    
    private void EventGetData2() {
        TvTraite.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends reclamation> observable,
                reclamation oldValue,
                reclamation newValue) -> {
            
            IdReclamation = newValue.getId();
            IdUser = newValue.getUser_id();
           
            
            
            
        });
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            buildTableviewData1();
            buildTableviewData2();
            EventGetData2();
            EventGetData1();
        } catch (ParseException ex) {
            Logger.getLogger(AdminreclamationController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void ClickStore(MouseEvent event) {
        
       try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/validerP.fxml"));
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
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/ListEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void ClickEncheres(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AnimauxGarde.fxml"));
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
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AssociationetToilitagesback.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void ClickVeterinaire(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/VeterinaireAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

    @FXML
    private void ClickProduit(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/adminreclamation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }

   
    
 
    
}
