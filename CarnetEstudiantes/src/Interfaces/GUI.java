package Interfaces;

import Logica.Carnet;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {
    //Atributos 
        JLabel foto;
        JLabel titulo;
        JLabel name;
        JLabel codigo;
        JLabel proyecto;
        
        
    public GUI(Carnet carnet) {
        this.setSize(700,400);
        this.setTitle("Carnet Estudiantil");
        
        this.setLocationRelativeTo(null);
        vercarnet(carnet);
    }
    
    
    
   private void vercarnet(Carnet prueba){
        
        JPanel contenedor = new JPanel();
        contenedor.setLayout(null);
        this.getContentPane().add(contenedor);
        
        // Fotografia
        ImageIcon foto1 = new ImageIcon(prueba.getSource());
        foto = new JLabel();
        foto.setBounds(10,80,225,210);
        foto.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(foto.getWidth(),foto.getHeight(),Image.SCALE_SMOOTH)));
        contenedor.add(foto);
        
       // titulo carnet
        titulo = new JLabel("Carnet Estudiantil");
        titulo.setFont(new Font("arial",Font.BOLD,50));
        titulo.setBounds(10,7,500,50);
        contenedor.add(titulo);
       // nombre estudiante
        name = new JLabel(prueba.getNombre());
        name.setBounds(250,100,450,30);
        name.setFont(new Font("arial",Font.BOLD,30));
        contenedor.add(name);
       // proyecto
        proyecto = new JLabel(prueba.getProyecto());
        proyecto.setBounds(250,210,400,30);
        proyecto.setFont(new Font("arial",Font.BOLD,30));
        contenedor.add(proyecto);
       // codigo
        codigo = new JLabel("Cod: "+prueba.getCodigo());
        codigo.setBounds(250,160,400,30);
        codigo.setFont(new Font("arial",Font.BOLD,30));
        contenedor.add(codigo);
              
        
    }
  
   
}
