/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author didid
 */
public class GestArticle extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Parent root =FXMLLoader.load(getClass().getResource("insertArticle.fxml"));
       // System.out.println( BCrypt.checkpw("vet","$2y$13$5X18.ZmygyF2okLMJvldKe24ZplgCXCpahpKncOGUUbvMkgQoj4Wu"));
        //BCrypt b = new BCrypt();
        
         Scene scene = new Scene(root);
         primaryStage.setScene(scene);
         primaryStage.setTitle("GestA");

        primaryStage.show();
}
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        launch(args);
    }
}    
