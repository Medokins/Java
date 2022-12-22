import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab10Tests{
	final double eps = 1e-12;

	@Test
	public void mulitplyTest3x3()
	{
		Matrix A = new Matrix(3);
		Matrix B = new Matrix(3);

		A.setVal(0, 0, 1.0);
		A.setVal(0, 1, 2.0);
		A.setVal(0, 2, 3.0);
		A.setVal(1, 0, 3.0);
		A.setVal(1, 1, 2.0);
		A.setVal(1, 2, 1.0);
		A.setVal(2, 0, 1.0);
		A.setVal(2, 1, 2.0);
		A.setVal(2, 2, 3.0);

		B.setVal(0, 0, 4.0);
		B.setVal(0, 1, 5.0);
		B.setVal(0, 2, 6.0);
		B.setVal(1, 0, 6.0);
		B.setVal(1, 1, 5.0);
		B.setVal(1, 2, 4.0);
		B.setVal(2, 0, 4.0);
		B.setVal(2, 1, 6.0);
		B.setVal(2, 2, 5.0);

		Matrix result = Matrix.multiply(A, B);
		double[][] expected = {{28, 33, 29}, {28, 31, 31}, {28, 33, 29}};
		for (int i = 0; i < A.getSize(); i++) {
			for (int j = 0; j < A.getSize(); j++) {
				assertEquals(expected[i][j], result.getVal(i, j), eps);
			}
		}
	}
	@Test
	public void mulitplyTest4x4() {
		Matrix A = new Matrix(4);
		Matrix B = new Matrix(4);

		A.setVal(0, 0, 1.0);
		A.setVal(0, 1, 2.0);
		A.setVal(0, 2, 3.0);
		A.setVal(0, 3, 3.0);

		A.setVal(1, 0, 4.0);
		A.setVal(1, 1, 3.0);
		A.setVal(1, 2, 2.0);
		A.setVal(1, 3, 1.0);

		A.setVal(2, 0, 1.0);
		A.setVal(2, 1, 2.0);
		A.setVal(2, 2, 3.0);
		A.setVal(2, 3, 4.0);

		A.setVal(3, 0, 1.0);
		A.setVal(3, 1, 2.0);
		A.setVal(3, 2, 3.0);
		A.setVal(3, 3, 4.0);

		B.setVal(0, 0, 4.0);
		B.setVal(0, 1, 5.0);
		B.setVal(0, 2, 6.0);
		B.setVal(0, 3, 7.0);

		B.setVal(1, 0, 7.0);
		B.setVal(1, 1, 6.0);
		B.setVal(1, 2, 5.0);
		B.setVal(1, 3, 4.0);

		B.setVal(2, 0, 4.0);
		B.setVal(2, 1, 6.0);
		B.setVal(2, 2, 5.0);
		B.setVal(2, 3, 7.0);

		B.setVal(3, 0, 4.0);
		B.setVal(3, 1, 6.0);
		B.setVal(3, 2, 5.0);
		B.setVal(3, 3, 7.0);

		Matrix result = Matrix.multiply(A, B);
		double[][] expected = {{42, 53, 46, 57}, {49, 56, 54, 61},
				               {46, 59, 51, 64}, {46, 59, 51, 64}};
		for (int i = 0; i < A.getSize(); i++) {
			for (int j = 0; j < A.getSize(); j++) {
				assertEquals(expected[i][j], result.getVal(i, j), eps);
			}
		}
	}
}