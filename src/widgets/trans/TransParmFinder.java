package widgets.trans;

import java.io.FileWriter;
import java.util.ArrayList;

public class TransParmFinder implements IParmFinder {
	private double stepL = 0.1;

	private double stepT = 1;

	private double level;

	private double tau;

	private double[] timeArray;

	private double[] valueArray;

	private String protocolFileName = "Console";

	private paint.Painter painter;

	private boolean metodSqr = true;

	private ArrayList finderFinishListeners;
	private ParmFinderView view; 
	public TransParmFinder(ParmFinderView v){
		view=v;
	}
	/* (non-Javadoc)
	 * @see transProcess.IParmFinder#addFinderFinishListener(transProcess.FinderFinishListener)
	 */
	public synchronized void addFinderFinishListener(
			FinderFinishListener listener) {
		if (finderFinishListeners == null) {
			finderFinishListeners = new java.util.ArrayList();
		}
		finderFinishListeners.add(listener);
	}

	public float drawRegres() {
		drawValue();
		painter.placeToXY(0, 0);
		double t;
		for (int i = 0; i < timeArray.length; i++) {
			t = timeArray[i];
			painter.drawToXY((float) t, (float) this.Y(t));
		}
		return (float) sum();
	}

	public void drawValue() {
		double t, v;
		for (int i = 0; i < timeArray.length; i++) {
			t = timeArray[i];
			v = valueArray[i];
			painter.drawOvalAtXY((float) t, (float) v, 3, 3);
		}
	}

	public double findMinimum(double xStart, double xStep, GetSetParam param) {
		double y0 = 0, y1 = 0, y2 = 0, y3 = 0, x0 = 0, x1 = 0, x2 = 0, x3 = 0, step = xStep;
		int f = 0;
		param.setParam(xStart);
		x0 = xStart;
		y0 = this.sum();
		this.print("Оцениваем исходную точку: X0=" + x0 + " целевая функция="
				+ this.sum());
		this.print("Пробуем шагнуть на величину заданного шага" + step);
		param.setParam(x0 + step);
		x1 = param.getParam();
		y1 = this.sum();
		this.print("Результат шага X1=" + x1 + " сумма=" + y1);
		if (y1 > y0) {
			this.print("Возрастает, это плохо. Попробуем пойти назад с шагом "
					+ (0 - step));
			step = 0 - step;
			param.setParam(x0 + step);
			x1 = param.getParam();
			y1 = this.sum();
			this.print("Результат шага: X1=" + x1 + " сумма=" + y1);
			if (y1 > y0) {
				this.print("Здесь тоже плохо. Выходим");
				this
						.print("Поиск по координате закончен. Стартовое значение оказалось наилучшим");
				param.setParam(x0);
				this.print("Координата: " + param.getParam()
						+ " Целевая функция: " + this.sum());
				return y0;
			}
		}
		this.print("Идем в сторону уменьшения целевой функции");
		this
				.print("Расстояние от исходной точки будем увеличивать пропорционально числам Фибоначи");
		f = 2;
		int nfibo = this.nextFibo(f);
		param.setParam((f = nfibo) * step + x0);
		x3 = param.getParam();
		y3 = this.sum();
		this.print("Число Фибоначи=" + f);
		this.print("X3=" + param.getParam() + " сумма=" + this.sum());
		while (y3 < y1) {
			this
					.print("Убывает! Определим новые границы и будем двигаться дальше");
			x0 = x1;
			y0 = y1;
			x1 = x3;
			y1 = y3;
			this.print("X0=" + x0 + " x1=" + x1);
			this.print("Y0=" + y0 + " Y1=" + y1);
			nfibo = this.nextFibo(f);
			param.setParam((f = nfibo) * step + x0);
			x3 = param.getParam();
			y3 = this.sum();
			this.print("Число Фибоначи=" + f);
			this.print("X3=" + param.getParam() + " сумма=" + this.sum());
		}
		x2 = 0;
		this.print("Стало возрастать, можно сужать интервал");

		if (x1 == 0) {
			param.setParam(this.predFibo(this.predFibo(f)) * step + x0);
			x1 = param.getParam();
			y1 = this.sum();
		}
		if (x2 == 0) {
			param.setParam(this.predFibo(f) * step + x0);
			x2 = param.getParam();
			y2 = this.sum();
		}
		this.print("x0=" + x0 + " x1=" + x1 + " x2=" + x2 + " x3=" + x3);
		this.print("y0=" + y0 + " y1=" + y1 + " y2=" + y2 + " y3=" + y3);
		while (f != 3) {
			f = this.predFibo(f);
			if (y1 < y2) {
				x3 = x2;
				y3 = y2;
				x2 = x1;
				y2 = y1;
				x1 = 0;
			} else {
				x0 = x1;
				y0 = y1;
				x1 = x2;
				y1 = y2;
				x2 = 0;
			}
			if (x1 == 0) {
				param.setParam(this.predFibo(this.predFibo(f)) * step + x0);
				x1 = param.getParam();
				y1 = this.sum();
			}
			if (x2 == 0) {
				param.setParam(this.predFibo(f) * step + x0);
				x2 = param.getParam();
				y2 = this.sum();
			}
		}
		this.print("Интервал сузился до минимума. Выбираем наменьший");
		if (y1 < y2) {
			if (y0 < y1) {
				param.setParam(x0);
			} else {
				param.setParam(x1);
			}
		} else {
			if (y3 < y2) {
				param.setParam(x3);
			} else {
				param.setParam(x2);
			}
		}
		this.print("Поиск по координате закончен");
		this.print("Координата " + param.getParam() + " Целевая функция "
				+ this.sum());
		return this.sum();
	}

