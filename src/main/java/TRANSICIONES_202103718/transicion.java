package TRANSICIONES_202103718;
import java.util.List;

public class transicion {
    public String estadoI;
    public String simbolo;
    public List<String> nodos;
    public String estadoF;
    public boolean acept;
    public boolean evaluacion = false;
    private List<String> sigEvaluar;

    public transicion(String estadoI, String simbolo, List<String> nodos, String estadoF, boolean acept) {
        this.estadoI = estadoI;
        this.simbolo = simbolo;
        this.nodos = nodos;
        this.estadoF = estadoF;
        this.acept = acept;
        this.evaluacion = evaluacion;
        this.sigEvaluar = sigEvaluar;
    }

    public List<String> getSigEvaluar() {
        return sigEvaluar;
    }

    public void setSigEvaluar(List<String> sigEvaluar) {
        this.sigEvaluar = sigEvaluar;
    }    
    
    public String getEstadoI() {
        return estadoI;
    }

    public void setEstadoI(String estadoI) {
        this.estadoI = estadoI;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public List<String> getNodos() {
        return nodos;
    }

    public void setNodos(List<String> nodos) {
        this.nodos = nodos;
    }

    public String getEstadoF() {
        return estadoF;
    }

    public void setEstadoF(String estadoF) {
        this.estadoF = estadoF;
    }

    public boolean isAcept() {
        return acept;
    }

    public void setAcept(boolean acept) {
        this.acept = acept;
    }

    public boolean isEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(boolean evaluacion) {
        this.evaluacion = evaluacion;
    }
    
   
}
