/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.Article;
import models.rating;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import services.serviceArticle;
import org.controlsfx.control.Rating;
import services.serviceRating_1;

/**
 * FXML Controller class
 *
 * @author didid
 */
public class AfficherArticleController implements Initializable {

    
 @FXML
    private ListView<Article> listeArticle;

    @FXML
    private ImageView IMAGEARTICLE;

    @FXML
    private Label titreArticle;

    @FXML
    private TextArea contenuArticle;

    @FXML
    private Label nomVet;

    @FXML
    private Label dateAfficher;
    
    @FXML
    private Pane paneArticle;
    
    @FXML
    private Rating rating;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        serviceArticle sa = new serviceArticle();
        ObservableList<Article> myObservableList = FXCollections.observableList(sa.selectAllArticles_client());
        listeArticle.setItems(myObservableList);
        
        listeArticle.setCellFactory((ListView<Article> p) -> {
            ListCell<Article> cell = new ListCell<Article>(){
                
                @Override
                protected void updateItem(Article t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null) {
                        setText(t.getTitre());
                    }
                }
                
            };
            
            return cell;
        });
        
        listeArticle.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Article> observable, Article oldValue, Article newValue) -> {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //paneArticle.setVisible(true);
            System.out.println(oldValue);
            System.out.println(newValue);
            titreArticle.setText(newValue.getTitre());
            contenuArticle.setText(newValue.getContenu());
            dateAfficher.setText(newValue.getDate());
                 //   System.out.println();
            nomVet.setText(newValue.getVet().getNom());
            //to fix change url by article.getimage
            Image image = new Image(newValue.getImage());
            

            IMAGEARTICLE.setImage(image);
        });
        // TODO
        
       rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue.toString());
                serviceRating_1 sr = new serviceRating_1();
                Article article_id = (Article)listeArticle.getSelectionModel().getSelectedItem();
                rating r = new rating( Double.parseDouble(newValue.toString()),article_id.getId());
                try {
                    sr.insertNote(r);
                } catch (SQLException ex) {
                    Logger.getLogger(AfficherArticleController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
      
    }    
    
}