	public float findRegres(double startLevel, double startTau,
			double stepLevel, double stepTau) {
		timeArray =view.getIRegresable().getFactorsArray();
		valueArray=view.getIRegresable().getResultMatrix()[0];
		
		GetSetParam getSetLevel = new GetSetParam() {
			public double getParam() {
				return level;
			}

			public void setParam(double param) {
				level = param;
			}
		};
		GetSetParam getSetTau = new GetSetParam() {
			public double getParam() {
				return tau;
			}

			public void setParam(double param) {
				tau = param;
			}
		};
		double slevel = 0, sTau = 0, sBest = 0;
		level = startLevel;
		tau = startTau;
		stepL = stepLevel;
		stepT = stepTau;
		this.print("Автоматический поиск");
		this.print("Координаты исходной точки");
		this.print("Установившийся уровень " + level);
		this.print("Длительность переходного процесса " + tau);
		this.print("Поиск начинаем по координате <Установившийся уровень>"
				+ tau);
		slevel = this.findMinimum(level, stepL, getSetLevel);
		sBest = slevel;
		boolean flag = true;
		while (flag) {
			this
					.print("Поиск продолжаем по координате <Длительность переходного процесса>");
			sTau = this.findMinimum(tau, stepT, getSetTau);
			if (sTau < sBest) {
				sBest = slevel;
				this
						.print("Поиск продолжаем по координате <Установившийся уровень>");
				slevel = this.findMinimum(level, stepL, getSetLevel);
				if (slevel < sBest) {
					sBest = slevel;
					flag = true;
				} else {
					flag = false;
				}

			} else {
				flag = false;
			}
		}
		this.print("Улучшений не наблюдается. Поиск по координатам закончен");
		this.print("Координаты оптимальной точки: ");
		this.print("Установившийся уровень: " + level);
		this.print("Продолж. процесса: " + tau);
		this.drawRegres();
		fireFinderFinishEvent();
		return (float) sBest;
	}

