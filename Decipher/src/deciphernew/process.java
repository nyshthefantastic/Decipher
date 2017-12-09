/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deciphernew;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nissanka
 */
public class process {

    static StringBuffer buffer;

    public void setBuffer(StringBuffer sbf) {
        buffer = sbf;

    }

    public void activate(int arr[]) {
        JOptionPane.showMessageDialog(null, "Saving Started");
        FileWriter write=null;
        try {
            write = new FileWriter("output.txt");
            BufferedWriter bufWrite=new BufferedWriter(write);
            int next = arr[0];
            int index = 0;
            int spaces=0;
            for (int a = 0; a < buffer.length(); a++) {
                if(spaces==71){
                    System.out.println("");
                    bufWrite.newLine();
                    spaces=0;
                }
                if (next == a) {
                    if (arr.length - 1 == index) {
                        bufWrite.write(buffer.charAt(a));
                        spaces++;
                        System.out.print(buffer.charAt(a));
                        index = 0;
                        next = next + arr[index];
                        System.out.println("    inner"+next);
                        continue;
                    }
                    bufWrite.write(buffer.charAt(a));
                    spaces++;
                    System.out.print(buffer.charAt(a));
                    next = next + arr[index + 1];
                    System.out.println("    outer"+next);
                    index++;
                    
                }

            }
            bufWrite.close();
             JOptionPane.showMessageDialog(null, "Saving Finished");
        } catch (IOException ex) {
            Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                
                write.close();
               
            } catch (IOException ex) {
                Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
    
    public void substituter(char[] ori,char[] sub){
       
          JOptionPane.showMessageDialog(null, "Substituting Started");
         StringBuffer sbb = new StringBuffer();
        FileReader fr = null;
        try {
            BufferedReader buff = null;
            fr = new FileReader("output.txt");
            buff = new BufferedReader(fr);
            String line;
           
            while ((line = buff.readLine()) != null) {
                
                for (int a = 0; a < line.length(); a++) {
                    char ch = line.charAt(a);
                    sbb.append(ch);
                    
                }
                
            }
          
            
            for(int a=0;a<sbb.length();a++){
                char ch=sbb.charAt(a);
                String chh=String.valueOf(ch);
                for(int b=0;b<ori.length;b++){
                    String or=String.valueOf(ori[b]);
                    
                    if(chh.equalsIgnoreCase(or)){
                        sbb.setCharAt(a, sub[b]);
                    }
                
                }
            }
            FileWriter fw=new FileWriter("substitute.txt");
            BufferedWriter bww=new BufferedWriter(fw);
            int nspace=0;
          for(int a=0;a<sbb.length();a++){
              if(nspace==71){
                  nspace=0;
                  bww.newLine();
              }
              bww.write(sbb.charAt(a));
              nspace++;
          }
             JOptionPane.showMessageDialog(null, "Substituting Finished");
            bww.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    
    }

}
