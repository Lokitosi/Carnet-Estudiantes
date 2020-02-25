package Logica;


import Logica.Controlador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controlador extends JFrame implements ActionListener {

    public String seleccion;
    public int nCarnet;
    final int num = 5;
    public boolean confi = true;
    JButton ok = new JButton("ok");
    JTextField seleaccion = new JTextField();
    ArrayList<Carnet> lista = new ArrayList<>();

    public void menu() {
        // Jframe
        JFrame a = new JFrame();
        a.setBounds(0, 0, 400, 400);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        a.add(ok);
        a.add(seleaccion);
        a.add(menu);

        a.setVisible(true);
        // fin operacion
    }

    public void iniciar() {
        int nume;
        try {
            nume = Integer.parseInt(JOptionPane.showInputDialog("cuantos carnets desea crear"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "por favor escriba un numero");
            nume = Integer.parseInt(JOptionPane.showInputDialog("cuantos carnets desea crear"));
        }
        for (int b = 0; b < nume; b++) {
            Carnet a = new Carnet();
            a.capturar();
            a.getimage();
            JOptionPane.showMessageDialog(null, "El estudiante ha sido añadido exitosamente");
            lista.add(a);

        }
    }

    public void añadir() {
        Carnet a = new Carnet();
        a.capturar();
        a.getimage();
        JOptionPane.showMessageDialog(null, "El estudiante ha sido añadido exitosamente");
        lista.add(a);

    }

    // persistencia time
    public void guardar() {

        try {
            FileOutputStream fout = new FileOutputStream("./bin/carne.bin");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(lista);
            out.close();

            fout.close();
            JOptionPane.showMessageDialog(null, "done");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "no se encontro el arcchivo");

        }
    }

    public void cargar() {

        try {
            FileInputStream fin = new FileInputStream("./bin/carne.bin");
            ObjectInputStream reader = new ObjectInputStream(fin);
            lista = (ArrayList) reader.readObject();

            reader.close();
            fin.close();
            JOptionPane.showMessageDialog(null, "done");

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "no se encontro el arcchivo");

        }
    }

    // end of persistencia time
    public void corregir() {
        int dato;
        String codigo;
        codigo = JOptionPane.showInputDialog("escriba el codigo a buscar");
        for (int i = 0; i < lista.size(); i++) {
            if (codigo.equals(lista.get(i).getCodigo()) == true) {
                dato = Integer.parseInt(JOptionPane.showInputDialog("dato a corregir: " + "\n" + "1:NOMBRE" + "\n" + "2:Codigo" + "\n" + "3:Proyecto"));
                switch (dato) {
                    case (1):
                        lista.get(i).setNombre(JOptionPane.showInputDialog("cual es el nuevo nombre  a corregir"));
                        break;
                    case (2):
                        lista.get(i).setCodigo(JOptionPane.showInputDialog("Digite el nuevo codigo:"));
                        break;
                    case (3):
                        lista.get(i).setProyecto(JOptionPane.showInputDialog("Nuevo proyecto:"));
                        break;

                }
            }
        }

    }

    public void eliminar() {
        int nCarnet = Integer.parseInt(JOptionPane.showInputDialog("que numero  de carnet desea eliminar"));
        lista.remove(nCarnet);
        JOptionPane.showMessageDialog(null, "el carnet ha sido eliminado");
    }

    public void ver() {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).visualizar();
        }
    }

    public void eliminarTodo() {
        lista.clear();
        JOptionPane.showMessageDialog(null, "Los carnets han sido eliminados");
    }

    public void cerrar() {
        System.exit(0);

    }

    public static void main(String[] args) {
        Controlador a = new Controlador();
        a.menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ok) | e.getSource().equals(seleaccion)) {
            seleccion = seleaccion.getText();
            switch (seleccion) {
                case ("1"):
                    iniciar();
                    break;
                case ("2"):
                    cargar();
                    break;
                case ("3"):
                    añadir();
                    break;
                case ("4"):
                    corregir();
                    break;
                case ("5"):
                    eliminar();
                    break;
                case ("6"):
                    ver();
                    break;
                case ("7"):
                    eliminarTodo();
                case ("8"):
                    guardar();
                    break;
                case ("9"):
                    cerrar();
                    break;
                default:
                    System.out.println("si no tiene un cromosoma de mas,por favor seleccione una opcion del menu");

            }
        }
    }
}
