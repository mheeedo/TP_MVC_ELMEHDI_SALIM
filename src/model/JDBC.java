package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;








public class JDBC {
	private static final String DATABASE_URL =  "jdbc:mysql://localhost:3306/music";;
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root";
    private String sql;
    static Connection conne = null;
    public JDBC() throws SQLException {
      	 conne = DriverManager
      	            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
      	 
       }
    public ArrayList<Album> get_album(String type) {
    	 sql= "select ref,titre,auteur,img,prix from article where refcat = (select refcat from categorie where cat = '"+ type +"')";
    	 try { 
    		 	PreparedStatement preparedStatement = conne.prepareStatement(sql);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            ArrayList<Album> list=new ArrayList<Album>();
	            while (resultSet.next()) {
	            	   Album album = new Album();
	            	   album.setAuteur(resultSet.getString("auteur"));
	            	   album.setTitre(resultSet.getString("titre"));
	            	   album.setImg(resultSet.getString("img"));
	            	   album.setPrix(resultSet.getInt("prix"));
	            	   album.setRef(resultSet.getString("ref"));
	            	 
	            	   list.add(album);
		         }
	            return list;
    	 } catch (SQLException e) {
	            printSQLException(e);
	            }
    	 return null;
    	}
    public ArrayList<Pan> panneau(String email){
    	
    	sql= "select titre from article as ar,client as cl,commande as com where com.id = cl.id and com.ida = ar.ida and cl.email ='"+email+"'";
   	 try { 
   		 	PreparedStatement preparedStatement = conne.prepareStatement(sql);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            ArrayList<Pan> list=new ArrayList<Pan>();
	            while (resultSet.next()) {
	            	   Pan titre = new Pan();
	            	
	            	   titre.setPan(resultSet.getString("titre")); 
	            	   list.add(titre);
	            
		         }
	            return list;
   	 } catch (SQLException e) {
	            printSQLException(e);
	            }
   	 return null;
    	
    	
    }

    
    
    public Album detail(String ref) {
    	sql = "select * from article where ref = ?";
    	   try {
			PreparedStatement preparedStatement = conne.prepareStatement(sql);
			preparedStatement.setString(1, ref);
			ResultSet rs = preparedStatement.executeQuery();
			Album album = new Album();
			while(rs.next()) {
				album.setAuteur(rs.getString("auteur"));
         	   album.setTitre(rs.getString("titre"));
         	   album.setImg(rs.getString("img"));
         	   album.setPrix(rs.getInt("prix"));
         	   album.setRef(rs.getString("ref"));
         	  
				
			}
			return album;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    
    
    
    
    public boolean connexion(String email,String mdp) {
    	sql ="select * from client where email = ? and mdp = ?";
    	  
        try { 

            
            PreparedStatement preparedStatement = conne.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setLong(2, mdp.hashCode());

            

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
            	return true;
                
           
            }
            
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return false;
    	
    }
    public void inscription(String email,String nom,String prenom,String adresse,int codepostal,String ville,String mdp) {
    	
    	sql ="insert into client(email,nom,prenom,adresse,codepostal,ville,mdp)  values(?,?,?,?,?,?,?)";
    	try { 

            PreparedStatement preparedStatement = conne.prepareStatement(sql);
       preparedStatement.setString(1,email );
       preparedStatement.setString(2, nom);
       preparedStatement.setString(3,prenom);
       preparedStatement.setString(4, adresse);
       preparedStatement.setInt(5, codepostal);
       preparedStatement.setString(6, ville);
    
       preparedStatement.setLong(7, mdp.hashCode());
      
      preparedStatement.executeUpdate();
           

          
            
        } catch (SQLException e) {
            
            printSQLException(e);
        }
    	
    	
    }
    public boolean validate_email(String email) {
    	
    	sql ="select * from client where email = ? ";
        
        try { 

     
            PreparedStatement preparedStatement = conne.prepareStatement(sql);
            preparedStatement.setString(1, email);
           

            

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
                return true;
            }

            
        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return false;
    }
    public void pannier(String ref,String email) {

        
        try { 
        	int id,ida;
        	sql="select id from client where email = ?";
            PreparedStatement preparedStatement = conne.prepareStatement(sql);
            preparedStatement.setString(1, email);
             
            		ResultSet rs =  preparedStatement.executeQuery();
            		rs.next();
            		id = rs.getInt("id");
            sql="select ida from article where ref = ?";
          preparedStatement = conne.prepareStatement(sql);
            preparedStatement.setString(1, ref);
            rs =preparedStatement.executeQuery();
        	rs.next();
        	ida = rs.getInt("ida");
            sql ="insert into commande(id,ida) values(?,?)";
            preparedStatement = conne.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ida);
            preparedStatement.executeUpdate();
       
           
            
        } catch (SQLException e) {
            
            printSQLException(e);
        }
   
    	
    	
    }
    
    
    
    public String nom(String email) throws SQLException {
    	sql="select nom from client where email = ?";
    	 PreparedStatement preparedStatement = conne.prepareStatement(sql);
    	 preparedStatement.setString(1,email );
    	ResultSet rs =  preparedStatement.executeQuery();
    	while(rs.next()) {
    		
    		return rs.getString("nom");
    	}
    	
    	return null;
    }
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
