/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Person.Patient;

/**
 *
 * @author sandeepbarla
 */
public class OrganMatchWorkRequest extends WorkRequest{
    Patient donpatient;
    Patient recpatient;
    String team;
    String organ;

    public Patient getDonpatient() {
        return donpatient;
    }

    public void setDonpatient(Patient donpatient) {
        this.donpatient = donpatient;
    }

    public Patient getRecpatient() {
        return recpatient;
    }

    public void setRecpatient(Patient recpatient) {
        this.recpatient = recpatient;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    
}

