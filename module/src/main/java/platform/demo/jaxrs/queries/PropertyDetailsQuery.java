package platform.demo.jaxrs.queries;

import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class PropertyDetailsQuery implements IQueryDefinition 
{
    @Override
    public void create(IQueryBuilder property, IQueryDefinitionContext aContext) 
    {

        property.addSearchField("Code","propertyCode");
        property.addSelectField("Code");
        property.addSelectField("Syscode");

    }

    @Override
    public String getBOName() 
    {
        return "Property";
    }
}