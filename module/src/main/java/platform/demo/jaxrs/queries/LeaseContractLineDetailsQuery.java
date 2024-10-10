package platform.demo.jaxrs.queries;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class LeaseContractLineDetailsQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder leaseContractLine, IQueryDefinitionContext aContext) {
         
        leaseContractLine.addSearchField("Code","leaseContractLineCode");
        leaseContractLine.addSelectField("Code");
        leaseContractLine.addSelectField("PropertyRef");
        leaseContractLine.addSelectField("ContractRef");
        leaseContractLine.addSelectField("SysDataSectionRef");
        leaseContractLine.addSelectField("ActualBeginDate");
        leaseContractLine.addSelectField("ActualEndDate");
        leaseContractLine.addSelectField("RefBOStateUserDefined");
        leaseContractLine.addSelectField("RentableUnitRef");
         
    }
   
    @Override
    public String getBOName() 
    {
        return "LeaseContractLine";
    }
    
}
