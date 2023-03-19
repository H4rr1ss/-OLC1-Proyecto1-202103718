package AFD_202103718;
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