/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Toilitages;
import services.ReserverService;
import services.ToilitageService;

/**
 * FXML Controller class
 *
 * @author p
 */
public class AffichageToilettageAdminController implements Initializable {

    @FXML 
    private VBox displayVBOX;
    
    private final String IMG_DIR = "C:\\xampp\\htdocs\\Toilitages\\";
    @FXML
    private AnchorPane rd;
    @FXML
    private HBox ev;
    @FXML
    private Label Animaux;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherReservations();
    }    
    
    public void afficherReservations() {
        ReserverService rs = new ReserverService();
        ToilitageService ts = new ToilitageService();
        HBox h = new HBox();
        List<Toilitages> tts = rs.afficherReservations();
        int i = 0;
        for(Toilitages t : tts){
            // System.out.println(t);
            int index = i;
            System.out.println(i);
            System.out.println(index);
            h.setPrefHeight(294);
            h.setPrefWidth(950);

            GridPane gp = new GridPane();
            gp.setPrefWidth(204);
            gp.setPrefHeight(189);

            ImageView im = new ImageView();
            im.setFitWidth(182);
            im.setFitHeight(182);
            im.setAccessibleText(t.getToilitage_id()+"");
            System.out.println(t.getImage());
            File f = new File(IMG_DIR + t.getImage());
            im.setImage(new Image(f.toURI().toString()));
            gp.addRow(0, im);
            gp.addRow(1, new Label("Nom:" + t.getNom()));
            gp.addRow(2, new Label("Description: " + t.getDescription()));
            
            Button rsv = new Button("Generer PDF");
            rsv.addEventHandler(MouseEvent.MOUSE_CLICKED,e -> {
                Document document = new Document() {};
                try{
                   PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\iyadh\\Desktop\\Reservation.pdf"));
                   document.open();
                   
                   document.add(new Paragraph("Reservation de toilettage no: "+ t.getToilitage_id()));
                   document.add(new Paragraph("Date reservation: "+ t.getDateReservation()));
                   document.close();
                   writer.close();
                   ts.dereserverToilitage(t.getToilitage_id());
                } catch (DocumentException | FileNotFoundException ex) {
                   ex.printStackTrace();
                }
            });
            gp.addRow(4, rsv);
            gp.addRow(3, new Label("Date reservation: " + t.getDateReservation().toString()));
            h.getChildren().add(gp);

            if(++index % 4 == 0){
                displayVBOX.getChildren().add(h);
                h = new HBox();
            }
            i++;
        }

        if(h.getChildren().size() > 0)
            displayVBOX.getChildren().add(h);
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


    
     
    
    //-------------------------------------------------------------------------------
        
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
    private void ClickProduit1(MouseEvent event) {
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
