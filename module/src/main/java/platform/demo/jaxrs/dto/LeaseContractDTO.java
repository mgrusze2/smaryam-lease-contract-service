package platform.demo.jaxrs.dto;

public class LeaseContractDTO
{
    private int syscode;
    private String code;
    private String name;
    private String freeString3;
    private String contractRef;
    private String buildingNumber;

    /**
     * @return the syscode
     */
    public int getSyscode() {
        return syscode;
    }

    /**
     * @param aPersonSyscode the syscode to set
     */
    public void setSyscode(final int aSyscode) {
        syscode = aSyscode;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param aCode the code to set
     */
    public void setCode(final String aCode) {
        code = aCode;
    }

    /**
     * @return the name
     */
    public String getname() {
        return name;
    }

    /**
     * @param aname the name to set
     */
    public void setname(final String aname) {
        name = aname;
    }

    /**
     * @return the freeString3
     */
    public String getfreeString3() {
        return freeString3;
    }
    
    /**
     * @param afreeString3 the freeString3 to set
     */
    public void setfreeString3(final String afreeString3) {
        freeString3 = afreeString3;
    }    
    /**
     * @return the contractRef
     */
    public String getcontractRef() {
        return contractRef;
    }
    
    /**
     * @param aContractRef the contractRef to set
     */
    public void setcontractRef(final String acontractRef) 
    {
        contractRef = acontractRef;
    }   
    /**
     * @return the buildingNumber
     */
    public String getbuildingNumber() {
        return buildingNumber;
    }
    
    /**
     * @param abuildingNumber the buildingNumber to set
     */
    public void setbuildingNumber(final String abuildingNumber) 
    {
        buildingNumber = abuildingNumber;
    }     
}
