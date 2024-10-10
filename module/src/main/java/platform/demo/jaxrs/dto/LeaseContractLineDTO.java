package platform.demo.jaxrs.dto;

    
public class LeaseContractLineDTO
{
    private String actualBeginDate; 
    private String actualEndDate;
    private String refBOStateUserDefined;
    private int syscode;
    private String rentableUnitRef;
    private String code;   
    private String contractRef;
    private String propertyRef;

    public int getSyscode() {
        return syscode;
    }
    public void setSyscode(int syscode) {
        this.syscode = syscode;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getContractRef() {
        return contractRef;
    }
    public void setContractRef(String contractRef) {
        this.contractRef = contractRef;
    }
    public String getPropertyRef() {
        return propertyRef;
    }
    public void setPropertyRef(String propertyRef) {
        this.propertyRef = propertyRef;
    }
    
    public String getSysDataSectionRef() {
        return sysDataSectionRef;
    }
    public void setSysDataSectionRef(String sysDataSectionRef) {
        this.sysDataSectionRef = sysDataSectionRef;
    }
    private String sysDataSectionRef;
    public String getActualBeginDate() {
        return actualBeginDate;
    }
    public void setActualBeginDate(String actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }
    public String getActualEndDate() {
        return actualEndDate;
    }
    public void setActualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
    }
    
    public String getRefBOStateUserDefined() {
        return refBOStateUserDefined;
    }
    public void setRefBOStateUserDefined(String refBOStateUserDefined) {
        this.refBOStateUserDefined = refBOStateUserDefined;
    }
    
    public String getRentableUnitRef() {
        return rentableUnitRef;
    }
    public void setRentableUnitRef(String rentableUnitRef) {
        this.rentableUnitRef = rentableUnitRef;
    }
}