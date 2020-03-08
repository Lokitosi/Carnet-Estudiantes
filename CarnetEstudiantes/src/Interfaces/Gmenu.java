package Interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Logica.Controlador;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gmenu extends JFrame implements ActionListener {

    //elementos necesarios :)
    public boolean confi = true;
    // botones
    JButton cargar = new JButton("Cargar");
    JButton guardar = new JButton("Guardar");
    JButton eliminarTodo = new JButton("Eliminar-Todo");
    JButton añadir = new JButton("añadir");
    JButton ver = new JButton("Ver carnet");
    JButton corregir = new JButton("Corregir");
    JButton eliminar = new JButton("Eliminar");

    //textfields
    JTextField nombret = new JTextField();
    JTextField codigot = new JTextField();
    JTextField proyectot = new JTextField();

    // otras cosas 
    Controlador a = new Controlador();

    public Gmenu(Controlador b) {
        this.setBounds(0, 0, 750, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearmenu();

    }

    public void crearmenu() {
        // Jpanel
        JPanel menu = new JPanel();
        menu.setLayout(null);
        //titulo
        String titulo = "Carnets Estudiantiles";        
        JLabel titulox = new JLabel(titulo);
        titulox.setBounds(120,10, 650, 48);
        titulox.setFont(new Font("arial", Font.BOLD, 48));
        menu.add(titulox);

        //Apartado Nombre
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setBounds(50, 100, 150, 30);
        nombre.setFont(new Font("arial", Font.BOLD, 30));
        menu.add(nombre);
        nombret.setBounds(200, 100, 400, 30);
        menu.add(nombret);

        //Apartado Codigo
        JLabel codigo = new JLabel("Codigo: ");
        codigo.setBounds(50, 150, 150, 30);
        codigo.setFont(new Font("arial", Font.BOLD, 30));
        menu.add(codigo);
        codigot.setBounds(200, 150, 400, 30);
        menu.add(codigot);

        //Apartado Proyecto 
        JLabel proyecto = new JLabel("Proyecto: ");
        proyecto.setBounds(50, 200, 150, 30);
        proyecto.setFont(new Font("arial", Font.BOLD, 30));
        menu.add(proyecto);
        proyectot.setBounds(200, 200, 400, 30);
        menu.add(proyectot);

        // Botones
        cargar.setBounds(20, 300, 100, 30);
        menu.add(cargar);
        cargar.addActionListener(this);

        guardar.setBounds(140,300, 100, 30);
        menu.add(guardar);
        guardar.addActionListener(this);

        eliminarTodo.setBounds(300, 350, 150, 30);
        menu.add(eliminarTodo);
        eliminarTodo.addActionListener(this);

        añadir.setBounds(380, 300, 100, 30);
        menu.add(añadir);
        añadir.addActionListener(this);

        ver.setBounds(500, 300, 100, 30);
        menu.add(ver);
        ver.addActionListener(this);

        corregir.setBounds(620, 300, 100, 30);
        menu.add(corregir);
        corregir.addActionListener(this);
        
        eliminar.setBounds(260, 300, 100, 30);
        menu.add(eliminar);
        eliminar.addActionListener(this);
            


        this.add(menu);

        this.setVisible(true);
    }
// Accion del boton 

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(cargar)) {
            a.cargar();
        }
        if (e.getSource().equals(guardar)) {
            a.guardar();
        }

        if (e.getSource().equals(eliminarTodo)) {
            a.eliminarTodo();
        }
        if (e.getSource().equals(añadir)) {
            String name = nombret.getText();
            String proy = proyectot.getText();
            String cod = codigot.getText();
            if (cod.length()==11){
               a.añadir(name,cod,proy); 
            }else{
                JOptionPane.showMessageDialog(null,"Por favor Ingrese un codigo de 11 digitos");
            }
            
            
        }
        if (e.getSource().equals(ver)) {
            a.ver();
        }
        if (e.getSource().equals(corregir)) {
            a.corregir();
        }
        if (e.getSource().equals(eliminar)) {
            a.eliminar();
        }
    }
}
