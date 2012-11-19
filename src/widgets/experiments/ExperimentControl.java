package widgets.experiments;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import process.Dispatcher;
import qusystem.IModelFactory;
import widgets.Diagram;
import widgets.regres.IRegresable;

public class ExperimentControl extends JPanel implements IRegresable {

	private static final long serialVersionUID = 1L;

	private JPanel jPanel = null;

	private JLabel jLabelFactors = null;

	private JTextField jTextFieldFactors = null;

	private JLabel jLabelNExpr = null;

	private JTextField jTextFieldNExpr = null;

	private JCheckBox jCheckBox = null;

	private JButton jButtonStart = null;

	private JButton jButtonRedraw = null;

	private int count; // countOfExperiments

	private double[] factors;

	private double[][] resultMatrix;

	private double[][] resultLnMatrix;

	private Dispatcher dispatcher = null; // @jve:decl-index=0:

	private IModelFactory factory = null;

	private Diagram diagram;

	public ExperimentControl(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initialize();
	}

	public ExperimentControl(LayoutManager layout) {
		super(layout);
		initialize();
	}

	public ExperimentControl(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initialize();
	}

	public ExperimentControl() {
		super();
		initialize();
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabelNExpr = new JLabel();
			jLabelNExpr.setName("JLabel2");
			jLabelNExpr.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelNExpr.setText("Повторів на рівні:");
			jLabelNExpr.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			jLabelNExpr.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelFactors = new JLabel();
			jLabelFactors.setName("factorLabel");
			jLabelFactors.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelFactors.setText("Значення фактору:");
			jLabelFactors.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			jLabelFactors.setHorizontalAlignment(SwingConstants.CENTER);
			jPanel = new JPanel();
			jPanel.setLayout(new FlowLayout());
			jPanel.setName("JPanel1");
			jPanel.setBorder(new EtchedBorder());
			jPanel.add(jLabelFactors, null);
			jPanel.add(getJTextFieldFactors(), null);
			jPanel.add(jLabelNExpr, null);
			jPanel.add(getJTextFieldNExpr(), null);
			jPanel.add(getJCheckBox(), null);
			jPanel.add(getJButtonStart(), null);
			jPanel.add(getJButtonRedraw(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFactors() {
		if (jTextFieldFactors == null) {
			jTextFieldFactors = new JTextField();
			jTextFieldFactors.setName("JTextFieldFactors");
			jTextFieldFactors.setBorder(javax.swing.BorderFactory
					.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			jTextFieldFactors.setHorizontalAlignment(JTextField.CENTER);
			jTextFieldFactors.setMinimumSize(new java.awt.Dimension(100, 20));
			jTextFieldFactors.setPreferredSize(new Dimension(220, 20));
			jTextFieldFactors
					.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jTextFieldFactors.setFont(new Font("Dialog", Font.PLAIN, 12));
			jTextFieldFactors
					.setText("  0.1 0.2 0.3 0.4 0.5  0.6  0.7  0.8 0.9 ");
		}
		return jTextFieldFactors;
	}

	/**
	 * This method initializes jTextField1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNExpr() {
		if (jTextFieldNExpr == null) {
			jTextFieldNExpr = new JTextField();
			jTextFieldNExpr.setName("JTextFieldCount");
			jTextFieldNExpr.setBorder(javax.swing.BorderFactory
					.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			jTextFieldNExpr
					.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
			jTextFieldNExpr.setMinimumSize(new java.awt.Dimension(25, 20));
			jTextFieldNExpr.setPreferredSize(new java.awt.Dimension(25, 20));
			jTextFieldNExpr.setFont(new Font("Dialog", Font.PLAIN, 12));
			jTextFieldNExpr.setText("5");
		}
		return jTextFieldNExpr;
	}

	/**
	 * This method initializes jCheckBox
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setName("JCheckBoxLn");
			jCheckBox.setText("Ln");
			jCheckBox.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					redraw(diagram);
				}
			});
		}
		return jCheckBox;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonStart() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setName("JButtonStart");
			jButtonStart.setText("Старт");
			jButtonStart.setMargin(new Insets(2, 4, 2, 4));
			jButtonStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buttonStartClick();
				}
			});
		}
		return jButtonStart;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonRedraw() {
		if (jButtonRedraw == null) {
			jButtonRedraw = new JButton();
			jButtonRedraw.setName("redrawBtn");
			jButtonRedraw.setText("Перерисовати");
			jButtonRedraw.setMargin(new Insets(2, 4, 2, 4));
			jButtonRedraw
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							redraw(diagram);
						}
					});
		}
		return jButtonRedraw;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new CardLayout());
		this.setSize(406, 96);
		this
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder(
								javax.swing.BorderFactory
										.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
								"Параметри експерименту",
								javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
								javax.swing.border.TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Dialog", java.awt.Font.BOLD,
										12), new java.awt.Color(51, 51, 51)));
		this.add(getJPanel(), getJPanel().getName());
		this.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				if ((e.getPropertyName().equals("enabled"))) {
					boolean b = ExperimentControl.this.isEnabled();
					getJButtonStart().setEnabled(b);
					getJTextFieldFactors().setEditable(b);
					getJTextFieldNExpr().setEditable(b);
				}
			}
		});
	}

	public void buttonStartClick() {
		// Метод буде виконуватися в окремому потоці для того щоб
		// візуальна частина могла відображати зміни параметрів експерименту
		new Thread() {
			public void run() {
				// Модель будемо створювати перед кожним запуском
				IExperimentable model = null;
				// Читаємо параметри експерименту
				String strCount = getJTextFieldNExpr().getText();
				count = Integer.parseInt(strCount);
				String strFactors = getJTextFieldFactors().getText();
				if ((strFactors.trim().length() == 0) || (count == 0))
					return;
				// Створюємо масив значень фактору із рядка strFactors
				StringTokenizer st = new StringTokenizer(
						strFactors);
				factors = new double[st.countTokens()];
				int i = 0;
				while (st.hasMoreTokens()) {
					factors[i] = Double.parseDouble(st.nextToken());
					i++;
				}
				Arrays.sort(factors);
				// Готуємо масиви для результатів експериментів
				resultMatrix = new double[factors.length][count];
				resultLnMatrix = new double[factors.length][count];
				// Готуємо діаграму
				if (diagram != null) {
					diagram.getPainter().setColor(new Color(0, 0, 255));
					diagram.clear();
				}
				getJButtonStart().setEnabled(false);
				// Цикл експериментів для різних значень фактору
				for (int j = 0; j < factors.length; j++) {
					ExperimentControl.this.getJTextFieldFactors().setText(
							String.valueOf(factors[j]));
					// Цикл повторів для одного значення фактору
					for (int k = 0; k < count; k++) {
						// створюємо модель
						model = (IExperimentable) (getFactory()
								.createModel(getDispatcher()));

						getJTextFieldNExpr().setText(
								String.valueOf(count - k));
						// Ініціалізація моделі
						model.initForExperiment(factors[j]);
						getDispatcher().start();
						// зупинка до закінчення роботи моделі
						try {
							getDispatcher().getThread().join();
						} catch (InterruptedException e) {
							System.out
									.println("Невдале приєднання до потоку диспетчера ");
							e.printStackTrace();
						}
						double result = model.getResultOfExperiment();
						resultMatrix[j][k] = result;
						resultLnMatrix[j][k] = Math.log(result);
						diagram.getPainter()
								.drawOvalAtXY((float) factors[j],
										(float) result, 4, 4);
					}
				}
				getJButtonStart().setEnabled(true);
				getJTextFieldNExpr().setText(strCount);
				getJTextFieldFactors().setText(strFactors);
			}
		}.start();
	}

	public double[] getFactorsArray() {
		return factors;
	}

	public double[][] getResultMatrix() {
		if (getJCheckBox().isSelected())
			return resultLnMatrix;
		return resultMatrix;
	}

	public void redraw(Diagram diagram) {
		if (diagram == null)
			return;
		diagram.getPainter().setColor(new Color(0, 0, 255));
		diagram.clear();
		if (getFactorsArray() == null)
			return;
		for (int i = 0; i < getFactorsArray().length; i++) {
			for (int j = 0; j < count; j++) {
				diagram.getPainter().drawOvalAtXY(
						(float) this.getFactorsArray()[i],
						(float) this.getResultMatrix()[i][j], 4, 4);
			}
		}
	}

	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	public void setTextFactors(String textFactors) {
		getJTextFieldFactors().setText(textFactors);
	}

	public void setTextNExpr(String textNExpr) {

		getJTextFieldNExpr().setText(textNExpr);
	}

	public String getTextFactors() {
		return getJTextFieldFactors().getText();
	}

	public String getTextNExpr() {
		return getJTextFieldNExpr().getText();
	}

	public Dispatcher getDispatcher() {
		if (dispatcher == null)
			dispatcher = new Dispatcher();
		return dispatcher;
	}

	public IModelFactory getFactory() {
		if (factory == null)
			System.out.println("Не визначено factory для ExperimentControl");
		return factory;
	}

	public void setFactory(IModelFactory factory) {
		this.factory = factory;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
