package blueleaf.giftregistry.services;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

@Path("/usermanagementservice")

public class UserManagementService {
	@Path("/authenticateUser/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status authenticateUser(UserInfo u){
		Client client=ClientBuilder.newClient();
		Status s=new Status();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/"+u.getEmail()).request().get();
		UserInfo validUserInfo=r.readEntity(UserInfo.class);
		if(validUserInfo.getUserID()==0){
			s.setCode(103);
			s.setMessage("User doesnot exits");
		}else{
			if(!u.getPassword().equals(validUserInfo.getPassword())){
				s.setCode(104);
				s.setMessage("Invalid Password");
			}else{
				if(validUserInfo.getUserType()==1){
					s.setCode(110);
				}else{
				s.setCode(100);
				}
				s.setMessage("Authentication Success");
			}
		}
		return s;
	}
	
	@Path("/updateUserProfileInfo/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserInfo updateUserProfileInfo(UserInfo newInfo){
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/updateInfo").request().post(Entity.json(newInfo));
		UserInfo updatedUserInfo=r.readEntity(UserInfo.class);
		return updatedUserInfo;
}
	
	@Path("/createNewUser/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserInfo createNewUser(UserInfo newInfo){
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registeruser").request().post(Entity.json(newInfo));
		UserInfo newUserInfo=r.readEntity(UserInfo.class);
		return newUserInfo;
}
	
	@Path("/getprofileinformation/{userID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getProfileInformation(@PathParam("userID") String userID){
		Client client=ClientBuilder.newClient();
		Status s=new Status();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/userID/"+userID).request().get();
		UserInfo uI=r.readEntity(UserInfo.class);
	   return uI;
	}	
	
	
}
