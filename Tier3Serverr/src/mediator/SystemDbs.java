package mediator;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Common.Petition;
import Common.Post;
import Common.User;

public class SystemDbs implements SystemPersistence
{
	private static String url;
	private static String username;
	private static String password;
	private CitizenPersistence citizendbs;
	
	public SystemDbs(String url,String username,String password)
	{
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void initializeCitizenDbs(String url)
	{
		citizendbs = new CitizenDbs(url,username,password);
	}
	
	
	
	@Override
	public User createAccount(User user)
	{
		User accountUser = user;
		System.out.println(accountUser.getCpr());
		System.out.println(accountUser.getCpr());
		if(citizendbs.CheckId(accountUser)==true)
		{
			String sql = "Insert into UserDetails(cpr,password,name,email,role,city) values(?,?,?,?,?,?)";
			String sql1 = "Select * from UserDetails where cpr =?";
			try (Connection con = DriverManager.getConnection(url, username, password);
		             PreparedStatement pst = con.prepareStatement(sql)) {
		            
		            pst.setString(1,accountUser.getCpr());
		            pst.setString(2,accountUser.GetPassword());
		            pst.setString(3,accountUser.GetName());
		            pst.setString(4,accountUser.GetEmail());
		            pst.setString(5,accountUser.GetRole());
		            pst.setString(6,accountUser.getCity());
		            pst.executeUpdate();
		            System.out.println("User added into database");
		}
			catch (SQLException ex) {

	            System.out.println(ex.getMessage());
	        }	
			
			try (Connection con = DriverManager.getConnection(url, username, password);
		             PreparedStatement pst = con.prepareStatement(sql1)) 
			{
				pst.setString(1, user.getCpr());
				ResultSet rs = pst.executeQuery();
				 if (rs.next()) {
		                
						User databaseuser = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
						return databaseuser;
						
		            }
				 else
				 {
					 return null;
				 }
				 
			
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
			
			}
			
		return null;
			
	}
	
@Override
	public User accesAccount(User user)
	{
	
	User loginUser = user; 
	
		String sql = "Select * from UserDetails where (cpr=? and password=?)";
		
		try (Connection con = DriverManager.getConnection(url, username, password);
	             PreparedStatement pst = con.prepareStatement(sql))
		{
			pst.setString(1, loginUser.getCpr());
			pst.setString(2, loginUser.GetPassword());
			ResultSet rs = pst.executeQuery();
			 if (rs.next()) {
	                
					User databaseuser = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					System.out.println("User is logged in");
					return databaseuser;
					
	            }
			 else
			 {
				 return null;
			 }

		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
@Override
	public Post createPost(Post post)
	{
	String sql = "insert into Post(pid,title,creator,content,type,pdate,city) values(?,?,?,?,?,?,?)";
	String sql1 = "select * from Post where pid=?";

    try (Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	pstmt.setInt(1,post.getPid());
    	pstmt.setString(2, post.getTitle());
    	pstmt.setString(3,post.getCreator().getCpr());
    	pstmt.setString(4, post.getContent());
    	pstmt.setString(5, post.getType());
    	pstmt.setDate(6, post.getDate());
    	pstmt.setString(7,post.getCity());
    	
    	pstmt.executeUpdate();
        System.out.println("Post added into database");
    }
    catch(SQLException ex)
    {
	 System.out.println(ex.getMessage()); 
	 }
    
	try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = con.prepareStatement(sql1))
	{
		pst.setInt(1, post.getPid());
		ResultSet rs = pst.executeQuery();
		 if (rs.next()) {
                
			 User user = new User();
			 user.setCpr(rs.getString(3));
			    Post databasepost = new Post(rs.getInt(1),rs.getString(2),user,rs.getString(4),rs.getString(5),rs.getDate(6),rs.getString(7));
				System.out.println("Post is in database");
				return databasepost;
				
            }
		 else
		 {
			 return null;
		 }

	}
	catch(SQLException ex)
	{
		System.out.println(ex.getMessage());
	}
	
	return null;
    
    }
@Override
public  ArrayList<Post> getPostByCity(String city)
{
	String sql = "Select * from post where city=?";
	
	   ArrayList<Post>  list = new ArrayList<>();
	
	try (Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement(sql))
	{
		pst.setString(1, city);
		boolean isResult = pst.execute();

        do {
            try (ResultSet rs = pst.getResultSet()) {

                while (rs.next()) {
                
               
                  User user = new User();
 				 user.setCpr(rs.getString(3));
                  Post databasepost = new Post(rs.getInt(1),rs.getString(2),user,rs.getString(4),rs.getString(5),rs.getDate(6),rs.getString(7));
                  list.add(databasepost);
                  System.out.println("Post added to list");
                }

                isResult = pst.getMoreResults();
            }
        } while (isResult);
        System.out.println(list.size());
        return list;
        


	}
	catch(SQLException ex)
	{
		System.out.println(ex.getMessage());
	}
	
	return null;

	}
@Override
public  Petition createPetition(Petition petition)
{
	String sql = "insert into Petition(peid,title,creator,pedate,content,approved,approvedby) values(?,?,?,?,?,?,?)";
	String sql1 = "select * from Petition where peid=?";

    try (Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	pstmt.setInt(1,petition.getPeid());
    	pstmt.setString(2, petition.getTitle());
    	pstmt.setString(3,petition.getCreator().getCpr());
    	pstmt.setDate(4, petition.getDate());
    	pstmt.setString(5, petition.getContent());
    	pstmt.setBoolean(6,  petition.isApproved());
    	pstmt.setString(7, petition.getApprovedBy().getCpr());

    	
    	pstmt.executeUpdate();
        System.out.println("Petition added into database");
    }
    catch(SQLException ex)
    {
	 System.out.println(ex.getMessage()); 
	 }
    
	try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = con.prepareStatement(sql1))
	{
		pst.setInt(1, petition.getPeid());
		ResultSet rs = pst.executeQuery();
		 if (rs.next()) {
                
			 User user = new User();
			 user.setCpr(rs.getString(3));
			 User admin = new User();
			 admin.setCpr(rs.getString(7));
			    Petition databasepetition = new Petition(rs.getInt(1),rs.getString(2),user,rs.getDate(4),rs.getString(5),rs.getBoolean(6),admin);
				System.out.println("Petition is in database");
				return databasepetition;
				
            }
		 else
		 {
			 return null;
		 }

	}
	catch(SQLException ex)
	{
		System.out.println(ex.getMessage());
	}
	
	return null;
    
}


}
