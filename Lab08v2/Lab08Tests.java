import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Lab08Tests {
    private final double eps = 1e-5;

    @Test
    public void TestFunkcja() {
        assertEquals(Funkcja.SIN.wartosc(Math.PI), 0, eps);
        assertEquals(Funkcja.ARCSIN.wartosc(0.5), Math.asin(0.5), eps);
        assertEquals(Funkcja.LN.wartosc(20), Math.log(20), eps);

        assertThrows(BladFunkcji.class, () -> {Funkcja.LN.wartosc(-1.0);});
    }
    @Test
    public void testPochodna1() {

        Pochodna pSIN = new Pochodna(Funkcja.SIN);
        Pochodna pASIN = new Pochodna(Funkcja.ARCSIN);

        assertEquals(pSIN.wartosc(1, Math.PI), -1.0, eps);
        //x / [sqrt(1 - x^2) * (1-x^2)]
        assertEquals(pASIN.wartosc(2, 0.5), 0.7698, eps);

        assertThrows(BladPochodnej.class, () -> {
            pSIN.wartosc(3, 10.0);
        });
    }
    @Test
    public void testPochodna2() {
        Pochodna pSIN = new Pochodna(Funkcja.SIN);
        double [] tab = new double[2];
        tab[0] = -1.0;
        tab[1] = 0.0;
        assertArrayEquals(pSIN.wartosc(1, Math.PI, Math.PI/2), tab, eps);
    }

    @Test
    public void testPochodna3() {
        // lambda
        Pochodna pSin = new Pochodna((x) -> {
            return Math.sin(x);
        });
        assertEquals(pSin.wartosc(1, Math.PI), -1.0, eps);

        // referencja do metody
        class Linear {
            public double linFunction(double x) {
                return 2 * x - 3.15;
            }
        }
        Linear linear = new Linear();
        Pochodna pLin = new Pochodna(linear::linFunction);
        assertEquals(pLin.wartosc(1, 10.0), 2.0, eps);
    }

    @Test
    public void testPlot(){
        Pochodna pSIN = new Pochodna(Funkcja.SIN);
        assertTrue(pSIN.plot(-Math.PI, Math.PI, 50));
    }
}