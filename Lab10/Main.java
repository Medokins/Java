public class Main {
	public static void main(String[] args) {
		System.out.println("######################## Matrix ########################");
		Matrix mat_A = new Matrix(2);
		Matrix mat_B = new Matrix(2);

		mat_A.setVal(0, 0, 1.0);
		mat_A.setVal(0, 1, 2.0);
		mat_A.setVal(1, 0, 3.0);
		mat_A.setVal(1, 1, 4.0);

		mat_B.setVal(0, 0, 4.0);
		mat_B.setVal(0, 1, 3.0);
		mat_B.setVal(1, 0, 2.0);
		mat_B.setVal(1, 1, 1.0);
//		System.out.println(mat_A);
//		System.out.println(mat_B);
		long start = System.currentTimeMillis();
		System.out.println("A * B\n" + Matrix.multiply(mat_A, mat_B));
		long finish = System.currentTimeMillis();
		System.out.println("Time elapsed multiply matrix double: " + (finish - start));

		System.out.println("Average = " + mat_A.avg());
		System.out.println("Std = " + mat_A.stdDeviation());

		System.out.println("######################## MatrixDouble ########################");

		MatrixDouble matD_A = new MatrixDouble(2);
		MatrixDouble matD_B = new MatrixDouble(2);

		matD_A.setVal(0, 0, 1.0);
		matD_A.setVal(0, 1, 2.0);
		matD_A.setVal(1, 0, 3.0);
		matD_A.setVal(1, 1, 4.0);
		matD_B.setVal(0, 0, 4.0);
		matD_B.setVal(0, 1, 3.0);
		matD_B.setVal(1, 0, 2.0);
		matD_B.setVal(1, 1, 1.0);
//		System.out.println(matD_A);
//		System.out.println(matD_B);
		start = System.currentTimeMillis();
		System.out.println("A * B\n" + MatrixDouble.multiply(matD_A, matD_B));
		finish = System.currentTimeMillis();
		System.out.println("Time elapsed multiply matrix Double: " + (finish - start));

		System.out.println("Average = " + matD_A.avg());
		System.out.println("Std = " + matD_A.stdDeviation());

		System.out.println("######################## MatrixGeneric ########################");

		MatrixGeneric<Double> matG_A = new MatrixGeneric<>(2);
		MatrixGeneric<Double> matG_B = new MatrixGeneric<>(2);

		matG_A.setVal(0, 0, 1.0);
		matG_A.setVal(0, 1, 2.0);
		matG_A.setVal(1, 0, 3.0);
		matG_A.setVal(1, 1, 4.0);

		matG_B.setVal(0, 0, 4.0);
		matG_B.setVal(0, 1, 3.0);
		matG_B.setVal(1, 0, 2.0);
		matG_B.setVal(1, 1, 1.0);
//		System.out.println(matG_A);
//		System.out.println(matG_B);
		start = System.currentTimeMillis();
		System.out.println("A * B\n" + MatrixGeneric.multiply(matG_A, matG_B));
		finish = System.currentTimeMillis();
		System.out.println("Time elapsed multiply matrix Generic: " + (finish - start));

		System.out.println("Average = " + matG_A.avg());
		System.out.println("Std = " + matG_A.stdDeviation());

		System.out.println("######################## Matrix Random ########################");
		Matrix matR = new Matrix(5);
		System.out.println(matR);
		System.out.println("Average = " + matR.avg());
		System.out.println("Std = " + matR.stdDeviation());

		Matrix A1 = new Matrix(500);
		Matrix B1 = new Matrix(500);
		start = System.currentTimeMillis();
		Matrix.multiply(A1, B1);
		finish = System.currentTimeMillis();
		System.out.println("Time elapsed multiply matrix 500x500: " + (finish - start));

		MatrixDouble A2 = new MatrixDouble(500);
		MatrixDouble B2 = new MatrixDouble(500);
		start = System.currentTimeMillis();
		MatrixDouble.multiply(A2, B2);
		finish = System.currentTimeMillis();
		System.out.println("Time elapsed multiply matrixDouble 500x500: " + (finish - start));

		MatrixGeneric<Double> A3 = new MatrixGeneric<>(500);
		MatrixGeneric<Double> B3 = new MatrixGeneric<>(500);
		start = System.currentTimeMillis();
		MatrixGeneric.multiply(A3, B3);
		finish = System.currentTimeMillis();
		System.out.println("Time elapsed multiply matrixGeneric 50x50: " + (finish - start));
	}
}