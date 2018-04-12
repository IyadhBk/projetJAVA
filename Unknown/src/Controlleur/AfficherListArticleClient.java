/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author didid
 */
public class AfficherListArticleClient extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           Parent root =FXMLLoader.load(getClass().getResource("afficherArticle.fxml"));

    
    
    Scene scene = new Scene(root);
         primaryStage.setScene(scene);
         primaryStage.setTitle("liste articles");

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