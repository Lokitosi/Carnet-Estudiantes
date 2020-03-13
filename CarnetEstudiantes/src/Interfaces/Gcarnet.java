package Interfaces;

import Logica.Carnet;
import Logica.Controlador;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gcarnet extends JFrame implements ActionListener {
    //Atributos 
        JLabel foto;
        JLabel titulo;
        JLabel name;
        JLabel codigo;
        JLabel proyecto;
        JButton anterior;
        JButton siguiente;
        Controlador control ;
        int b = 0;
        
        

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
        
        
        
    public Gcarnet(Carnet carnet,Controlador c ) {
        control = c;
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
        
        anterior = new JButton("anterior");
        anterior.setBounds(0,320,100,20);
        anterior.addActionListener(this);
        contenedor.add(anterior);
        
        siguiente = new JButton("siguiente");
        siguiente.setBounds(320,320,100,20);
        siguiente.addActionListener(this);
        contenedor.add(siguiente);
              
        
    }
   private void cargar(){
       control.cargar();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(anterior)){
            
            System.out.println("aaaa");
            
        }
        if (e.getSource()==(siguiente)){ 
            control.ver(b);
            b += 1;
            System.out.println(b);
            System.out.println("ayuda");
        }
    }
  
   
}
