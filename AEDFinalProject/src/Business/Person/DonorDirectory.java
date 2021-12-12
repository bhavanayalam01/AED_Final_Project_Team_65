/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhavana
 */
public class DonorDirectory {

    private ArrayList<Donor> donorList;


    public DonorDirectory() {
        donorList = new ArrayList();
        ArrayList <String> organs = new ArrayList<String>();
        organs.add("Heart");
        organs.add("Lungs");
        organs.add("Kidney");
        organs.add("Liver");
    }

    public ArrayList<Donor> getDonorList() {
        return donorList;
    }

    
    public Donor createDonor(int id,String name, String lastName, String middleName, String state, String zipCode, String SSN, int age, String sex, String bloodGroup, String contactNum, String address, String sign,
                String emailAdd, String emergencyPOC, String emergencyPOC_Num, boolean isOrganAvaiNow, List<String >organs){
        Donor donor = new Donor();
        donor.setDonorId(id);
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
        donor.setIsOrganAvaiNow(isOrganAvaiNow);
        donor.setOrgans(organs);
        donorList.add(donor);
        return donor;
    }
}
