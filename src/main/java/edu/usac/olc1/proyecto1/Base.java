package edu.usac.olc1.proyecto1;
import AFD_202103718.*;
import Analizador.DefConjuntos;
import AFD_202103718.dbAFD;
import java.util.*;
import Interfaz.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import TRANSICIONES_202103718.*;

public class Base {

    private static List<String> iterator(Map<String, List<String>> conjuntos, String alfabeto){
        int ite = 0;
        for(Map.Entry<String, List<String>> c: conjuntos.entrySet()){
            if(alfabeto.equals(c.getKey())){
                return c.getValue();
            }
             ite++;
        }
        return null;
    }

    
    public static void SCanner(String cadena, AFD afd){
        
        String estado = afd.getEstadoI();
            for(char caracter: cadena.toCharArray()){

                boolean encontrado = false;

                for(String[] mapa : afd.getTransiciones().get(estado)){
                    String alfabeto = mapa[0];
                    String sig = mapa[1];

                    if(caracter != alfabeto.toCharArray()[0]){

                        // VERIFICARA SI EXISTE EN ALGUN CONJUNTO DEL HASH
                        boolean llaveExistente = afd.getConjuntos().containsKey(alfabeto);

                        if(llaveExistente){
                            List<String> arrayDeLlave = iterator(afd.getConjuntos(), alfabeto);

                            if(arrayDeLlave.contains(String.valueOf(caracter))){
                                estado = sig;
                                encontrado = true;
                                break;
                            }
                        }

                        continue;
                    }

                    estado = sig;
                    encontrado = true;
                    break;
                }

                if (!encontrado){
                    System.out.println("Caracter invalido <"+caracter+">, no se puede hacer una transicion.");
                    break;
                }
            }

            if(!afd.getEstadosA().contains(estado)){
                System.out.println("cadena invalida, no termina en el estado de aceptacion");
            }else{
                System.out.println("cadena valida");
            }
    } 
    
    public static void insert(Map<String, List<String[]>> map, String key, List<String[]> entrada){
        if (map.containsKey(key)){
            map.get(key).addAll(entrada);
        } else {
            map.put(key, entrada);
        }
    }
 
    public static void main(String[] args)
    {
        DefConjuntos conj = new DefConjuntos();
        
        //conj.asignacionConjuntos();
        
        
        
        
        
        /*Map<String, List<String[]>> transi = new HashMap<>();
        
        ////
        List<String[]> entrada0 = new ArrayList<String[]>();
        String[] data0 = {"minuscula", "S1"};
        String[] data01 = {"mayuscula", "S1"};
        entrada0.add(data0);
        entrada0.add(data01);
        transi.put("S0", entrada0);
        
        
        ////
        List<String[]> entrada1 = new ArrayList<String[]>();
        String[] data1 = {"minuscula", "S2"};
        String[] data11 = {"mayuscula", "S2"};
        String[] data12 = {"simbolos", "S2"};
        String[] data13 = {"numero", "S2"};
        entrada1.add(data1);
        entrada1.add(data11);
        entrada1.add(data12);
        entrada1.add(data13);
        transi.put("S1", entrada1);
        
        ////
        List<String[]> entrada2 = new ArrayList<String[]>();
        String[] data2 = {"minuscula", "S2"};
        String[] data21 = {"mayuscula", "S2"};
        String[] data22 = {"simbolos", "S2"};
        String[] data23 = {"numero", "S2"};
        String[] data24 = {"@", "S3"};
        entrada2.add(data2);
        entrada2.add(data21);
        entrada2.add(data22);
        entrada2.add(data23);
        entrada2.add(data24);
        transi.put("S2", entrada2);
        
        ////
        List<String[]> entrada3 = new ArrayList<String[]>();
        String[] data3 = {"minuscula", "S4"};
        String[] data31 = {"mayuscula", "S4"};
        entrada3.add(data3);
        entrada3.add(data31);
        transi.put("S3", entrada3);
        
        ////
        List<String[]> entrada4 = new ArrayList<String[]>();
        String[] data4 = {"minuscula", "S4"};
        String[] data41 = {"mayuscula", "S4"};
        String[] data42 = {".", "S5"};
        entrada4.add(data4);
        entrada4.add(data41);
        entrada4.add(data42);
        transi.put("S4", entrada4);
        
        ////
        List<String[]> entrada5 = new ArrayList<String[]>();
        String[] data5 = {"c", "S6"};
        entrada5.add(data5);
        transi.put("S5", entrada5);
        
        ////
        List<String[]> entrada6 = new ArrayList<String[]>();
        String[] data6 = {"o", "S7"};
        entrada6.add(data6);
        transi.put("S6", entrada6);
        
        List<String[]> entrada6_1 = new ArrayList<String[]>();
        String[] data6_1 = {"m", "S8"};
        entrada6_1.add(data6_1);
        insert(transi, "S7", entrada6_1);
        
        List<String[]> entrada6_2 = new ArrayList<String[]>();
        String[] data6_2 = {"", ""};
        entrada6_2.add(data6_2);
        insert(transi, "S8", entrada6_2);
        
        
        
        
        
        
        
        
        
        
        
        
        // CREACION DEL AFD
        List<String> estadosAceptacion = new ArrayList<String>();
        estadosAceptacion.add("S8");
        AFD afdI = new AFD("prueba", "S0", estadosAceptacion, transi);
        
        // AGRAGAR CONJUNTOS
        Map<String, List<String>> conjuntos = new HashMap<>();
        List<String> letra = new ArrayList<String>();
        letra.add("a");
        letra.add("b");
        letra.add("c");
        letra.add("d");
        letra.add("e");
        letra.add("f");
        letra.add("g");
        letra.add("h");
        letra.add("i");
        letra.add("j");
        letra.add("k");
        letra.add("l");
        letra.add("m");
        letra.add("n");
        letra.add("o");
        letra.add("p");
        letra.add("q");
        letra.add("r");
        letra.add("s");
        letra.add("t");
        letra.add("u");
        letra.add("v");
        letra.add("w");
        letra.add("x");
        letra.add("y");
        letra.add("z");
        
        List<String> digito = new ArrayList<String>();
        digito.add("0");
        digito.add("1");
        digito.add("2");
        digito.add("3");
        digito.add("4");
        digito.add("5");
        digito.add("6");
        digito.add("7");
        digito.add("8");
        digito.add("9");
        
        List<String> simbolos = new ArrayList<String>();
        simbolos.add("-");
        simbolos.add("_");
        
        String abcMayus = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z"; 
        List<String> lista_ABC = Arrays.asList(abcMayus.split(","));
        
        
        conjuntos.put("minuscula", letra);
        conjuntos.put("numero", digito);
        conjuntos.put("mayuscula", lista_ABC);
        conjuntos.put("simbolos", simbolos);
        
        afdI.setConjuntos(conjuntos);
        
        SCanner("lachalana666@ingusac.com", afdI);*/
        
        /*
        for(Map.Entry<String, List<String[]>> mapa : colors.){
            List<String[]> llave = mapa.getValue();
            String[] burbuja = llave.get(0);
            
            System.out.println(mapa.getKey()+" -> "+burbuja[0]+" = "+ burbuja[1]);
            
            
        }
        */
        
        
        
        
        
        


        // PRUEBAS PARA LA REALIZACION DE LA TABLA DE TRANSICIONES´
        
     //System.out.println("RESULTADO  " + ((Object)p10).getClass().getSimpleName());
        //-----------------------------------------------------------------------
        
        
        //objT.returnDatos();
   
       // System.out.println("");
        
        //objT.TablaTransiciones(PrimeroRaiz);
        
        

/*
System.out.println("RESULTADO  " + ((Object)parts).getClass().getSimpleName());
*/
        
        
        
        


    }
}



