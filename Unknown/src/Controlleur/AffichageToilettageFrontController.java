/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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


public class AffichageToilettageFrontController implements Initializable {

    
    @FXML
    private VBox displayVBOX;

    @FXML
    private Pane detailPane;

    @FXML
    private TextField tfNomToil;

    @FXML
    private TextField tfDescToil;

    @FXML
    private ImageView imgvToil;

    @FXML
    private TextField tfNumToil;

    @FXML
    private TextField tfAddrToil;
    
    @FXML
    private DatePicker dpDatePicker;
    
    private final String IMG_DIR = "C:\\xampp\\htdocs\\Toilitages\\";
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        detailPane.setVisible(false);
        tfNomToil.setDisable(true);
        tfDescToil.setDisable(true);
        tfNumToil.setDisable(true);
        tfAddrToil.setDisable(true);
        try {
            this.loadToilettages();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageToilettageFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void loadToilettages() throws SQLException{
        HBox h = new HBox();
        ToilitageService ts = new ToilitageService();

        List<Toilitages> toilitages = ts.getToilitage1();

        int i = 0;
        for(Toilitages t : toilitages){

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
            im.addEventHandler(MouseEvent.MOUSE_CLICKED,e -> {
                if(e.getClickCount() == 2){
                    System.out.println("Hidden ID : " + im.getAccessibleText());
                    detailPane.setVisible(true);
                    tfNomToil.setText(t.getNom());
                    tfDescToil.setText(t.getDescription());
                    tfNumToil.setText(t.getNum_tel_toilitage() + "");
                    tfAddrToil.setText(t.getAdresse() + "");
                    File prev = new File(IMG_DIR + t.getImage());
                    imgvToil.setImage(new Image(prev.toURI().toString()));
                    imgvToil.setAccessibleText("" + im.getAccessibleText());
                }
            });
            System.out.println(t.getImage());
            File f = new File(IMG_DIR + t.getImage());
            im.setImage(new Image(f.toURI().toString()));
            gp.addRow(0, im);
            gp.addRow(1, new Label(t.getNom()));
            gp.addRow(2, new Label(t.getDescription()));
            
            h.getChildren().add(gp);

            if(++index % 5 == 0){
                displayVBOX.getChildren().add(h);
                h = new HBox();
            }
            i++;
        }

        if(h.getChildren().size() > 0)
            displayVBOX.getChildren().add(h);
    }
    
   @FXML
   private void closeEditPane(){
       this.detailPane.setVisible(false);
   }
    
   @FXML
   private void reserverToil(ActionEvent event) {
       System.out.println("reserverToil clicked " );
        try {
            ToilitageService ts = new ToilitageService();
            ReserverService rs = new ReserverService();
            ts.reserverToilitage(Integer.parseInt(imgvToil.getAccessibleText()));
            rs.reserver(Integer.parseInt(imgvToil.getAccessibleText()), 1, Date.valueOf(dpDatePicker.getValue()));
            displayVBOX.getChildren().clear();
            detailPane.setVisible(false);
            this.loadToilettages();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageToilettageFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    @FXML
    private void backAcceuil(MouseEvent event) {
        
    }

    @FXML
    private void frontAssociationettoilitages(MouseEvent event) {
        
        try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/AssociationetToilitages.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
        
        
    }
    }

