package example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Scanner;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class CorbaFiguClient implements ChangeListener{

    figure figuImpl;

    public static String[] args;

    public JRadioButton radioCubo;
    public JRadioButton radioParalelepipedo;
    public JRadioButton radioCilindro;
    public JRadioButton radioEsfera;

    JFrame f;

    boolean cubo;
    boolean paralelepipedo;
    boolean cilindro;
    boolean esfera;

    Double a,b,c,r,h,resultado;

    public CorbaFiguClient(){
        try{
            f=new JFrame();//creating instance of JFrame  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(new FlowLayout());
            
            f.add(new JLabel("Seleccione figura : "));
            
            ButtonGroup bg=new ButtonGroup();
            
            radioCubo=new JRadioButton("Cubo");
            radioCubo.setBounds(10,20,100,30);

            radioParalelepipedo=new JRadioButton("Paralelepipedo");
            radioParalelepipedo.setBounds(10,70,100,30);
            
            radioCilindro=new JRadioButton("Cilindo");
            radioCilindro.setBounds(10,120,100,30);

            radioEsfera=new JRadioButton("Esfera");
            radioEsfera.setBounds(10,120,100,30);

            f.add(radioCubo);
            f.add(radioParalelepipedo);
            f.add(radioCilindro);
            f.add(radioEsfera);
            
            bg.add(radioCubo);
            bg.add(radioParalelepipedo);
            bg.add(radioCilindro);   
            bg.add(radioEsfera);   


            JButton bArea=new JButton("Calcular Area");//creating instance of JButton  
            JButton bVolumen=new JButton("Calcular Volumen");

            bArea.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    CorbaFiguClient.this.calcularArea();
                }
            });

            bVolumen.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    CorbaFiguClient.this.calcularVolumen();
                }
            });

            f.getContentPane().add(bArea);
            f.getContentPane().add(bVolumen);
                      

            radioCubo.addChangeListener(this);        
            radioParalelepipedo.addChangeListener(this);        
            radioCilindro.addChangeListener(this);        
            radioEsfera.addChangeListener(this);        

            f.setSize(500,200);//400 width and 500 height  
            f.setVisible(true);//making the frame visible
            f.setLocation(400,200);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) 
    {
        args=args;
        new CorbaFiguClient();
    }

     public void stateChanged(ChangeEvent e) {
        cubo=radioCubo.isSelected();
        paralelepipedo=radioParalelepipedo.isSelected();
        cilindro=radioCilindro.isSelected();
        esfera=radioEsfera.isSelected();
    }

    public boolean figuraSeleccionada(){
        return cubo || paralelepipedo || cilindro || esfera;
    }

    public void calcularArea(){
        if(!figuraSeleccionada())
            JOptionPane.showMessageDialog(null, "Seleccione una figura", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
        
        if(cubo){
            a=getNumero("Ingrese 'a'");
            resultado=areaCubo(a);
        }else if(paralelepipedo){
            a=getNumero("Ingrese 'a'");
            b=getNumero("Ingrese 'b'");
            c=getNumero("Ingrese 'c'");

            resultado=areaParalelepipedo(a, b, c);
        }else if(cilindro){
            r=getNumero("Ingrese 'r'");
            h=getNumero("Ingrese 'h'");

            resultado=areaCilindro(r,h);
        }else if(esfera){
            r=getNumero("Ingrese 'r'");
            resultado=areaEsfera(r);
        }

        mensaje("El resultado es : "+resultado);
    }

    public void mensaje(String msg){
        JOptionPane.showMessageDialog(null, msg, "Información" , JOptionPane.INFORMATION_MESSAGE);
    }

    public void calcularVolumen(){
        if(!figuraSeleccionada())
            JOptionPane.showMessageDialog(null, "Seleccione una figura", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
        
        if(cubo){
            a=getNumero("Ingrese 'a'");
            resultado=volumenCubo(a);
        }else if(paralelepipedo){
            a=getNumero("Ingrese 'a'");
            b=getNumero("Ingrese 'b'");
            c=getNumero("Ingrese 'c'");

            resultado=volumenParalelepipedo(a, b, c);
        }else if(cilindro){
            r=getNumero("Ingrese 'r'");
            h=getNumero("Ingrese 'h'");

            resultado=volumenCilindro(r,h);
        }else if(esfera){
            r=getNumero("Ingrese 'r'");
            resultado=volumenEsfera(r);
        }

        mensaje("El resultado es : "+resultado);
    }

    public Double getNumero(String mensaje){
        String salida = JOptionPane.showInputDialog(f, mensaje);
        if(salida.isEmpty())return 0d;
        try{
            return Double.parseDouble(salida);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número valido", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            getNumero(mensaje);
        }
        return 0d;
    }


    public figure getFigureImpl(){
        try{
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            figure figuImpl = figureHelper.narrow(ncRef.resolve_str("Figure"));
            return figuImpl;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Double areaCubo(Double a){
        return getFigureImpl().areaCubo(a);
    }


    public Double volumenCubo(Double a){
        return getFigureImpl().volumenCubo(a);
    }

    public Double areaParalelepipedo(Double a, Double b, Double c){
        return getFigureImpl().areaParalelepipedo(a, b, c);
    }

    public Double volumenParalelepipedo(Double a, Double b, Double c){
        return getFigureImpl().volumenParalelepipedo(a,b,c);
    }

    public Double areaCilindro(Double r, Double h){
        return getFigureImpl().areaCilindro(r, h);
    }

    public Double volumenCilindro(Double r, Double h){
        return getFigureImpl().volumenCilindro(r, h);
    }

    public Double areaEsfera(Double r){
        return getFigureImpl().areaEsfera(r);
    }

    public Double volumenEsfera(Double r){
        return getFigureImpl().volumenEsfera(r);
    }
}   