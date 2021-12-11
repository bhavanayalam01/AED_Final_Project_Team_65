/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Waitlist;

import Business.Person.Patient;

/**
 *
 * @author bhavana
 */
public class Wait {
    Patient patient;
    String age;
    String ped;
    String survival;
    String urgency;
    String organ;
    int waitlist;
    int rank;

    public Wait(Patient patient, String age, String ped, String survival, String urgency, String organ, int waitlist,int rank) {
        this.patient = patient;
        this.age = age;
        this.ped = ped;
        this.survival = survival;
        this.urgency = urgency;
        this.organ = organ;
        this.waitlist = waitlist;
        this.rank=rank;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
    
    public int getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(int waitlist) {
        this.waitlist = waitlist;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    public int compareTo(Wait w) {
        int comparewait=((Wait)w).getWaitlist();
        /* For Ascending order*/
        return this.waitlist-comparewait;
    }
}
