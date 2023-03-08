package ERRORES_202103718;
import java.io.*;

public class usoER {
    int _num;
    String _tipoErr;
    String _descripcion;
    int _linea;
    int _columna;

    public usoER(int _num, String _tipoErr, String _descripcion, int _linea, int _columna) {
        this._num = _num;
        this._tipoErr = _tipoErr;
        this._descripcion = _descripcion;
        this._linea = _linea;
        this._columna = _columna;
    }

    
    
    public int getNum(){
        return this._num;
    }
    
    public String getTipoError(){
        return this._tipoErr;
    }
    
    public String getDescipcion(){
        return this._descripcion;
    }
    
    public String getLinea(){
        String str_x = String.valueOf(this._linea);
        return str_x;
    }
    
    public String getColumna(){
        String str_x = String.valueOf(this._columna);
        return str_x;
    }
    

    
    
    
    public void TablaDeErrores(String cadenaErrores){
        String ValoresIniciales = "    <table border=\"2\" cellpadding =\"0\" cellspacing =\"0\" BorderColor =\"#000000\">\n"
  	        +	"    <tr>\n"
        +			"        <th scope=\"col\">No.</th>\n"
        +			"        <th scope=\"col\">Tipo de Error</th>\n"
        +			"        <th scope=\"col\">Descripcion</th>\n"
        +			"        <th scope=\"col\">Linea</th>\n"
        +			"        <th scope=\"col\">Columna</th>\n"
            +	"    </tr>\n"   
            +	cadenaErrores;
            

        String htmlOut = "<!DOCTYPE html>\n" 
        +"<html>\n"     
        +"<head>\n"
        +"    <title>Reporte</title>\n"
        +"    <meta charset= \"utf-8\"/>\n"
        +"    <link rel=\"stylesheet\" href=\"C:\\Users\\harry\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1\\src\\main\\java\\ERRORES_202103718\\stylesERRORES.css\"/>\n"
        +"</head>\n"
        +"<body>\n"
        +"    <header>\n"
        +"        <h1>Reporte de errores</h1>\n"
        +"        <p>202103718</p>\n"
        +"    </header>\n"
        +       ValoresIniciales
        +"</table>\n"
        +"</body>\n"
        +"</html>";

        File archivo = new File("C:\\Users\\harry\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1\\src\\main\\java\\ERRORES_202103718\\ERRORES.html");
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(htmlOut);
            salida.close();
            System.out.println("Se escribio el archivo correctamente");
        } catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
}