/*

// STRING OBJ->(STRING, LISTA)        
        List<String> p1 = new ArrayList<String>();
        p1.add("3");
        p1.add("4");
        p1.add("5");
        p1.add("6");
        List<String> p2 = new ArrayList<String>();
        p2.add("3");
        p2.add("4");
        p2.add("5");
        p2.add("6");
        List<String> p3 = new ArrayList<String>();
        p3.add("3");
        p3.add("4");
        p3.add("5");
        p3.add("6");
        p3.add("7");
        List<String> p4 = new ArrayList<String>();
        p4.add("3");
        p4.add("4");
        p4.add("5");
        p4.add("6");
        p4.add("7");
        List<String> p5 = new ArrayList<String>();
        p5.add("3");
        p5.add("4");
        p5.add("5");
        p5.add("6");
        p5.add("7");
        List<String> p6 = new ArrayList<String>();
        p6.add("3");
        p6.add("4");
        p6.add("5");
        p6.add("6");
        p6.add("7");
        List<String> p7 = new ArrayList<String>();
        p7.add("8");
        p7.add("9");
        List<String> p8 = new ArrayList<String>();
        p8.add("8");
        p8.add("9");
        p8.add("10");
        List<String> p9 = new ArrayList<String>();
        p9.add("8");
        p9.add("9");
        p9.add("10");
        List<String> p10 = new ArrayList<String>();
        p10.add("11");
        List<String> p11 = new ArrayList<String>();
        p11.add("12");
        List<String> p12 = new ArrayList<String>();
        p12.add("13");
        List<String> p13 = new ArrayList<String>();
        p13.add("14");
        List<String> p14 = new ArrayList<String>();
        p14.add("-");       
        
        elementHash e1 = new elementHash("minuscula", p1);
        elementHash e2 = new elementHash("mayuscula", p2);
        elementHash e3 = new elementHash("simbolos", p3);
        elementHash e4 = new elementHash("minuscula", p4);
        elementHash e5 = new elementHash("mayuscula", p5);
        elementHash e6 = new elementHash("numero", p6);
        elementHash e7 = new elementHash("@", p7);
        elementHash e8 = new elementHash("minuscula", p8);
        elementHash e9 = new elementHash("mayuscula", p9);
        elementHash e10 = new elementHash(".", p10);
        elementHash e11 = new elementHash("c", p11);
        elementHash e12 = new elementHash("o", p12);
        elementHash e13 = new elementHash("m", p13);
        elementHash e14 = new elementHash("#", p14);
        
        dbTablaTransicion objT = new dbTablaTransicion();
        objT.PROVISIONAL("1", e1);
        objT.PROVISIONAL("2", e2);
        objT.PROVISIONAL("3", e3);
        objT.PROVISIONAL("4", e4);
        objT.PROVISIONAL("5", e5);
        objT.PROVISIONAL("6", e6);
        objT.PROVISIONAL("7", e7);
        objT.PROVISIONAL("8", e8);
        objT.PROVISIONAL("9", e9);
        objT.PROVISIONAL("10", e10);
        objT.PROVISIONAL("11", e11);
        objT.PROVISIONAL("12", e12);
        objT.PROVISIONAL("13", e13);
        objT.PROVISIONAL("14", e14);

       
        



        //-----------------------------------------------------------------------
        
        String PrimeroRaiz = "1,2,";
        
        //objT.returnDatos();
        
        String hola = ",";
        
        String[] S0 = hola.split(",");
        System.out.println("");
        
        objT.TablaTransiciones(PrimeroRaiz);

*/

