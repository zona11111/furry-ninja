package widgets.regres;

import stat.StatTables;

/**
 * @author sanbok
 */
// instanceVariableNames: 'matrix p n factorArray avrg avrgArray doverArray
// dArray dExpr dFactor dAdequat '
public abstract class RegresTesters {// implements CalcParam{
	private double[][] matrix;

	protected double[] factorArray;

	private int p;

	protected int n;

	protected double[] avrgArray, dArray;

	protected double[] doverArray;

	protected double dExpr;

	private double avrg;

	private double dFactor;

	private double dAdequat;

	protected abstract void calculateParameters();

	public abstract double f(double arg0);

	public double getAvrg() {
		return avrg;
	}

	public double[] getAvrgArray() {
		return avrgArray;
	}

	public double[] getDArray() {
		return dArray;
	}

	public double getDExpr() {
		return dExpr;
	}

	public double getDFactor() {
		return dFactor;
	}

	public double[] getDoverArray() {
		return doverArray;
	}

	public abstract String getLabelName();

	public boolean isDispersUniform() {
		double sum = 0;
		double max = 0;
		for (int i = 0; i < dArray.length; i++) {
			sum += dArray[i];
			if (dArray[i] > max)
				max = dArray[i];
		}
		double g = max / sum;
		return (g < StatTables.kochren05(n - 1, p).floatValue());
	}

	public boolean isFactorValid() {
		double f = dFactor / (dExpr / n);
		if (f <= 1)
			return false;
		return (f > (StatTables.fisher05(p - 1, p * (n - 1))).floatValue());
	}

	public boolean isRegresAdequat() {
		double f = dAdequat / (dExpr / n);
		if (f <= 1)
			return true;
		return (f < (StatTables.fisher05(p - this.k(), p * (n - 1)))
				.floatValue());
	}

	public abstract int k();

	public abstract String parametersAsString();

	public void testMatrix(double[][] arg0, double[] arg1) {
		if (arg0 == null || arg1 == null)
			return;
		matrix = arg0;
		// First index - it is level number
		// Second index - it is experiment number on the level
		n = matrix[0].length; // Число экспериментов на уровне
		factorArray = arg1;
		p = arg1.length; // Число уровней
		if (matrix.length != p)
			return;
		double sum, d;
		// Вычисление массива средних значений для каждого уровня
		avrgArray = new double[p];
		for (int i = 0; i < p; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				sum += matrix[i][j];
			}
			avrgArray[i] = sum / n;
		}
		// Вычисление массива дисперсий отклика на каждом уровне
		dArray = new double[p];
		for (int i = 0; i < p; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				d = matrix[i][j] - avrgArray[i];
				sum += d * d;
			}
			dArray[i] = sum / (n - 1);
		}
		// Вычисление массива доверительных интервалов для отклика на всех
		// уровнях
		doverArray = new double[p];
		for (int i = 0; i < p; i++)
			doverArray[i] = StatTables.student05(n) * Math.sqrt(dArray[i] / n);
		// Вычисление дисперсии эксперимента dExpr
		sum = 0;
		for (int i = 0; i < p; i++)
			sum += dArray[i];
		dExpr = sum / p;
		// Вычисление общего среднего avrg
		sum = 0;
		for (int i = 0; i < p; i++)
			sum += avrgArray[i];
		avrg = sum / p;
		// Сравнение данных по уровням
		if (p > 1) {
			// Вычисление дисперсии фактора dFactor
			for (int i = 0; i < p; i++) {
				d = avrgArray[i] - avrg;
				sum += d * d;
			}
			dFactor = sum / (p - 1);
			// Расчет параметров выбранного уравнения регресии (вызов из
			// подкласса)
			this.calculateParameters();
			if (p > this.k()) {
				// Вычисление дисперсии адекватности dAdequat.
				sum = 0;
				for (int i = 0; i < p; i++) {
					d = this.f(factorArray[i]) - avrgArray[i];
					sum += d * d;
				}
				dAdequat = sum / (p - this.k());
			}
		}
	}
}
