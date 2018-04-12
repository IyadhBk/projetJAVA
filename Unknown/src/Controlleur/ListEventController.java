/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.Event;
import services.EventServices;
import com.mysql.jdbc.EscapeTokenizer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.lang.String ; 
import javafx.scene.Node;
import jdk.nashorn.internal.objects.Global;
import technique.DataSource;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ListEventController implements Initializable {
    @FXML
    private TableColumn<?, ?> id;
   @FXML
    private TableColumn<Event, String> nom;

   
    @FXML
    private TableColumn<?,?> date;
    @FXML
    private TableView<Event> table;
    
    DataSource ds;
   
    private ObservableList<Event> data;
   // @FXML
    //private TableColumn<?, ?> nom;
    @FXML
    private Label idEve;
    @FXML
    private Button delete;
    @FXML
    private Button ajouter;
    @FXML
    private TextField rech;
    private TableColumn<?, ?> places;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> nbr;
    @FXML
    private TableColumn<?, ?> lieu;
    @FXML
    private Button update;
    @FXML
    private Label idEvent;
   
    
  
    
    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
       data = FXCollections.observableArrayList();
       loadDataFromDatabase();
      setsCllTable();
        setcellValue();
        
       //setcellValue();
    // ;
       search();
       
       
      // badd.setOnAction(AjoutController());
    }
    
    public void search() {
        FilteredList<Event> filterdata = new FilteredList<>(data, e -> true);
        rech.setOnKeyReleased(e -> {
            rech.textProperty().addListener((observableValue, oldValue, x) -> {
                filterdata.setPredicate((Predicate<? super Event>) evenement -> {
                    if (rech.getCharacters()== null ) {
                        return true;
                    }
                    if ((evenement.getNom().contains(rech.getCharacters())) ) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Event> sorteddata = new SortedList<>(filterdata);
            sorteddata.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sorteddata);
        });
    }
    
       private void loadDataFromDatabase() {
      services.EventServices es = new EventServices(); 
      List <Event> evs = es.SelectAllEvents();
      
      for(Event ev : evs )
      {
          data.add(ev);
      }
             
        table.setItems(data);
    
       }
       
       public void setsCllTable() {
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
       // places.setCellValueFactory(new PropertyValueFactory<>("nombrePlaces"));
        
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
         lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
         nbr.setCellValueFactory(new PropertyValueFactory<>("nombrePlaces"));
       }
       
       private void setcellValue() {
       table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               Event pl = table.getItems().get(table.getSelectionModel().getSelectedIndex());
               idEve.setText(Integer.toString(pl.getId()));
               
               
               
                
            }});
           
       }

    @FXML
    private void deleteAction(ActionEvent event) {
        int idE = Integer.valueOf(idEve.getText());
        
        services.EventServices es = new EventServices() ; 
        es.deleteEvent(idE);
        
         data.clear();
        loadDataFromDatabase();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bonjour");
        alert.setHeaderText("Evenement supprimé avec succés *_* ");
        alert.setContentText("Suppression:");
        alert.showAndWait();
         table.refresh();
     }

    @FXML
    private void ajoutAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/GUI/Ajout.fxml")));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage () ;
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void goFront(ActionEvent event) throws IOException {
        
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource(("Front.fxml")));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage () ;
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void goLogin(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource(("Login.fxml")));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage () ;
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void Update(ActionEvent event) {
        
        
        
        
        
        
    }
    
     
     private void setId() {
       table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               Event pll = table.getItems().get(table.getSelectionModel().getSelectedIndex());
               idEvent.setText(Integer.toString(pll.getId()));
               
               
               
                
            }});
           
       }
    
     
       //-----------------------------------------------------------------------
         
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

     
        
  
        


