/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Therapists;
import Business.Person.DonorDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.TherapistRole.TherapistWorkAreaJPanel;

/**
 *
 * @author sandeepbarla <your.name at your.org>
 */
public class TherapistRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network, DonorDirectory donorDirectory) {
         return new TherapistWorkAreaJPanel(userProcessContainer, account, (Therapists)organization, enterprise,business, network);
    }
    
}
