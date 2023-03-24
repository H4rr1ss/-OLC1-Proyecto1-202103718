package AFD_202103718;
import edu.usac.olc1.proyecto1.Nodo;
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
    
    private Boolean nohijos(Nodo nodo){
        
        if(nodo.getHder() == null && nodo.getHizq() == null){
            return true;
        }
        return false;
        
    }
    
    int cont = 0;
    private String GraficaANDF(Nodo nodo){
        
        String etiqueta = "";
        var arraylex = nodo.getValor().toCharArray();
        
        if(nodo.getHizq() == null && nodo.getHder() == null){
            if(arraylex[0] == '\\'){
                etiqueta += "[label = \"\\"+nodo.getValor()+"\"]";
            }
            else if(arraylex[0] == '\"'){
                etiqueta += "[label = \"\\"+arraylex[0]+arraylex[1]+"\\"+arraylex[2]+"\"]";
            }
            else{
                etiqueta += "[label = \""+nodo.getValor()+"\"]";
            }
        }else{
            if(arraylex[0] == '.'){
                if(nohijos((Nodo) nodo.getHizq())){
                    etiqueta += "\nS"+cont+" -> S"+(++cont)+GraficaANDF((Nodo) nodo.getHizq());
                }else{
                    etiqueta += GraficaANDF((Nodo) nodo.getHizq());
                }
                
                if(nohijos((Nodo) nodo.getHder())){
                    etiqueta += "\nS"+cont+" -> S"+(++cont)+GraficaANDF((Nodo) nodo.getHder());
                }else{
                    etiqueta += GraficaANDF((Nodo) nodo.getHder());
                }
            }
            else if(arraylex[0] == '|'){   
                var contor = cont;             
                etiqueta += "\nS" + contor + " -> S" + (++cont) + "[label=\"e\"]";
                if(nohijos((Nodo) nodo.getHizq())){
                    etiqueta += "\nS" + cont + " -> S" + (++cont) + GraficaANDF((Nodo)nodo.getHizq());
                }
                else{
                    etiqueta += GraficaANDF((Nodo) nodo.getHizq());
                }
                var contfinal = cont;
                etiqueta += "\nS" + contor + " -> S" + (++cont) + "[label=\"e\"]";
                if(nohijos((Nodo) nodo.getHder())){
                    etiqueta += "\nS" + cont + " -> S" + (++cont) + GraficaANDF((Nodo)nodo.getHder());
                }
                else{
                    etiqueta += GraficaANDF((Nodo) nodo.getHder());
                }
                etiqueta += "\nS" + cont + " -> S" + (++cont) + "[label=\"e\"]";

                etiqueta += "\nS" + contfinal + " -> S" + cont + "[label=\"e\"]";
            }
            else if(arraylex[0] == '*'){
                var contcom = cont;
                etiqueta += "\nS" + contcom + " -> S" + (++cont) + "[label=\"e\"]";
                var contini = cont;
                if(nohijos((Nodo) nodo.getHizq())){
                    etiqueta += "\nS" + cont + " -> S" + (++cont) + GraficaANDF((Nodo)nodo.getHizq());
                }
                else{
                    etiqueta += GraficaANDF((Nodo) nodo.getHizq());
                }
                etiqueta += "\nS" + cont + " -> S" + contini + "[label=\"e\"]";
                etiqueta += "\nS" + cont + " -> S" + (++cont) + "[label=\"e\"]";
                etiqueta += "\nS" + contcom + " -> S" + cont + "[label=\"e\"]";
            }
            else if(arraylex[0] == '+'){
                etiqueta += "\nS" + cont + " -> S" + (++cont) + "[label=\"e\"]";
                var contini = cont;
                if(nohijos((Nodo)nodo.getHizq())){
                    etiqueta += "\nS" + cont + " -> S" + (++cont) + GraficaANDF((Nodo)nodo.getHizq());
                }
                else{
                    etiqueta += GraficaANDF((Nodo) nodo.getHizq());
                }
                etiqueta += "\nS" + cont + " -> S" + contini + "[label=\"e\"]";
                etiqueta += "\nS" + cont + " -> S" + (++cont) + "[label=\"e\"]";
            }
            else if(arraylex[0] == '?'){
                var contcou = cont;
                etiqueta += "\nS" + contcou + " -> S" + (++cont) + "[label=\"e\"]";
                if(nohijos((Nodo)nodo.getHizq())){
                    etiqueta += "\nS" + cont + " -> S" + (++cont) + GraficaANDF((Nodo) nodo.getHizq());
                }
                else{
                    etiqueta += GraficaANDF((Nodo) nodo.getHizq());
                }
                etiqueta += "\nS" + cont + " -> S" + (++cont) + "[label=\"e\"]";
                etiqueta += "\nS" + contcou + " -> S"+ cont + "[label=\"e\"]";
            }
            
        }
        return etiqueta;
    }
    
    
    private String graficarAFND(Nodo nodo){
        String grafica2 = "digraph G {\n rankdir=\"LR\" \n" + GraficaANDF((Nodo) nodo.getHizq()) + "\nS" + cont + "[shape = doublecircle]; \n}";
        return grafica2;
    }
    
    public void graficar_AFND(String nombre, Nodo nodo){
        String entrada = graficarAFND(nodo);
        
        graphviz_AFND(nombre, entrada);
    }
    
    private void graphviz_AFND(String nombre, String graphviz){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src/main/java/AFND_202103718/" + nombre + ".dot");
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
            String fileInputPath = "src/main/java/AFND_202103718/" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "src/main/java/AFND_202103718/" + nombre + ".jpg";
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
    
    
}




