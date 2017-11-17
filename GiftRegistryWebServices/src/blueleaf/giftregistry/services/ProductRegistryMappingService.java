package blueleaf.giftregistry.services;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Status;

@Path("/productregistrymangement")
public class ProductRegistryMappingService {

	@Path("/addProductToRegistry/{registryID}/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status addProductToRegistry(@PathParam("registryID") String registryID,@PathParam("productID") String productID) {
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/addproduct/"+registryID+"/"+productID).request(MediaType.APPLICATION_JSON).get(Response.class);		
		Status s=r.readEntity(Status.class);
        return s;
	}
	
	@Path("/deleteProductFromRegistry/{registryID}/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status deleteProductFromRegistry(@PathParam("registryID") String registryID,@PathParam("productID") String productID) {
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/deleteproduct/"+registryID+"/"+productID).request(MediaType.APPLICATION_JSON).get(Response.class);		
		Status s=r.readEntity(Status.class);
        return s;
	}
	
	@Path("/getProductsFromRegistry/{registryID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getProductsFromRegistry(@PathParam("registryID") String registryID) {
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/allproducts/"+registryID).request(MediaType.APPLICATION_JSON).get(Response.class);	
		List<Product> list =r.readEntity(new GenericType<List<Product>>() {
        });
		List<Product> lp=new LinkedList<Product>();
		for(Product p:list)
		{
			lp.add(p);
		}
        return lp;
	}
	
	@Path("/buyerMapping/{registryID}/{productID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status addBuyerMapping(@PathParam("registryID") int regID,@PathParam("productID") int productID,@PathParam("buyerUserID") String buyerUserID) {
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/buyerproductmapper/assignproduct/"+regID+"/"+productID+"/"+buyerUserID).request(MediaType.APPLICATION_JSON).get(Response.class);		
		Status s=r.readEntity(Status.class);
        return s;
	}
	
	@Path("/getProductsAssignedToSelf/{registryID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getProductsFromRegistry(@PathParam("registryID") String registryID,@PathParam("buyerUserID") String buyerUserID) {
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/buyerproductmapper/getassignedproducts/"+registryID+"/"+buyerUserID).request(MediaType.APPLICATION_JSON).get(Response.class);	
		List<Product> list =r.readEntity(new GenericType<List<Product>>() {
        });
		List<Product> lp=new LinkedList<Product>();
		for(Product p:list)
		{
			lp.add(p);
		}
        return lp;
	}
	
}
