/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import models.Event;
import services.EventServices;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import technique.DataSource;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutController implements Initializable {

    @FXML
    private TextField Nom;
    @FXML
    private TextArea Description;
    @FXML
    private DatePicker Date;
    @FXML
    private TextField Lieu;
    
DataSource ds;
    @FXML
    private Button Enregister;
    @FXML
    private Button Quitter;
    @FXML
    private Button filechooser;
    
    FileChooser fc = new FileChooser() ; 
     File selectedFile ; 
    @FXML
    private ImageView imggg;
    @FXML
    private TextField image;
    @FXML
    private TextField nbrplace;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//       ds=new DataSource();
// testChamps();
    }    

    @FXML
    private void addEvent(ActionEvent event) {
       // System.out.println("evenement ajouté !!!");
        
        
        String nom=Nom.getText();
        String description=Description.getText();
        String dateDeut=Date.getValue().toString();
        String lieu=Lieu.getText();
        int nbr = (Integer.parseInt(nbrplace.getText())) ; 
        String image=this.image.getText();
        int cat = 5 ; 
        
        
        
       
       /* e.setNom(nom);
        e.setDescription(description);
        e.setDateDebut(dateDeut);
        e.setLieu(lieu);
        e.setImage(image);
*/
         Event e = new Event();
         e.setLieu(lieu);
         e.setDateDebut(dateDeut);
         e.setNom(nom);
         e.setNombrePlaces(nbr);
         e.setDescription(description);
         e.setImage(image);
         e.setCategorie_id(1);
        
        services.EventServices es=new EventServices();
        es.insertEvent(e);
        testChamps();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bonjour");
        alert.setContentText("Evénement ajouté avec succées *_* ");
         alert.showAndWait();
        
    }

    @FXML
    private void quitter(ActionEvent event) {
        System.exit(0);
        
        
        
    }
    
    private void image () {
        File file = new File("C:\\Users\\HP\\Desktop\\Images",image.getText());
        
        Image image = new Image(file.toURI().toString());
        imggg.setImage(image);
         
        
    }

    @FXML
    private void filechooser(ActionEvent event) throws FileNotFoundException {
        fc.setInitialDirectory(new File("C:\\Users\\HP\\Desktop\\Images"));
        selectedFile = fc.showOpenDialog(null);
       if(selectedFile!=null){
      
        Image image = new Image(selectedFile.toURI().toString());
        imggg.setImage(image);
        this.image.setText(selectedFile.getAbsolutePath()); 
    }
    }
    
    
    
    private boolean testChamps(){
        
        boolean res=true;
        String msgTitle = "" ;
        String msgContent = "" ;
        
       if(Nom.getText().equals("")) 
       {
           System.out.println("unChamp: " + Nom + " est vide");
           msgTitle="un champ nom est vide";
             msgContent="veillez remplir le champ nom  ";
              
       }
       
       
       
       if ((Nom.getText().compareTo("")==0))
            {

             
             msgTitle="un champ nom est vide";
             msgContent="veillez remplir le champ nom  ";
             
            res = false ;
        }
          
       if(res == false ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle(msgTitle);
             alert.setContentText(msgContent);
             alert.showAndWait();
       }
       return res;
       
        
    }
}
