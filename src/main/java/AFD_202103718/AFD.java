package AFD_202103718;
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
    
    private String recorrido(List<String[]> value, List<String> estadosA){
        
        for(String[] nodos: value){
            if(estadosA.contains(nodos[1])){
                return nodos[1];
            }
        }
        return "";
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
            
            /*String f = recorrido(trans.getValue(), getEstadosA());
            
            if(!f.equals("")){
                graphviz += "    node"+f+"[label = \""+f+"\" fontcolor = \"#000000\" fontsize = 20 fillcolor = \"#D0F3E6\" style = filled shape = doublecircle]; \n";
                continue;
            }*/
                
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
        
        
        System.out.println("\n\n\n\n-----GRAPHVIZ-----\n");
        System.out.println(graphviz);
    }
}

/*

String prim = IDS+"";
            String ult = IDS+"";
            String prime;
            String ulti;
            Nodo nuevofinal = new Nodo(null, null, "#", parser.cont, parser.IDS, "N", prim, ult);
            parser.objSig.addElementH(nuevofinal.getPrimero(), "-");

            parser.cont++;
            if (valor.getAnulable().equals("A")){
                prime = valor.getPrimero() + ult;
            }else{
                prime = valor.getPrimero();
            }
            ulti = nuevofinal.getUltimo();
            Nodo nuevaraiz = new Nodo(valor, nuevofinal, ".", parser.cont, 0, "N", prime,ulti);
            parser.Raiz = nuevaraiz;
            graficarArbol(nuevaraiz, nombre);
            IDS = 1;

            //TABLA DE SIGUIENTES------------------------------>
            parser.objSig.addElementH(nuevaraiz.getHizq().getUltimo(), nuevaraiz.getHder().getPrimero());
            cadenaERnombre += "#,";
            System.out.println("ABAJO: "+cadenaERnombre);
            parser.objSig.Graphviz(cadenaERnombre, nombre);
            //------------------------------------------------->

            //TABLA DE TRANSICIONES---------------------------->
            dbTablaTransicion TT = new dbTablaTransicion();
            parser.objSig.asignacionTablaTransiciones(TT, cadenaERnombre);
            TT.TablaTransiciones(nuevaraiz.getPrimero(), nombre);
            //------------------------------------------------->

            //CREACION OBJ AFD--------------------------------->
            List<String> statusA =  TT.estadosDeAceptacion();
            Map<String, List<String[]>> transitions = TT.modificacionTransiciones();
            HashMap<String, List<String>> conjunts = parser.defC.DefinicionDeConjuntos();
            AFD objAFD = new AFD(nombre, "S0", statusA, transitions);
            objAFD.setConjuntos(conjunts);
            dbAFD.InsertAFD(objAFD);
            //-------------------------------------------------->
            
            //-----------------REINICIO DE VARIABLES-----------------
            //SIGUIENTES
            cadenaERnombre = "";
            parser.objSig.limpiarMap();
            //TRANSICIONES
            TT.limipiarMap_t();

*/