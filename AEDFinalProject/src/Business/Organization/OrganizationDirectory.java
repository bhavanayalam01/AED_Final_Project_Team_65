/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author bhavana
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    
    
    
     public Organization createOrganization(Type type,String name){
        Organization organization = null;
        if (type.getValue().equals(Type.Medical.getValue())){
            organization = new Medical(name);
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Diagnostics.getValue())){
            organization = new Diagnostics(name);
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Facilities.getValue())){
            organization = new Facilities(name);
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.OrganManagement.getValue())){
            organization = new OrganManagement(name);
            organizationList.add(organization);
        }else if(type.getValue().equals(Type.PoliciesFinance.getValue())){
          organization = new PoliciesAndFinance(name);
          organizationList.add(organization);
        }else if(type.getValue().equals(Type.AwarnessCampaign.getValue())){
             organization = new AwarnessCampaign(name);
            organizationList.add(organization);
        }else if(type.getValue().equals(Type.Therapist.getValue())){
             organization = new Therapists(name);
             organizationList.add(organization);
        }
        return organization;
    }
}
