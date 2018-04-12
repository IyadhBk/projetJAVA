///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev;
//
//import iservices.IAnimauxService;
//import iservices.IGardeService;
//import java.sql.Date;
//import java.util.List;
//import javafx.application.Application;
//import static javafx.application.Application.launch;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
////import models.Animaux;
//import models.Association;
//import models.Garde;
////import models.User;
//import services.AnimauxService;
//import services.GardeService;
//
///**
// *
// * @author s
// */
//public class Pidev extends Application {
//
//    /**
//     * @param args the command line arguments
//     */
//    
//         @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/GUI/HomeAdmin.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//    }
//    public static void main(String[] args) {
//        launch(args);
//        
//         //IGardeService service =new GardeService();
//         //IAnimauxService service1 =new AnimauxService();
//    //Garde g=new Garde("garde9",25,"zarzouna");
//   // service.ajoutGarde(g);
//   // service.getGarde();
//   // List<Garde>Gardes = service.getGarde();
//    //for (Garde garde : Gardes){
//      //      System.out.println(garde);
//     
//      // Date d = new Date(1222222);
//       //Garde t=new Garde(9);
//      //User U =new User(1);
//       // Association a2 = new Association(1);     
//        
//       //Animaux A=new Animaux("sisi","chat","Noir","4","Femelle",d,t,U,"image",a2);
//      //service1.ajoutAnimaux(A);
//      
//     // List <Animaux> A = service1.getAnimaux() ;
//      //for (Animaux Animaux : A){
//        //    System.out.println(Animaux);
//    //}
//    //Animaux A=new Animaux(115);
//    //service1.supprimerAnimaux(A);
//    
//     
//         
////         Animaux Anix = (Animaux) service1.findById(95);
////         
////         Animaux Anix2  = new Animaux(Anix.getNom(),Anix.getType(),Anix.getColeur(), Anix.getAge(), Anix.getSexe(),Anix.getDateAdoption(), Anix.getGarde(), Anix.getUser(), Anix.getBrochure(),Anix.getAssociation());
////         Anix2.setType("chat");
////         service1.modifierAnimaux(Anix2);
////         System.out.println(Anix2);
//    
//  
//    }}
//    
//
