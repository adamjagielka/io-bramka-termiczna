
package bramka2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author adam8
 */
public class TextPanel extends JPanel {
    private double temperatura;
    private JTextArea textArea;
    private JTextArea textArea2;
    private JPanel panel;
    private JPanel panel2;
    private String kom_niska_temperatua = "Masz za niską temperaturę\n";
    private String kom_wysoka_temperatua = "Masz za wysoką temperaturę\n";
    private String kom_ok_temperatua = "Masz odpowiednią temperaturę\n";
    private String za_niska = "błąd, za niska temperatura\n";
    private String za_wysoka = "błąd, za wysoka temperatura\n";
    private String imie = "";
    private String nazwisko = "";
    private int flaga=0;
    private JButton przycisk;
    private JButton przycisk_wstecz;
    private FaceBean facebean;
   
    
    public TextPanel() throws InterruptedException
    {
        facebean = new FaceBean();
        Random rand = new Random();
        przycisk = new JButton();
        przycisk_wstecz = new JButton("cofnij");
        textArea = new JTextArea();
        textArea2 = new JTextArea();
        JPanel panel = new JPanel();
        
        panel.setVisible(true);
        setLayout(new BorderLayout());
       
        add(new JScrollPane(textArea), BorderLayout.NORTH);
        add(new JScrollPane(textArea2), BorderLayout.CENTER);
        
        
        panel.add(new JScrollPane(przycisk), BorderLayout.PAGE_END );
        panel.add(new JScrollPane(przycisk_wstecz), BorderLayout.PAGE_START); 
  
        add(new JScrollPane(panel),BorderLayout.SOUTH);
        
        przycisk.setText("dalej");
        
        settemperatura(rand.nextDouble()*30+25);                                // 25-55 
        System.out.println(" temperatura " + temperatura);
       
        todo();
        start();
        
    }
    void start() throws InterruptedException
            {
               
      
                imie = "";
                nazwisko = "";
                textArea.setText("Witam w aplikacji ''Bramka Termiczna''\n");
                textArea.append("kliknij przycisk by przejść dalej");
                textArea.setEditable(false);
                textArea2.setEditable(false);
                textArea2.setText("");
            }
    
    void sprawdz() throws InterruptedException
    {
          if (gettemperatura()==0 )
        {
            textArea.append("\n"+"nie pobrano temperatury");
            Thread.sleep(4000);
        }
          else
          {
        
        if (gettemperatura()<32 )
        {
            textArea.append("\n"+za_niska + gettemperatura());
        }
        else if (gettemperatura()>42)
        {
            textArea.append("\n"+za_wysoka + gettemperatura());
        }
        else if (gettemperatura()>=32 && gettemperatura()<=36)
        {
            textArea.append("\n"+kom_niska_temperatua + gettemperatura());
        }
         else if (gettemperatura()>=37.5 && gettemperatura()<=42)
        {
            textArea.append("\n"+kom_wysoka_temperatua + gettemperatura());
        }
         else if (gettemperatura()>36 && gettemperatura()<37.5)
         {
              textArea.append("\n"+kom_ok_temperatua + gettemperatura());
              
         }
        
          }
      
        
    }
    
    

    public void settemperatura(double temperatura)
    {
        this.temperatura = temperatura;
    }
    
    public double gettemperatura()
     {
        return temperatura;
     }
        
    
    
    public void  setimie(String imie)
    {
        this.imie=imie;
    }
    
    public String getimie()
    {
        return imie;
    }
    
    
     public void  setnazwisko(String nazwisko)
    {
        this.nazwisko=nazwisko;
    }
    
      public String getnazwisko()
    {
        return nazwisko;
    }
  
    
    
      public void appendText (String text)
    {
        textArea.append(text);
    }
      
      private void przyciskActionPerformed(java.awt.event.ActionEvent evt) {
           textArea2.setEditable(true);
        
         textArea.setText("Wprowadź imie");
         setimie(textArea2.getText());
         System.out.println("imie " + imie);
           if (!imie.equals(""))
           {   
               textArea2.setText("");
               textArea.setText(" twoje imie to " + imie +" Wprowadź nazwisko");               
          } 
       }
        private void przyciskActionPerformed2(java.awt.event.ActionEvent evt) throws InterruptedException {
           textArea2.setEditable(true);
          setnazwisko(textArea2.getText());
          System.out.println("nazwisko " + nazwisko);
           if (!nazwisko.equals(""))
           {   
               textArea2.setText("");
                textArea.setText("Cześć " + imie+ " " + nazwisko); 
                sprawdz();
            
              
               
          } 
        }
        private void przycisk_wsteczActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
          
        start();
        
       }
      void todo()
      {
    
      przycisk.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 if (imie.equals(""))
          {
               przyciskActionPerformed(evt);
               
               
               
          } 
                 else if (nazwisko.equals(""))
          { 
               textArea.setText("twoje imie to " + imie +" Wprowadź nazwisko");
               setnazwisko(textArea2.getText());
                     try {
                         przyciskActionPerformed2(evt);
                     } catch (InterruptedException ex) {
                         System.out.println("błąd");
                     }
          }
                 
                 else
                 {
                     textArea.setText("Cześć " + imie+ " " + nazwisko);
                     try {
                         sprawdz();
                         
                    
                     } catch (InterruptedException ex) {
                        System.out.println("błąd");
                     }
                
                    
                 }
                 
                       
                 
            }
            
            
        });
        przycisk_wstecz.addActionListener(new java.awt.event.ActionListener() {
            
    public void actionPerformed(java.awt.event.ActionEvent evt)  
              {
        try {
            przycisk_wsteczActionPerformed(evt);
        } catch (InterruptedException ex) {
            Logger.getLogger(TextPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
              }
        });
}

}
