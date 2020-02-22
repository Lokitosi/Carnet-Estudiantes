

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controlador  {

    public String seleccion;
    public int nCarnet;
    final int num = 5;
    public boolean confi = true;    
    ArrayList<Carnet> lista = new ArrayList<>();
    //Carnet[] lista = new Carnet[2];
    
    public void menu() {
        while (confi == true) {
            String texto = "1:Iniciar carnets"+"\n";
            texto += "2:añadir carnet"+"\n";
            texto += "3:modificar un carnet"+"\n";
            texto += "4:eliminar un carnet"+"\n";
            texto += "5:ver carnets"+"\n";
            texto += "6: Eliminar todos los carnets"+"\n";
            texto += "7:cerrar programa"+"\n";
            texto += "8:Guardar";
                seleccion = JOptionPane.showInputDialog(null,texto);
            switch (seleccion) {
                case ("1"):
                    iniciar();
                    break;
                case ("2"):
                    añadir();
                    break;
                case ("3"):
                    corregir();
                    break;
                case ("4"):
                    eliminar();
                    break;
                case ("5"):
                    ver();
                case ("6"):
                    relleno();
                case ("7"):
                    cerrar();
                case ("8"):
                    guardar();
                    break;
                default:
                    System.out.println("si no tiene un cromosoma de mas, seleccione una opcion del menu");

            }
        }
    }

    public void iniciar() {
        int i;
        for (i = 0; i < 2; i++) {
            Carnet a = new Carnet();
            a.capturar();
            a.getimage();
            a.visualizar();
            lista.add(a);
            
            
        }
    }
    public void añadir(){
        Carnet a = new Carnet();
            a.capturar();
            a.getimage();
            a.visualizar();
            lista.add(a);

    }
    // persistencia time
    public void guardar(){
        Carnet carnet = (Carnet)lista.get(0);
        try{
        FileOutputStream fout = new FileOutputStream("./data/carne.bin");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(carnet);
        out.close();
        fout.close();
        JOptionPane.showMessageDialog(null,"done");
    }catch(IOException e){
        JOptionPane.showMessageDialog(null,"no se encontro el arcchivo");
        
    }
    }
    public void cargar(){
         Carnet carnet;
        try{
        FileInputStream fin = new FileInputStream("./data/carne.bin");
        ObjectInputStream reader = new ObjectInputStream(fin);
        carnet = (Carnet)reader.readObject();
        reader.close();
        fin.close();
        JOptionPane.showMessageDialog(null,"done");
    }catch(IOException | ClassNotFoundException e ){
        JOptionPane.showMessageDialog(null,"no se encontro el arcchivo");
        
    }
    }
    // end of persistencia time
    public void corregir() {
        int dato;
       String codigo;
       codigo = JOptionPane.showInputDialog("escriba el codigo a buscar");
        for (int i=0;i<lista.size();i++){
            if (codigo == lista.get(i).getCodigo()){
             dato = Integer.parseInt(JOptionPane.showInputDialog("dato a corregir: "+"\n"+"1:NOMBRE"+"\n"+"2:Codigo"+"\n"+"3:Proyecto"));
            switch (dato){
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
    public void eliminar(){
        int nCarnet = Integer.parseInt(JOptionPane.showInputDialog("que numero  de carnet desea eliminar"));
        lista.remove(nCarnet);
    }
    public void ver(){
        for (int i = 0;i<lista.size();i++){
            lista.get(i).visualizar();
        }
    }
    public void relleno(){
        lista.clear();
    }
    public void cerrar(){
        confi = false;
    }

    public static void main(String[] args) {
        Controlador a = new Controlador();
        a.menu();
    }
}
