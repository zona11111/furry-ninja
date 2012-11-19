package model;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import process.Dispatcher;
import process.DispatcherFinishListener;
import qusystem.IModelFactory;
import rnd.Erlang;
import stat.Histo;
import widgets.ChooseRandom;
import widgets.Diagram;
import widgets.experiments.ExperimentControl;
import widgets.regres.RegresAnaliser;
import widgets.trans.TransMonitorView;

public class MainForm {

	private JFrame frmSkating;
	
	private JTextField countClients;
	private JTextField countSkates;
	private JTextField countSeats;
	private JTextField countShowers;
	private JTextField modelTime;
	
	private JTextPane statOnePane;
	private JTextPane statTwoPane;

	private Diagram dressingRoomQueueDiagram;
	private Diagram skatesQueueDiagram;
	private Diagram showerQueueDiagram;
	private Diagram statOneDiagram;
	private Diagram statTwoDiagram;
	private Diagram regresDiagram;
	private Diagram transDiagram;

	private ChooseRandom chooseRandomServiceTime;
	private ChooseRandom chooseRandomDressTime;
	private ChooseRandom chooseRandomComingTime;
	private ChooseRandom chooseRandomSkatingTime;
	private ChooseRandom chooseRandomShowerTime;

	private ExperimentControl experimentControl;
	
	private RegresAnaliser regresAnaliser;
	
	private TransMonitorView transMonitorView;

	public static MainForm Skating;

	private IModelFactory factory;

	private int factor;
	/**
	 * @wbp.nonvisual location=108,-17
	 */
	private final Histo histoStatOne = new Histo();
	/**
	 * @wbp.nonvisual location=148,-17
	 */
	private final Histo histoStatTwo = new Histo();
	/**
	 * @wbp.nonvisual location=198,-17
	 */
	public final Histo histoFactor1 = new Histo();
	/**
	 * @wbp.nonvisual location=268,-17
	 */
	public final Histo histofactor2 = new Histo();
	/**
	 * @wbp.nonvisual location=348,-17
	 */
	public final Histo histoTrans = new Histo();
	
	private JButton btnBeginTest;
	private JButton btnStatistics;
	
	private JRadioButton rdbtnFactor1;
	private JRadioButton rdbtnFactor2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Skating = new MainForm();
					Skating.frmSkating.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSkating = new JFrame();
		frmSkating.setTitle("Skating Modeling Tool");
		frmSkating.setResizable(false);
		frmSkating.setBounds(100, 100, 1024, 600);
		frmSkating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSkating.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(324, 8, 686, 556);
		frmSkating.getContentPane().add(tabbedPane);

		JPanel modelTab = new JPanel();
		tabbedPane.addTab("Modeling", null, modelTab, null);
		modelTab.setLayout(null);

