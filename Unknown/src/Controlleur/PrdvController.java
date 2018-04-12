/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;



import Controlleur.LoginController;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import com.sun.javafx.scene.control.skin.DatePickerContent;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import models.UserDoha;
import models.rdv;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.cell.PropertyValueFactory;
import validation.TextFieldValidation;

public class PrdvController implements Initializable{

   @FXML
    private TableColumn<UserDoha, String> PRENOM;

    @FXML
    private TableColumn<UserDoha, String> NOM;

    @FXML
    private TableColumn<UserDoha, String> ADRESSE;

    @FXML
    private TableColumn<UserDoha ,String> EMAIL;
    @FXML
    private TableColumn<UserDoha ,Integer> ID;


    @FXML
    private Button reserver;

    @FXML
    private ToggleButtonGroup toggle;

    @FXML
    private RadioButton choisirDate;

    @FXML
    private RadioButton choisirVeter;

    @FXML
    private TitledPane choisirDateP;

    @FXML
    private DatePicker date;

    @FXML
    private TableView<UserDoha> tableVet;
    
     @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private TextField adresse;

    @FXML
    private TextField email;
     @FXML
    private TextField numTel;

    @FXML
    private Button RESERVER;
    @FXML
    private Label erreur_number;
    @FXML
    private Label erreurMail;
    
    String dateParam;


  



    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // choisirDateP.setExpanded(false);
       // choisirVet.setExpanded(false);
System.out.println(tableVet.visibleProperty().get());
        choisirDate.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    
                    Boolean selected_item = choisirDate.selectedProperty().getValue();
                    if(selected_item)
                    {
                        System.out.println(tableVet.visibleProperty().get());
                        choisirDateP.setVisible(true);
                        tableVet.setVisible(false);

                        //choisir Date slected
                        
                    }
            }
        });

        
        date.setOnAction(new EventHandler() {
     public void handle(Event t) {
         
          dateParam = date.getValue().toString();
          if(difference_date(date.getValue()))
                {  
         System.err.println("Selected date: " + dateParam);
        services.PriseRdv prise = new services.PriseRdv();
                ObservableList priseObservable = FXCollections.observableArrayList(prise.rechercheDate(dateParam));
      tableVet.setVisible(true);
        tableVet.setItems(priseObservable);
        NOM.setCellValueFactory(new PropertyValueFactory<>("nom"));

        PRENOM.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ADRESSE.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        EMAIL.setCellValueFactory(new PropertyValueFactory<>("email"));
                ID.setCellValueFactory(new PropertyValueFactory<>("id"));

                }else{
              System.out.println("error");
          } 
         
     }
 });
        
         numTel.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           if (!newValue)
           { erreur_number.setText("error ");
            }}
        });
          
        
            

        
        
        // TODO
    }   
    @FXML
    public void priseRdv (ActionEvent event)throws SQLException, IOException, NexmoClientException 
    {
        
        if (TextFieldValidation.isNumber(numTel)&& TextFieldValidation.isTextFieldNotEmpty(nom)&&TextFieldValidation.isTextFieldNotEmpty(prenom)&&TextFieldValidation.isTextFieldNotEmpty(adresse))
        {String name = nom.getText();
        String lastName = prenom.getText();
        String adress= adresse.getText();
        if (TextFieldValidation.isEmail(email))
        {String mail = email.getText();} else { erreurMail.setText("Error e-mail");
        }
        String num = numTel.getText();
       UserDoha vet = (UserDoha)tableVet.getSelectionModel().getSelectedItem();
       String contenu = "Votre rendez-vous a été confirme avec le Docteur"+vet.getNom()+" "+vet.getPrenom()+"Pour le "+dateParam;

        int idUser= LoginController.id;
        int idVet= vet.getId();


          sms(num,contenu);

          rdv Rdv = new rdv (idUser,idVet,dateParam )  ;
          services.PriseRdv pr = new services.PriseRdv();
          pr.insertRDV(Rdv);
          
        }
        else {
        
         Alert alert =new Alert(Alert.AlertType.ERROR);
       alert.setContentText("Erreur veuillez remplir les champs");
       alert.setTitle("Erreur");
       alert.setHeaderText("Erreur");
       alert.showAndWait();
        }
         
    }
    
    public void sms(String numTele, String contenu) throws IOException, NexmoClientException
    {
        AuthMethod auth = new TokenAuthMethod("2ffd82c3", "l5tUAbYppJlpBvLR");
       NexmoClient client = new NexmoClient(auth);
       SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(
        "Z animo",
        numTele,
        contenu));
for (SmsSubmissionResult response : responses) {
    System.out.println(response);
}
}
    
     boolean difference_date(LocalDate d1)
{
      LocalDate currentDate = LocalDate.now();
     long diffInDays = ChronoUnit.DAYS.between(currentDate, d1);
     long diffInMonths = ChronoUnit.MONTHS.between(d1, currentDate);
     long diffInYears = ChronoUnit.YEARS.between(d1, currentDate);
     System.out.println(diffInDays);
     if(diffInDays < 0)
     {
         return false;
     }
     return true;
}
    }
            
    
  
    
    
    

