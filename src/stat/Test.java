package stat;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import rnd.RandomGenerators;
import widgets.ChooseRandom;
import widgets.Diagram;

/**
 * Данный класс предназначен для осуществления возможности выбора различных
 * параметров теста Пирсона и вывода резуьтатов тестирования
 * 
 * @author Andrey
 * 
 */
public class Test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane = null;
	private JPanel jContentPane = null;
	private JButton ivjJButtonTest = null;
	private JTextArea ivjJTextArea = null;
	private ChooseRandom ivjChooseRandom = null;
	private Histo ivjHisto = null;
	private Diagram ivjDiagram = null;
	private Histo savedHisto = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Test thisClass = new Test();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * конструктор без параметров
	 * 
	 */
	public Test() {
		super();
		initialize();
	}

	/**
	 * Конструктор с параметрами
	 * 
	 * @param d -
	 *            диаграмма, на которой будет вестись прорисовка
	 * @param h -
	 *            гистограмма, которая тестируется по критерию Пирсона
	 */
	public Test(Diagram d, Histo h) {
		super();
		initialize();
		ivjHisto = h;
		ivjDiagram = d;
	}

	/**
	 * добавляем панель, на которой будут размещаться все компоненты.
	 * настраиваем начальные параметры отображения окна
	 */
	private void initialize() {
		// устанавливаем начальное местоположение окна
		this.setLocation(500, 200);
		// устанавливаем начальный размер окна
		this.setSize(400, 300);
		// устанавливаем минимальный размер окна
		this.setMinimumSize(new Dimension(300, 200));
		this.setAlwaysOnTop(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Тестирование по критерию Пирсона");
	}

	/**
	 * добавляем ChooseRandom, кнопку для запуска теста и компонент для вывода
	 * информации. а также устанавливаем менеджер
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			// Добавляем кнопку для запуска теста по Пирсону
			jContentPane.add(getJButtonTest(), BorderLayout.SOUTH);
			// Добавляем текстовую область для вывода результатов тестирования
			jContentPane.add(getJScrollPane(getJTextArea()),
					BorderLayout.CENTER);
			// Добавляем ChooseRandom для выбора параметров теста
			jContentPane.add(getChooseRandom(), BorderLayout.NORTH);
		}
		return jContentPane;
	}

	/**
	 * создаем кнопку по нажатии на которую будет происходить выполнение теста
	 * по Пирсону При создании кнопки используется паттерн синглтон
	 */
	private javax.swing.JButton getJButtonTest() {
		if (ivjJButtonTest == null) {
			try {
				ivjJButtonTest = new javax.swing.JButton();
				ivjJButtonTest.setName("JButtonTest");
				ivjJButtonTest.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJButtonTest.setText("Выполнить тест");
				ivjJButtonTest.setMargin(new java.awt.Insets(2, 4, 2, 4));
				ivjJButtonTest.setPreferredSize(new Dimension(100, 40));
				// реализовуем событие нажатия на кнопку
				ivjJButtonTest
						.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(
									java.awt.event.ActionEvent e) {
								try {
									// выполняем тест Пирсона
									pirsonTest();
									} catch (Exception e1) {
									// если тест не может выполниться, то
									// выводим причину неудачи
									System.out
											.println("тест Пирсона не может выполниться: "
													+ e1.getMessage());
									e1.printStackTrace();
								}
							}
						});

			} catch (Throwable ivjExc) {

			}
		}
		return ivjJButtonTest;
	}

	/**
	 * создаем текстовую область, куда будут выводиться результаты тестирования
	 * по Пирсону
	 * 
	 */
	private JTextArea getJTextArea() {
		if (ivjJTextArea == null) {
			try {
				ivjJTextArea = new javax.swing.JTextArea();
				ivjJTextArea.setName("JTextArea");
				ivjJTextArea.setLineWrap(false);
				ivjJTextArea.setWrapStyleWord(true);
				ivjJTextArea.setBounds(0, 0, 160, 120);
				ivjJTextArea.setFont(new java.awt.Font("Dialog",
						java.awt.Font.PLAIN, 14));
				ivjJTextArea.setMargin(new java.awt.Insets(10, 10, 10, 10));

			} catch (java.lang.Throwable ivjExc) {

			}
		}
		return ivjJTextArea;
	}

	/**
	 * Данный метод нужен для реализации прокрутки текста
	 * 
	 * @param comp -
	 *            прокручиваемый компонент
	 * @return jScrollPane
	 */
	private JScrollPane getJScrollPane(Component comp) {
		if (jScrollPane == null) {
			try {
				jScrollPane = new JScrollPane(comp);

			} catch (java.lang.Throwable ivjExc) {

			}
		}
		return jScrollPane;
	}

	/**
	 * Происходит создание ChooseRandom
	 * 
	 * @return ivjChooseRandom - генератор
	 */
	private ChooseRandom getChooseRandom() {
		if (ivjChooseRandom == null) {
			try {
				ivjChooseRandom = new widgets.ChooseRandom();
				ivjChooseRandom.setName("ChooseRandom");

			} catch (java.lang.Throwable ivjExc) {

			}
		}
		return ivjChooseRandom;
	}

	/**
	 * получаем гистограмму, заполненную эмпирическими частотами
	 * 
	 * @return ivjHisto - переданная гистограмма с заполненными эмпирическими
	 *         частотами
	 * @throws Exception -
	 *             если гистограмма не передана
	 */
	private Histo getHisto() throws Exception {
		if (ivjHisto == null)
			throw new Exception("не передана Histo");
		return ivjHisto;
	}

	/**
	 * получаем диаграмму на которой будем производить прорисовку
	 * 
	 * @return ivjDiagram - переданная диаграмма
	 * @throws Exception -
	 *             если диаграмма не передана
	 */
	private Diagram getDiagram() throws Exception {
		if (ivjDiagram == null)
			throw new Exception("не передана Diagram");
		return ivjDiagram;
	}

	/**
	 * Тест по критерию Пирсона
	 * 
	 * @throws Exception -
	 *             если не проинициализированна диаграмма или гистограмма. так
	 *             как тестироваться может только уже прорисованая гистограмма
	 */
	public void pirsonTest() throws Exception {
		// Выбираем закон распределения
		RandomGenerators gen = getChooseRandom().getRandom();
		// Создаем гистограмму для файла???????
		if ((gen != null) && (getHisto() != null)) {

			/* Берем из гистограммы эмпирические частоты */
			double[] a = getCopyHisto().absolutFrequency();
			double[] b = getCopyHisto().getBorders();
			/* Создаем массив теоретических частот */
			double[] t = new double[a.length];
			t[0] = gen.probability(b[0]);
			t[t.length - 1] = 1 - gen.probability(b[b.length - 1]);
			for (int i = 1; i < t.length - 1; i++)
				t[i] = gen.probability(b[i]) - gen.probability(b[i - 1]);
			/* Превращаем теор. частоты в абсолютные */
			double[] ta = new double[t.length];
			for (int i = 0; i < ta.length; i++)
				ta[i] = t[i] * getCopyHisto().count();
			/* Рисуем гистограммы эмпирическую и теоретическую */
			getCopyHisto().showRelFrec(getDiagram(), java.awt.Color.magenta, 0.9,
					0.05, true);
			getDiagram().setPainterColor(java.awt.Color.orange);
			getDiagram().drawBarsDiagram(getCopyHisto().realBorders(), t, 0.6, 0.3,
					false);
			// Проводим тест и выводим результаты
			getJTextArea().setText("Гипотеза о соответствии\n");
			getJTextArea().append("выбранному закону распределения:\n");
			getJTextArea().append(gen.toString() + "\n");
			double[] res = stat.StatTables.pirsonResult(a, ta, getCopyHisto()
					.realBorders(), getJTextArea(), gen.getKParm());
			getJTextArea().append(
					"Хи-квадрат = " + stat.StatTables.format(res[0], 1, 1));
			getJTextArea().append(
					"\nКритическое значение = "
							+ stat.StatTables.format(res[1], 1, 1));
			if (res[0] < res[1])
				getJTextArea().append("\nГипотезу можно принять");
			else
				getJTextArea().append("\nГипотезу следует отвергнуть");
			/* сбрасываем "сбрасываем отрисованную гисограмму" */
			savedHisto = null;
		}
	};

	/**
	 * Метод получающий гистограмму посредством создания ее копии в ОЗУ
	 * 
	 */
	private Histo getCopyHisto() {
		if (savedHisto == null)
			try {
				savedHisto = getHisto().clone();
			} catch (Exception e) {
			}
		return savedHisto;
	};

}
