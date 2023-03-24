# MANUAL DE USUARIO 🕹️

## Introducción 📑
Con la finalidad de la implementación de el Método del Árbol y el Método de Thompson del curso Organización de Lenguajes y Compiladores 1 se llevó a cabo el programa denomidado REGEX, un intérprete de Expresiones regulares desarrollado por medio de jflex y cup que esta encargado de analizar un archivo de expresiones que definiran el patrón que se utilizará dentro del sistema para que reciba lexemas, se entiene que con la información de la expresión regular se tendrá lo necesario para la validación de los lexemas.

## Descripción 📄
* **Caracteres especiales:** Dentro del lenguaje pueden utilizarse estos caracateres especiales:

| Notación |          Definición        |
| ------ | ------ |
| \ n | Salto de llínea |
| \\' | Comilla Simple |
| \\" | Comilla Doble |  

* **Comentarios:** El lenguaje OLC perimitrá el uso de comentario de una o varias líneas.

| Tipo |          Notación        |
| ------ | ------ |
| Unlínea | Se debe de comenzar con "//" |
| Multilínea | Se debe de comenzar con "<!" y terminar con "!>" |  

* **Declaración de conjuntos:** Para la definición de conjuntos se utiliza la palabra reservada "CONJ". Un conjunto puede utilizarse dentro de una expresión regular, pero no en la definición de otro conjunto.
~
CONJ: nombre_conjunto -> notacion;
~
A continuación, algunas de las notaciones a utilizar para definirlos:

| Notación |          Definición        |
| ------ | ------ |
| a~c |		{a,b,c} |
| 0~6 | {0,1,2,3,4,5,6} |  
| 0,2,9,4 | {0,2,9,4} |  
|J,Y,L | {J,Y,L} |  
|!~& | Conjunto de signos entre ! y &. Nota: el rango válido será desde el ascii 32 hasta el 125 omitiendo los ascii de las letras y digitos. |  

* **Definición de expresiones regulares:** Las expresiones regulares establecen el patrón que se debe cumplir para representar un token, estas se reconocerán en notación polaca o también llamada prefija. 
~
Nombre_expresionR -> definir_expresion_regular_en_prefijo;
~
A continuación, se muestra la notación a utilizar.

| Notación |          Definición        |
| ------ | ------ |
| . a b |Concatenación |
| \| a b | Disyunción |  
| * a | 0 o más veces |  
|+ a| 1 o más veces |
|? a| 0 o una vez |

* **Definición de prueba de lexemas:** Para probar cada una de las expresiones regulares escritas anteriormente se coloca un lexema el cual se analizará y verificará si es válido o no es válido dependiendo con que expresión regular se evalue.
~
expresion_regular: "Este lexema se evaluara";
~
* *Ejemplo de la estructura básica de un archivo de entrada .OLC*
>{
>
>// Definición de conjuntos
>
>CONJ: letra -> a ~ z;  
>CONJ: digito -> 0 ~ 9;
>
>
>//Expresiones regulares
>
>ExpReg1 -> . {letra} * | "_" | {letra} {digito};  
>ExpresionReg2 -> . {digito} . "." + {digito};
>
>%%  
>%%
>
>//Prueba de expresiones regulares  
>ExpReg1: "primerLexemaCokoa";  
>ExpresionReg2: "34.44";
>
>}

## Aplicación 🔲
El programa cuenta con una vista gráfica la cual facilita la interacción entre el sistema y el usuario final para un mejor desempeño del mismo. Por medio de dicha interfaz, al usuario se le permite seleccionar de forma gráfica un archivo de entrada que contendrá el código a analizar. El usuario puede navegar por la aplicación seleccionando a través de botones la acción que desea realizar, si ocurre un error en el ingreso de datos el programa mostrará un listado de los errores cometidos durante la lectura.
* **Ventana inicial:** La ventana inicial cuenta con las opciones, guardar, guardar como, abrir archivo, crear archivo, salir, analizar y ver afd.



~~~
Universidad San Carlos de Guatemala 2023
Programador: Harry Aaron Gómez Sanic
Carné: 202103718
~~~