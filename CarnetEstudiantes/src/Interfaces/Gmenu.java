package Interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Logica.Controlador;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Gmenu extends JFrame implements ActionListener {

    public boolean confi = true;
    JButton ok = new JButton("ok");
    JTextField seleaccion = new JTextField();
    public String seleccion;
    Controlador a = new Controlador();

    public Gmenu(Controlador b) {
        this.setBounds(0, 0, 400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearmenu();

    }

    public void crearmenu() {
        // Jpanel
        JPanel menu = new JPanel();
        menu.setLayout(null);
        //titulo
        String titulo = "<HTML><b><h1>Carnets Estudiantiles</h1></b></HTML>";
        JLabel titulox = new JLabel(titulo);
        titulox.setBounds(50, 0, 400, 40);
        menu.add(titulox);
        // opciones
        String texto = "<HTML><b>1: Iniciar carnets<br>2: Cargar carnets anteriormente guardados";
        texto += "<br>3: Añadir carnet<br>4: Modificar un carnet<br>5: Eliminar un carnet";
        texto += "<br>6: Ver carnets<br>7: Eliminar todos los carnets<br>8:Guardar";
        texto += "<br>9:Cerrar programa</b></HTML>";
        JLabel txt = new JLabel(texto);
        txt.setFont(new Font("arial", Font.BOLD, 15));
        txt.setBounds(20, 30, 250, 230);
        menu.add(txt);
        //boton
        ok.setBounds(128, 282, 60, 20);
        ok.addActionListener(this);
        // campo de texto
        seleaccion.setBounds(80, 260, 180, 20);
        seleaccion.addActionListener(this);

        this.add(ok);
        this.add(seleaccion);
        this.add(menu);

        this.setVisible(true);
    }
// Accion del boton o del textBox :)

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(ok) | e.getSource().equals(seleaccion)) {

            seleccion = seleaccion.getText();
            switch (seleccion) {
                case ("1"):
                    a.iniciar();
                    break;
                case ("2"):
                    a.cargar();
                    break;
                case ("3"):
                    a.añadir();
                    break;
                case ("4"):
                    a.corregir();
                    break;
                case ("5"):
                    a.eliminar();
                    break;
                case ("6"):
                    a.ver();
                    break;
                case ("7"):
                    a.eliminarTodo();
                case ("8"):
                    a.guardar();
                    break;
                case ("9"):
                    a.cerrar();
                    break;
                default:
                    System.out.println("si no tiene un cromosoma de mas,por favor seleccione una opcion del menu");

            }
        }
    }
}
