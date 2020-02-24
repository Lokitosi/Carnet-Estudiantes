
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controlador {

    public String seleccion;
    public int nCarnet;
    final int num = 5;
    public boolean confi = true;
    ArrayList<Carnet> lista = new ArrayList<>();

    public void menu() {
        while (confi == true) {
            String texto = "1:Iniciar carnets" + "\n";
            texto += "2:cargar carnets anteriormente guardados" + "\n";
            texto += "3:añadir carnet" + "\n";
            texto += "4:modificar un carnet" + "\n";
            texto += "5:eliminar un carnet" + "\n";
            texto += "6:ver carnets" + "\n";
            texto += "7: Eliminar todos los carnets" + "\n";
            texto += "8:Guardar" + "\n";
            texto += "9:cerrar programa";
            seleccion = JOptionPane.showInputDialog(null, texto);
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
        Carnet carnet;
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
            if (codigo == lista.get(i).getCodigo()) {
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
        confi = false;
    }

    public static void main(String[] args) {
        Controlador a = new Controlador();
        a.menu();
    }
}
