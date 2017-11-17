package blueleaf.giftregistry.webservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import blueleaf.giftregistry.DbAccess.DBConnector;
import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.Status;

@Path("/buyerproductmapper")
public class BuyerProductMappingSerive {
	@Path("/assignproduct/{registryID}/{productID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status assignProduct(@PathParam("registryID") int regID,@PathParam("productID") int productID,@PathParam("buyerUserID") String buyerUserID) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		Status s=new Status();
		boolean b=db.assignProduct(con,regID,productID,buyerUserID);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(b){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;		
	}
	
	
	@Path("/getassignedproducts/{registryID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getAssignedProducts(@PathParam("registryID") int regID,@PathParam("buyerUserID") String buyerUserID) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Product> lp=db.getAssignedProduct(con,regID,buyerUserID);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lp;		
	}
}
