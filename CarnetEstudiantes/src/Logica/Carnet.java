package Logica;


import Interfaces.Gcarnet;
import java.io.File;
import java.io.Serializable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Carnet implements Serializable {

    // atributos 
    private String nombre;
    private  String codigo;
    private  String proyecto;
    private  String source;
    // static = atributo de clase y se aplica para todos los objetos
    public boolean confi = true;
    
    int imagen;
    public Carnet(String nom,String cod,String proy){
        this.nombre = nom;
        this.codigo = cod;
        this.proyecto = proy;
    }

  

    //metodos
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getProyecto() {
        return proyecto;
    }
    public String getSource() {
        return source;
    }
    public void setNombre(String nam){
        nam = nombre;
    }
    public void setCodigo(String cod){
        cod = codigo;
    }
    public void setProyecto(String pro){
        pro = proyecto;
    }
    
    public void capturar() {
        // nombre
        nombre = JOptionPane.showInputDialog("nombre del estudiante");
         // codigo con confirmacion de 11 digitos
        while (confi == true) {
            codigo = JOptionPane.showInputDialog("ingrese su codigo");
            if (codigo.length() == 3) {
                confi = false;
            }
        }
        // proyecto curricular
        proyecto = JOptionPane.showInputDialog("Nommbre del proyecto curricular");
    }

  

    public void visualizar() {  
        System.out.println("aaaaaaa mi pixchula");
        Gcarnet prueba = new Gcarnet(this);
        prueba.setVisible(true);
    }

    public void getimage() {
        JOptionPane.showMessageDialog(null, "seleccione la imagen del estudiante");
        JFileChooser archivo = new JFileChooser("./imagenes");
        archivo.showOpenDialog(null);
        File foto = archivo.getSelectedFile();
        source = foto.getPath();
    }

}
