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
public class Patient {
    private int id;
    private String name;
    private String age;
    private String sex;
    private String phnNum;
    private String speciality;
    private String doctor;
    private boolean alive;
    private boolean donor;
    private boolean directdonation;
    private ArrayList<String> organs;
    private ArrayList<String> testData;
    
    public Patient(int id, String name, String age,String sex, String phnNum, String speciality, String doctor, boolean alive, boolean donor, boolean directdonation,ArrayList<String> organs,ArrayList<String> testData) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phnNum = phnNum;
        this.speciality = speciality;
        this.doctor = doctor;
        this.alive = alive;
        this.donor = donor;
        this.directdonation = directdonation;
        this.organs=organs;
        this.testData=testData;
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhnNum() {
        return phnNum;
    }

    public void setPhnNum(String phnNum) {
        this.phnNum = phnNum;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isDonor() {
        return donor;
    }

    public void setDonor(boolean donor) {
        this.donor = donor;
    }

    public boolean isDirectdonation() {
        return directdonation;
    }

    public void setDirectdonation(boolean directdonation) {
        this.directdonation = directdonation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getOrgans() {
        return organs;
    }

    public void setOrgans(ArrayList<String> organs) {
        this.organs = organs;
    }

    public ArrayList<String> getTestData() {
        return testData;
    }

    public void setTestData(ArrayList<String> testData) {
        this.testData = testData;
    }

    @Override
    public String toString() {
        return ""+id ;
    }
    
    
    
}

