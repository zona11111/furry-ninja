package widgets.regres;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import widgets.Diagram;

public class TestForRegresAnaliser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel jContentPane = null;
	private RegresAnaliser regresAnaliser = null;
	private Diagram diagram = null;
	private IRegresable sourceData = new IRegresable(){
		private double a =3;
		private double b= 2;

		public double[] getFactorsArray() {
			double[] mas = {1,2,3,4};
			//double[] mas = {2};
			return mas;
		}

		public double[][] getResultMatrix() {
			double[][] mas = new double[getFactorsArray().length][5];
			for (int i = 0; i < getFactorsArray().length; i++) {
				mas[i][0]=a/(i+1)+b;
				mas[i][1]=a/(i+1)+b+Math.random();
				mas[i][2]=a/(i+1)+b+Math.random();
				mas[i][3]=a/(i+1)+b-Math.random();
				mas[i][4]=a/(i+1)+b-Math.random();
			}
			return mas;
		}
		
	};

	/**
	 * This method initializes regresAnaliser	
	 * 	
	 * @return experiment.controls.RegresAnaliser	
	 */
	private RegresAnaliser getRegresAnaliser() {
		if (regresAnaliser == null) {
			regresAnaliser = new RegresAnaliser();
			regresAnaliser.setIRegresable(sourceData);
			regresAnaliser.setDiagram(getDiagram());
		}
		return regresAnaliser;
	}

	/**
	 * This method initializes diagram	
	 * 	
	 * @return paint.Diagram	
	 */
	private Diagram getDiagram() {
		if (diagram == null) {
			diagram = new Diagram();
			diagram.setTitleText("Графік гіперболи y= 3/х+2");
			diagram.setVerticalMaxText("10");
		}
		return diagram;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TestForRegresAnaliser application = new TestForRegresAnaliser();
		application.setVisible(true);
	}

	/**
	 * This is the default constructor
	 */
	public TestForRegresAnaliser() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(635, 282);
		this.setContentPane(getJContentPane());
		this.setTitle("Application");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(getRegresAnaliser(), null);
			jContentPane.add(getDiagram(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
