/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import iservices.IReservationService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Reservation;
import models.Toilitages;
import technique.DataSource;

/**
 *
 * @author p
 */
public class ReserverService implements IReservationService{

    private final Connection connection;
    private PreparedStatement pst;

    public ReserverService() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void reserver(int idToil, int idUser, Date resDate) {
        try {
            String stm = "INSERT INTO `reservation`(`id_user`, `id_toilettage_anmaux`, `date_reservation`) VALUES (?,?,?)";
            pst = connection.prepareStatement(stm);
            pst.setInt(1, idUser);
            pst.setInt(2, idToil);
            pst.setDate(3, resDate);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReserverService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Toilitages> afficherReservations() {
        List<Toilitages> toilitages = new ArrayList<>();
        try{
            String stm = "SELECT * FROM reservation r JOIN toilettage_anmaux t on t.id = r.id_toilettage_anmaux";
            pst = connection.prepareStatement(stm);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                Toilitages toilitage = new Toilitages(resultSet.getString("nom_toilettage"), resultSet.getString("description_toilettage"), resultSet.getInt("num_tel"), resultSet.getString("addresse"), resultSet.getString("image"));
                toilitage.setToilitage_id(resultSet.getInt("id_toilettage_anmaux"));
                toilitage.setDateReservation(resultSet.getDate("date_reservation"));
                toilitages.add(toilitage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserverService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toilitages;
    }
    
}
