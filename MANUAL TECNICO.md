# MANUAL TÉCNICO 💻


## Descripción de la solución ⚙️ 

#### **ANALIZADOR[carpeta]**:
- ***Lexer.jflex***:  
Acá se realiza todo lo relacionado con el analisis léxico, se declaran los tokens y expresiones regulares que se utilizaran en el programa.

- ***Sintactico.cup***:  
Se declaran los terminales y no terminales que se utilizaran para la gramatica. La estructura inicial de la gramatica es  
LLAVE_A   
DEFCONJS = Define los conjuntos a utilizar.  
DEFER = Se definiran las ER con notación polaca.  
PORCENT PORCENT  
TESTER = Se probará una cadena con la ER.  
LLAVE_C

- ***Analizador.java***:  
Se crearán los archivos complemetarios para el análisis.

#### **AFD[carpeta]**:  
- ***AFD.java***:
Acá se crea el objeto afd y se crean los archivos de graphviz para mostrar el grafo de afd y afnd.

#### **SIGUIENTES[carpeta]**:
- ***tablaSig***:
Se realiza toda la lógica para la tabla de siguientes y la graficación. 

#### **TRANSICIONES[carpeta]**:
- ***elementHash***:
objeto que recibe los datos que vienen de la tabla de siguientes.  

- ***transicion***: objeto donde se almacenará toda la información sobre las transiciones.  

- ***dbTablaTransicion***: Se encuentra toda la lógica para realizar la tabla de transiciones y creación de archivo dot para la graficación.  


#### **INTERFAZ[carpeta]**:
- ***Menu.form***: Es el menú principal del programa donde tiene opciones de guardar, guardar como, abrir archivo, nuevo archivo y analizar archivo.

#### **ERRORES[carpeta]**:
- ***usoER***: Acá se encuentra el código para generar un archivo hmtl en el cual se mostrarán todos los errores léxicos que existan en cada archivo analizado.
___

## Requerimientos del Entorno de Desarrollo 🔧
* Lenguaje de programación: Java

* Versión de JDK: OpenJDK16U x64_windows hotspot_16.0.2_7

* Ambiente de desarrollo integrado (IDE): Apache NetBeans 14

* Version libreria CUP: java-cup-11b

* Version libreria JFLEX: jflex-1.7.0
___
## Métodos en el manejo de archivos en las diferentes DataBase

### [dbAFD] 📖
Estas son algunas de las funciones más importantes usadas en la base de datos de programa.

| Función                       |   Definición  |
| ------------------------------|:-------------:|
| `validarCadena`                         | Esta función tendrá como entrada una cadena y nombre del afd. Primero busca el afd con el que se realizara el análisis y luego empieza todo el proceso.      |
| `returnDatosInterfaz`             | retorna la lista de afd´s para que se pueda mostrar el la interefaz gráfica su información.      |
| `jsonSalida`             | recorrerá la lista e ira creando todos los archivos con extensión json.      |
| `cleanList` | eliminará todos los elementos de la lista de AFD luego de haber analizado un archivo en concreto.      |

### [dbTablaTransicion] 📖
Estas son las estructuras utilizadas para la realización de la primera fase.

| Método  | Definición |
| ------------- |:-------------:|
| `addDatosHash`       |Crea los objetos de tipo elementHash los cuales se analizarán para realizar la tabla de transiciones.      |
|     `SeleccionNodos`  | Inicio de proceso de análisis.      |
| `aceptacion`       | verificará si el estado que se esta creando es de aceptación.      |
| `nuevaListaNodos`    | Toma los nodos del simbolo de entrada y si se repite más de 2 veces, se unen los dos array.     |
| `eliminados`    | Luego que de analice un nodo de la tabla de siguientes, este se eliminará ya que no se usará de nuevo.     |
| `asignarTablaAzul`    | Esta es un HashMap auxiliar donde su función principal es almacenar a todos los nodos que seran analizados    |
| `asignarEstadoF`    | Verificará si su lista de nodos del estado que se esta evaluando ya existe, si existe ya la lista solo se copiará el último estado, si no existe se creará un estado nuevo.     |
| `rellenohashEvaluar`    |Esta función se utiliza cuando el HashMap tabla azul esta vácio, verificará si hay nodos que aún no se evaluan para rellenar de nuevo esta tabla auxiliar y volver a hacer todo el proceso de creacion de nuevos estados.  |
| `graficarF`    | Se recorrerá la lista de transiciones e ira graficando el grafo.    |
___

~~~
Universidad San Carlos de Guatemala 2023
Programador: Harry Aaron Gómez Sanic
Carné: 202103718
~~~