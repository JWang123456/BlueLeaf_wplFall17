package blueleaf.giftregistry.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;
@Path("/registrysharingservice")
public class RegistrySharingService {
	
	
	@Path("/shareprivateregistry/{registryID}/{registryOwnerID}/{buyerEmailID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status shareRegistry(@PathParam("registryID") int regID,@PathParam("registryOwnerID") int regOwnerID,@PathParam("buyerEmailID") String buyerEmailID) {
		Client client=ClientBuilder.newClient();
        Status s=new Status();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/"+buyerEmailID).request().get();
		UserInfo userInfo=r.readEntity(UserInfo.class);
		if(userInfo!=null && userInfo.getUserID()!=0){
			//user exists, then we can share the registry.
			int buyerUserID=(int) userInfo.getUserID();
			Response r1=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/shareprivateregistry/"+regID+"/"+regOwnerID+"/"+buyerUserID).request(MediaType.APPLICATION_JSON).get(Response.class);		
			 s=r1.readEntity(Status.class);
			 
		}else{
			s.setCode(300);
			s.setMessage("USER DOESNOT EXITS");
		}
        return s;
	}
}
