package process;

public abstract class Actor implements Runnable, Cloneable {

	private String nameForProtocol = this.getClass().getName();

	private double activateTime;

	private IWaitCondition activateCondition;

	private Semaphore suspendIndicator = new Semaphore();

	private Thread thread = null;

	// private Dispatcher dispatcher = Dispatcher.getSingleton();

	private Dispatcher dispatcher;

	public Actor() {
		super();
	}

	/**
	 * Метод start() вызывается "Диспетчером" при обработке списка startList. Он
	 * запускает поток выполнения правил действия "актера", описанных в
	 * подклассе в методе rule, вызывая метод run интерфейса Runnable. Запустив
	 * поток "актера", метод приостановит родительский поток, то есть
	 * "Диспетчер", до тех пор, пока "актер" не будет приостановлен
	 */
	final void start() {
		// Создаем и запускаем поток выполнения правил действия актера
		thread = new Thread(this, getNameForProtocol());
		thread.start();
	}

	/**
	 * Метод определяет правила действия актера. Должен быть переопределен в
	 * подклассе.
	 */
	abstract protected void rule();

	/**
	 * Метод интерфейса Runnable. Обеспечивает выполнение правил действия актера
	 * в отдельном потоке
	 */
	public void run() {
		getDispatcher().printToProtocol(
				"  " + this.getNameForProtocol() + " стартує");
		rule();	
		getDispatcher().printToProtocol(
				"  " + getNameForProtocol() + " роботу завершив");

		// Устанавливаем индикатор в состояние "Актер остановлен"
		// тем самым сообщая "Диспетчеру", что поток выполнения
		// правил действия данного "актера" завершен,
		// что дает возможность "Диспетчеру" продолжить работу
		suspendIndicator.setValue(true);
	}

	/**
	 * Метод обеспечивает задержку выполнения правил действия "актера" на время
	 * holdTime (время здесь виртуальное, модельное). Применяется для имитации
	 * какой-то работы "актера", связанной с затратами времени.
	 */
	protected final void holdForTime(double holdTime) {
		if(holdTime<0){
			System.out.println("Negative holdTime! It is imposible. There was not made holdForTime.");
			return;
		}
		// Задержка не имеет смысла, если диспетчер закончил работу.
		if (!getDispatcher().getThread().isAlive()) {
			System.out.println("!getDispatcher().getThread().isAlive()");
			return;
		}
		// Вычисляем время возобновления правил действия "актера"
		activateTime = getDispatcher().getCurrentTime() + holdTime;
		// Передаем "актера" "Диспетчеру", в список актеров,
		// задержанных на некоторое время
		getDispatcher().getTimingActorQueue().add(this);
		getDispatcher().printToProtocol(
				"  " + getNameForProtocol() + " затримано до "
						+ Double.toString(activateTime));
		// Устанавливаем индикатор в состояние "Актер приостановлен",
		// тем самым давая возможность работать "Диспетчеру".
		suspendIndicator.setValue(true);
		// Переводим поток выполнения правил действия "актера"
		// в состояние ожидания.
		// Когда придет время возобновить работу "актера"
		// диспетчер переключит индикатор в состояние false
		suspendIndicator.waitForValue(false);
		// Здесь актер возобновляет выполнение правил действия
		getDispatcher().printToProtocol(
				"  " + getNameForProtocol() + " активізувався");
	}

	/**
	 * Метод обеспечивает задержку выполнения правил действия "актера" до
	 * выполнения условия, которое описано в виде метода testCondition(),
	 * интерфейса WaitCondition. К этому методу мы получаем доступ через объект
	 * с, передаваемый в данный метод в виде параметра. Следует иметь в виду,
	 * что возобновление правил действия "актера", ждущего выполнения условия
	 * может произойти и в случае, когда "Диспетчер", перед завершением работы,
	 * "отпускает" все ждущие потоки. Поэтому после выхода их ожидания
	 * выполнения условия, целесообразно в правилах действия это условие
	 * проверить. Невыполнение условия свидетельствует о завершении процесса
	 * моделирования. Дальнейшее выполнение правил действия будет бессмысленно.
	 * 
	 * @throws Exception
	 */
	protected final void waitForCondition(IWaitCondition c)
			throws DispatcherFinishException {
		// Если условие выполняется то задерка не нужна
		if (c.testCondition())
			return;
		// Если диспетчер закончил работу, задержка не имеет смысла.
		if (!getDispatcher().getThread().isAlive()) {
			return;
		}
		// Запомонаем объект, хранящий условие.
		activateCondition = c;
		// Передаем "актера" "Диспетчеру", в список актеров,
		// задержанных до выполнения условия
		getDispatcher().getWaitingActorQueue().add(this);
		getDispatcher().printToProtocol(
				"  " + getNameForProtocol() + " чекає '"
						+ activateCondition.toString() + "'");
		// Устанавливаем индикатор в состояние "Актер приостановлен",
		// тем самым давая возможность работать "Диспетчеру".
		suspendIndicator.setValue(true);
		// Переводим поток выполнения правил действия "актера"
		// в состояние ожидания.
		// Когда условие выполнится,
		// диспетчер переключит индикатор в состояние false
		suspendIndicator.waitForValue(false);
		if (activateCondition.testCondition())
			getDispatcher().printToProtocol(
					"  " + getNameForProtocol() + " дочекався '"
							+ activateCondition.toString() + "'");
		else
			throw new DispatcherFinishException();
	}

