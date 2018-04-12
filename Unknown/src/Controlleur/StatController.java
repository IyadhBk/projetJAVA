/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import services.serviceRating_1;

/**
 * FXML Controller class
 *
 * @author didid
 */
public class StatController implements Initializable {




    @FXML
    private BarChart<String, Double> stat;

    @FXML
    private CategoryAxis nomArticle;

    @FXML
    private NumberAxis note;
     Map<String,Double> map = new HashMap<>();
    ObservableMap<String,Double> titreArticle = FXCollections.observableMap(map);
    

   


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       XYChart.Series<String, Double>  serie =  new XYChart.Series<>();

        services.serviceRating_1 sra= new serviceRating_1();
        map=sra.StatArticle();
        titreArticle.putAll(map);
        System.out.println(map);
        map.forEach((k, v) -> {
            serie.getData().add(new XYChart.Data<>(k, v));
        });
        
        stat.getData().add(serie);
    }    
    
}
