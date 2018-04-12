/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.Evaluation;
import models.Event;
import services.EventServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FrontController implements Initializable {

        ObservableList<Event> data ;

    @FXML
    private ListView<Event> list;
    @FXML
    private Label nom;
    @FXML
    private Label lieu;
    @FXML
    private Label descc;
    @FXML
    private Label id;
    @FXML
    private Label date;
    @FXML
    private ImageView imgg;
    @FXML
    private Rating rating;
    @FXML
    private Button evaluer;
    @FXML
    private Label nbr;
    @FXML
    private Button participer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         rating.setPartialRating(true);
        services.EventServices es = new services.EventServices();
        
        
       
                  data = FXCollections.observableArrayList();
       

                  data = FXCollections.observableArrayList();
            try {
                loadDataFromDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
                  // setcellValue();
                  list.setCellFactory(lv -> new Evenements());   
                  setcellValue(); 
        
        
    
    }    

    @FXML
    private void evaluerAction(ActionEvent event) {
        
       int iduser = 3 ;
        int idEve = (Integer.parseInt(id.getText())) ; 
        float note = (float)rating.getRating(); 
        
        Evaluation e  = new Evaluation(iduser, idEve, note) ; 
        
        services.EvlaluationServices es = new services.EvlaluationServices() ; 
        es.insertEvent(e);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bonjour");
        alert.setContentText("Evaluation ajouté avec succées  ");
         alert.showAndWait();
        
        
                
    }

    @FXML
    private void participerAction(ActionEvent event) throws IOException {
        
        if(Integer.parseInt(nbr.getText())==0) {
            
        }; 
        int nombre = Integer.parseInt(nbr.getText())-1;
        int ideve = Integer.parseInt(id.getText()); 
        EventServices es = new EventServices(); 
        es.decrEtChangementDetat(nombre, ideve);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bonjour");
        alert.setContentText("Participation ajouté avec succées  ");
         alert.showAndWait();
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource(("Front.fxml")));
         
                ((Node)(event.getSource())).getScene().getWindow().hide();

                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage () ;
                stage.setScene(scene);
                stage.show();
        
        
        
        
    }

     @FXML       
 private void logout(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/UserDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
 
      @FXML       
 private void Acceuil(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/Acceuil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
       @FXML       
 private void Produit(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
 
        @FXML       
 private void Animaux(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AffichageAccueil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
    
    
    static public class Evenements extends ListCell<Event> { 
  
   
  
    public Evenements(){ 
        
    } 
  
  
    @Override
    protected void updateItem(Event item, boolean bln) { 
         super.updateItem(item, bln);
                       // Rating rss = new Rating();
                       // rss.setPartialRating(true);
                       // Button delete =new Button("supprimer");
                        // Button update =new Button("modifier");
                       // Services.EvaluationService ess = new EvaluationService(); 
                       //double moy = ess.moyByName(item.getNomEvenement()); 
                            //rss.getStylesheets().add("GUI/fxml1.css");
                           
                        if (item != null) {
                            Text t =new Text("Nom : "+item.getNom().toString());
                            Text t2 =new Text(item.getDateDebut().toString());
                            Text t3 = new Text (item.getLieu().toString()); 
                          
                           t.setStyle("-fx-font-size: 25 arial;");
                            t2.setStyle("-fx-font-size: 20 arial;");
                          t3.setStyle("-fx-font-size: 20 arial;");
                           // t4.setStyle("-fx-font-size: 20 arial;");
                                  
                                
                   
                    
                    
                            
                       //   Button facebook = new Button("Partager");
                           
                            
                           // double moy = ess.moyByName(item.getIdEvenement()); 
                           // rss.setRating(moy);
                            
                            VBox vBox = new VBox(t,t2,t3);
                             File file = new File(item.getImage());
                            
            
        Image image = new Image(file.toURI().toString());
        ImageView img = new ImageView(image); 
       img.setFitHeight(100);
       img.setFitWidth(110);
                            
                            HBox hBox = new HBox(img, vBox);
                           
                        /* facebook.setOnAction(e->{
                                String accesToken = "EAACEdEose0cBAFsAbMfb6eFz3ZCPJqOFTOmuRJ1Q9PWqwmV3nNKuyzeWwPd3nWKXeL6ZB2DjF8Fv5yHOsrNMw72IhFYHZC4ZBXqXP64dD6zQDbRJ85LZCsZCS5noBcSVmxZCyKYNteubCuZB4TjiRGcbroFUeKDZAjNKsokWkNe65EYKaeBlyQvwXS2p3PFXoKWcZD" ;
                                 FacebookClient fb = new DefaultFacebookClient(accesToken);
                    
                               
                              FacebookType response =  fb.publish("fb.com/",FacebookType.class,Parameter.with(accesToken,ListCell.class));
                                System.out.println(response);
                    
                           
                            }); */
                            
                            hBox.setSpacing(10);
                            setGraphic(hBox);
    } 
}   }
    
    private void loadDataFromDatabase() throws SQLException {
       List<Event> events = new ArrayList<>();
       //List<Evaluation> evaluations = new ArrayList<>();
           EventServices se=new EventServices();

        events=   se.SelectAllEvents();
       for(Event e : events)
            {
                data.add(e); 
               
            }
        list.setItems(data);
       
      
                }
    
    private void setcellValue() {
        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Event eqp = list.getItems().get(list.getSelectionModel().getSelectedIndex());
                
                    File file = new File(eqp.getImage());
            
        Image image = new Image(file.toURI().toString());
        
        id.setText(Integer.toString(eqp.getId()));
         nom.setText(eqp.getNom());
         date.setText(eqp.getDateDebut().toString());
         descc.setText(eqp.getDescription());
         nbr.setText(Integer.toString(eqp.getNombrePlaces()));
         
         lieu.setText(eqp.getLieu());
        // lblType.setText(eqp.getType());
         
        /*  
         lblEtat.setText(eqp.getEtat());
                  
         lblNombre.setText(Integer.toString(eqp.getNbrPlaces()));
         lblPrix.setText(Float.toString(eqp.getPrix()));
         
        if(participeDéja()==true) {
           
           participer.setDisable(true);


         }
         
         else {
             participer.setDisable(false);
         }
        
        Services.EvaluationService ess = new EvaluationService(); 
        Double moy = ess.moyByName(eqp.getIdEvenement());
        
         rat.setRating(moy);
         rat.setPartialRating(true);
        */
        if(Integer.parseInt(nbr.getText())<=0) {
            participer.setDisable(true);
        }
        else {
            participer.setDisable(false);
        }

         
            
        Image image2 = new Image(file.toURI().toString());
            
            imgg.setImage(image2); 
            imgg.setFitHeight(300);
            imgg.setFitHeight(100);
            
            
            }
        });
    } 
    
    
    
    
}
