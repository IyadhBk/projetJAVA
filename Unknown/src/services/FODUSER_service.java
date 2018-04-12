/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import technique.DataSource;
import models.User;
import models.BCrypt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.IllegalArgumentException;
import java.text.ParseException;

/**
 *
 * @author farouk
 */
public class FODUSER_service {

    private static FODUSER_service instance;
    private Connection conn;
    private PreparedStatement ps;
    public static int id;
    // public static FosUser connecteduser ;

    public FODUSER_service() {
        conn = DataSource.getInstance().getConnection();
    }

    public static FODUSER_service getInstance() {
        if (instance == null) {
            instance = new FODUSER_service();
        }
        return instance;
    }
    private static int workload = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        System.out.println(salt);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

  /*public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}
*/
    public int getId() {
        return id;
    }

  /* public int login(String username, String password) {
        FosUser user = null;
        PreparedStatement pst;
        ResultSet res;

        try {
            pst = conn.prepareStatement("select * from `user` where `username`=? and enabled = 1");
            pst.setString(1, username);
            res = pst.executeQuery();
            System.out.println("");
            if (res.last())//kan il9a il user
            {
                if (checkPassword(password, res.getString("password"))) {
                    id = res.getInt("id");
                    System.out.println(id);
                    // connecteduser.setNom(res.getString("nom")) ;
                    return 1;//user l9ah
                }

            } else {
                return 0;// no user

            }
        } catch (SQLException ex) {
            Logger.getLogger(FODUser_service.class.getName()).log(Level.SEVERE, null, ex);
            return 0;//error
        }
        return 0;
    }
*/
    public boolean register(User user) throws SQLException {

        PreparedStatement pst;
        // ResultSet res;
  pst = conn.prepareStatement("INSERT INTO user (username,email,password,enabled,roles,num_tel) VALUES (?,?,?,?,?,?)");
  
  
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getPassword());
        pst.setBoolean(4, true);
        pst.setString(5, user.getRoles());
        pst.setInt(6, user.getNum_tel());
        return pst.executeUpdate() == 1;

    }

    public int verifusername(String username) throws SQLException {

        PreparedStatement pst;
        ResultSet res;
        pst = conn.prepareStatement("select * from `user` where `username`=?");
        pst.setString(1, username);
        res = pst.executeQuery();

        if (res.last())//kan il9a il user
        {

            return 1;//user l9ah

        } else {
            return 0;// no user

        }

    }

    public int verifmail(String mail) throws SQLException {

        PreparedStatement pst;
        ResultSet res;
        System.out.println(mail);
        pst = conn.prepareStatement("select * from `user` where `email`=?");
        pst.setString(1, mail);
        res = pst.executeQuery();
        System.out.println(res);
        if (res.last())//kan il9a il user
        {

            return 1;//user l9ah

        } else {
            return 0;// no user

        }
    }

 

    public void updateUtilisateur(int id, String newPass) throws SQLException {
        PreparedStatement pst;
        ResultSet res;
        pst = conn.prepareStatement("update `user` set password = ? where `id`=?");
        pst.setString(1, hashPassword(newPass));
        pst.setInt(2, id);
        pst.executeUpdate();

    }
       public int login(String username, String password) throws IllegalAccessException {
        User user = null;
        PreparedStatement pst;
        ResultSet res;
        try {
            pst = conn.prepareStatement("select * from `user` where `username`=? and enabled = 1");
            pst.setString(1, username);
            res = pst.executeQuery();
            System.out.println("");
            if (res.last())//kan il9a il user
            {
                {
                    id = res.getInt("id");
                    System.out.println(id);
                    // connecteduser.setNom(res.getString("nom")) ;
                    return 1;//user l9ah
                }

            } else {
                return 0;// no user

            }
        } catch (SQLException ex) {
            Logger.getLogger(FODUSER_service.class.getName()).log(Level.SEVERE, null, ex);
            return 0;//error
        }
       
    }

         public User getuser(int id) throws SQLException {
        User user = new User();
        PreparedStatement pst;
        ResultSet res;

        pst = conn.prepareStatement("select * from `user` where `id`=?");
        pst.setString(1, String.valueOf(id));
        res = pst.executeQuery();

        while (res.next()) {
            System.out.println(res.getString("username"));
            user.setId(res.getInt("id"));
            user.setUsername(res.getString("username"));
         ;
            user.setRoles(res.getString("roles"));
//            user.setDate(res.getDate("date").toLocalDate());
            user.setEmail(res.getString("email"));
          

        }

        return user;
    }
           public int verifMailAndGiveMeTheId(String mail) throws SQLException {

        PreparedStatement pst;
        ResultSet res;
        System.out.println(mail);
        pst = conn.prepareStatement("select * from `user` where `email`=?");
        pst.setString(1, mail);
        res = pst.executeQuery();
        System.out.println(res);
        int id = -1;
        while (res.next()) {
            id = res.getInt("id");
        }
        return id;
    }
             public int verifNumTel(int num) throws SQLException {

        PreparedStatement pst;
        ResultSet res;
        System.out.println(num);
        pst = conn.prepareStatement("select * from `user` where `num_tel`=?");
        pst.setInt(1, num);
        res = pst.executeQuery();
        System.out.println(res);
        int id = -1;
        while (res.next()) {
            id = res.getInt("id");
        }
        return id;
    }
         


}