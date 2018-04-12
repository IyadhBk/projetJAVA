/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import static Controlleur.AffichageAssociationController.id;
import iservices.IAssociationService;
import iservices.IToilitageService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import models.Toilitages;

import services.AssociationService;
import services.ToilitageService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class AffichageToilitagesController implements Initializable {

    @FXML
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Label Animaux;
    
    @FXML
    private Separator separator;
    @FXML
    private ImageView imageview;
    private Button modfier;
    @FXML
    private VBox AnimauxVBox;
    @FXML
    private Label nomToiltages;
    @FXML
    private Label capiciter;
    @FXML
    private Label description;
    @FXML
    private Label numTEl;
    @FXML
    private Label Addresse;
    private List <Toilitages>Toilitages;
    IToilitageService service = new ToilitageService();
    @FXML
    private AnchorPane AnimauxAnchorPane;
    @FXML
    private Label idTOI;
    @FXML
    private Button suprimer;
    @FXML
    private Button Modifer;
    
    public static int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AfficherToilitage();
        
        // TODO
    }    

    
    
    
    public void AfficherToilitage(){
    IToilitageService service = new ToilitageService();
   Toilitages=service.getToilitage1();
      if(!Toilitages.isEmpty()){
    for (Toilitages Anx :Toilitages ) {
         AnchorPane newAnimauxAnchorPane = new AnchorPane();
         newAnimauxAnchorPane.setStyle(AnimauxAnchorPane.getStyle());
       newAnimauxAnchorPane.setEffect(AnimauxAnchorPane.getEffect());
       
       Label NomLabel2 = new Label();
       NomLabel2.setFont(nomToiltages.getFont());
        NomLabel2.setTextFill(nomToiltages.getTextFill());
        NomLabel2.setLayoutX(nomToiltages.getLayoutX());
        NomLabel2.setLayoutY(nomToiltages.getLayoutY());
        NomLabel2.setText("Nom Toilitage: "+Anx.getNom());
        
        Label descrip =new Label();
       descrip.setFont(description.getFont());
        descrip.setTextFill(description.getTextFill());
        descrip.setLayoutX(description.getLayoutX());
        descrip.setLayoutY(description.getLayoutY());
        descrip.setText("Description: "+Anx.getDescription());
        
        
        
        Label num =new Label();
       num.setFont(numTEl.getFont());
        num.setTextFill(numTEl.getTextFill());
        num.setLayoutX(numTEl.getLayoutX());
        num.setLayoutY(numTEl.getLayoutY());
        num.setText("Numero de telephone: "+Anx.getNum_tel_toilitage()+ "");
        
        
        
        
       
        
        
        
        
        
        Label addres =new Label();
       addres.setFont(Addresse.getFont());
        addres.setTextFill(Addresse.getTextFill());
        addres.setLayoutX(Addresse.getLayoutX());
        addres.setLayoutY(Addresse.getLayoutY());
        
        System.out.println(Anx.getImage());
        addres.setText("Adresse: "+Anx.getAdresse());
        
        
//        
//        Button Button1 = new Button();
//        Button1.setFont(modfier.getFont());
//        Button1.setTextFill(modfier.getTextFill());
//       Button1.setLayoutX(modfier.getLayoutX());
//        Button1.setLayoutY(modfier.getLayoutY());
//       Button1.setText(modfier.getText());
//         
//        Button Button2= new Button();
//        Button1.setFont( suprimer.getFont());
//        Button1.setTextFill( suprimer.getTextFill());
//       Button1.setLayoutX( suprimer.getLayoutX());
//        Button1.setLayoutY( suprimer.getLayoutY());
//       Button1.setText( suprimer.getText());
       
       
     
        
        
   
        System.out.println(Anx.getImage());
        File f = new File("C:\\xampp\\htdocs\\Toilitages\\"+Anx.getImage());
        ImageView ImageView = new ImageView(new Image(f.toURI().toString()));
        ImageView.setFitHeight(150);
        ImageView.setFitWidth(150);
//         Button1.setOnAction((event) -> {
//           System.out.println("Modifier");
//          
//            id=Anx.getToilitage_id();
//            System.out.println(id);
//        
//        try {
//              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/ModiferToilitages.fxml"));
//        Scene home_page_scene = new Scene(home_page_parent);
//        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//          
//            
//                //app_stage.hide(); //optional
//                app_stage.setScene(home_page_scene);
//                app_stage.show();  
//            
//        
//            
//        } catch (IOException ex) {
//           
//        
//     }
//            
//         });
        //ImageView.setStyle(imageview.getStyle());
        //ImageView.toFront();
        
         newAnimauxAnchorPane.getChildren().addAll(NomLabel2,descrip,num,ImageView);
         //newAnimauxAnchorPane.getChildren().add(ImageView);
       AnimauxVBox.getChildren().add(newAnimauxAnchorPane);
        
        
    
      
      
              }
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

    @FXML
    private void ClickVeterinaire(MouseEvent event) {
    }

    @FXML
    private void ClickProduit(MouseEvent event) {
    }

    @FXML
    private void suprimer(ActionEvent event) {
       

           
}

    @FXML
    private void Modifer(ActionEvent event) {
    }
}

   