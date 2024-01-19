import java.util.Scanner;
public class SopaDeLLetres {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        char[][] SopaDeLetras= convertirMatriz();
    }




    /**
     * Scanner para que el usuario introduzca Su String donde aparezcan las palabras,
     * lo he convertido en una matriz para imprimirla por pantalla
     * @return null
     */
    public static char[][] convertirMatriz() {
        Scanner input=new Scanner(System.in);
        int posicion = 0;
        String StringNombre= input.nextLine();
        char[]sopa=StringNombre.toCharArray();
        char[][] matriz = new char[10][10];








        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                matriz[fila][col] = sopa[posicion];
                posicion++;
                System.out.print(matriz[fila][col]+" ");
            }
            System.out.println();
        }
        return null;




    }
}
