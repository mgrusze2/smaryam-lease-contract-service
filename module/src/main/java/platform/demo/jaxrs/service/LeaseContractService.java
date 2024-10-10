package platform.demo.jaxrs.service;

import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import com.planonsoftware.platform.data.v1.IDatabaseQuery;
import com.planonsoftware.platform.data.v1.IResultSet;
import com.planonsoftware.platform.data.v1.Operator;
import java.util.ArrayList;
import java.util.List;
import platform.demo.jaxrs.dto.LeaseContractDTO;
import platform.demo.jaxrs.dto.LeaseContractLineDTO;
import platform.demo.jaxrs.dto.PropertyDTO;

public class LeaseContractService {
    IJaxRsResourceContext jaxrsContext;
    private static final String FREE_STRING3 = "FreeString3";
    public List<LeaseContractDTO> getLeaseContractCode(final IJaxRsResourceContext context,
        final String leaseContractCode) throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractService: getLeaseContractCode " + leaseContractCode);
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractDetailsQuery");
        IResultSet resultset = query.execute();
        context.getLogService().debug("Query Executed successfully...");
        return loadLeaseContractRecord(context, resultset);

    }

    private List<LeaseContractDTO> loadLeaseContractRecord(final IJaxRsResourceContext context,
            final IResultSet resultset) throws IllegalStateException, FieldNotFoundException, BusinessException {
        List<LeaseContractDTO> leaseContracts = new ArrayList<>();        
        List<LeaseContractLineDTO> leaseContractLines = getLeaseContractLineCode(context, "");
        context.getLogService().debug("loadLeaseContractLine.getLeaseContractLineCode count is : " + leaseContractLines.size() );
        List<PropertyDTO> properties = getProperties(context);
        context.getLogService().debug("properties.getProperties count is : " + properties.size() );
        while (resultset.next()) {
            if (resultset.getString(FREE_STRING3) != null && !resultset.getString(FREE_STRING3).isEmpty()) {
                LeaseContractDTO leaseContract = new LeaseContractDTO();
                leaseContract.setSyscode(resultset.getPrimaryKey());
                leaseContract.setCode(resultset.getString("Code"));
                leaseContract.setname(resultset.getString("Name"));
                leaseContract.setfreeString3(resultset.getString(FREE_STRING3));

                context.getLogService()
                        .debug("loadLeaseContractRecord:Lease contract lines size: " + leaseContractLines.size());

                for (LeaseContractLineDTO line : leaseContractLines) {
                    context.getLogService().debug("Inside LeaseContractLineDTO for loop");
                    context.getLogService().debug("leaseContract.getSyscode() " + leaseContract.getSyscode());
                    context.getLogService().debug("line.getContractRef() " + line.getContractRef());                   
                    if (String.valueOf(line.getContractRef()).equals(String.valueOf(leaseContract.getSyscode()))) {
                        context.getLogService().debug("Value of line.getPropertyRef() is  :-" + line.getPropertyRef()
                                + " And value for leaseContract.getSyscode() is " + leaseContract.getSyscode());
                        for (PropertyDTO proper : properties) {
                            if (String.valueOf(proper.getSyscode()).equals(String.valueOf(line.getPropertyRef()))) {
                                leaseContract.setbuildingNumber(proper.getCode());
                            }
                        }                     
                    }
                }
                leaseContracts.add(leaseContract);
            }
        }

        return leaseContracts;
    }

    public List<LeaseContractLineDTO> getLeaseContractLineCode(final IJaxRsResourceContext context,final String leaseContractLineCode) 
    throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("LeaseContractLineService: getLeaseContractLineCode " + leaseContractLineCode);
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("LeaseContractLineDetailsQuery");
        //IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("ServiceContractLineDetailsQuery");
        IResultSet resultset = query.execute();
        context.getLogService().debug("resultset:" + resultset);
        context.getLogService().debug("Query Executed successfully...");
        return loadLeaseContractLine(context, resultset);
    }
    private List<LeaseContractLineDTO> loadLeaseContractLine(final IJaxRsResourceContext context,
            final IResultSet resultset) throws IllegalStateException, FieldNotFoundException, BusinessException {
        List<LeaseContractLineDTO> leaseContractLines = new ArrayList<>();
        context.getLogService().debug("Execution started for loadLeaseContractLine");
        try {
            //boolean hasData = false;
            while (resultset.next()) {
                //if(resultset.next()){
                //hasData = true;
                context.getLogService().debug("Inside loadLeaseContractLine result set");
                LeaseContractLineDTO leaseContractLine = new LeaseContractLineDTO();
                String propertyRef = resultset.getString("PropertyRef");
                context.getLogService().debug("inside loadLeaseContractLine : value for PropertyRef " + propertyRef);
                leaseContractLine.setPropertyRef(propertyRef);
                leaseContractLine.setCode(resultset.getString("Code"));
                leaseContractLine.setContractRef(resultset.getString("ContractRef"));
                leaseContractLine.setSysDataSectionRef(resultset.getString("SysDataSectionRef"));
                leaseContractLine.setActualBeginDate(resultset.getString("ActualBeginDate"));
                leaseContractLine.setActualEndDate(resultset.getString("ActualEndDate"));
                leaseContractLine.setRefBOStateUserDefined(resultset.getString("RefBOStateUserDefined"));
                leaseContractLine.setRentableUnitRef(resultset.getString("RentableUnitRef"));
                leaseContractLines.add(leaseContractLine);
                //}
            }

            //if (!hasData) {
            //   context.getLogService().debug("ResultSet is empty, no data to process");
           // }
        } catch (Exception e) {
            context.getLogService().error("Exception while processing result set: " + e.getMessage());
        }

        context.getLogService().debug("loadLeaseContractLine: Lease contract lines size: " + leaseContractLines.size());
        return leaseContractLines;
    }

    public PropertyDTO getPropertyCode(final IJaxRsResourceContext context, final int sysCode)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("PropertyService: getSyscodeCode " + sysCode);

        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("PropertyDetailsQuery");
        query.getStringSearchExpression("Syscode", Operator.EQUAL).addValue(sysCode);
        IResultSet resultset = query.execute();
        context.getLogService().debug("resultset:  " + resultset);
        context.getLogService().debug("Query Executed successfully...");
        return loadProperty(resultset);

    }

    private PropertyDTO loadProperty(final IResultSet resultset)
            throws IllegalStateException, FieldNotFoundException, BusinessException {
            PropertyDTO property = null;       
        if (resultset.next()) 
        {
           property = new PropertyDTO();
            // LeaseContractDTO leaseContract = new LeaseContractDTO();
            property.setSyscode(resultset.getPrimaryKey());
            property.setCode(resultset.getString("Code"));
            // leaseContract.setname(resultset.getString("Name"));

        }

        return property;
    }

    public List<PropertyDTO> getProperties(final IJaxRsResourceContext context)
            throws BusinessException, FieldNotFoundException {
        context.getLogService().debug("Start PropertyService: getSyscodeCode ");
        List<PropertyDTO> properties = new ArrayList<>();
        IDatabaseQuery query = context.getDataService().getPVDatabaseQuery("PropertyDetailsQuery");
        // query.getStringSearchExpression("Syscode", Operator.EQUAL).addValue(sysCode);
        IResultSet resultset = query.execute();
        context.getLogService().debug("resultset:  " + resultset);
        context.getLogService().debug("Query Executed successfully...");
        while (resultset.next()) {
            PropertyDTO property = new PropertyDTO();
            property.setSyscode(resultset.getPrimaryKey());
            property.setCode(resultset.getString("Code"));
            properties.add(property);
        }
        return properties;

    }

}
