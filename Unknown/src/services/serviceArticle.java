/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Article;
import models.UserDoha;
import technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Date;



/**
 *
 * @author didid
 */
public class serviceArticle {
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    
    
     public serviceArticle()
    {
     con=DataSource.getInstance().getConnection();}
     
      public void insertArticle(Article article) throws SQLException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        String date_current = dateFormat.format(date).toString();
        String req="INSERT INTO `article_J`"+"(`titre`, `contenu`,`date`,`image` ,id_user)"+ "VALUES (?,?,?,?,?)";
         try{
        PreparedStatement ste = con.prepareStatement(req);
        ste.setString(1,article.getTitre());
        ste.setString(2,article.getContenu());
        ste.setString(3,date_current);
        ste.setString(4,article.getImage());
        ste.setInt(5,article.getVet().getId());
        

        ste.executeUpdate();
         }
         catch (SQLException ex)
         {            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);

             }

                
                
                }
      
       public List<Article> selectAllArticles()
    { String req="Select * from article_J order by date ASC";
      List<Article> list = new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                System.out.println(rs);
            Article article=new Article(rs.getInt("id"),rs.getString("titre"),rs.getString("contenu"),rs.getString("date"),rs.getString("image"));
               
            list.add(article);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
       
        }
       
       
       
       public void updateArticle (Article article, int id) throws SQLException
       {
           System.out.println(article);
           String sql ="UPDATE article_J SET titre=?,contenu=?,date=?,image=? WHERE id=?";
           try{
           PreparedStatement ste = con.prepareStatement(sql);
           ste.setString(1,article.getTitre());
           ste.setString(2,article.getContenu());
           ste.setString(3, article.getDate());
           ste.setString(4,article.getImage());
           ste.setInt(5,id);
               System.out.println(sql);
           int rowsUpdated = ste.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Article modifié");
			}
           
           
          }
           catch (SQLException ex)
         {            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);

             }
       }
       
       public void deleteArticle ( int id) throws SQLException
       {
           String req =" DELETE FROM article_J WHERE id=?";
           try{
           PreparedStatement ste = con.prepareStatement(req);
           ste.setInt(1,id);
           
           int rowsDeleted = ste.executeUpdate();
            if (rowsDeleted > 0) {
                 System.out.println("article supprimé");
           } 
           }
           
        catch (SQLException ex)
         {            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);

             }           
           

}
              public List<Article> selectAllArticles_client()
    { String req="Select id,article_j.id_user as user_vet, titre ,date, contenu , image, nom, prenom from article_J ,test_user"
            + " WHERE article_j.id_user = test_user.id_user order by date ASC";
      List<Article> list = new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                System.out.println(rs);
                UserDoha vet = new UserDoha();
                vet.setId(rs.getInt("user_vet"));
                vet.setNom(rs.getString("nom") + " " + rs.getString("prenom"));
                System.out.println(vet);
                
            Article article=new Article(rs.getInt("id"),rs.getString("titre"),rs.getString("contenu"),rs.getString("date"),rs.getString("image"));
            //  article.setVet(vet);
            list.add(article);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
       
        }
}


