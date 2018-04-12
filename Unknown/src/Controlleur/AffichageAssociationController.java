/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import iservices.IAssociationService;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Association;
import services.AssociationService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class AffichageAssociationController implements Initializable {

    @FXML
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Label Animaux;
    @FXML
    private AnchorPane AnimauxAnchorPane;
    @FXML
    private VBox AnimauxVBox;
    @FXML
    private Label nomAssociation;
    @FXML
    private Label addresse;
    @FXML
    private Label email;
    @FXML
    private Label numtel;
    
    AssociationService service = new AssociationService();
    
    private List<Association>Association1;
    
    @FXML
    private Separator separator;
    @FXML
    private ImageView ImageView;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    
   public static int id;
    public static int ida;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AfficherAssocations();
    }    

    
    public void AfficherAssocations(){
    AssociationService service = new AssociationService();
   Association1=service.getAssociations1();
      if(!Association1.isEmpty()){
    for (Association Anx :Association1 ) {
         AnchorPane newAnimauxAnchorPane = new AnchorPane();
        newAnimauxAnchorPane.setStyle(AnimauxAnchorPane.getStyle());
       newAnimauxAnchorPane.setEffect(AnimauxAnchorPane.getEffect());
       Label NomLabel2 = new Label();
       
       NomLabel2.setFont(nomAssociation.getFont());
        NomLabel2.setTextFill(nomAssociation.getTextFill());
        NomLabel2.setLayoutX(nomAssociation.getLayoutX());
        NomLabel2.setLayoutY(nomAssociation.getLayoutY());
        NomLabel2.setText(Anx.getNom_association());
        
        Label Addresse =new Label();
       Addresse.setFont(addresse.getFont());
        Addresse.setTextFill(addresse.getTextFill());
        Addresse.setLayoutX(addresse.getLayoutX());
        Addresse.setLayoutY(addresse.getLayoutY());
        Addresse.setText(Anx.getAdresse());
        
        
        Label Email =new Label();
        Email.setFont(email.getFont());
        Email.setTextFill(email.getTextFill());
        Email.setLayoutX(email.getLayoutX());
        Email.setLayoutY(email.getLayoutY());
        Email.setText(Anx.getEmail());
        
        Label Numtel =new Label();
        Numtel.setFont(numtel.getFont());
        Numtel.setTextFill(numtel.getTextFill());
        Numtel.setLayoutX(numtel.getLayoutX());
        Numtel.setLayoutY(numtel.getLayoutY());
        Numtel.setText(Anx.getNum_tel() + "");
        
        Button Button2 = new Button();
        Button2.setFont(Modifier.getFont());
        Button2.setTextFill(Modifier.getTextFill());
       Button2.setLayoutX(Modifier.getLayoutX());
        Button2.setLayoutY(Modifier.getLayoutY());
       Button2.setText(Modifier.getText());
       
       Button Button1 = new Button();
        Button1.setFont(Supprimer.getFont());
        Button1.setTextFill(Supprimer.getTextFill());
       Button1.setLayoutX(Supprimer.getLayoutX());
        Button1.setLayoutY(Supprimer.getLayoutY());
       Button1.setText(Supprimer.getText());
       
       Button2.setOnAction((event) -> {
            System.out.println("Modifier");
          
            id=Anx.getId();
            System.out.println(id);
            
            try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/ModiferAssociation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
            
            
        
        
       });
        Button1.setOnAction((event) -> {
            System.out.println("supprimer");
          
            ida=Anx.getId();
            System.out.println(ida);
            service.supprimerAssociation(ida);
            
            try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AffichageAssociation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
            
            
        
        
       });
        
        System.out.println(Anx.getImage());
        File f = new File("C:\\xampp\\htdocs\\Association\\"+Anx.getImage());
        ImageView ImageView = new ImageView(new Image(f.toURI().toString()));
        ImageView.setFitHeight(150);
        ImageView.setFitWidth(150);
        //ImageView.setStyle(imageview.getStyle());
        //ImageView.toFront();
        
         newAnimauxAnchorPane.getChildren().addAll(NomLabel2,Addresse,Email,Numtel,ImageView, Button1,Button2);
        //newAnimauxAnchorPane.getChildren().add(ImageView);
       AnimauxVBox.getChildren().add(newAnimauxAnchorPane);
    }
      }
    }

      
    

    @FXML
    private void ClickEvenement(MouseEvent event) {
    }

    @FXML
    private void ClickEncheres(MouseEvent event) {
    

        
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
    }

    @FXML
    private void ClickProduit(MouseEvent event) {
    }

    @FXML
    private void HomeClick(ActionEvent event) {
    }

    @FXML
    private void ClickStore(MouseEvent event) {
    }

    @FXML
    private void Supprimer(ActionEvent event) {
    }
    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
