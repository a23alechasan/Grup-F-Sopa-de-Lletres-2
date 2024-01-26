import java.util.Scanner;

public class SopaDeLLetres {
    public static void main(String[] args){
        System.out.println("Sisplau, introdueix les lletres de la sopa de lletres");
        int paraulesContades = 0;
        String lletres = demanarLletres();
        //char[][] matriu = lletresAMatriu(lletres);
        //imprimirMatriu(lletres);
        while (paraulesContades < 5) {
            System.out.println("Introdueix una paraula per comprovar si existeix.");
            String paraula = solicitarParaula();
            char[] lletresParaula = separarParaula(paraula);
            while (!esValida(lletresParaula)){
                System.out.println("Sisplau, introdueix una paraula vàlida.");
                paraula = solicitarParaula();
                lletrdetectarHoritzontalesParaula = separarParaula(paraula);
            }
            //detectarHoritzontal(matriu, lletresParaula);
            //detectarVertical(matriu, lletresParaula);
            //if (coordenades[0][0] != void){
            //pintarParaules(coordenades[0[0], coordenades[1][1]);
            //imprimirMatriu(matriu);
            paraulesContades++;
            //} else {
            //imprimirMatriu(matriu);
            //}
            //}
        }
    }
    /**
     * Request a String to check if there are 100 letters.
     * @return letters to the function convertirLletresMatriu
     */

    private static char[][] demanarLletres() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dona 100 lletres seguides per començar el joc:");
        String lletres = input.nextLine();
        for(int i = 0; i < 100; i++) {
            if (lletres.length() != 100) {
                System.out.println("No hi han 100 lletres, torna a provar");
                lletres = input.nextLine();
            }
        }
        return convertirLletresMatriu(lletres);
    }
    /**
     * Convert and separate the 100 letters in a 10*10 matrix
     * @param lletres String where the 100 letters are saved
     * @return matriu Final result of the converted matriu
     */

    public static char[][] convertirLletresMatriu(String lletres) {
        char[][] matriu = new char[10][10];
        int index = 0;

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                matriu[f][c] = lletres.charAt(index++);
            }
        }
        return matriu;
    }
    /**
     * Show the matrix in the sceen
     * @param matriu char to show
     */
    public static void mostrarMatriu(char[][] matriu) {
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                System.out.print(matriu[f][c] + " ");
            }
            System.out.println();
        }
    }

    public static String solicitarParaula(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public static char[] separarParaula(String paraula){
        char[] lletresParaula;
        lletresParaula = paraula.toCharArray();
        return lletresParaula;
    }
    public  static boolean esValida(char[] lletres){
        return lletres.length >= 3 && lletres.length <= 10;
    }
    public static void detectarHoritzontal(char[][] matriu, char[] lletresParaula){
        for (int x = 0; x < matriu.length; x++){
            for (int y = 0; y < matriu.length; y++){
                if (matriu[x][y] == lletresParaula[0]){
                    for (int i = 0; )
                }
            }
        }
    }
}
