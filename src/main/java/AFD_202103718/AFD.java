package AFD_202103718;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AFD {
    private String nombre;
    private String estadoI;
    private List<String> estadosA;
    private Map<String, List<String[]>> transiciones;
    private Map<String, List<String>> conjuntos;
    
    public AFD(String nombre, String estadoI, List<String> estadosA, Map<String, List<String[]>> transiciones){
        this.nombre = nombre;
        this.estadoI = estadoI;
        this.estadosA = estadosA;
        this.transiciones = transiciones;
        this.conjuntos = conjuntos;
    }
    
    public Map<String, List<String>> getConjuntos() {
        return conjuntos;
    }
    
    public void setConjuntos(Map<String, List<String>> conjuntos) {
        this.conjuntos = conjuntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoI() {
        return estadoI;
    }

    public void setEstadoI(String estadoI) {
        this.estadoI = estadoI;
    }

    public List<String> getEstadosA() {
        return estadosA;
    }

    public void setEstadosA(List<String> estadosA) {
        this.estadosA = estadosA;
    }

    public Map<String, List<String[]>> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(Map<String, List<String[]>> transiciones) {
        this.transiciones = transiciones;
    }
    
    
    private void graficarF(String nombre, String graphviz){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src/main/java/AFD_202103718/" + nombre + ".dot");
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
            String fileInputPath = "src/main/java/AFD_202103718/" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "src/main/java/AFD_202103718/" + nombre + ".jpg";
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
    
    public void graphvizAFD(){
        String graphviz = "";//AGREGAR  COMA POR APARTE
        String especiales = " ,!,\\\",#,$,%,&,\\',(,),*,+,-,.,/,:,;,<,=,>,?,@,[,\\,],^,_,`,{,|},\\n";
        List<String> listaSimbolosEspeciales = Arrays.asList(especiales.split(","));
        // -----------------------------------------------GRAFICACIÓN-----------------------------------------------
        int contadorEstadoF = 0;
        graphviz += "digraph Patron{ \n\n    rankdir = LR\n    layout = dot\n    node[shape = circle, width = 1, height = 1]; \n    subgraph Cluster_A{ \n    label = \"Nombre:" + getNombre() + "\"   \n    fontcolor =\"black\" \n    fontsize = 30 \n    bgcolor =\"#F1DFB2\" \n";
            
        for(Map.Entry<String, List<String[]>> trans: getTransiciones().entrySet()){
            if(trans.getKey().equals("S0")){
                contadorEstadoF++;                    
                graphviz += "    nodeS0[label = \"S0\n(inicio)\" fontcolor = \"#000000\" fontsize = 20 fillcolor = \"#CFF7E7\" style = filled shape = cds]; \n";
                continue;
            }

            if(getEstadosA().contains(trans.getKey())){
                contadorEstadoF++;
                graphviz += "    node"+trans.getKey()+"[label = \""+ trans.getKey() +"\" fontcolor = \"#000000\" fontsize = 20 fillcolor = \"#D0F3E6\" style = filled shape = doublecircle]; \n";
                continue;
            }
                
            contadorEstadoF++;
            graphviz += "\tnode"+trans.getKey()+"[label = \""+ trans.getKey() +"\" fontcolor = \"#000000\" fontsize = 20 fillcolor = \"#CFF7E7\" style = filled]; \n";
        }


            // .....................CONEXION DE NODOS.......................|
        for(Map.Entry<String, List<String[]>> E_origen: getTransiciones().entrySet()){

            List<String[]> listEstado = getTransiciones().get(E_origen.getKey());
                            
            for(String[] elemento : listEstado){
                String simbolo = elemento[0];
                String E_destino = elemento[1];
                
                if(simbolo.equals("")){
                    continue;
                }
                
                if(listaSimbolosEspeciales.contains(simbolo)){
                    
                    if(simbolo.equals(" ")){
                        simbolo = "espacio";
                    }else if(simbolo.equals("\\\"")){
                        graphviz += "    node"+E_origen.getKey()+"->node"+E_destino+"[label = \"\\\\"+simbolo+"\"]\n";
                        continue;
                    }
                    
                    graphviz += "    node"+E_origen.getKey()+"->node"+E_destino+"[label = \"\\"+simbolo+"\"]\n";
                    continue;
                    
                }else if(simbolo.equals(",")){
                    graphviz += "    node"+E_origen.getKey()+"->node"+E_destino+"[label = \""+simbolo+"\"]\n";
                    continue;
                }
                
                graphviz += "    node"+E_origen.getKey()+"->node"+E_destino+"[label = "+simbolo+"]\n";
            }
        }

        graphviz += "\n    } \n\n}";       
        graficarF(getNombre(), graphviz);
        System.out.println("\n\n\n\n-----GRAPHVIZ-----\n");
        System.out.println(graphviz);
    }
}