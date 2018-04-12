/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import iservices.IAnimauxService;
import iservices.IGardeService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
public class AfficherUserAnimauxController implements Initializable {

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
    private Separator separator;
    @FXML
    private ImageView AnimauxImageView;
    @FXML
    private Label Nom;
    @FXML
    private Label Garde;
    @FXML
    private Label Association;
    @FXML
    private Label Age;
    @FXML
    private Label Sexe;
    @FXML
    private VBox AnimauxVBox;
      IAnimauxService serviceAnimaux =new AnimauxService();
      IGardeService serviceGarde =new GardeService();
      AssociationService associationservice = new AssociationService();
        private List<Animaux> Animaux;
    @FXML
    private Button contrat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherAnimaux();
    }
    public void AfficherAnimaux(){
    IAnimauxService serviceAnimaux =new AnimauxService();
    Animaux  = serviceAnimaux.getAnimaux2();
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
        Button2.setFont(contrat.getFont());
        Button2.setTextFill(contrat.getTextFill());
       Button2.setLayoutX(contrat.getLayoutX());
        Button2.setLayoutY(contrat.getLayoutY());
       Button2.setText(contrat.getText());
       
       Button2.setOnAction((event) -> {
           Document document = new Document() {};
                try{
                   PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\iyadh\\Desktop\\contart.pdf"));
                   document.open();
                   
                   document.add(new Paragraph("Nom Animal :"+ Anx.getNom()));
                   document.add(new Paragraph(" Age :"+ Anx.getAge()));
                   document.add(new Paragraph(" Image:"+ Anx.getBrochure()));
                   document.close();
                   writer.close();
                  // ts.dereserverToilitage(t.getToilitage_id());
                } catch (DocumentException | FileNotFoundException ex) {
                   ex.printStackTrace();
                }
           
           
       });
         newAnimauxAnchorPane.getChildren().addAll(NomLabel2,AgeLabel2,GardeLabel2,AssociationLabel2,SexeLabel2,ImageView2,Button2);
       AnimauxVBox.getChildren().add(newAnimauxAnchorPane);
    
    }
    } else
            System.out.println("else");
    
    }
    @FXML
     public void Acceuil(MouseEvent event) {
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/Acceuil.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
               // app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
          System.out.println(ex); 
        
    }
    }
    
}
