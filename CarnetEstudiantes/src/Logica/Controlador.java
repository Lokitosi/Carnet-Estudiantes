package Logica;
import Logica.Carnet;
import Interfaces.GUI;
import Interfaces.Gmenu;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controlador {
//atributos

    public String seleccion;
    public int nCarnet;
    final int num = 5;
    public int vercarne = 0;
    Controlador control;
    int posicion = 0;
    public boolean confi = true;
    Carnet ab = new Carnet(null, null, null);
    ArrayList<Carnet> lista = new ArrayList<>();
    int cantidad = lista.size();

    public int getVercarne() {
        return vercarne;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setVercarne(int vercarne) {
        this.vercarne = vercarne;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

//constructor
    public void menu() {
        Gmenu b = new Gmenu(this);
        b.setVisible(true);
    }

//metodos
    public void añadir(String nom, String cod, String proy) {
        Carnet a = new Carnet(nom, cod, proy);

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

    public void ver(int a) {
        cantidad = lista.size();
        lista.get(a).visualizar(this);
      
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

}
