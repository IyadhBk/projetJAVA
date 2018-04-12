/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import iservices.IAnimauxService;
import iservices.IGardeService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Animaux;
import services.AnimauxService;
import services.AssociationService;
import services.GardeService;

/**
 * FXML Controller class
 *
 * @author s
 */
public class AfficherAnimauxController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Label Nom;

    @FXML
    private ImageView AnimauxImageView;
 @FXML
    private VBox AnimauxVBox;

    @FXML
    private Label Garde;

    @FXML
    private Label Association;
     @FXML
    private Label Age;
     @FXML
    private Label Sexe;
     @FXML
    private AnchorPane AnimauxAnchorPane;
     @FXML
     private Button Modifier;
     @FXML
     private Button Supprimer;
        
     IAnimauxService serviceAnimaux =new AnimauxService();
      IGardeService serviceGarde =new GardeService();
      AssociationService associationservice = new AssociationService();

    
  
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Separator separator;
   
   private List<Animaux> Animaux;
     int ida1 ;
     public static int ida ;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("uuuuuuuuu");
        AfficherAnimaux();
    } 
    public void AfficherAnimaux(){
    IAnimauxService serviceAnimaux =new AnimauxService();
    Animaux  = serviceAnimaux.getAnimaux1();
     if(!Animaux.isEmpty()){
    for (Animaux Anx : Animaux) {
         AnchorPane newAnimauxAnchorPane = new AnchorPane();
        newAnimauxAnchorPane.setStyle(AnimauxAnchorPane.getStyle());
       newAnimauxAnchorPane.setEffect(AnimauxAnchorPane.getEffect());
       Label NomLabel2 = new Label();
       
       NomLabel2.setFont(Nom.getFont());
        NomLabel2.setTextFill(Nom.getTextFill());
        NomLabel2.setLayoutX(Nom.getLayoutX());
        NomLabel2.setLayoutY(Nom.getLayoutY());
        NomLabel2.setText(Anx.getNom());
    
       Label AgeLabel2 = new Label();
       AgeLabel2.setFont(Age.getFont());
        AgeLabel2.setTextFill(Age.getTextFill());
        AgeLabel2.setLayoutX(Age.getLayoutX());
        AgeLabel2.setLayoutY(Age.getLayoutY());
        AgeLabel2.setText(Anx.getAge());
        
        Label GardeLabel2 = new Label();
       GardeLabel2.setFont(Garde.getFont());
        GardeLabel2.setTextFill(Garde.getTextFill());
        GardeLabel2.setLayoutX(Garde.getLayoutX());
       GardeLabel2.setLayoutY(Garde.getLayoutY());
        GardeLabel2.setText(Anx.getGarde().getNom());
        
        Label AssociationLabel2 = new Label();
       AssociationLabel2.setFont(Association.getFont());
        AssociationLabel2.setTextFill(Association.getTextFill());
        AssociationLabel2.setLayoutX(Association.getLayoutX());
       AssociationLabel2.setLayoutY(Association.getLayoutY());
        AssociationLabel2.setText(Anx.getAssociation().getNom_association());
        
        Label SexeLabel2 = new Label();
       SexeLabel2.setFont(Sexe.getFont());
        SexeLabel2.setTextFill(Sexe.getTextFill());
        SexeLabel2.setLayoutX(Sexe.getLayoutX());
       SexeLabel2.setLayoutY(Sexe.getLayoutY());
        SexeLabel2.setText(Anx.getSexe());
        
        
       ImageView ImageView2 = new ImageView("http://localhost/Animaux_images/"+Anx.getBrochure());
        
        
        ImageView2.setLayoutX(AnimauxImageView.getLayoutX());
        ImageView2.setLayoutY(AnimauxImageView.getLayoutY());
        ImageView2.setStyle(AnimauxImageView.getStyle());
        ImageView2.setFitWidth(AnimauxImageView.getFitWidth());
        ImageView2.setFitHeight(AnimauxImageView.getFitHeight());
        
        
        Button Button2 = new Button();
        Button2.setFont(Modifier.getFont());
        Button2.setTextFill(Modifier.getTextFill());
       Button2.setLayoutX(Modifier.getLayoutX());
        Button2.setLayoutY(Modifier.getLayoutY());
       Button2.setText(Modifier.getText());
        
       Button Button3 = new Button();
        Button3.setFont(Supprimer.getFont());
        Button3.setTextFill(Supprimer.getTextFill());
       Button3.setLayoutX(Supprimer.getLayoutX());
        Button3.setLayoutY(Supprimer.getLayoutY());
       Button3.setText(Supprimer.getText());
        
       
       
            Button2.setOnAction((event) -> {
            System.out.println("Modifier");
          
            ida=Anx.getAnimauxId();
            System.out.println(ida);
           //modifier page
           
              try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/Modifier.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
              //  app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
               
               
        } catch (IOException ex) {
            System.out.println(ex);
           
        
    }
      });
        Button3.setOnAction((event) -> {
            System.out.println("Supprimer");
            ida1=Anx.getAnimauxId();
            System.out.println(ida1);
            
            //Animaux a = serviceAnimaux.findById(ida);
             serviceAnimaux.supprimerAnimaux(ida1);
             try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AfficherAnimaux.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
              //  app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
               
               
        } catch (IOException ex) {
            System.out.println(ex);
           
        
    }
        });

         newAnimauxAnchorPane.getChildren().addAll(NomLabel2,AgeLabel2,GardeLabel2,AssociationLabel2,SexeLabel2,ImageView2,Button2,Button3);
       AnimauxVBox.getChildren().add(newAnimauxAnchorPane);
    
    }
    } else
            System.out.println("else");
    
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
    
    
    
    
    
    
}
