package Analizador;

public class Analizador {
    public static void main(String[] args){
        generarCompilador();
    }
    
    private static void generarCompilador(){
        try {
            String ruta = "src/main/java/Analizador/";
            String opcFlex[] = {ruta + "Lexer.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "parser", ruta + "Sintactico.cup"};
            java_cup.Main.main(opcCUP);
            System.out.println("\n*** Resultados finales ***");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
