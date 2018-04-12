/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import iservices.IToilitageService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Toilitages;
import services.ToilitageService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class AffichageTOilitageFrontController implements Initializable {
    
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
    private AnchorPane AnimauxAnchorPane;
    @FXML
    private Label nomToiltages;
    @FXML
    private Label description;
    
    @FXML
    private VBox AnimauxVBox;
    
    private List<Toilitages> Toilitages;
    IToilitageService service = new ToilitageService();
    @FXML
    private Separator separator;
    @FXML
    private Label idtoi;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        AnimauxAnchorPane.setVisible(false);
        AfficherToilitage();
        
    }
    
    public void AfficherToilitage() {
        IToilitageService service = new ToilitageService();
        Toilitages = service.getToilitage();
        if (!Toilitages.isEmpty()) {
            for (Toilitages Anx : Toilitages) {
                AnchorPane newAnimauxAnchorPane = new AnchorPane();
                newAnimauxAnchorPane.setStyle(AnimauxAnchorPane.getStyle());
                newAnimauxAnchorPane.setEffect(AnimauxAnchorPane.getEffect());
                
                Label NomLabel2 = new Label();
                NomLabel2.setFont(nomToiltages.getFont());
                NomLabel2.setTextFill(nomToiltages.getTextFill());
                NomLabel2.setLayoutX(nomToiltages.getLayoutX());
                NomLabel2.setLayoutY(nomToiltages.getLayoutY());
                NomLabel2.setText(Anx.getNom());
                
                Label descrip = new Label();
                descrip.setFont(description.getFont());
                descrip.setTextFill(description.getTextFill());
                descrip.setLayoutX(description.getLayoutX());
                descrip.setLayoutY(description.getLayoutY());
                descrip.setText(Anx.getDescription());
                
                Label id = new Label();
                id.setFont(idtoi.getFont());
                id.setTextFill(idtoi.getTextFill());
                id.setLayoutX(idtoi.getLayoutX());
                id.setLayoutY(idtoi.getLayoutY());
                id.setText(Anx.getToilitage_id() + "");
                
                File f = new File("C:\\xampp\\htdocs\\Toilitages\\" + Anx.getImage());
                ImageView ImageView = new ImageView(new Image(f.toURI().toString()));
                ImageView.setFitHeight(150);
                ImageView.setFitWidth(150);
                //ImageView.setStyle(imageview.getStyle());
                //ImageView.toFront();
                
                newAnimauxAnchorPane.getChildren().addAll(NomLabel2, descrip, ImageView);
                //newAnimauxAnchorPane.getChildren().add(ImageView);
                AnimauxVBox.getChildren().add(newAnimauxAnchorPane);
            }
        }
    }
    
    private void imageview(MouseEvent event) {
        try {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AffichageetReservationtoilitage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            //app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();            
            
        } catch (IOException ex) {
            
        }
        
    }
    
    
    
    //--------------------------------------------------------------------------
        
@FXML
    private void Produit (MouseEvent event) throws IOException
    {
        
        
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
    private void ClickProduit(MouseEvent event) throws IOException {

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
        private void ClickService(MouseEvent event) throws IOException {

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
     @FXML   
   private void ClickVeterinaires(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/afficherArticle.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
   @FXML
      private void ClickEvenements(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/Front.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
      @FXML
            private void ClickEspace(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AssociationetToilitages.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
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
    //--------------------------------------------------------------------------
    
}
