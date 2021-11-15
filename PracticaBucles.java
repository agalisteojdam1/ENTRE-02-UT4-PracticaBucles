import java.util.Random;
/**
 *    
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private static Random generador;

    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {
        int SumaImpar = 0;
        int maximoPar = Integer.MIN_VALUE;
        int sumaAleatorios = 0;
        int i = 0;
        int aleatorio = generador.nextInt(6001) - 1000;

        System.out.println("Nº máximo de aleatorios a generar " + n + "\no hasta que salga 0\n"); 

        while(i < n && aleatorio != 0){
            if(!esImpar(aleatorio)){
                if(aleatorio > maximoPar){
                    maximoPar = aleatorio;
                }
            }
            else{
                SumaImpar += aleatorio;
            }
            System.out.printf("%12d :" + "%5d",aleatorio, obtenerNumeroSinCeros(aleatorio));
            i++;
            if(i % 5 == 0){
                System.out.println();
            }

            sumaAleatorios += aleatorio;
            aleatorio = generador.nextInt(6001) - 1000;
        }

        double media = sumaAleatorios / i;

        System.out.println();
        System.out.printf("\n%25s" + "%10.2f","Media:", media);
        System.out.printf("\n%25s" + "%10d","Suma impares:",SumaImpar);
        if(maximoPar == Integer.MIN_VALUE){
            System.out.printf("\n%25s" + "%19s", "Máximo pares:"," No ha salido par");
        }
        else{
            System.out.printf("\n%25s" + "%10d","Máximo pares:", maximoPar);
        }
    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        return  numero % 2 != 0;
    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3
     *   
     *   
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int a = numero;
        int exponente = 0;
        int resultado = 0;

        while(a != 0){
            int cifra = a % 10;
            if(cifra == 0){
                a = a / 10;
            }
            else{
                int pot = (int)(Math.pow(10,exponente));
                resultado = resultado + cifra * pot;
                a = a / 10;
                exponente++; 
            }

        }

        return resultado;
    }

    /**
     *  Borrar la pantalla
     *
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  
     *  Hay que usar el método escribirCaracter()
     *  
     *  
     *   
     */
    public void escribirLetraN(int altura)    {

        for(int fila = 1; fila <= altura; fila++){
            escribirCaracter(CARACTER,1);
            escribirCaracter(ESPACIO, fila - 1);
            escribirCaracter(CARACTER,1);
            escribirCaracter(ESPACIO, altura - fila);
            escribirCaracter(CARACTER,1);
            System.out.println();

        }
    }

    /**
     *  escribe n veces el caracter  indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {

        for(int i = 1; i <= n; i++){
            System.out.printf("%-1s",caracter);
        }

    }
}
