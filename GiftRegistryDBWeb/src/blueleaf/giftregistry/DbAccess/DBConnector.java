package blueleaf.giftregistry.DbAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import blueleaf.giftregistry.model.Brand;
import blueleaf.giftregistry.model.Category;
import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.UserInfo;

public class DBConnector {
static Connection conn = null;
private final static Logger LOGGER = Logger.getLogger(DBConnector.class.getName());
	public Connection getConnection(){
		try
		{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://localhost/blue_leaf?user=root&password=mysqlpass");
		} catch(Exception e){
		  System.out.println("Exception occured while get connection call :"+e.getMessage());
		  e.printStackTrace();
		}
		return conn;
	}
	
	public UserInfo  addUser(Connection con,UserInfo newUser){
		try
		{    
		String sql ="Insert into UserInfoTable (userName,password,email,userType) values(?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,newUser.getUsername());
		ps.setString(2,newUser.getPassword());
		ps.setString(3,newUser.getEmail());
		ps.setInt(4,newUser.getUserType());
		ps.executeUpdate();
		ResultSet rs =ps.getGeneratedKeys();
		if (rs.next()){
            newUser.setUserID(rs.getInt(1));
		}
	}catch(Exception e){
		System.out.println("Exception occured while adding new user :"+e.getMessage());
		  e.printStackTrace();
	}
		return newUser;
	}
	
