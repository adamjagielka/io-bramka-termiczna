
package bramka2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
    private double temperatura=  35.8;
    private JTextArea textArea;
    private JTextArea textArea2;
    private String kom_niska_temperatua = "Masz za niską temperaturę";
    private String kom_wysoka_temperatua = "Masz za wysoką temperaturę";
    private String kom_ok_temperatua = "Masz odpowiednią temperaturę";
    private String imie = "";
    private String nazwisko = "";
    private JButton przycisk;
   
    
    public TextPanel()
    {
        
        przycisk = new JButton();
        textArea = new JTextArea();
        textArea2 = new JTextArea();
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.NORTH);
        add(new JScrollPane(textArea2), BorderLayout.CENTER);
        add(new JScrollPane(przycisk),BorderLayout.SOUTH);
        textArea.setText("Witam w aplikacji ''Bramka Termiczna''\n");
        textArea.append("kliknij przycisk by przejść dalej");
        textArea.setEditable(false);
        textArea2.setEditable(false);
        przycisk.setText("dalej");
        
        todo();
        
        
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
               textArea.setText("twoje imie to " + imie +" Wprowadź nazwisko");               
          } 
       }
        private void przyciskActionPerformed2(java.awt.event.ActionEvent evt) {
           textArea2.setEditable(true);
          setnazwisko(textArea2.getText());
          System.out.println("nazwisko " + nazwisko);
           if (!nazwisko.equals(""))
           {   
               textArea2.setText("");
                textArea.setText("Cześć " + imie+ " " + nazwisko);              
          } 
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
               przyciskActionPerformed2(evt);
          }
                 
                 else
                 {
                     textArea.setText("Cześć " + imie+ " " + nazwisko);
                 }
                 
                       
                 
            }
            
            
            
              
        });
}

}
