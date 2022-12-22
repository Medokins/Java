public class MatrixGeneric<T> {
	private final Object[][] arr;
	private final int size;

	public MatrixGeneric(int N){
		size = N;
		arr = new Double[N][N];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = Math.random();
			}
		}
	}

	public Double getVal(int i, int j) {return (Double) arr[i][j];}
	public void setVal(int i, int j, double value) {arr[i][j] = value;}
	public int getSize() {return size;}

	public static MatrixGeneric<?> multiply(MatrixGeneric<?> A, MatrixGeneric<?> B) {
		int N = A.getSize();
		MatrixGeneric<?> result = new MatrixGeneric(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				double val = 0.0;
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
		for (int i = 0; i < getSize(); i++) {
			result.append("[");
			for (int j = 0; j < getSize(); j++) {
				result.append(getVal(i, j));
				if(j != size - 1){
					result.append(" ");
				}
			}
			result.append("]\n");
		}
		return result.toString();
	}

	public Double avg(){
		Double avg = 0.0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				avg += (Double) arr[i][j];
			}
		}
		return avg / (size*size);
	}

	public Double stdDeviation() {
		Double avg = avg();
		double sum = 0.0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += (Double) arr[i][j] - avg;
			}
		}
		return Math.sqrt((sum*sum) / (size*size));
	}
}