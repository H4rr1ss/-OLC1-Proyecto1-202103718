package TRANSICIONES_202103718;
import java.util.List;

public class elementHash {
    public String simbolo;
    public List<String> siguientes;

    public elementHash(String simbolo, List<String> siguientes) {
        this.simbolo = simbolo;
        this.siguientes = siguientes;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public List<String> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(List<String> siguientes) {
        this.siguientes = siguientes;
    }
    
    
}
