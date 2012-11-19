package widgets.trans;

import process.Actor;
import qusystem.IModelFactory;
import widgets.Diagram;

/**
 * Объекты этого класса предназначены для создания и запуска требуемого
 * количества параллельно работающих моделей и периодического снятия и
 * усреднения данных о работе модели. Монитор создает массив объектов
 * ITransProcesable, используя фабрику моделей, реализующую интерфейс
 * IModelFactory. Созданные модели монитор готує до старту методом
 * initForTrans() и передает в стартовый список диспетчера с помощью метода
 * componentsToStartList(). Мониторинг параллельно работающих моделей
 * осуществляется через промежутки interval модельного времени. В начале каждого
 * промежутка накопители информации в модели инициализируются с помощью метода
 * resetAccum(). В конце промежутка времени interval, monitor, с помощью метода
 * getTransResult(), опрашивает все параллельно работающие модели. Результаты
 * опроса усредняются, передаются объекту painter для отрисовки на диаграмме и
 * запомонаются в массиве intervalAverageArray.
 * 
 * Creation date: (18.11.2007 17:26:58)
 * 
 * @author: biv
 */

public class TransMonitor extends Actor {

	public TransMonitor() {
		super();
	}

	private double interval; // Интервал усреднения информации о процессе

	private int nIntervals; // Число интервалов усреднения

	private int nParallel; // Число параллельно работающих моделей

	private Diagram diagram; // Объект для отрисовки результатов мониторинга

	// на paint.Diagram //

	private IModelFactory factory = null; // Фабрика, создающая модели,

	// реализующие интерфейс
	// ITransProcesable

	private double[] intervalAverageArray; // Массив усредненных значений

	// результатов мониторинга

	// Правила действия монитора

	public void rule() {
		// Масив для моделей
		ITransProcesable[] modelArray = new ITransProcesable[nParallel];
		for (int i = 0; i < nParallel; i++) {
			// Створюємо моделі і готуємо їх до старту
			modelArray[i] = (ITransProcesable) (getFactory()
					.createModel(getDispatcher()));
			modelArray[i].initForTrans(interval * nIntervals);
		}
		// Готуємося до моніторингу моделей
		float average;
		intervalAverageArray = new double[nIntervals];
		// Цикл по інтервалам усреднення
		for (int i = 0; i < nIntervals; i++) {
			// Ініціалізація накопичувачів інформації
			for (int j = 0; j < nParallel; j++)
				modelArray[j].resetTransAccum();
			// Затримка на довжину інтервалу
			this.holdForTime(interval);
			// Усереднення накопичених даних
			average = 0;
			for (int j = 0; j < nParallel; j++)
				average += modelArray[j].getTransResult();
			average /= nParallel;
			// Запис та індикація результату усереднення
			intervalAverageArray[i] = average;
			getDispatcher().printToProtocol(
					" " + getNameForProtocol() + ":середнє по інтервалу"
							+ average);
			if (diagram != null)
				diagram.getPainter().drawOvalAtXY(
						(float) (interval * (i + 0.5)), (float) average, 3, 3);
		}

	}

	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	public void setInterval(double interval) {
		this.interval = interval;
	}

	public Diagram getDiagram() {
		return diagram;
	}

	public double getInterval() {
		return interval;
	}

	public int getNIntervals() {
		return nIntervals;
	}

	public int getNParallel() {
		return nParallel;
	}

	public void setIntervalAverageArray(double[] intervalAverageArray) {
		this.intervalAverageArray = intervalAverageArray;
	}

	public IModelFactory getFactory() {
		if (factory == null)
			System.out.println("Не визначена фабрика моделей");
		return factory;
	}

	public void setFactory(IModelFactory factory) {
		this.factory = factory;
	}

	public void setNIntervals(int intervals) {
		nIntervals = intervals;
	}

	public void setNParallel(int parallel) {
		nParallel = parallel;
	}

	public double[] getIntervalAverageArray() {
		return intervalAverageArray;
	}
}
