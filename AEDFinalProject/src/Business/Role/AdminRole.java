/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Person.DonorDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import ui.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;
import ui.AdministrativeRole.HospitalAdminJPanel;
import ui.AdministrativeRole.OrganBankJPanel;

/**
 *
 * @author sandeepbarla
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network, DonorDirectory donorDirectory) {
        JPanel jp;
        if(enterprise.getClass().getTypeName().contains("Hospital")){
            jp=new HospitalAdminJPanel(userProcessContainer, enterprise, business,network);
        }
        else if(enterprise.getClass().getTypeName().contains("OrganBank")){
            jp=new OrganBankJPanel (userProcessContainer, enterprise, business,network);
        }
        else{
            jp=new AdminWorkAreaJPanel(userProcessContainer, enterprise, business,network);
        }
        return jp;
    }

}
