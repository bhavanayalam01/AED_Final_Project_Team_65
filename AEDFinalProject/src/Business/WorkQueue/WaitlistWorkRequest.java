/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Person.Patient;
import java.util.ArrayList;

/**
 *
 * @author sandeepbarla
 */
public class WaitlistWorkRequest extends WorkRequest{
    
    Patient patient;
    private ArrayList<String> organList=new ArrayList<>();

    public ArrayList<String> getOrganList() {
        return organList;
    }

    public void setOrganList(ArrayList<String> organList) {
        this.organList = organList;
    }

    public void setPatientAccount(Patient patAccount) {
        patient=patAccount;
   }
    
}
