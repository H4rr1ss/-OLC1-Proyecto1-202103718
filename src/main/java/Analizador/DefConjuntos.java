package Analizador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DefConjuntos {
    
    /*
        VACIAR LAS VARIABLES GLOBALES CUANDO LLEGUE A LA RAIZ, YA QUE
        HABRÁ ACABADO EL ANALISIS Y 100% LO SIGUIENTE SERÁ OTRO ANALISIS
    */
    
    private HashMap<String, String> conjuntos = new HashMap<>();
    private HashMap<String, List<String>> conjFinal = new HashMap<>();
    
    public void add(String NombreConj, String notacion){     
        try{
            for (HashMap.Entry<String, String> entry : conjuntos.entrySet()){
                if(NombreConj.equals(entry.getKey())){
                    System.out.println("Este nombre de conjunto ya existe, <"+NombreConj+">");
                    return;
                }
            }
        }catch(Exception ex){
            System.out.println("Error al Definir un conjunto");
        }
        
        conjuntos.put(NombreConj, notacion);
        System.out.println("\nYa se agrego el conjunto correctamente."+ NombreConj+", "+notacion);
    }
    
    public void print(){
        System.out.println("-------------------------------");
        for (HashMap.Entry<String, String> entry : conjuntos.entrySet()){
            System.out.println("Conjunto: "+entry.getKey()+", Valor: "+entry.getValue());
        }
        System.out.println("\n");
    }
    
    public void printA(String entrada){
        System.out.println("AUXILIAR----\n"+entrada);
    }
    
    
    public HashMap<String, List<String>> DefinicionDeConjuntos(){ //  letras = a~z     0,1,2,2,3
        for (HashMap.Entry<String, String> conjunto : conjuntos.entrySet()){
            
            String notacion = conjunto.getValue();
            char opcion = notacion.charAt(1);
            List<String> lista = new ArrayList<String>();
            
            if(opcion == '~'){
                lista = asignacionConjuntos_rango(String.valueOf(notacion.charAt(0)), String.valueOf(notacion.charAt(2)));
            }else{
                lista = Arrays.asList(notacion.split(","));
            }
            
            conjFinal.put(conjunto.getKey(), lista);
        }
        System.out.println("\n--------------------------CONJUNTOS CARGADOS--------------------------\n"+conjFinal);
        return conjFinal;
    }
    // (\!|\"|\#|\$|\%|\&|\'|\(|\)|\)|\*|\+|\,|\-|\.|\/|\:|\;|\<|\=|\>|\?|\@|\[|\\|\]|\^|\_|\`|\{|\||\})
    // ( |\!|\"|\#|\$|\%|\&|\'|\(|\)|\)|\*|\+|\,|\-|\.|\/|\:|\;|\<|\=|\>|\?|\@|\[|\\|\]|\^|\_|\`|\{|\||\})
    //   CONJ: pepe -> \~|;
    
    private List<String> asignacionConjuntos_rango(String E_inicio, String E_final){
        String abcMinus = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z";
        String abcMayus = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z"; 
        String numeros = "0,1,2,3,4,5,6,7,8,9";// --->  " ' \  ---> \" \' \\
        String simbolos = " 1!1\"1#1$1%1&1'1(1)1*1+1,1-1.1/1:1;1<1=1>1?1@1[1\\1]1^1_1`1{1|1}";
        
        // SE DECLARAN LA LISTA DE LETRAS Y NUMEROS
        List<String> lista_abc = Arrays.asList(abcMinus.split(","));
        List<String> lista_ABC = Arrays.asList(abcMayus.split(","));
        List<String> lista_dig = Arrays.asList(numeros.split(","));
        List<String> lista_sim = Arrays.asList(simbolos.split("1"));
                
        // ESTA ES LA LISTA FINAL CON EL RANGO OBTENIDO
        List<String> nuevo = new ArrayList<String>();
        
        if(lista_abc.contains(E_inicio)){
            
            int iteI_abc = lista_abc.lastIndexOf(E_inicio);
            int iteF_abc = lista_abc.lastIndexOf(E_final);

            for(String abc: lista_abc){
                int actual_abc = lista_abc.lastIndexOf(abc);

                if(actual_abc >= iteI_abc && actual_abc <= iteF_abc){
                    nuevo.add(abc);
                }
            }
            
        }else if(lista_ABC.contains(E_inicio)){
            
            int iteI_ABC = lista_ABC.lastIndexOf(E_inicio);
            int iteF_ABC = lista_ABC.lastIndexOf(E_final);
            
            for(String abc: lista_ABC){
                int actual_ABC = lista_ABC.lastIndexOf(abc);

                if(actual_ABC >= iteI_ABC && actual_ABC <= iteF_ABC){
                    nuevo.add(abc);
                }
            }
            
        }else if(lista_dig.contains(E_inicio)){
            
            int iteI_dig = lista_dig.lastIndexOf(E_inicio);
            int iteF_dig = lista_dig.lastIndexOf(E_final);
            
            for(String abc: lista_dig){
                int actual_dig = lista_dig.lastIndexOf(abc);

                if(actual_dig >= iteI_dig && actual_dig <= iteF_dig){
                    nuevo.add(abc);
                }
            }
            
        }else if(lista_sim.contains(E_inicio)){
            
            int iteI_sim = lista_sim.lastIndexOf(E_inicio);
            int iteF_sim = lista_sim.lastIndexOf(E_final);
            
            for(String abc: lista_sim){
                int actual_sim = lista_sim.lastIndexOf(abc);

                if(actual_sim >= iteI_sim && actual_sim <= iteF_sim){
                    nuevo.add(abc);
                }
            }
        }
        
        
        return nuevo;
        
    }
    
    
    
    
    
    
}
