/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package cenadelosfilosofos;

//import Componentes.Comedor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 *  @author Beto,RoBerto,MaNuel
 */
public class Interface extends JApplet
{
    JButton boton1;
    JButton boton2;
     JButton boton3;
     JButton boton4;
     JButton boton5;
    
    public Interface(){
        this.InitInterface();
    }   

    
    private void InitInterface(){
        
        
        JFrame contenedor = new JFrame("Cena de los Filósofos");
        contenedor.setSize(225,175);
        contenedor.setLayout(null);
        //contenedor.setLayout(new BorderLayout());
        
        
        boton1 = new JButton();
        boton1.setSize(200, 25);
        boton1.setLocation(0, 0);
        boton1.setText("Filosofo 1");
        boton1.setBackground(Color.WHITE);
        contenedor.add(boton1);
    //    boton1.setActionCommand("BOTON1");
        
        boton2 = new JButton();
        boton2.setSize(200, 25);
        boton2.setLocation(0, 26);
        boton2.setText("Filosofo 2");
        boton2.setBackground(Color.WHITE);
        contenedor.add(boton2);
      //  boton2.setActionCommand("BOTON2");
       
        boton3 = new JButton();
        boton3.setSize(200, 25);
        boton3.setLocation(0, 52);
        boton3.setText("Filosofo 3");
        boton3.setBackground(Color.WHITE);
        contenedor.add(boton3);
      //  boton3.setActionCommand("BOTON3");
        
        boton4 = new JButton();
        boton4.setSize(200, 25);
        boton4.setLocation(0, 78);
        boton4.setText("Filosofo 4");
        boton4.setBackground(Color.WHITE);
        contenedor.add(boton4);
      //  boton4.setActionCommand("BOTON4");
        
        boton5 = new JButton();
        boton5.setSize(200, 25);
        boton5.setLocation(0, 104);
        boton5.setText("Filosofo 5");
        boton5.setBackground(Color.WHITE);
        contenedor.add(boton5);
       // boton5.setActionCommand("BOTON5");
        
        contenedor.setVisible(true);
        contenedor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
        public  void colorboton(char a, int f) {
            a=a; //accion del filosofo comer, pensar o estar hambriento
           f=f; //numero del filosofo
            
            if(a == 'p'){
            
               switch (f) {
            case 1: boton1.setText("Filosofo 1: pensando");
                        boton1.setBackground(Color.yellow);break;
            case 2:  boton2.setText("Filosofo 2: pensando");
                        boton2.setBackground(Color.yellow); break;
            case 3:  boton3.setText("Filosofo 3: pensando");
                        boton3.setBackground(Color.yellow); break;
            case 4:  boton4.setText("Filosofo 4: pensando");
                        boton4.setBackground(Color.yellow); break;
            case 5:  boton5.setText("Filosofo 5: pensando");
                        boton5.setBackground(Color.yellow); break;
            
                    }//end switch
               
            }//end if
            if(a == 'h'){
           
             switch (f) {
            case 1:  boton1.setText("Filosofo 1: hambriento");
                        boton1.setBackground(Color.red); break;
            case 2:  boton2.setText("Filosofo 2: hambriento");
                        boton2.setBackground(Color.red); break;
            case 3:  boton3.setText("Filosofo 3: hambriento");
                        boton3.setBackground(Color.red); break;
            case 4:  boton4.setText("Filosofo 4: hambriento");
                        boton4.setBackground(Color.red); break;
            case 5:  boton5.setText("Filosofo 5: hambriento");
                        boton5.setBackground(Color.red); break;
            
                        }//end switch
            }//end if
            if(a == 'c'){
          
             switch (f) {
            case 1:  boton1.setText("Filosofo 1: comiendo");
                        boton1.setBackground(Color.green); break;
            case 2:  boton2.setText("Filosofo 2: comiendo");
                        boton2.setBackground(Color.green); break;
            case 3:  boton3.setText("Filosofo 3: comiendo");
                        boton3.setBackground(Color.green); break;
            case 4:  boton4.setText("Filosofo 4: comiendoo");
                        boton4.setBackground(Color.green); break;
            case 5:  boton5.setText("Filosofo 5: comiendo");
                        boton5.setBackground(Color.green); break;
            
                    }//end switch
            
             }//end if
            }//end colorboton
        
    }
     
