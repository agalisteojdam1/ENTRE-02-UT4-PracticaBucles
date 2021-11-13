import java.util.Scanner;

/**
 * Incluye todo el código dentro del main()
 * No declares ningún nuevo método en esta clase ni atributos
 *  
 */
public class TestPracticaBucles
{

    /**
     *  Punto de entrada a la aplicación
     *  - define y crea el teclado  
     *  - define e instancia un objeto PracticaBucles
     *  - pide al usuario la cantidad máxima de aleatorios a generar
     *    (valida que sea  un nº positivo)
     *  - muestra las estadísticas de números aleatorios
     *  - haz una pausa y borra la pantalla    
     *  
     *  - pide al usuario un valor para la altura de la letra N -
     *          Valida que este valor es correcto, es decir,
     *          está en el intervalo 3 <= altura <= 10
     *  - muestra la letra N
     *  
     */
    public static void main(String[] args)    {
        Scanner teclado = new Scanner(System.in);
        PracticaBucles bucle = new PracticaBucles();
        
        System.out.print("Dame nº máximo de aleatorios a generar (n > 0): ");
        int aleatorios = teclado.nextInt();
        while(aleatorios <= 0){
            System.out.print("Dame nº máximo de aleatorios a generar: ");
            aleatorios = teclado.nextInt();
        }
        bucle.generarNumeros(aleatorios);
        
        Utilidades.hacerPausa();
        Utilidades.borrarPantalla();
        
        System.out.print("Teclea altura de la letra N(3 <= altura <= 10): "); 
        int altura = teclado.nextInt();
        while(altura < 3 || altura > 10){
            System.out.print("Altura incorrecta, teclea altura de la letra N (3 <= altura <= 10): ");
            altura = teclado.nextInt();
        }
        bucle.escribirLetraN(altura);
    }
}

