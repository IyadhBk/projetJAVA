/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import services.FODUSER_service;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.simplejavamail.email.Email;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.TransportStrategy;

/**
 * FXML Controller class
 *
 * @author chandal
 */
public class PasswordForgetController implements Initializable {

    @FXML
    private Label methodeRecLabel;

    @FXML
    private ComboBox<String> methodeCombo;

    @FXML
    private Label entrerLabel;

    @FXML
    private TextField entrerTextField;

    @FXML
    private Button recupererPassButton;

    @FXML
    private TextField entrerCode;

    @FXML
    private TextField newPassTextField;

    @FXML
    private TextField newPassConfirmationTextField;

    @FXML
    void recupererPassButtonAction(ActionEvent event) throws SQLException {
        if (methodeCombo.getSelectionModel().getSelectedItem().equals("Email")) {
            if (FODUSER_service.getInstance().verifMailAndGiveMeTheId(entrerTextField.getText()) != -1) {
               
                entrerCode.setVisible(true);
                methodeCombo.setDisable(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information!");
                alert.setHeaderText(null);
                alert.setContentText("Nous avons vous envoyé un email contenant votre code de vérification!");
                alert.showAndWait();
                Email email = new Email();

               email.setFromAddress("esprit", "famicity@esprit.tn");
               email.addRecipient("Sir", entrerTextField.getText(), javax.mail.Message.RecipientType.TO);
               email.setSubject("Récuperation du mot de passe Host&Guest");
                email.setText("Votre code de vérification est " + verifCode);
                new Mailer("smtp.gmail.com", 465, "jihene.yahyaoui@esprit.tn", "J09927167", TransportStrategy.SMTP_SSL).sendMail(email);
                recupererPassButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handlePassRecovery();
                    }
                });
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email invalid!");
                alert.setHeaderText(null);
                alert.setContentText("L'email que vous avez saisi est invalide!");
                alert.showAndWait();
            }

        } else if (methodeCombo.getSelectionModel().getSelectedItem().equals("SMS")) {
            if (-1 != FODUSER_service.getInstance().verifNumTel(Integer.parseInt(entrerTextField.getText()))) {
             
                entrerCode.setVisible(true);
                methodeCombo.setDisable(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information!");
                alert.setHeaderText(null);
                alert.setContentText("Nous avons vous envoyé un SMS contenant votre code de vérification!");
                alert.showAndWait();

                

                String ACCOUNT_SID = "AC0243f1bf629ab90e9b719099a21881d9";
                String AUTH_TOKEN = "bb4e757d201df62d03a1c2f69dc96f37";
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                String verifMessage = "Votre code de vérification est " + verifCode;
                Message message = Message.creator(new PhoneNumber("+216"+entrerTextField.getText()),
                        new PhoneNumber("+19388000849"),verifMessage).create();
                recupererPassButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handlePassRecovery();
                    }
                });
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Numero invalid!");
                alert.setHeaderText(null);
                alert.setContentText("le numero que vous avez saisi est invalide!");
                alert.showAndWait();
            }
        }
    }

    private String verifCode;
    private int userId;
    private String mail;
    private int numtel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        verifCode = makeVerifCode();
        entrerCode.setVisible(false);
        newPassTextField.setVisible(false);
        newPassConfirmationTextField.setVisible(false);
         methodeCombo.getItems().addAll("Email", "SMS");
        
      
    }
    private void handlePassRecovery() {
        System.out.println("verif code is " + verifCode);
        System.out.println("enter code is " + entrerCode.getText());
        if (entrerCode.getText().isEmpty() || !entrerCode.getText().equals(verifCode)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setHeaderText(null);
            alert.setContentText("Vérifier votre code!");
            alert.showAndWait();
        } 
            newPassConfirmationTextField.setVisible(true);
            newPassTextField.setVisible(true);
            entrerCode.setDisable(true);
            entrerTextField.setDisable(true);
            recupererPassButton.setText("Changer mot de passe");
            recupererPassButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        updatePassword();
                    } catch (SQLException ex) {
                    }
                }
            });
        }
    

    private void updatePassword() throws SQLException {
        if (newPassConfirmationTextField.getText().equals(newPassTextField.getText())) {
            FODUSER_service userService = new FODUSER_service();
            System.out.println(String.valueOf(userId));
            if (FODUSER_service.getInstance().verifMailAndGiveMeTheId(entrerTextField.getText())>= 0){
            userService.updateUtilisateur(FODUSER_service.getInstance().verifMailAndGiveMeTheId(entrerTextField.getText()), newPassTextField.getText());
             System.out.println(String.valueOf("-----------"+FODUSER_service.getInstance().verifMailAndGiveMeTheId(entrerTextField.getText())));
            }else{
            userService.updateUtilisateur(FODUSER_service.getInstance().verifNumTel(Integer.parseInt(entrerTextField.getText())), newPassTextField.getText());
                System.out.println(String.valueOf(FODUSER_service.getInstance().verifNumTel(Integer.parseInt(entrerTextField.getText()))));
            }
            //FOSUser_service.getInstance().verifNumTel(Integer.parseInt(entrerTextField.getText()))
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Changement avec succés!");
            alert.setHeaderText(null);
            alert.setContentText("Votre mot de passe à été changé avec succés!");
            alert.showAndWait();
            //launch();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setHeaderText(null);
            alert.setContentText("Vérifier les champs!");
            alert.showAndWait();
        }
    }
    

 


    public static String makeVerifCode() {
        String randomString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String verifCode = "";
        for (int i = 0; i < 8; i++) {
            int n = rand.nextInt(randomString.length());
            verifCode += randomString.charAt(n);
        }
        return verifCode;
    }
}
