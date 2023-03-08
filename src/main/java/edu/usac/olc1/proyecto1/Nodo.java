package edu.usac.olc1.proyecto1;

public class Nodo {
    public Nodo hizq;
    public Nodo hder;
    public String valor;
    public int id;
    public int identificador;
    public String anulable;
    public String primero;
    public String ultimo;

    public Nodo(Nodo hizq, Nodo hder, String valor, int id, int identificador, String anulable, String primero, String ultimo) {
        this.hizq = hizq;
        this.hder = hder;
        this.valor = valor;
        this.id = id;
        this.identificador = identificador;
        this.anulable = anulable;
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public Nodo getHizq() {
        return hizq;
    }

    public void setHizq(Nodo hizq) {
        this.hizq = hizq;
    }

    public Nodo getHder() {
        return hder;
    }

    public void setHder(Nodo hder) {
        this.hder = hder;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdentificador(){
        return identificador;
    }
    
    public void setIdentificador(int identificador){
        this.identificador = identificador;
    }

    public String getAnulable() {
        return anulable;
    }

    public void setAnulable(String anulable) {
        this.anulable = anulable;
    }

    public String getPrimero() {
        return primero;
    }

    public void setPrimero(String primero) {
        this.primero = primero;
    }

    public String getUltimo() {
        return ultimo;
    }

    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }
        
    public String getCodigoInterno(){
        String etiqueta;
        if (hizq == null && hder == null){
            etiqueta = "nodo"+ id +"[ label = \"" + primero+"|{"+anulable+"|"+valor+"|"+identificador+"}|"+ultimo+"\"];\n";
            
        } else{
            if (valor.equals("|")){
                etiqueta = "nodo"+ id +"[ label = \"" + primero+"|{"+anulable+"|\\"+valor+"|"+identificador+"}|"+ultimo+"\"];\n";
            }else{
                etiqueta = "nodo"+ id +"[ label = \"" + primero+"|{"+anulable+"|"+valor+"|"+identificador+"}|"+ultimo+"\"];\n";
            }
        }
        if (hizq != null){
            etiqueta = etiqueta + hizq.getCodigoInterno()
                    + "nodo" + id + "->nodo"+hizq.id + "\n";
        }
        if (hder != null){
            etiqueta = etiqueta + hder.getCodigoInterno()
                    +"nodo"+id+"->nodo"+hder.id + "\n";
        }
        return etiqueta;
    }     
}
