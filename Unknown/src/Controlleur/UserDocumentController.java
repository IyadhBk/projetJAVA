/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

 

import models.User;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ServiceUser;
//import com.restfb.DefaultFacebookClient;
//import com.restfb.FacebookClient;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class UserDocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField Nom;
private boolean btnclicked;
    @FXML
    private JFXPasswordField pass;
        @FXML
    private Button login;
        
    @FXML
    private Button facebook;

    @FXML
    private Label noU;
            @FXML
    private AnchorPane pane;
            private String loggeduser;
            private User Us;
            private Stage dialogStage;

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
            
           private int iduser;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public User getUs() {
        return Us;
    }

    public void setUs(User Us) {
        this.Us = Us;
    }

    public String getLoggeduser() {
        return loggeduser;
    }

    public void setLoggeduser(String loggeduser) {
        this.loggeduser = loggeduser;
    }
          

    
    @FXML
    private void LoginAction (ActionEvent event) throws IOException, SQLException{
       
        
        String  username=Nom.getText();
       String password=pass.getText();
       
User U =new User();
       U.setPassword(password);
       U.setUsername(username);
       
       
     
       ServiceUser su=new ServiceUser();
       NewFXMain1 main = new NewFXMain1();
       
           
    

       
        try
 {
     String userValide=su.authenticateUser(U);
            Us=su.recupererUtilisateur(username);
            main.setU(su.recupererUtilisateur(username));
          

 
        
     if(userValide.equals("Admin"))
 {

 System.out.println("Admin's Home");
 
   
iduser=Us.getId();
 System.out.println(Us.getId());
     System.out.println(main.u.getUsername());
 
     System.out.println(iduser);

     
//  AnchorPane p= FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        pane.getChildren().setAll(p);
//         p.setMinHeight(849);
//        p.setMinWidth(561);


//FXMLLoader loader =new FXMLLoader();
//  loader.setLocation(FXMLDocumentController.class.getResource("FXMLDocument.fxml"));
//  AnchorPane pane=(AnchorPane) loader.load();
//       Stage dialogStage=new Stage();
//  dialogStage.setTitle("Souk el Mdina ");
//     Scene scene = new Scene(pane);
//     dialogStage.setScene(scene);
//     dialogStage.setResizable(false);
//        
//        this.dialogStage=dialogStage;
//        
//        dialogStage.show();
// 

 Stage stage = (Stage) login.getScene().getWindow();
        // do what you have to do
        stage.close();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/HomeAdmin.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage2 = new Stage();
           
       
            stage2.setTitle("Z'animaux ");
            stage2.setScene(new Scene(root2));

            stage2.show();

        }catch(IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

 }
     else if(userValide.equals("Utilisateur"))
 {

     System.out.println("User Home");
      System.out.println(Us.getId());
      
      
       
Stage stage = (Stage) login.getScene().getWindow();
        // do what you have to do
        stage.close();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Acceuil.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage2 = new Stage();
           
       
            stage2.setTitle("Z'animaux ");
            stage2.setScene(new Scene(root2));

            stage2.show();

        }catch(IOException e) {
            e.printStackTrace();
        }
     
 
 }
          else if(userValide.equals("Veterinaire"))
 {

     System.out.println("Veterinaire Home");
      System.out.println(Us.getId());
      
      
       
Stage stage = (Stage) login.getScene().getWindow();
        // do what you have to do
        stage.close();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/vetAfterLogin.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage2 = new Stage();
           
       
            stage2.setTitle("Z'animaux ");
            stage2.setScene(new Scene(root2));

            stage2.show();

        }catch(IOException e) {
            e.printStackTrace();
        }
     
 
 }
     else if(userValide.equals("Vendeur"))
 {
 System.out.println("Vendeur Home");
  System.out.println(Us.getId());
   

 Stage stage = (Stage) login.getScene().getWindow();
        // do what you have to do
        stage.close();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Acceuil.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage2 = new Stage();
           
       
            stage2.setTitle("Z'animaux");
            stage2.setScene(new Scene(root2));

            stage2.show();

        }catch(IOException e) {
            e.printStackTrace();
        }
 }
     else
 {
 System.out.println("Error message = "+userValide);}
     
 }
 catch (Exception e1)
 {
 e1.printStackTrace();
 }
}  
    
//    @FXML
//    public void loginfacebook(ActionEvent event){
//        
//      String domain=  "http://soukelmadina.com/";
//      String appid="2033288736939186";
//       String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appid+"&redirect_uri="+domain+"&scope=user_about_me,"
//                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_activities,user_birthday,user_education_history,"
//                + "user_events,user_photos,user_friends,user_games_activity,user_groups,user_hometown,user_interests,user_likes,user_location,user_photos,user_relationship_details,"
//                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
//                + "manage_notifications,manage_pages,publish_actions,read_friendlists,read_insights,read_mailbox,read_page_mailboxes,read_stream,rsvp_event,manage_pages";
//                System.setProperty("webdirver.chrome.driver", "C:/Users/HP/Documents/NetBeansProjects/Produit2/PIDEVJAVA/Produit2/chromedriver.exe");
//          
//                
//                WebDriver driver = new ChromeDriver();
//                
//        driver.get(authUrl);
//        String accessToken;
//        while(true){
//       
//            if(!driver.getCurrentUrl().contains("http://facebook.com/")){
//            String url = driver.getCurrentUrl();
//            accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
//           
//            driver.quit();
//           
//                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
//                User user = fbClient.fetchObject("me",User.class);
//               
//               
//                noU.setText(user.getUsername());
//           
//            }}
//    }
//    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  
    
        // TODO
    }    
    
         @FXML
    private void register(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/register.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
    
             @FXML
    private void forgetpassword(MouseEvent event) throws IOException {

 try {
              Parent home_page_parent = FXMLLoader.load(getClass().getResource("/GUI/forgetpassword.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
            
                //app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
        
            
        } catch (IOException ex) {
           
        
    }
    }
}

