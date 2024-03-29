package widgets.trans;

import process.Store;

/**
 * Клас забезпечує динамічну індикацію змін розміру купи у часі, 
 * оцінювання середнього значення розміру купи за весь період моделювання 
 * та оцінювання середнього розміру купи грунту на заданих відрізках часу.
 * Можливості суперкласу qusystem.Store забезпечують  динамічне відображення 
 * розміру купи грунту на діаграмі, а також визначення  * середного розміру купи за весь період. 
 * Оцінювання середнього розміру купи грунту на заданих відрізках часу 
 * має бути реалізовано у самому класі BuldoHeap. 
 * Для визначення середнього значення розміру купи на інтервалі накопичення 
 * слід обчислити інтеграл від розміру купи за час накопичення та
 * поділити його на час накопичення. Процесс накопичення починається з моменту
 * надходження повідомлення resetAccum() від об’єкта buldoModel. У відповідь на
 * це повідомлення об'єкт класу ВuldoHeap ініціалізує змінну для накопичення
 * інтегралу – sum, змінну для накопичення часу інтегрування – accumTime і
 * змінну для збереження моменту початку накопичення на відрізку часу –
 * lastSumTime. Далі, у процесі роботи моделі, від об’єкта buldoDevice надходять
 * повідомлення add(double), а від об’єкта buldoLoader remove(double). У
 * відповідь на ці повідомлення об’єкт buldoHeap змінює свій розмір, але перед
 * цим викликає методи beforeAdd() та beforeRemove() суперкласу. Саме у цей час
 * потрібно обчислювати чергову складову інтегралу. Інтеграл при постійному
 * розмірі купи – це площина прямокутника на діаграмі зміни розміру купи у часі.
 * Для обчислення площини такого прямокутника треба знати час, на протязі якого
 * довжина купи не змінювалася і розмір купи на цьому проміжку часу. Розмір купи
 * можна отримати за допомогою метода getSize() cуперкласу, а відрізок часу
 * можна визначити як різницю між поточним часом і значенням змінної
 * lastSumTime. Усі необхідні обчислення, що мають бути виконані на цьому етапі
 * зведені у методі accumSum(). який буде викликатися із перевизначених методів
 * суперкласу beforeAdd() та beforeRemove(), та у методі getAvg(). Саме середнє
 * значення розміру купи на інтервалі накопичення може бути визначено у методі
 * getAvg() як частка sum/accumTime.
 */
public class TransProcessStore extends Store {

	private double sum;

	private double lastSumTime;

	private double accumTime;

	public TransProcessStore() {
		super();
	}

	/**
	 * Метод забезпечує реалізацію інтерфейсу ItransProcessable у моделі. У
	 * методі приватним атрибутам класу, що використовуються при обчисленні
	 * інтервального середнього для розміру купи грунту, встановлюються
	 * початкові значення
	 */
	public void resetAccum() {
		lastSumTime = getDispatcher().getCurrentTime();
		sum = 0;
		accumTime = 0;
	}

	/**
	 * Метод забезпечує накопичення інформації, необхідної для обчислення
	 * інтервального середнього розміру купи грунту.
	 * 
	 */
	private void accumSum() {
		double dt = getDispatcher().getCurrentTime() - lastSumTime;
		lastSumTime = getDispatcher().getCurrentTime();
		sum += dt * this.getSize();
		accumTime += dt;
	}


	/**
	 * Метод розширює одноіменний метод суперкласу і забезпечує виклик методу
	 * accumSum() перед зміною розміру купи грунту.
	 */
	public double getAvg() {
		accumSum();
		return sum / accumTime;
	}

}