		modelTab.add(getBtnBeginTest());

		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 657, 468);
		modelTab.add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		panel.add(getDressingRoomQueueDiagram());
		panel.add(getSkatesQueueDiagram());
		panel.add(getShowerQueueDiagram());

		JPanel statTab = new JPanel();
		tabbedPane.addTab("Statistics", null, statTab, null);
		statTab.setLayout(null);

		statTab.add(getBtnStatistics());

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 12, 657, 174);
		statTab.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		panel_1.add(getStatOneDiagram());

		panel_1.add(getStatTwoDiagram());

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 198, 657, 282);
		statTab.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 6));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.add(getStatOnePane());

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 6, 0, 0));
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		panel_4.add(getStatTwoPane());

		JPanel regressTab = new JPanel();
		tabbedPane.addTab("Regress Analyse", null, regressTab, null);
		regressTab.setLayout(null);

		regressTab.add(getRegresDiagram());

		regressTab.add(getExperimentControl());

		regressTab.add(getRegresAnaliser());

		JPanel panelFactor = new JPanel();
		panelFactor
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFactor.setBounds(12, 293, 304, 48);
		regressTab.add(panelFactor);
		panelFactor.setLayout(new GridLayout(2, 0, 0, 0));
		
		panelFactor.add(getRdbtnFactor1());

		panelFactor.add(getRdbtnFactor2());

		ButtonGroup bg = new ButtonGroup();
		bg.add(getRdbtnFactor1());
		bg.add(getRdbtnFactor2());

		JPanel transTab = new JPanel();
		tabbedPane.addTab("Transient Analyse", null, transTab, null);
		transTab.setLayout(null);

		transTab.add(getTransDiagram());

		transTab.add(getTransMonitorView());

		JLabel lblTimeSkating = new JLabel("Skating time");
		lblTimeSkating.setBounds(12, 12, 131, 15);
		frmSkating.getContentPane().add(lblTimeSkating);

		frmSkating.getContentPane().add(getChooseRandomServiceTime());

		JLabel lblTimeShower = new JLabel("Shower time");
		lblTimeShower.setBounds(12, 83, 131, 15);
		frmSkating.getContentPane().add(lblTimeShower);

		frmSkating.getContentPane().add(getChooseRandomDressTime());

		JLabel lblNewLabel = new JLabel("Service time");
		lblNewLabel.setBounds(12, 156, 270, 15);
		frmSkating.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Changing shoes time");
		lblNewLabel_1.setBounds(12, 229, 200, 15);
		frmSkating.getContentPane().add(lblNewLabel_1);

		JLabel lblTimeComing = new JLabel("Time coming");
		lblTimeComing.setBounds(12, 302, 200, 15);
		frmSkating.getContentPane().add(lblTimeComing);

		frmSkating.getContentPane().add(getChooseRandomComingTime());

		frmSkating.getContentPane().add(getChooseRandomSkatingTime());

		frmSkating.getContentPane().add(getChooseRandomShowerTime());

		JLabel lblCountSakters = new JLabel("Clients count");
		lblCountSakters.setBounds(12, 380, 115, 15);
		frmSkating.getContentPane().add(lblCountSakters);

		frmSkating.getContentPane().add(getCountClients());

		JLabel lblNewLabel_2 = new JLabel("Skates count");
		lblNewLabel_2.setBounds(12, 409, 121, 15);
		frmSkating.getContentPane().add(lblNewLabel_2);

		frmSkating.getContentPane().add(getCountSkates());

		JLabel lblSeatsCount = new JLabel("Seats count");
		lblSeatsCount.setBounds(12, 438, 115, 15);
		frmSkating.getContentPane().add(lblSeatsCount);

		frmSkating.getContentPane().add(getCountSeats());

		JLabel lblShowersCount = new JLabel("Showers count");
		lblShowersCount.setBounds(12, 467, 115, 15);
		frmSkating.getContentPane().add(lblShowersCount);

		frmSkating.getContentPane().add(getCountShowers());

		JLabel lblModelingTome = new JLabel("Modeling time");
		lblModelingTome.setBounds(12, 494, 115, 15);
		frmSkating.getContentPane().add(lblModelingTome);

		frmSkating.getContentPane().add(getModelTime());
	}

	private JButton getBtnBeginTest() {
		if (btnBeginTest == null) {
			btnBeginTest = new JButton("Begin test");
			btnBeginTest.setBounds(12, 492, 657, 25);
			btnBeginTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					beginTest();
				}
			});
		}
		return btnBeginTest;
	}
	
	private JButton getBtnStatistics(){
		if (btnStatistics == null) {
			btnStatistics = new JButton("Statistics");
			btnStatistics.setBounds(12, 492, 657, 25);
			btnStatistics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					beginStatistic();
				}
			});
		}
		return btnStatistics;
	}

	private JRadioButton getRdbtnFactor1() {
		if (rdbtnFactor1 == null) {
			rdbtnFactor1 = new JRadioButton("factor1");
			rdbtnFactor1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// TODO
					setFactor(0);
					experimentControl.setTextFactors("1 2 3 4 5 6 7 8 9 10");
				}
			});
		}
		return rdbtnFactor1;
	}

	private JRadioButton getRdbtnFactor2() {
		if (rdbtnFactor2 == null) {
			rdbtnFactor2 = new JRadioButton("factor2");
			rdbtnFactor2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO
					setFactor(1);
					experimentControl.setTextFactors("1 2 3 4 5 6 7 8 9 10");
				}
			});
		}
		return rdbtnFactor2;
	}

	private void beginTest() {
		getDressingRoomQueueDiagram().setHorizontalMaxText(getModelTime().getText());
		getSkatesQueueDiagram().setHorizontalMaxText(getModelTime().getText());
		getShowerQueueDiagram().setHorizontalMaxText(getModelTime().getText());
		getDressingRoomQueueDiagram().setVerticalMaxText(getCountClients().getText());
		getSkatesQueueDiagram().setVerticalMaxText(getCountClients().getText());
		getShowerQueueDiagram().setVerticalMaxText(getCountClients().getText());
		getDressingRoomQueueDiagram().clear();
		getSkatesQueueDiagram().clear();
		getShowerQueueDiagram().clear();
		final Dispatcher disp = new Dispatcher();

		ModelSkating model = (ModelSkating) ModelFactory.getInstance().createModel(disp);
		model.initForTest();
		getBtnBeginTest().setEnabled(false);
		getDressingRoomQueueDiagram().getPainter().placeToXY(0.0F, 0.0F);

		disp.start();
		disp.addStartingActor(model);
		disp.addDispatcherFinishListener(new DispatcherFinishListener() {
			@Override
			public void onDispatcherFinish() {
				getBtnBeginTest().setEnabled(true);
			}
		});
	}

	private void beginStatistic() {
		getStatOneDiagram().clear();
		getStatTwoDiagram().clear();
		
		final Dispatcher disp = new Dispatcher();

		final ModelSkating model = (ModelSkating) ModelFactory.getInstance().createModel(disp);
		
		getBtnStatistics().setEnabled(false);
		getDressingRoomQueueDiagram().getPainter().placeToXY(0.0F, 0.0F);
		disp.start();
		disp.addStartingActor(model);
		disp.addDispatcherFinishListener(new DispatcherFinishListener() {
			@Override
			public void onDispatcherFinish() {
				getBtnStatistics().setEnabled(true);
				for (Iterator<Molod> iterator = model.allTheSkating.iterator(); iterator
						.hasNext();) {
					Molod type = (Molod) iterator.next();
					histoStatOne.add(type.getTimeSkating());
				}
				histoStatOne.showRelFrec(getStatOneDiagram());
				getStatOnePane().setText(histoStatOne.toString());
				for (Iterator<Molod> iterator = model.allTheSkating.iterator(); iterator
						.hasNext();) {
					Molod type = (Molod) iterator.next();
					histoStatTwo.add(type.getLiveTime());
				}
				histoStatTwo.showRelFrec(getStatTwoDiagram());
				getStatTwoPane().setText(histoStatTwo.toString());
				histoStatOne.init();
				histoStatTwo.init();
			}
		});
	}

	public ExperimentControl getExperimentControl() {
		if (experimentControl == null) {
			setExperimentControl(new ExperimentControl());
			experimentControl.setBounds(12, 353, 304, 164);
			experimentControl.setFactory(ModelFactory.getInstance());
			experimentControl.setDiagram(getRegresDiagram());
		}
		return experimentControl;
	}

	private void setExperimentControl(ExperimentControl experimentControl) {
		this.experimentControl = experimentControl;
	}

	public int getFactor() {
		return factor;
	}

	private void setFactor(int factor) {
		this.factor = factor;
	}

	public ChooseRandom getChooseRandomServiceTime() {
		if (chooseRandomServiceTime == null) {
			chooseRandomServiceTime = new ChooseRandom();
			chooseRandomServiceTime.setBounds(12, 183, 300, 34);
		}
		return chooseRandomServiceTime;
	}

	public ChooseRandom getChooseRandomDressTime() {
		if (chooseRandomDressTime == null) {
			chooseRandomDressTime = new ChooseRandom();
			chooseRandomDressTime.setBounds(12, 256, 300, 34);
		}
		return chooseRandomDressTime;
	}

	public ChooseRandom getChooseRandomComingTime() {
		if (chooseRandomComingTime == null) {
			chooseRandomComingTime = new ChooseRandom();
			chooseRandomComingTime.setBounds(12, 329, 300, 34);
		}
		return chooseRandomComingTime;
	}

	public ChooseRandom getChooseRandomSkatingTime() {
		if (chooseRandomSkatingTime == null) {
			chooseRandomSkatingTime = new ChooseRandom();
			chooseRandomSkatingTime.setBounds(12, 37, 300, 34);
			chooseRandomSkatingTime.setRandom(new Erlang(2, 2));
		}
		return chooseRandomSkatingTime;
	}

	public ChooseRandom getChooseRandomShowerTime() {
		if (chooseRandomShowerTime == null) {
			chooseRandomShowerTime = new ChooseRandom();
			chooseRandomShowerTime.setBounds(12, 110, 300, 34);
			chooseRandomShowerTime.setRandom(new Erlang());
		}
		return chooseRandomShowerTime;
	}

	public JTextField getCountClients() {
		if (countClients == null) {
			countClients = new JTextField();
			countClients.setText("20");
			countClients.setBounds(145, 375, 114, 19);
			countClients.setColumns(10);
		}
		return countClients;
	}

	public void setCountClients(String countClients) {
		this.countClients.setText(countClients);
	}

	public JTextField getCountShowers() {
		if (countShowers == null) {
			countShowers = new JTextField();
			countShowers.setText("10");
			countShowers.setBounds(145, 465, 114, 19);
			countShowers.setColumns(10);
		}
		return countShowers;
	}

	public void setCountShowers(double countShowers) {
		this.countShowers.setText(Integer.toString((int) countShowers));
	}

	public JTextField getCountSkates() {
		if (countSkates == null) {
			countSkates = new JTextField();
			countSkates.setText("10");
			countSkates.setBounds(145, 407, 114, 19);
			countSkates.setColumns(10);
		}
		return countSkates;
	}

	public void setCountSkates(double countSkates) {
		this.countSkates.setText(Integer.toString((int) countSkates));
	}

	public JTextField getCountSeats() {
		if (countSeats == null) {
			countSeats = new JTextField();
			countSeats.setText("10");
			countSeats.setBounds(145, 436, 114, 19);
			countSeats.setColumns(10);
		}
		return countSeats;
	}

	public void setCountSeats(String countSeats) {
		this.countSeats.setText(countSeats);
	}

	public JTextField getModelTime() {
		if (modelTime == null) {
			modelTime = new JTextField();
			modelTime.setText("100");
			modelTime.setBounds(145, 496, 114, 19);
			modelTime.setColumns(10);
		}
		return modelTime;
	}

	public void setModelTime(String modelTime) {
		this.modelTime.setText(modelTime);
	}

	public Diagram getDressingRoomQueueDiagram() {
		if (dressingRoomQueueDiagram == null) {
			dressingRoomQueueDiagram = new Diagram();
			dressingRoomQueueDiagram.setTitleText("All in the locker room");
			dressingRoomQueueDiagram.setPainterColor(Color.blue);
			dressingRoomQueueDiagram.setGridByX(50);
			dressingRoomQueueDiagram.setGridByY(10);
			dressingRoomQueueDiagram.getPainter().setColor(Color.red);
		}
		return dressingRoomQueueDiagram;
	}

	public Diagram getSkatesQueueDiagram() {
		if (skatesQueueDiagram == null) {
			skatesQueueDiagram = new Diagram();
			skatesQueueDiagram.setTitleText("All in for skates");
			skatesQueueDiagram.setGridByX(50);
			skatesQueueDiagram.setGridByY(10);
			skatesQueueDiagram.getPainter().setColor(Color.red);
		}
		return skatesQueueDiagram;
	}

	public Diagram getShowerQueueDiagram() {
		if (showerQueueDiagram == null) {
			showerQueueDiagram = new Diagram();
			showerQueueDiagram.setTitleText("All in the shower");
			showerQueueDiagram.setGridByX(50);
			showerQueueDiagram.setGridByY(10);
			showerQueueDiagram.getPainter().setColor(Color.red);
		}
		return showerQueueDiagram;
	}

	private Diagram getStatOneDiagram() {
		if (statOneDiagram == null) {
			statOneDiagram = new Diagram();
			statOneDiagram.setTitleText("Average time skiing");
		}
		return statOneDiagram;
	}

	private Diagram getStatTwoDiagram() {
		if (statTwoDiagram == null) {
			statTwoDiagram = new Diagram();
			statTwoDiagram.setTitleText("Average leisure time");
		}
		return statTwoDiagram;
	}

	private Diagram getRegresDiagram() {
		if (regresDiagram == null) {
			regresDiagram = new Diagram();
			regresDiagram.setTitleText("Regress Analyse");
			regresDiagram.setBounds(12, 12, 657, 269);
		}
		return regresDiagram;
	}

	public Diagram getTransDiagram() {
		if (transDiagram == null) {
			transDiagram = new Diagram();
			transDiagram.setTitleText("Transient for the number of skiers");
			transDiagram.setBounds(12, 12, 657, 275);
		}
		return transDiagram;
	}

	private RegresAnaliser getRegresAnaliser() {
		if (regresAnaliser == null) {
			regresAnaliser = new RegresAnaliser();
			regresAnaliser.setBounds(328, 293, 341, 224);
			regresAnaliser.setIRegresable(getExperimentControl());
			regresAnaliser.setDiagram(getRegresDiagram());
		}
		return regresAnaliser;
	}

	private TransMonitorView getTransMonitorView() {
		if (transMonitorView == null) {
			transMonitorView = new TransMonitorView();
			transMonitorView.setBounds(247, 299, 181, 218);
			transMonitorView.setDiagram(getTransDiagram());
			transMonitorView.setFactory(ModelFactory.getInstance());
		}
		return transMonitorView;
	}

	private JTextPane getStatOnePane() {
		if (statOnePane == null) {
			statOnePane = new JTextPane();
		}
		return statOnePane;
	}

	private JTextPane getStatTwoPane() {
		if (statTwoPane == null) {
			statTwoPane = new JTextPane();
		}
		return statTwoPane;
	}

}
