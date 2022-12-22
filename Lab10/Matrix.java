public class Matrix
{
	private final double[][] arr;
	private final int size;

	public Matrix(int N) {
		size = N;
		arr = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = Math.random();
			}
		}
	}

	public double getVal(int i, int j) {return arr[i][j];}
	public void setVal(int i, int j, double value) {arr[i][j] = value;}
	public int getSize() {return size;}

	public static Matrix multiply(Matrix A, Matrix B) {
		int N = A.getSize();
		Matrix result = new Matrix(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				double val = 0;
				for (int k = 0; k < N; k++) {
					val += A.getVal(i, k) * B.getVal(k, j);
				}
				result.setVal(i, j, val);
			}
		}
		return result;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < size; i++) {
			result.append("[");
			for (int j = 0; j < size; j++) {
				result.append(arr[i][j]);
				if(j != size - 1){
					result.append(" ");
				}
			}
			result.append("]\n");
		}
		return result.toString();
	}

	public double avg(){
		double avg = 0.0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				avg += arr[i][j];
			}
		}
		return avg / (size*size);
	}

	public double stdDeviation() {
		double avg = avg();
		double sum = 0.0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += arr[i][j] - avg;
			}
		}
		return Math.sqrt((sum*sum) / (size*size));
	}
}