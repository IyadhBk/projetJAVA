/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.Article;
import models.User;
import models.UserDoha;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import services.serviceArticle;

/**
 * FXML Controller class
 *
 * @author didid
 */
public class InsertArticleController implements Initializable {
    
    @FXML
    private TextField TITLE;
    @FXML
    private TextArea CONTENTS;
    @FXML
    private TextField DATE;
    @FXML
    private TextField IMAGE;
    @FXML
    private Button add;
     @FXML
    private Button delete;
      @FXML
    private Button choose;
     
    
      @FXML
    private Button update;
    
     @FXML
    private TableView<Article> TABLEARTICLE;
      @FXML
    private TableColumn<Article, Integer> ID;
    @FXML
    private TableColumn<Article, String> TITRE;
     @FXML
    private TableColumn<Article, String> CONTENU;
      @FXML
    private TableColumn<Article, String> DATEE;
       @FXML
    private TableColumn<Article, String> PICTURE;
       
       @FXML
    private Label erreur_titre;

    @FXML
    private Label erreur_contenu;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        
        serviceArticle sa = new serviceArticle();
        ArrayList article = (ArrayList) sa.selectAllArticles();
        ObservableList articlesObservable = FXCollections.observableArrayList(article);
        System.out.println(articlesObservable);
        TABLEARTICLE.setItems(articlesObservable);
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));

        TITRE.setCellValueFactory(new PropertyValueFactory<>("titre"));
        CONTENU.setCellValueFactory(new PropertyValueFactory<>("contenu")); 
        DATEE.setCellValueFactory(new PropertyValueFactory<>("date")); 
        PICTURE.setCellValueFactory(new PropertyValueFactory<>("image")); 

        TITLE.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           if (!newValue)
           { erreur_titre.setText("Title is Required");
            }}
        });
        
        CONTENTS.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           if (!newValue)
           { erreur_contenu.setText("Contents is Required");
            }}
        });
       
        // TODO
    } 
    public void load()
    {
              try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/insertArticle.fxml")) ;
            
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InsertArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void add(ActionEvent event) throws SQLException {
        
        boolean isTitleEmpty= validation.TextFieldValidation.isTextFieldNotEmpty(TITLE, erreur_titre, "Title is Required");
        boolean isContentsEmpty= validation.TextFieldValidation.isTextFAreaNotEmpty(CONTENTS, erreur_contenu, "Contents is Required");
      if (!isTitleEmpty &&isContentsEmpty )
      {
        if("update".equals(add.getText()))
        { Article article_id = (Article)TABLEARTICLE.getSelectionModel().getSelectedItem();
        Article article = new Article (TITLE.getText(),CONTENTS.getText(),DATE.getText(),IMAGE.getText());
         serviceArticle sa = new serviceArticle();
        sa.updateArticle(article,article_id.getId());
            
            System.out.println("clicked update ");
        }else{
                Article article =new Article(TITLE.getText(),CONTENTS.getText(),DATE.getText(),IMAGE.getText());
                User vet = new User();
                vet.setId(LoginController.id);
                article.setVet(vet);
        serviceArticle sa = new serviceArticle();
        sa.insertArticle(article);
        }

        
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/insertArticle.fxml")) ;
            
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InsertArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }}
    
    @FXML
    private void deleteArticle( ActionEvent event ) throws SQLException
    {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation Dialog");
alert.setHeaderText("Look, a Confirmation Dialog");
alert.setContentText("Are you ok with this?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
          Article article = (Article)TABLEARTICLE.getSelectionModel().getSelectedItem();
        serviceArticle sa = new serviceArticle();
        sa.deleteArticle(article.getId());
        load();
} else {
    // ... user chose CANCEL or closed the dialog
}

      
        
    }
     @FXML
     public void chooseFile(ActionEvent event)
     {
         
          FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JPGyyy files (*.jpg)", "*.jpg");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(null);
                System.out.println(file.getPath());
                UploadImage imageUp = new UploadImage();
                imageUp.httpConn(file.getAbsolutePath(),file.getName());
                IMAGE.setText(file.getName());
         }
     
     @FXML
    private void updateArticle( ActionEvent event ) throws SQLException
    {
      Article article = (Article)TABLEARTICLE.getSelectionModel().getSelectedItem();
      TITLE.setText(article.getTitre());
            CONTENTS.setText(article.getContenu());
      IMAGE.setText(article.getImage());

      add.setText("update");
     
    
   

     
    
}
}