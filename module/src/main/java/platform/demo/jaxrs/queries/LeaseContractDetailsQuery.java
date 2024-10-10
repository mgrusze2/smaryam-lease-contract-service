package platform.demo.jaxrs.queries;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class LeaseContractDetailsQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder leaseContract, IQueryDefinitionContext aContext) {
         
        leaseContract.addSearchField("Code","leaseContractCode");
        leaseContract.addSelectField("Code");
        leaseContract.addSelectField("Name");
        leaseContract.addSelectField("FreeString3"); 
        //leaseContract.addSelectField("BuildingNumber");       
    }
   
    @Override
    public String getBOName() 
    {
        return "LeaseContract";
    }
    
}
