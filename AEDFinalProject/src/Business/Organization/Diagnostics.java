/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LabAssistant;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sandeepbarla
 */
public class Diagnostics extends Organization{
    
    public Diagnostics(String name){
        super(name);

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabAssistant());
        return roles;
    }
    @Override
    public Type getType() {
        return Organization.Type.Diagnostics;
    } 
}
