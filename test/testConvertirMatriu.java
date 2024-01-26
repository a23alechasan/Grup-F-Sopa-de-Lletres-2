import static org.junit.jupiter.api.Assertions.*;

class testConvertirMatriu {

    @org.junit.jupiter.api.Test
    void testConvertirLletresMatriuLongitudExacta() {
        String lletres = "NASQYCCSOZMRWOIHZNFRZUIFEUWBYTPBFPCSFQQIPYTHONBGVIJPDDBTNEVWGGESOYPYTUFYUILECHAVVBZSHXTAJTDZXLYJAVAQ";
        char[][] resultado = SopaDeLLetres.convertirLletresMatriu(lletres);
        assertEquals(10, resultado.length);
        assertEquals(10, resultado[0].length);
    }
    /*Aquet test només comprova si el contingut de lletres es correcte, es a dir que sigui char*/
    @org.junit.jupiter.api.Test
    void testConvertirLletresMatriuCharCorrectes() {
        String lletres = "NASQYCCSOZMRWOIHZNFRZUIFEUWBYTPBFPCSFQQIPYTHONBGVIJPDDBTNEVWGGESOYPYTUFYUILECHAVVBZSHXTAJTDZXLYJAVAQ";
        char[][] resultado = SopaDeLLetres.convertirLletresMatriu(lletres);

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                assertEquals(lletres.charAt(f * 10 + c), resultado[f][c]);
            }
        }
    }
    /*El rquesit de 10*10 no es cumpleix perque no hi han 100 paraules*/
    @org.junit.jupiter.api.Test
    void testConvertirLletresMatriuRequesitNoCumplit() {
        String lletres = "NASQYCCSOZMRWOIHZNFRZUIFEUWBYTPBFPCSFQQIPYTHONBGVIJPDDBTNEVWGGESOYPYTUFYUILECHAVVBZSHXTAJTDZXLY";
        assertThrows(IndexOutOfBoundsException.class, () -> SopaDeLLetres.convertirLletresMatriu(lletres));
    }
}