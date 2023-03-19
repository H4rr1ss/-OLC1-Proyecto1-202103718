package TRANSICIONES_202103718;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class dbTablaTransicion {
    private HashMap<String, elementHash> tabla = new HashMap<>();       // TABLA GENERAL
    private Map<String, List<String>> transicionP = new HashMap<>();    // TABLA AZUL
    private List<transicion> listadoF = new ArrayList<transicion>();    // TRANSICIONES AFD
    private List<String> estadosA = new ArrayList<String>();
    private List<List<String>> evaluacionEstados = new ArrayList<List<String>>();
    private int indice = 0;
    private boolean llave = true;
    
    public void addDatosHash(String nodo, String simbolo, List<String> siguientes){
        elementHash obj = new elementHash(simbolo, siguientes);
        tabla.put(nodo, obj);
    }
    
    public void limipiarMap_t(){
        tabla.clear();
        transicionP.clear();
        listadoF.clear();
        estadosA.clear();
        evaluacionEstados.clear();
        this.indice = 0;
        this.llave = true;
    }
    
    // SOLO SERVIRA PARA REALIZAR LAS PRUEBAS DE ESTA CLASE
    public void PROVISIONAL(String nodo, elementHash objeto){
        tabla.put(nodo, objeto);
    }
    
    /*public void returnDatos(){
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            indice = 2;
            System.out.println(mapa.getKey()+" = "+ mapa.getValue().getSimbolo()+", "+mapa.getValue().getSiguientes());
        }
    }*/
    
    
    public void returnDatosFinales(){
        System.out.println("\n----------------------- TABLA DE TRANSICIONES-----------------------\n");
        for(transicion cadena :listadoF) {
            System.out.println("Tran["+cadena.getEstadoI()+", "+ cadena.getSimbolo()+"] = "+cadena.getSigEvaluar()+" = "+cadena.getEstadoF()+"("+cadena.isAcept()+")");
        }
    }
    

    
    
    
    
    // SE COMPARA EL HASH DE TRANSICIONES CON LA LISTA SIGUIENTE Y RETORMA EL ESTADOFINAL
    private String verificarExistSigPos(List<String> listaSig){
        if(transicionP.isEmpty()){
            return "";
        }
        
        for(Map.Entry<String, List<String>> tablaF : transicionP.entrySet()){
            
            boolean EstadoExistente = Objects.equals(listaSig, tablaF.getValue());
            
            if(EstadoExistente){
                return tablaF.getKey();
            }
            
        }
        return "";
    }
    
    // COLOCARA SI EL LISTADO DE NODOS CONTIENE EL NODO DE NUMERAL ENTONCES SERA ACEPTACION
    private Boolean aceptacion(List<String> listaSig, String estadoF, String estadoI){
        
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            if(!mapa.getValue().getSimbolo().equals("#")){
                continue;
            }
            
            //ME DEVUELVE EL NODO EN QUE SE ENCUENTRA "#"  estadosA
            for(String li: listaSig){
                if((!li.equals(mapa.getKey())) || estadosA.contains(estadoF)){
                    continue;
                }
                
                estadosA.add(estadoF);
            }
        }
        
        if(estadosA.contains(estadoI)){
            return true;
        }
        return false;
    }
    
    // TOMA LOS NODOS DEL SIMBOLO DE ENTRADA Y SI SE REPITE MAS DE 2 VECES, UNE ESE ARRAY
    private List<String> nuevaListaNodos(List<String> listaFinal, List<String> listaComparar){
        if(listaFinal.isEmpty()){
            for(int i = 0; i<listaComparar.size(); i++){
                listaFinal.add(listaComparar.get(i));
            }
            
        }else{
            for(int i = 0; i<listaComparar.size(); i++){
                int data = 0;
                
                for(int j = 0; j<listaFinal.size(); j++){
                    if(listaComparar.get(i).equals(listaFinal.get(j))){
                        data++;
                    }
                }
                
                if(data == 0){
                    listaFinal.add(listaComparar.get(i));
                }
            }
        }
        return listaFinal;
    }
    
    // ELIMINA LOS NODOS ANALIZADOS DE LA TABLA AZUL
    private void eliminados(String eliminar, Map<String, elementHash> hashEvaluar){
        String[] eliminados = eliminar.split(",");
        
        for(int i=0; i < eliminados.length; i++){
            hashEvaluar.remove(eliminados[i]);
        }
    }
    
    private void asignarTablaAzul(Map<String, elementHash> hashEvaluar, String[] S0){
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            for(int i = 0; i < S0.length; i++){
                if(S0[i].equals(mapa.getKey())){
                    // SE CREA UN NUEVO HASHMAP QUE REPRESENTA LA TABLA COLOR AZUL
                    hashEvaluar.put(S0[i], mapa.getValue());
                }
            }
        }
    }
    
    // VERIFICARA SI ESE ESTADO FINAL YA EXISTE ANTERIORMENTE, SI NO CREARÁ UNO NUEVO
    private String asignarEstadoF(String estado, String EstadoF, List<String> ListaSig){
        if (this.indice !=0){
            estado = verificarExistSigPos(ListaSig);// ACA IRA estadoF = [tablaSig]
        }
        
        if (estado.equals("")){
            EstadoF = "S"+String.valueOf(this.indice+1); 
            this.indice++;
            return EstadoF;
        }
        EstadoF = estado; 
        return EstadoF;
    }
    
    private boolean verificarRelleno(List<String> nodos){
        if (evaluacionEstados.isEmpty()){
            return false;
        }
        
        for(int i = 0; i < evaluacionEstados.size(); i++){
               
            boolean sonIguales = Objects.equals(evaluacionEstados.get(i), nodos);
                
            if (sonIguales){
                return true;
            }
        }
        return false;
    }
    
    private String nodoNumeral(){
        String numNodo = "";
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            if(mapa.getValue().getSimbolo().equals("#")){
                numNodo = mapa.getKey();
            }
        }
        return numNodo;
    }
    
    private void rellenohashEvaluar(Map<String, elementHash> hashEvaluar){
        
        String nodos = "";
        
        for(int i = 0; i< listadoF.size(); i++){
            
            if(!listadoF.get(i).isEvaluacion()){
                
                if (verificarRelleno(listadoF.get(i).getNodos())){
                    listadoF.get(i).setEvaluacion(true);
                    continue;
                }
                
                listadoF.get(i).setEvaluacion(true);
                evaluacionEstados.add(listadoF.get(i).getNodos());
                int numeral = 0;
                List<String> nodo = new ArrayList<String>();
                
                for(int j = 0; j < listadoF.get(i).getNodos().size(); j++){
                    
                    if (nodoNumeral().equals(listadoF.get(i).getNodos().get(j))){
                        numeral++;
                        nodo.add(listadoF.get(i).getNodos().get(j));
                        continue;
                    }
                    nodos += listadoF.get(i).getNodos().get(j) + ",";
                }
                
                String[] S0 = nodos.split(",");

                if(S0.length == 1 && S0[0].equals("") && numeral == 1){
                    String EstadoI = finalEstado();
                    transicion objTransiciones = new transicion(EstadoI, "", null, "", true);
                    objTransiciones.setSigEvaluar(nodo);
                    this.listadoF.add(objTransiciones); 
                }
                
                asignarTablaAzul(hashEvaluar,S0);
                return;
            }
        }
    }
    
    // COLOCA LA LISTA DE NODOS CON QUE SE EVALUA UN ESTADO -> S0[va a evaluar]
    private List<String> sigGraphviz(Map<String, elementHash> hashEvaluar){
        List<String> SigPorAnalizar = new ArrayList<String>();
        
        for(Map.Entry<String, elementHash> tablaAzul : hashEvaluar.entrySet()){
            SigPorAnalizar.add(tablaAzul.getKey());
        }
        return SigPorAnalizar;
    }
    
    
    
    
    
    
    
    // LOGICA FINAL PARA TABLA DE TRANSICIONES
    private void SeleccionNodos(String[] S0){//S0 = 1,2,3,4,5,6
        Map<String, elementHash> hashEvaluar = new HashMap<>();
        asignarTablaAzul(hashEvaluar, S0);
        int indiceI = 0;
        
        while(this.llave){
            
            for(Map.Entry<String, elementHash> mapaBase : tabla.entrySet()){
                
                if (hashEvaluar.isEmpty()){
                    break;
                }
                
                String NodosYaUtilizados_tablaAzul = "";
                boolean nodoEvaluar = false;
                List<String> ListaSig = new ArrayList<String>();
                List<String> listaF = new ArrayList<String>();
                
                for(Map.Entry<String, elementHash> mapAux : hashEvaluar.entrySet()){

                    if(mapaBase.getKey().equals(mapAux.getKey())){      
                        nodoEvaluar = true;
                        ListaSig = nuevaListaNodos(listaF, mapAux.getValue().getSiguientes());// ALMACENA LOS NUEVOS SIGPOS
                        NodosYaUtilizados_tablaAzul += mapAux.getKey()+",";
                    }
                }
                
                if (!nodoEvaluar){
                    continue;
                }
                
                List<String> SigPorAnalizar = new ArrayList<String>();
                SigPorAnalizar = sigGraphviz(hashEvaluar);
                eliminados(NodosYaUtilizados_tablaAzul, hashEvaluar);
                String EstadoF = "";
                String estado = "";
                
                EstadoF = asignarEstadoF(estado, EstadoF, ListaSig);
                String EstadoI = "S"+String.valueOf(indiceI); 
                String simbolo = mapaBase.getValue().getSimbolo();
                boolean acept = aceptacion(ListaSig, EstadoF, EstadoI);
                       
                transicionP.put(EstadoF, ListaSig);
                transicion objTransiciones = new transicion(EstadoI, simbolo, ListaSig, EstadoF, acept);
                objTransiciones.setSigEvaluar(SigPorAnalizar);
                this.listadoF.add(objTransiciones);
            }
            
            indiceI++;
            rellenohashEvaluar(hashEvaluar);
            
            if(hashEvaluar.isEmpty()){
                this.llave = false;
            }
        }
    }
    
    private String finalEstado(){
        String estado = "";
        int tamaño = this.listadoF.size()-1;
        for(int i = 0; i < this.listadoF.size(); i++){
            
            if(i != tamaño){
                continue;
            }
           
            estado = this.listadoF.get(i).getEstadoF();
        }
        
        return estado;
    }
        
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // ------------------------------------------- GRAPHVIZ -------------------------------------------
    
    //                              FUNCIONES EXTRA PARA LA CREACION DEL GRAFO 

    // DEVUELVE EL TAMAÑO QUE DEBE DE TENER LA FILA DE LA PALABRA "TERMINALES" EN EL GRAFO
    private int sizeEncabezado(){
        List<String> rep = new ArrayList<String>();
        
        for(Map.Entry<String, elementHash> t : tabla.entrySet()){
            if(rep.contains(t.getValue().getSimbolo())){
                continue;
            }
            rep.add(t.getValue().getSimbolo());
        }
        return rep.size();
    }
    
    // LLENADO DE FILAS DE CADA ESTADO INICIAL S0[a,b, ...] ------>
    private String llenadoDeFilas_Sn(String estadoI, List<String> terminales, List<String> saltar){
        String t = "";
        
        for(String terminal: terminales){
            if(terminal.equals("")){
                continue;
            }
            
            String agregado = busquedaDeTerminal(terminal, estadoI, saltar);
            
            if(agregado != ""){
                t += agregado;
                continue;
            }
            t += "\t\t\t\t\t<td>--</td>\n";
        }
        return t;
    }
    
    private String busquedaDeTerminal(String terminal, String estadoI, List<String> saltar){     
        String t = "";
        
        for(transicion tr: listadoF){
            
            if(saltar.contains(tr.getEstadoI())){
                continue;
            }
            
            if(tr.getEstadoI().equals(estadoI) && tr.getSimbolo().equals(terminal)){
                t += "\t\t\t\t\t<td>"+ tr.getEstadoF() +"</td>\n";
                break;
            }
            
            if(!tr.getEstadoI().equals(estadoI)){
                break;
            }
        }
        return t;
    }
    
    // CREACION DE ARCHIVO DOT E IMAGEN PNG ------>
    private void graficarF(String nombre, String graphviz){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src/main/java/TRANSICIONES_202103718/" + nombre + ".dot");
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
            String fileInputPath = "src/main/java/TRANSICIONES_202103718/" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "src/main/java/TRANSICIONES_202103718/" + nombre + ".jpg";
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
    
    // CREACION DEL ARCHIVO DOT ----------->
    private String graphviz(){
        List<String> repetidos = new ArrayList<String>();
        
        String t = "";

        t += "digraph H {\n\n";
        t += "\tparent [\n";
        t += "\t\tshape=plaintext\n";
        t += "\t\tlabel=<\n";
        t += "\t\t\t<table border='1' cellborder='1'>\n\n";

        t += "\t\t\t\t<tr>\n";
        t += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" colspan=\"1\" rowspan= \"2\">Estado</td>\n";
        t += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" colspan= \""+String.valueOf(sizeEncabezado()-1)+"\">Terminales</td>\n";
        t += "\t\t\t\t</tr>\n\n";

        // ***************************** COLOCACION DE LOS TERMINALES (FILA) *****************************
        t += "\t\t\t\t<tr>\n";
        
        List<String> terminales = new ArrayList<String>();
        terminales.add("");
        for(transicion objec :listadoF) {
            
            if(terminales.contains(objec.getSimbolo())){
                continue;
            }

            if(objec.getSimbolo().equals(" ")){
                t += "\t\t\t\t\t<td bgcolor = \"#F9D1E0\" >\" \"</td>\n";
                terminales.add(objec.getSimbolo());
                continue;
            }
            
            terminales.add(objec.getSimbolo());
            t += "\t\t\t\t\t<td bgcolor = \"#F9D1E0\" >"+ objec.getSimbolo() +"</td>\n";
        }
        t += "\t\t\t\t</tr>\n\n";//**********************************************************************
        
        // ************************* LLENADO DE TERMINALES CON SU ESTADO FINAL **************************
        List<String> veri = new ArrayList<String>();
        for(transicion objec1 :listadoF) {
            
            if(repetidos.contains(objec1.getEstadoI())){
                continue;
            }
            
            repetidos.add(objec1.getEstadoI());
            
            //ESTADO
            t += "\t\t\t\t<tr>\n";
            if(objec1.isAcept()){
                t += "\t\t\t\t\t<td>*"+ objec1.getEstadoI()+ objec1.getSigEvaluar() +"</td>\n";
            }else{
                t += "\t\t\t\t\t<td>"+ objec1.getEstadoI()+ objec1.getSigEvaluar() +"</td>\n";
            }
                        
            t += llenadoDeFilas_Sn(objec1.getEstadoI(), terminales, veri);
            veri.add(objec1.getEstadoI());
            
            t += "\t\t\t\t</tr>\n\n";
        }// **********************************************************************************************
        
        t += "\t\t\t</table>\n";
        t += "\t>];\n\n";

        t += "}";
        return t;
    }
    // -----------------------------------------FIN GRAPHVIZ-----------------------------------------------------
    
    private void insert(Map<String, List<String[]>> map, String key, List<String[]> entrada){
        if (map.containsKey(key)){
            map.get(key).addAll(entrada);
        } else {
            map.put(key, entrada);
        }
    }
    
    private void armadoTransiciones(Map<String, List<String[]>> transiciones, String estadoI){
        
        for(transicion tr: listadoF){
            
            if(!tr.getEstadoI().equals(estadoI) || tr.getNodos() == null){
                continue;
            }
            
            List<String[]> contenidoTransiones = new ArrayList<String[]>();
            String[] data = {tr.getSimbolo(), tr.getEstadoF()};
            contenidoTransiones.add(data);
            insert(transiciones, tr.getEstadoI(), contenidoTransiones);
        }
        
    }
    
    /*
        ESTA FUNCION RETORNARA UN HASH DE TRANSICIONES QUE
        SE DEBE INGRESAR EN EL OBJETO AFD
    */
    public Map<String, List<String[]>> modificacionTransiciones(){
        Map<String, List<String[]>> transiciones = new HashMap<>();
        List<String> estados = new ArrayList<String>();
        
        for(transicion t: listadoF){
            if(estados.contains(t.getEstadoI())){
                continue;
            }// [S0,S1,S2,S3,S4,S5,S6,S7,S8]
            estados.add(t.getEstadoI());
        }
        
        for(String estado: estados){
            armadoTransiciones(transiciones, estado);
        }
        
        return transiciones;
    }
    
    public List<String> estadosDeAceptacion(){
        List<String> estados = new ArrayList<String>();
        
        for(transicion tr: listadoF){
            if(tr.isAcept()){
                if(estados.contains(tr.getEstadoI())){
                    continue;
                }
                estados.add(tr.getEstadoI());
            }
        }
        
        return estados;
    }
    
    
    public void TablaTransiciones(String estadoI, String nombre){
        String[] S0 = estadoI.split(",");// {1,2,3,4,5,6}
        SeleccionNodos(S0);
        returnDatosFinales();
        graficarF(nombre, graphviz());
    }
}












