import java.util.Scanner;

public class SopaDeLLetres {
    public static void main(String[] args){
        System.out.println("Sisplau, introdueix les lletres de la sopa de lletres");
        int paraulesContades = 0;
        //String lletres = demanarLletres();
        //char[][] matriu = lletresAMatriu(lletres);
        //imprimirMatriu(lletres);
        while (paraulesContades < 5) {
            System.out.println("Introdueix una paraula per comprovar si existeix.");
            String paraula = solicitarParaula();
            char[] lletresParaula = separarParaula(paraula);
            while (!esValida(lletresParaula)){
                System.out.println("Sisplau, introdueix una paraula vàlida.");
                paraula = solicitarParaula();
                lletresParaula = separarParaula(paraula);
            }
            //int[][] coordenades = detectarHoritzontal(matriu, lletresParaula);
            //int[][] coordenades = detectarVertical(matriu, lletresParaula);
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
    public static int[][] detectarHoritzontal(char[][] sopa, char[] paraula){
        int[][] coordenades = new int[1][1];
        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                int contador = 0;
                if (sopa[x][y] == paraula[0]){
                    for (int i = paraula.length; i > 0; i--){
                        if (sopa[x+i][y] == paraula[i-1]){
                            contador++;
                        }
                        else {
                            break;
                        }
                    }
                    if (contador == paraula.length){
                        coordenades[0][0] = sopa[x][y];
                        coordenades[1][1] = sopa[x+paraula.length][y];
                    }
                }
            }
        }
        return coordenades;
    }
}
