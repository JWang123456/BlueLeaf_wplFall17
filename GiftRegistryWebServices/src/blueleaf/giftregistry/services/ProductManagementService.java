package blueleaf.giftregistry.services;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Brand;
import blueleaf.giftregistry.model.Category;
import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.Status;

@Path("/productmangement")
public class ProductManagementService {
	@Path("/getallproducts/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getProducts() {
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/productmanagement/allproducts").request(MediaType.APPLICATION_JSON).get(Response.class);
		
		List<Product> list =r.readEntity(new GenericType<List<Product>>() {
        });
		List<Product> lp=new LinkedList<Product>();
		for(Product p:list)
		{
			lp.add(p);
		}
        return lp;
	}
	
	@Path("/getallbrands/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Brand> getAllBrand() {
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/productmanagement/getbrands").request(MediaType.APPLICATION_JSON).get(Response.class);
		
		List<Brand> list =r.readEntity(new GenericType<List<Brand>>() {
        });
		List<Brand> lb=new LinkedList<Brand>();
		for(Brand b:list)
		{
			lb.add(b);
		}
        return lb;
	}
	
	@Path("/getallcategories/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Category> getAllCategories() {
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/productmanagement/getcategories").request(MediaType.APPLICATION_JSON).get(Response.class);
		
		List<Category> list =r.readEntity(new GenericType<List<Category>>() {
        });
		List<Category> lc=new LinkedList<Category>();
		for(Category c:list)
		{
			lc.add(c);
		}
        return lc;
	}
	
	@Path("/addProduct/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status addProduct(Product new_p){
		Status s=new Status();
		Client client=ClientBuilder.newClient();
		Response r1=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/productmanagement/addproduct").request().post(Entity.json(new_p));
		Status updatedP=r1.readEntity(Status.class);
		if(updatedP.getCode()==100){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;
	}
	
	@Path("/deleteProduct/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status deleteProduct(@PathParam("productID") String productID) {
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/productmanagement/deleteproduct/"+productID).request(MediaType.APPLICATION_JSON).get(Response.class);		
		Status s=r.readEntity(Status.class);
        return s;
	}
	
}
