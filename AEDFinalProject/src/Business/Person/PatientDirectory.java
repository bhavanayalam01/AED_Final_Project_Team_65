/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author bhavana
 */
public class PatientDirectory {
    private ArrayList<Patient> patientList;

    public PatientDirectory() {
        patientList = new ArrayList();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }     
    
    
     public Patient createPatient(int id,String name,String age,String sex,String phnNum,String speciality,String doctor,boolean alive,boolean donor,boolean directdonor,ArrayList<String> organs,ArrayList<String> testData){
         Patient p=new Patient(id, name, age,sex, phnNum, speciality, doctor, alive, donor, directdonor,organs,testData);
         patientList.add(p);
         return p;
     }
}
