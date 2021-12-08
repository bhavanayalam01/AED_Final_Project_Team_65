/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author sandeepbarla
 */
public class Ranking {
    EcoSystem ecoSystem;
    ArrayList<Double> heart=new ArrayList<>();
        ArrayList<Double> kidney=new ArrayList<>();
        ArrayList<Double> liver=new ArrayList<>();
        ArrayList<Double> lungs=new ArrayList<>();
        ArrayList<Double> pancreas=new ArrayList<>();
        ArrayList<Double> intestines=new ArrayList<>();
    public Ranking(EcoSystem ecoSystem) {
        this.ecoSystem = ecoSystem;
    }

    public void match(String organ){
       
    
    }
    
    
    
  
    public int findrank(String organ,double score){
        int rankFinal=0;
        JOptionPane.showMessageDialog(null, organ+" This is organ");
        if(organ.equalsIgnoreCase("heart")){
            JOptionPane.showMessageDialog(null, "1");
            Collections.sort(heart);
            rankFinal+=(heart.indexOf(score))+1;
        }else if(organ.equalsIgnoreCase("kideny")){
            Collections.sort(kidney);
            rankFinal+=(kidney.indexOf(score))+1;
        }else if(organ.equalsIgnoreCase("liver")){
            Collections.sort(liver);
            rankFinal+=(liver.indexOf(score))+1;
        }else if(organ.equalsIgnoreCase("lungs")){
            Collections.sort(lungs);
            rankFinal+=(lungs.indexOf(score))+1;
        }else if(organ.equalsIgnoreCase("pancreas")){
            Collections.sort(pancreas);
            rankFinal+=(pancreas.indexOf(score))+1;
        }else if(organ.equalsIgnoreCase("intestines")){
            Collections.sort(intestines);
            rankFinal+=(intestines.indexOf(score))+1;
        }
        return rankFinal;
    }
    
}
