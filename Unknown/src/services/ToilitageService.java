/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

//import com.sun.org.apache.bcel.internal.generic.RETURN;
import iservices.IToilitageService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Association;
import models.Toilitages;
import technique.DataSource;

/**
 *
 * @author p
 */
public class ToilitageService implements IToilitageService {

    private final Connection connection;
    private PreparedStatement pst;

    public ToilitageService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouterToilitage(Toilitages toilitage) {
        String req = "INSERT INTO `toilettage_anmaux`(`nom_toilettage`, `description_toilettage`, `num_tel`, `addresse`, `lat`, `lng`,`image`) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, toilitage.getNom());
            pst.setString(2, toilitage.getDescription());
            pst.setInt(3, toilitage.getNum_tel_toilitage());
            pst.setString(4, toilitage.getAdresse());
            pst.setDouble(5, toilitage.getLat());
            pst.setDouble(6, toilitage.getLongi());

            pst.setString(7, toilitage.getImage());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modifierToilitage(Toilitages toilitage) {
        try {
            String req = "UPDATE `toilettage_anmaux` SET `nom_toilettage`=?,`description_toilettage`=?,`num_tel`=?,`addresse`=?,`image`=?" + "WHERE id =  '";

            pst = connection.prepareStatement(req);
            pst.setString(1, toilitage.getNom());
            pst.setString(2, toilitage.getDescription());
            pst.setInt(3, toilitage.getNum_tel_toilitage());
            pst.setString(4, toilitage.getAdresse());
             pst.setString(5,toilitage.getImage());

            pst.setInt(6, toilitage.getToilitage_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerToilitage(Toilitages toilitage) {
        String req = "DELETE FROM `toilettage_anmaux` WHERE id =?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, toilitage.getToilitage_id());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Toilitages> getToilitages() {
        String req = "SELECT * FROM `toilettage_anmaux`";
        List<Toilitages> toilitages = new ArrayList<>();

        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Toilitages toilitage = new Toilitages(resultSet.getInt("id"), resultSet.getString("nom_toilettage"), resultSet.getString("description_toilettage"), resultSet.getInt("num_tel"), resultSet.getString("addresse"), resultSet.getDouble("lat"), resultSet.getDouble("lng"));
                toilitages.add(toilitage);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toilitages;
    }

    @Override
    public List<Toilitages> getToilitage1() {
        String req = "SELECT * FROM `toilettage_anmaux` where reservation = 0";
        List<Toilitages> toilitages = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Toilitages toilitage = new Toilitages(resultSet.getString("nom_toilettage"), resultSet.getString("description_toilettage"), resultSet.getInt("num_tel"), resultSet.getString("addresse"), resultSet.getString("image"));
                toilitage.setToilitage_id(resultSet.getInt("id"));
                toilitages.add(toilitage);

            }
        } catch (SQLException e) {
        }

        return toilitages;
    }

//    public Toilitages selectProduitDet(int id) throws SQLException {
//        String req = "select * from toilettage_anmaux where id=?;";
//        Toilitages p = new Toilitages();
//        try {
//            PreparedStatement stm = connection.prepareStatement(req);
//
//            stm.setString(1, String.valueOf(id));
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//
//                p.setNom(rs.getString("nom_toilettage"));
//                p.setDescription(rs.getString("description_toilettage"));
//                p.setNum_tel_toilitage(rs.getInt("num_tel"));
//                p.setAdresse(rs.getString("addresse"));
//                p.setImage(rs.getString("image"));
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ToilitageService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return p;
//    }

    @Override
    public List<Toilitages> getToilitage() {

        String req = "SELECT * FROM `toilettage_anmaux`";
        List<Toilitages> toilitages = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Toilitages toilitage = new Toilitages(resultSet.getInt("id"), resultSet.getString("nom_toilettage"), resultSet.getString("description_toilettage"), resultSet.getString("image"));
                toilitages.add(toilitage);

            }
        } catch (SQLException e) {
        }

        return toilitages;

    }

    @Override
    public void reserverToilitage(int toilId) {
        String req = "UPDATE `toilettage_anmaux` SET reservation = 1 where id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(req);
            stm.setInt(1, toilId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ToilitageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void dereserverToilitage(int toilId) {
        String req = "UPDATE `toilettage_anmaux` SET reservation = 0 where id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(req);
            stm.setInt(1, toilId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ToilitageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Toilitages findby(int id) {
         String req = "select * from toilettage_anmaux where id = ?";
        Toilitages t = null;
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                t= new Toilitages(resultSet.getString("nom_toilettage"), resultSet.getString("description_toilettage"), resultSet.getInt("num_tel"), resultSet.getString("addresse"), resultSet.getString("image")); // new User(resultSet.getInt(3))
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
        
    }
    

}
