/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Donor;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Waitlist.Wait;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sandeepbarla
 */
public class EcoSystem extends Organization {
     private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ArrayList<Donor> donorDirectory;
    private ArrayList<Wait> waitList;
    int patientId;
    int employeeId;
    int donorId;
    


    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
     public Donor createDonor(String name, String lastName, String middleName, String state, String zipCode, String SSN, int age, String sex, String bloodGroup, String contactNum, String address, String sign,
                String emailAdd, String emergencyPOC, String emergencyPOC_Num, boolean isOrganAvaiNow,List<String >organs){
        
        Donor donor = new Donor();
        donor.setName(name);
        donor.setMiddleName(middleName);
        donor.setLastName(lastName);
        donor.setState(state);
        donor.setZipcode(zipCode);
        donor.setSSN(SSN);
        donor.setAge(age);
        donor.setGender(sex);
        donor.setBloodGroup(bloodGroup);
        donor.setContactNum(contactNum);
        donor.setAddress(address);
        donor.setSign(sign);
        donor.setEmailAdd(emailAdd);
        donor.setPocName(emergencyPOC);
        donor.setPocContact(emergencyPOC_Num);
        donor.setOrgans(organs);
        donorDirectory.add(donor);
        return donor;
    }
    
    public ArrayList<Donor> getDonorDirectory() {
        return donorDirectory;
    }

    public void setDonorDirectory(ArrayList<Donor> donorDirectory) {
        this.donorDirectory = donorDirectory;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public int getPatientId() {
        return patientId;
    }
    public void incPatientId() {
        patientId++;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void incEmployeeId() {
        employeeId++;
    }
    
    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }
    public int getDonorId() {
        return donorId;
    }
    public void incDonorId() {
        donorId++;
    }
    
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
          donorDirectory = new ArrayList<Donor>();
        popDonor();
    }
    
    //todo
    void popDonor(){
        
    }

    public ArrayList<Wait> getWaitList() {
        return waitList;
    }

    public void setWaitList(ArrayList<Wait> waitList) {
        this.waitList = waitList;
    }
    public void addWaitlist(Wait w){
        waitList.add(w);
        JOptionPane.showMessageDialog(null, "Patient added to the national waitlist successfully");
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        
        //todo
        for(Network network:networkList){
            
        }
        return true;
    }
    
    
}