	public List<UserInfo> getAllUserInfo(Connection con)
	{
		List<UserInfo> l=new LinkedList<UserInfo>();
		try	{ //change the query to search
			String sql = "SELECT * FROM UserInfoTable";
 			Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            int userID=0;
        	String username="";
        	String password="";
        	String email="";
        	int userType=0;
            while(rs.next())
			{
            	userID=rs.getInt("userID");
            	username=rs.getString("userName");
            	password=rs.getString("password");
            	email=rs.getString("email");
            	userType=rs.getInt("userType");
            	UserInfo u=new UserInfo(userID,username,password,email,userType);
            	l.add(u);
			}
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return l;
	}

	public UserInfo getUserInfo(Connection conn, String userID) {
		UserInfo u =new UserInfo();
		try	{ //change the query to search
			String sql = "SELECT * FROM UserInfoTable where userID='"+userID+"'";
 			Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            int userId=0;
        	String username="";
        	String password="";
        	String email="";
        	int userType=0;
            if(rs.next())
			{
            	userId=rs.getInt("userID");
            	username=rs.getString("userName");
            	password=rs.getString("password");
            	email=rs.getString("email");
            	userType=rs.getInt("userType");
            	u=new UserInfo(userId,username,password,email,userType);
			}
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return u;	
	}

	public UserInfo checkNewUser(Connection con, String email) {
		UserInfo u =new UserInfo();
		try	{ //change the query to search
			String sql = "SELECT * FROM UserInfoTable where email='"+email+"'";
 			Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            int userId=0;
        	String username="";
        	String password="";
        	email="";
        	int userType=0;
            if(rs.next())
			{
            	userId=rs.getInt("userID");
            	username=rs.getString("userName");
            	password=rs.getString("password");
            	email=rs.getString("email");
            	userType=rs.getInt("userType");
            	u=new UserInfo(userId,username,password,email,userType);
			}
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return u;	
	}

	public UserInfo updateUser(Connection con, UserInfo newInfo) {
		try	{ //change the query to search
			PreparedStatement ps = conn.prepareStatement("update UserInfoTable SET userName= ?, password = ? WHERE userID = ?");
			ps.setString(1,newInfo.getUsername());
		    ps.setString(2,newInfo.getPassword());
		    ps.setInt(3,(int)newInfo.getUserID());
		    ps.executeUpdate();
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return newInfo;
	}

	public List<Brand> getBrands(Connection con) {
		List<Brand> lb=new LinkedList<Brand>();
		try	{ //change the query to search
			String sql = "SELECT * FROM ProductBrandTable";
 			Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            int brandID=0;
        	String brandname="";
            while(rs.next())
			{
            	brandID=rs.getInt("brandID");
            	brandname=rs.getString("brandName");
            	Brand b=new Brand(brandID,brandname);
            	lb.add(b);
			}
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return lb;
	}

	public List<Category> getCategory(Connection con) {
		List<Category> lc=new LinkedList<Category>();
		try	{ //change the query to search
			String sql = "select * from ProductCategoryTable";
 			Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            int categoryID=0;
        	String categoryName="";
            while(rs.next())
			{
            	categoryID=rs.getInt("categoryID");
            	categoryName=rs.getString("categoryName");
            	Category c=new Category(categoryID,categoryName);
            	lc.add(c);
			}
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return lc;
	}

	public List<Product> getAllProducts(Connection con) {
		List<Product> lp=new LinkedList<Product>();
		try	{ 
			String sql = "select * from ProductTable inner join ProductBrandTable on brandID=brand_brandID inner join ProductCategoryTable on categoryID=category_categoryID";
 			Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            long productID=0;
        	String productName="";
        	float price=0;
        	String imageURL="";
        	int rating=0;
        	int certification=0;
        	int brandID=0;
        	int categoryID=0;
        	String brandName="";
        	String categoryName="";
            while(rs.next())
			{
            	productID=rs.getInt("productID");
            	productName=rs.getString("productName");
            	price=rs.getFloat("price");
            	imageURL=rs.getString("imageURL");
            	rating=rs.getInt("rating");
            	certification=rs.getInt("certification");
            	brandID=rs.getInt("brand_brandID");
            	categoryID=rs.getInt("category_categoryID");
            	brandName=rs.getString("productName");
            	categoryName=rs.getString("categoryName");
            	Product p=new Product(productID,productName,price,imageURL,rating,certification,brandID,categoryID,brandName,categoryName);
            	lp.add(p);
			}
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return lp;
	}

	public Product addProduct(Connection con, Product prod) {
		try
		{    
		String sql ="Insert into ProductTable (productName,price,imageURL,rating,certification,brand_brandID,category_categoryID) values(?,?,?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,prod.getProductName());
		ps.setFloat(2,prod.getPrice());
		ps.setString(3,prod.getImageURL());
		ps.setInt(4,prod.getRating());
		ps.setInt(5, prod.getCertification());
		ps.setInt(6, prod.getBrandID());
		ps.setInt(7, prod.getCategoryID());
		ps.executeUpdate();
		ResultSet rs =ps.getGeneratedKeys();
		if (rs.next()){
			prod.setProductID(rs.getInt(1));
		}
	}catch(Exception e){
		System.out.println("Exception occured while adding new user :"+e.getMessage());
		  e.printStackTrace();
	}
		return prod;
	}

	public boolean deleteProduct(Connection con, String productID) {
		boolean success=false;
		try{
			String query = "delete from ProductTable where productID=?";
 			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,productID);

			int rNum = ps.executeUpdate();
			if(rNum>0){
				success=true;
			}
		}
		catch(Exception e){
			System.out.println("Exception occured while removeContact :"+e.getMessage());
		}
		return success;
	}

	public Registry addRegistry(Connection con, Registry r) {
		try
		{  
		String sql ="Insert into UserRegistryTable(registryType,userID,registryName) values(?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1,r.getRegistryType());
		ps.setInt(2,r.getUserID());
		ps.setString(3,r.getRegistryName());
		ps.executeUpdate();
		
		ResultSet rs =ps.getGeneratedKeys();
		if (rs.next()){
			r.setRegistryID(rs.getInt(1));
		}
	}catch(Exception e){
		System.out.println("Exception occured while adding new user :"+e.getMessage());
		  e.printStackTrace();
	}
      return r;
	}

	public List<Registry> getUserRegistry(Connection con, String userID) {
		List<Registry> lr=new LinkedList<Registry>();
		try	{ 
			String sql = "select * from UserRegistryTable where userID="+userID;
 			Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            int registryType = 0;
    		int registryID = 0;
    		String registryName="";
    		int userId=0;
            while(rs.next())
			{
            	registryType=rs.getInt("registryType");
            	registryID=rs.getInt("registryID");
            	registryName=rs.getString("registryName");
            	userId=rs.getInt("userID");
            	Registry r=new Registry(registryID,registryType,userId,registryName);
            	lr.add(r);
			}
	} catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
		return lr;
	}

	public boolean deleteRegistry(Connection con, String registryID) {
		boolean success=false;
		try{
			String query = "delete from UserRegistryTable where registryID=?";
 			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,registryID);
			int rNum = ps.executeUpdate();
			if(rNum>0){
				success=true;
			}
		}
		catch(Exception e){
			System.out.println("Exception occured while removeContact :"+e.getMessage());
		}
		return success;
	}	
}