import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class testBuscarPalabra {

    @org.junit.jupiter.api.Test
    void buscarPalabraParaulaExisteixoNo() {
        char[][] matriu = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };
        assertTrue(SopaDeLLetres.buscarPalabra(matriu, "abc"));
        assertTrue(SopaDeLLetres.buscarPalabra(matriu, "aeim"));
        assertTrue(SopaDeLLetres.buscarPalabra(matriu, "afk"));
        assertFalse(SopaDeLLetres.buscarPalabra(matriu, "eeee"));
        assertFalse(SopaDeLLetres.buscarPalabra(matriu, "xyz"));
    }
}