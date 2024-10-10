package platform.demo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import platform.demo.jaxrs.dto.LeaseContractDTO;
import platform.demo.jaxrs.dto.LeaseContractLineDTO;
import platform.demo.jaxrs.dto.PropertyDTO;
import platform.demo.jaxrs.service.LeaseContractService;
import java.util.ArrayList;
import java.util.List;

@Path("/leaseContracts")
public class LeaseContractRestService
{

    @Context 
    IJaxRsResourceContext jaxrsContext;

    @GET
    @Path("/{leaseContractCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaseContractDetails(@PathParam("leaseContractCode") String leaseContractCode) {
        
        jaxrsContext.getLogService().debug("Planon getLeaseContract method execution started. leaseContractCode : " + leaseContractCode);

        LeaseContractService service = new LeaseContractService();
        //LeaseContractDTO leaseContract = null;
        List<LeaseContractDTO> leaseContract = null;
        Response response = null;

		try {
			leaseContract = service.getLeaseContractCode(jaxrsContext, leaseContractCode);
		} catch (FieldNotFoundException | BusinessException e) {		
			e.printStackTrace();
		}

        if(leaseContract == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {            
            response = Response.ok().entity(leaseContract).build();
        }  

        jaxrsContext.getLogService().debug("Planon getleaseContract method execution ended.");
        return response;
    }
    @GET
    //@Path("/leaseContractLine/{leaseContractLineCode}")
    @Path("/leaseContractLine")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaseContractLineCode(@PathParam("leaseContractLineCode") String leaseContractLineCode) {
        
        jaxrsContext.getLogService().debug("Planon getLeaseContract method execution started. leaseContractLineCode : " + leaseContractLineCode);

        LeaseContractService service = new LeaseContractService();
        //LeaseContractDTO leaseContract = null;
        List<LeaseContractLineDTO> leaseContractLine = null;
        Response response = null;
		try {
			leaseContractLine = service.getLeaseContractLineCode(jaxrsContext, leaseContractLineCode);
		} catch (FieldNotFoundException | BusinessException e) {		
			e.printStackTrace();
		}
        if(leaseContractLine == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {            
            response = Response.ok().entity(leaseContractLine).build();
        }  

        jaxrsContext.getLogService().debug("Planon getleaseContractLine method execution ended.");
        return response;
    }

    @GET
    @Path("/property/{syscode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPropertyCode(@PathParam("syscode") int syscode) {
        
        jaxrsContext.getLogService().debug("Planon getProperty method execution started. propertyCode : " + syscode);
        LeaseContractService service = new LeaseContractService();
        PropertyDTO property = null;
        Response response = null;
		try 
        {
			property = service.getPropertyCode(jaxrsContext, syscode);
		} 
        catch (FieldNotFoundException | BusinessException e) 
        {		
			e.printStackTrace();
		}

        if(property == null) 
        {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else 
        {            
            response = Response.ok().entity(property).build();
        }  

        jaxrsContext.getLogService().debug("Planon getproperty method execution ended.");
        return response;
    }
    
 }