	/**
	 * Метод обеспечивает задержку правил действия "актера" до выполнения
	 * условия, которое описано в виде метода testCondition(), интерфейса
	 * WaitCondition. Но продолжительность ожидания не может быть более время
	 * holdTime holdTime (время здесь виртуальное, модельное).
	 */
	protected final void waitForConditionOrHoldForTime(IWaitCondition c,
			double holdTime)  {
		// Задержка не имеет смысла, если диспетчер закончил работу.
		if (!getDispatcher().getThread().isAlive()) {
			return;
		}
		// Если условие выполняется то задерка не нужна
		if (c.testCondition())
			return;
		// Вычисляем время возобновления правил действия "актера"
		activateTime = getDispatcher().getCurrentTime() + holdTime;
		// Передаем "актера" "Диспетчеру", в список актеров,
		// задержанных на некоторое время
		getDispatcher().getTimingActorQueue().add(this);
		// Запомонаем объект, хранящий условие.
		activateCondition = c;
		// Передаем "актера" "Диспетчеру", в список актеров,
		// задержанных до выполнения условия
		getDispatcher().getWaitingActorQueue().add(this);
		getDispatcher().printToProtocol(
				"  " + getNameForProtocol() + " чекає '"
						+ activateCondition.toString()
						+ "', але не пізніше ніж до "
						+ Double.toString(activateTime));
		// Устанавливаем индикатор в состояние "Актер приостановлен",
		// тем самым давая возможность работать "Диспетчеру".
		suspendIndicator.setValue(true);
		// Переводим поток выполнения правил действия "актера"
		// в состояние ожидания.
		// Когда придет время возобновить работу "актера"
		// диспетчер переключит индикатор в состояние false
		suspendIndicator.waitForValue(false);
		// Здесь актер возобновляет выполнение правил действия
		getDispatcher().printToProtocol(
				"  " + getNameForProtocol() + " активізувався ");
	}

	/**
	 * Иногда "актеров" удобно размножать клонированием, но при этом индикатор
	 * должен быть у каждого свой.
	 */
	public Object clone() {
		try {
			Actor clon = (Actor) super.clone();
			clon.suspendIndicator = new Semaphore();
			return clon;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Метод используется "Диспетчером" при анализе списка "актереов", ждущих
	 * выполнения условия.
	 * 
	 * @return process.WaitCondition
	 */
	IWaitCondition getActivateCondition() {
		return activateCondition;
	}

	/**
	 * Метод возвращает время, на которое было заплпнировано возобновление
	 * правил действия данного "актера" *
	 * 
	 * @return double
	 */
	public double getActivateTime() {
		return activateTime;
	}

	/**
	 * Метод обеспечивает доступ к имени "актера". Чаще всего нужен при выводе
	 * отладочной информации в протокол.
	 * 
	 * @return java.lang.String
	 */

	public String getNameForProtocol() {
		return nameForProtocol;
	}

	/**
	 * Метод обеспечивает доступ к индикатору состояния потока выполнения правил
	 * действия. Индикатор играет роль семафора, останавливающего и
	 * возобновляющего выполнение потока правил действия как "актера" так и
	 * "Диспетчера". Используется "Диспетчером".
	 * 
	 * @return process.Semaphore
	 */

	Semaphore getSuspendIndicator() {
		return suspendIndicator;
	}

	/**
	 * Устанавливает индикатор состояния потока выполнения правил действия.
	 * Индикатор играет роль семафора, останавливающего и возобновляющего
	 * выполнение потока правил действия как "актера" так и "Диспетчера".
	 * Используется при клонировании.
	 * 
	 * @param newBooleanIndicator
	 *            process.Semaphore
	 */
	// private void setSuspendIndicator(Semaphore newBooleanIndicator) {
	// suspendIndicator = newBooleanIndicator;
	// }
	/**
	 * Задание имени актера, которое будет использоваться при выводе протокола
	 * работы модели
	 * 
	 * @param newNameForProtocol
	 *            java.lang.String
	 */
	public void setNameForProtocol(java.lang.String newNameForProtocol) {
		nameForProtocol = newNameForProtocol;
	}

	/**
	 * При отладке помогает
	 */
	public String toString() {
		return getNameForProtocol();
	}

	public void setActivateCondition(IWaitCondition activateCondition) {
		this.activateCondition = activateCondition;
	}

	public void setActivateTime(double activateTime) {
		this.activateTime = activateTime;
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	protected final void replaceActivateTimeBy(double newActivateTime)
			throws Exception {
		if (getDispatcher().getCurrentTime() > newActivateTime)
			throw new Exception("Time revers is impossible");
		if (!getDispatcher().getTimingActorQueue().contains(this))
			throw new Exception("Actor is not in  timingActorQueue");
		this.setActivateTime(newActivateTime);
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread t) {
		thread = null;

	}

	void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;

	}
}
