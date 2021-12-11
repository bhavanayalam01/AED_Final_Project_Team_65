/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Facilities;
import Business.Organization.Organization;
import Business.Person.DonorDirectory;
import Business.UserAccount.UserAccount;
import ui.ProcurementTeamRole.ProcurementTeamJPanel;
import javax.swing.JPanel;

/**
 *
 * @author sandeepbarla
 */
public class ProcurementTeam extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network, DonorDirectory donorDirectory) {
        return new ProcurementTeamJPanel(userProcessContainer,account, (Facilities)organization, enterprise,business, network);
    }
}
