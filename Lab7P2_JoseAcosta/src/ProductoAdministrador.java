
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josed
 */
public class ProductoAdministrador {
    
    private ArrayList<Producto> m =new ArrayList();
    private File archivo = null;

    public ProductoAdministrador() {
    }

    public ArrayList<Producto> getM() {
        return m;
    }

    public void setM(ArrayList<Producto> m) {
        this.m = m;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "ProductoAdministrador{" + "m=" + m + ", archivo=" + archivo + '}';
    }
    
    public void setPdocuto(Producto m) {
        this.m.add(m);
    }
    
  
      public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Producto t : m) {
                bw.write(t.getId() + ",");
                bw.write(t.getName() + ",");
                bw.write(t.getBin() + ",");
                 bw.write(t.getAisle() + ",");
                  bw.write(t.getPrice() + ",");
                  bw.write(t.getCategory() + ",");
                  
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner entrada = null;
        m = new ArrayList();
        if (archivo.exists()) {
            try {
                entrada = new Scanner(archivo);
                entrada.useDelimiter(",");
                while (entrada.hasNext()) {
                    m.add(new Producto(entrada.nextInt(), entrada.next(), entrada.nextInt(), entrada.nextDouble(), entrada.nextInt(), entrada.nextInt()));
                }
            } catch (Exception ex) {
            }
            entrada.close();
        }
    }
    
    
    
}