	private synchronized void fireFinderFinishEvent() {

		java.util.ArrayList targets = null;
		synchronized (this) {
			if (finderFinishListeners != null) {
				targets = (java.util.ArrayList) finderFinishListeners.clone();
			}
		}
		if (targets != null) {
			for (int i = 0; i < targets.size(); i++) {
				FinderFinishListener target = (FinderFinishListener) targets
						.get(i);
				target.onFinderFinish(new java.util.EventObject(this));
			}
		}
	}


	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 17:01:32)
	 * 
	 * @return paint.Painter
	 */
	public paint.Painter getPainter() {
		return painter;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 10:42:36)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getProtocolFileName() {
		return protocolFileName;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 10:52:06)
	 * 
	 * @return double
	 */
	public double getLevel() {
		return level;
	}

	public double getStepL() {
		return stepL;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 10:52:35)
	 * 
	 * @return double
	 */
	public double getStepT() {
		return stepT;
	}

	public double getTau() {
		return tau;
	}

	public double[] getTimeArray() {
		return timeArray;
	}

	public double[] getValueArray() {
		return valueArray;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 20:33:19)
	 * 
	 * @return boolean
	 */
	public boolean isMetodSqr() {
		return metodSqr;
	}

	public static int nextFibo(int arg0) {
		int f1, f2, f;
		f1 = 0;
		f2 = 1;
		f = f1 + f2;
		while (f <= arg0) {
			f1 = f2;
			f2 = f;
			f = f1 + f2;
		}
		return f;
	}

	public static int  predFibo(int arg0) {
		int f1, f2, f;
		f1 = 0;
		f2 = 1;
		f = f1 + f2;
		while (f < arg0) {
			f1 = f2;
			f2 = f;
			f = f1 + f2;
		}
		return f2;
	}

	private void print(String newString) {
		if(view.isCheckProtokol()){
		if (protocolFileName == null || protocolFileName.trim().length() == 0) {
			return;
		}
		if (protocolFileName == "Console") {
			System.out.println(newString);
			return;
		}
		FileWriter file;
		try {
			file = new java.io.FileWriter(protocolFileName, true);
			file.write(newString + "\n");
			file.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		}
	}

	/* (non-Javadoc)
	 * @see transProcess.IParmFinder#removeFinderFinishListener(transProcess.FinderFinishListener)
	 */
	public synchronized void removeFinderFinishListener(
			FinderFinishListener listener) {
		if (finderFinishListeners == null) {
			return;
		}
		finderFinishListeners.remove(listener);
	}

	public void setLevel(double level) {
		this.level = level;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 20:33:19)
	 * 
	 * @param newMetodSqr
	 *            boolean
	 */
	public void setMetodSqr(boolean newMetodSqr) {
		metodSqr = newMetodSqr;
	}

	/* (non-Javadoc)
	 * @see transProcess.IParmFinder#setPainter(paint.Painter)
	 */
	public void setPainter(paint.Painter newPainter) {
		painter = newPainter;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 10:42:36)
	 * 
	 * @param newProtocolFileName
	 *            java.lang.String
	 */
	public void setProtocolFileName(java.lang.String newProtocolFileName) {
		protocolFileName = newProtocolFileName;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 10:52:06)
	 * 
	 * @param newStepL
	 *            double
	 */
	public void setStepL(double newStepL) {
		stepL = newStepL;
	}

	/**
	 * Insert the method's description here. Creation date: (25.03.2006
	 * 10:52:35)
	 * 
	 * @param newStepT
	 *            double
	 */
	public void setStepT(double newStepT) {
		stepT = newStepT;
	}

	public void setTau(double tau) {
		this.tau = tau;
	}

	/* (non-Javadoc)
	 * @see transProcess.IParmFinder#setTimeArray(double[])
	 */
	public void setTimeArray(double[] timeArray) {
		this.timeArray = timeArray;
	}

	/* (non-Javadoc)
	 * @see transProcess.IParmFinder#setValueArray(double[])
	 */
	public void setValueArray(double[] valueArray) {
		this.valueArray = valueArray;
	}

	public double sum() {
		if (isMetodSqr())
			return sumSqr();
		return sumAbs();
	}

	private double sumAbs() {
		double sum = 0, t, v;
		for (int i = 0; i < timeArray.length; i++) {
			t = timeArray[i];
			v = valueArray[i];
			sum += Math.abs(this.Y(t) - v);
		}
		return sum;
	}

	private double sumSqr() {
		double sum = 0, t, v, s;
		for (int i = 0; i < timeArray.length; i++) {
			t = timeArray[i];
			v = valueArray[i];
			s = this.Y(t) - v;
			sum += s * s;
		}
		return sum;
	}

	private double Y(double z) {
		double x;
		if (tau == 0 || (x = z / tau * 3) > 50)
			return level;
		if (tau < 0)
			return (1 - tau) * 1000 * level;
		return level * (1 - (1 / Math.exp(x)));
	}

	public double getResult() {
		
		return getTau();
	}

	public void startSearch() {
		// TODO Auto-generated method stub
		
	}
}
