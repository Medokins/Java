import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Lab08g1Tests {

    private double eps = 0.7;

    @Test
    public void TestFunkcja() {

        assertEquals(Funkcja.SIN.wartosc(3.14), 0, eps);
        assertEquals(Funkcja.ARCSIN.wartosc(0.5), Math.asin(0.5), eps);
        assertEquals(Funkcja.LN.wartosc(20), Math.log(20), eps);

        assertThrows(BladFunkcji.class, () -> {
            Funkcja.LN.wartosc(-1.0);
        });

    }

    @Test
    public void testPochodna1() {

        Pochodna pSIN = new Pochodna(Funkcja.SIN);
        Pochodna pASIN = new Pochodna(Funkcja.ARCSIN);
        Pochodna pLN = new Pochodna(Funkcja.LN);

        assertEquals(pSIN.wartosc(1, 3.14), -1.0, eps);
        assertEquals(pASIN.wartosc(2, 0.5), 0.7698, eps);
        assertEquals(pLN.wartosc(2, 2.0), -0.25, eps);

        assertThrows(BladPochodnej.class, () -> {
            pSIN.wartosc(3, 10.0);
        });
    }

    @Test
    public void testPochodna2() {
        Pochodna pSIN = new Pochodna(Funkcja.SIN);
        assertEquals(pSIN.wartosc(1, 3.14, 3.14 / 2)[0], -1.0, eps);
    }

    @Test
    public void testPochodnaPlot() {
        Pochodna pSIN = new Pochodna(Funkcja.SIN);
        assertEquals(pSIN.plot(-3.14, 3.14), true);
    }
}