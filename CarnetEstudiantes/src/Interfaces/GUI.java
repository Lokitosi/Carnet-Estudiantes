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
// version 1.5
public class GUI extends JFrame implements ActionListener {

    //Atributos 
    JLabel foto;
    JLabel titulo;
    JLabel name;
    JLabel codigo;
    JLabel proyecto;
    JButton siguiente;
    JButton anterior;
    JButton cerrar;
    Carnet b;
    Controlador dat;
    Boolean error = false;

    public GUI(Carnet carnet, Controlador a) {
        b = carnet;
        dat = a;
        this.setSize(700, 400);
        this.setTitle("Carnet Estudiantil");

        this.setLocationRelativeTo(null);
        vercarnet(b, dat);
    }

    private void vercarnet(Carnet prueba, Controlador a) {

        JPanel contenedor = new JPanel();
        contenedor.setLayout(null);
        this.getContentPane().add(contenedor);

        // Fotografia
        ImageIcon foto1 = new ImageIcon(prueba.getSource());
        foto = new JLabel();
        foto.setBounds(10, 80, 225, 210);
        foto.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH)));
        contenedor.add(foto);

        // titulo carnet
        titulo = new JLabel("Carnet Estudiantil");
        titulo.setFont(new Font("arial", Font.BOLD, 50));
        titulo.setBounds(10, 7, 500, 50);
        contenedor.add(titulo);
        // nombre estudiante
        name = new JLabel(prueba.getNombre());
        name.setBounds(250, 100, 450, 30);
        name.setFont(new Font("arial", Font.BOLD, 30));
        contenedor.add(name);
        // proyecto
        proyecto = new JLabel("Proyecto : "+prueba.getProyecto());
        proyecto.setBounds(250, 210, 400, 30);
        proyecto.setFont(new Font("arial", Font.BOLD, 30));
        contenedor.add(proyecto);
        // codigo
        codigo = new JLabel("Codigo : " + prueba.getCodigo());
        codigo.setBounds(250, 160, 400, 30);
        codigo.setFont(new Font("arial", Font.BOLD, 30));
        contenedor.add(codigo);
        // Botones
        anterior = new JButton("anterior");
        anterior.setBounds(100, 320, 100, 30);
        anterior.addActionListener(this);
        contenedor.add(anterior);

        siguiente = new JButton("siguiente");
        siguiente.setBounds(210, 320, 100, 30);
        siguiente.addActionListener(this);
        contenedor.add(siguiente);

        cerrar = new JButton("cerrar");
        cerrar.setBounds(320, 320, 100, 30);
        cerrar.addActionListener(this);
        contenedor.add(cerrar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(anterior)) {

            try {
                dat.setPosicion(dat.getPosicion() - 1);
                this.setVisible(false);
                dat.ver(dat.getPosicion());
            } catch (IndexOutOfBoundsException g) {
                dat.setPosicion(dat.getCantidad() - 1);
                dat.ver(dat.getPosicion());

            }

        }
        if (e.getSource().equals(siguiente)) {
            try {
                dat.setPosicion(dat.getPosicion() + 1);
                this.setVisible(false);
                dat.ver(dat.getPosicion());
            } catch (IndexOutOfBoundsException h) {
                dat.setPosicion(0);
                dat.ver(dat.getPosicion());
            }

        }
        if (e.getSource().equals(cerrar)) {
            this.dispose();

        }
    }

}
