package SIGUIENTES_202103718;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class tablaSig {
    
    private Map<String, List<String>> tabla = new HashMap<>();

    // METODOS PRIVADOS---------------------------------------------
    private boolean repetidos(String clave, String valor){
        boolean ve = false;
        
        for(Map.Entry<String, List<String>> mapa : tabla.entrySet()){
       
            if (mapa.getKey().equals(clave)){
                for (int i = 0; i < mapa.getValue().toArray().length; i++){
                    if(mapa.getValue().toArray()[i].equals(valor)){
                        ve = true;
                        return ve;
                    }
                }
            }
        }
        return ve;
    }
    
    private void insert(Map<String, List<String>> map, String key, List<String> value) {
        if (map.containsKey(key)){
            map.get(key).addAll(value);
        } else {
            map.put(key, value);
        }
    }
    
    private void agregar(String[] claves, String[] valores){
        for (int i = 0; i < claves.length; i++) {

            for (int j = 0; j< valores.length; j++){
                
                if (repetidos(claves[i], valores[j])){
                    continue;
                }
                
                if (tabla.containsKey(claves[i])){
                    insert(tabla, claves[i], Arrays.asList(valores[j]));
                }else {
                    tabla.put(claves[i], new ArrayList<>(Arrays.asList(valores[j])));
                }
            }
        }
    }
    
    private void graficarF(String nombre, String graphviz){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src/main/java/SIGUIENTES_202103718/" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println(graphviz);

        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo"+e);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            //dirección del archivo dot
            String fileInputPath = "src/main/java/SIGUIENTES_202103718/" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "src/main/java/SIGUIENTES_202103718/" + nombre + ".jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    
    // METODOS PUBLICOS---------------------------------------------
    public void addElementH(String clave, String valor){
        String[] claves = clave.split(",");
        String[] valores = valor.split(",");
        
        agregar(claves, valores);
    }
    
    public void Graphviz(String nombre, String nomFile){
        String[] letras = nombre.split(",");
        String cadena = "";
        int i = 0;

        cadena += "digraph H {\n\n";
        cadena += "\tparent [\n";
        cadena += "\t\tshape=plaintext\n";
        cadena += "\t\tlabel=<\n";
        cadena += "\t\t\t<table border='1' cellborder='1'>\n";
        cadena += "\t\t\t\t<tr>\n";
        cadena += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" colspan = \"4\">HOJA</td>\n";
        cadena += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" colspan = \"" + String.valueOf(tabla.size()) + "\">Siguientes Posiciones </td>\n";
        cadena += "\t\t\t\t</tr>\n\n";

        for(Map.Entry<String, List<String>> mapa : tabla.entrySet()){
            cadena += "\t\t\t\t<tr>\n";
            cadena += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" colspan = \"3\">"+letras[i]+"</td>\n";
            cadena += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" >"+ mapa.getKey() +"</td>\n";
            cadena += "\t\t\t\t\t<td colspan = \""+ String.valueOf(tabla.size()) +"\">"+mapa.getValue()+"</td>\n";
            cadena += "\t\t\t\t</tr>\n\n";
            i++;
        }
        
        cadena += "\t\t\t</table>\n";
        cadena += "\t>];\n\n";
        cadena += "}";
        
        graficarF(nomFile, cadena);
    }
    
    public void limpiarMap(){
        tabla.clear();
    }
    
}
