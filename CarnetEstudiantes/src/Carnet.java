
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
            if (codigo.length() == 11) {
                confi = false;
            }
        }
        // proyecto curricular
        proyecto = JOptionPane.showInputDialog("Nommbre del proyecto curricular");
    }

  

    public void visualizar() {
        GUI prueba = new GUI(this);
        prueba.setVisible(true);
    }

    public void getimage() {
        JOptionPane.showMessageDialog(null, "seleccione la imagen del estudiante");
        JFileChooser archivo = new JFileChooser("./imagenes");
        archivo.showOpenDialog(null);
        File imagen = archivo.getSelectedFile();
        source = imagen.getPath();
    }

}
