package widgets;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.StringTokenizer;

import rnd.Discret;
import rnd.Erlang;
import rnd.Linear;
import rnd.Negexp;
import rnd.Norm;
import rnd.RandomGenerators;
import rnd.Randomable;
import rnd.Uniform;

/**
 * Insert the type's description here. Creation date: (23.03.2005 22:34:56)
 * 
 * @author: Administrator
 */
public class ChooseRandom extends javax.swing.JPanel implements Randomable {
	
	private String title = null;
	private javax.swing.JPanel ivjJDialogContentPane = null;

	IvjEventHandler ivjEventHandler = new IvjEventHandler();

	private javax.swing.JMenu ivjJMenu1 = null;

	private javax.swing.JMenuItem ivjJMenuNegexp = null;

	private javax.swing.JPanel ivjJPanelNegexp = null;

	private javax.swing.JButton ivjJButtonChoose = null;

	private javax.swing.JTextField ivjJTextFieldRandomAsString = null;

	private javax.swing.JButton ivjJButtonNegexpSelect = null;

	private javax.swing.JCheckBox ivjJCheckBoxRound = null;

	private javax.swing.JDialog ivjJDialogChooseRandom = null;  //  @jve:decl-index=0:visual-constraint="64,165"

	private javax.swing.JMenuBar ivjJDialogChooseRandomJMenuBar = null;

	private javax.swing.JLabel ivjJLabelNegexpM = null;

	private javax.swing.JTextField ivjJTextFieldNegexpM = null;

	private javax.swing.JButton ivjJButtonErlangSelect = null;

	private javax.swing.JLabel ivjJLabelErlangK = null;

	private javax.swing.JLabel ivjJLabelErlangM = null;

	private javax.swing.JLabel ivjJLabelErlangTitle = null;

	private javax.swing.JPanel ivjJPanelErlang = null;

	private javax.swing.JTextField ivjJTextFieldErlangK = null;

	private javax.swing.JTextField ivjJTextFieldErlangM = null;

	private javax.swing.JMenuItem ivjJMenuItemErlang = null;

	private javax.swing.JMenuItem ivjJMenuItemDiscret = null;

	private javax.swing.JMenuItem ivjJMenuItemLinear = null;

	private javax.swing.JMenuItem ivjJMenuItemNorm = null;

	private javax.swing.JMenuItem ivjJMenuItemUniform = null;

	private javax.swing.JLabel ivjJLabel1 = null;

	private javax.swing.JButton ivjJButtonNormSelect = null;

	private javax.swing.JLabel ivjJLabelNormM = null;

	private javax.swing.JLabel ivjJLabelNormSigma = null;

	private javax.swing.JLabel ivjJLabelNormTitle = null;

	private javax.swing.JPanel ivjJPanelNorm = null;

	private javax.swing.JTextField ivjJTextFieldErlangK1 = null;

	private javax.swing.JTextField ivjJTextFieldNormM = null;

	private javax.swing.JButton ivjJButtonlUniformSelect = null;

	private javax.swing.JLabel ivjJLabelUniformMax = null;

	private javax.swing.JLabel ivjJLabelUniformMin = null;

	private javax.swing.JLabel ivjJLabelUniformTitle = null;

	private javax.swing.JPanel ivjJPanelUniform = null;

	private javax.swing.JTextField ivjJTextFieldlUniformMax = null;

	private javax.swing.JTextField ivjJTextFieldlUniformMin = null;

	private javax.swing.JButton ivjJButtonlUniformSelect1 = null;

	private javax.swing.JLabel ivjJLabelUniformMax1 = null;

	private javax.swing.JLabel ivjJLabelUniformMax11 = null;

	private javax.swing.JLabel ivjJLabelUniformMax111 = null;

	private javax.swing.JLabel ivjJLabelUniformMax12 = null;

	private javax.swing.JLabel ivjJLabelUniformMin1 = null;

	private javax.swing.JLabel ivjJLabelUniformMin11 = null;

	private javax.swing.JLabel ivjJLabelUniformTitle1 = null;

	private javax.swing.JLabel ivjJLabelUniformTitle11 = null;

	private javax.swing.JPanel ivjJPanelDiscret = null;

	private javax.swing.JPanel ivjJPanelLinear = null;

	private javax.swing.JTextField ivjJTextFieldlUniformMax1 = null;

	private javax.swing.JTextField ivjJTextFieldlUniformMax11 = null;

	private javax.swing.JTextField ivjJTextFieldlUniformMin1 = null;

	private javax.swing.JTextField ivjJTextFieldlUniformMin11 = null;

	public RandomGenerators random;

	private javax.swing.JButton ivjJButtonlUniformSelect11 = null;

	class IvjEventHandler implements java.awt.event.ActionListener,
			java.awt.event.MouseListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == ChooseRandom.this.getJMenuNegexp())
				connEtoM1(e);
			if (e.getSource() == ChooseRandom.this.getJButtonChoose())
				connEtoM2(e);
			if (e.getSource() == ChooseRandom.this.getJButtonNegexpSelect())
				connEtoC1(e);
			if (e.getSource() == ChooseRandom.this.getJButtonNegexpSelect())
				connEtoM4(e);
			if (e.getSource() == ChooseRandom.this.getJMenuItemErlang())
				connEtoM5(e);
			if (e.getSource() == ChooseRandom.this.getJButtonErlangSelect())
				connEtoC2(e);
			if (e.getSource() == ChooseRandom.this.getJButtonErlangSelect())
				connEtoM7(e);
			if (e.getSource() == ChooseRandom.this.getJMenuItemUniform())
				connEtoM8(e);
			if (e.getSource() == ChooseRandom.this.getJButtonlUniformSelect())
				connEtoC3(e);
			if (e.getSource() == ChooseRandom.this.getJButtonlUniformSelect())
				connEtoM9(e);
			if (e.getSource() == ChooseRandom.this.getJMenuItemNorm())
				connEtoM10(e);
			if (e.getSource() == ChooseRandom.this.getJButtonNormSelect())
				connEtoC4(e);
			if (e.getSource() == ChooseRandom.this.getJButtonNormSelect())
				connEtoM12(e);
			if (e.getSource() == ChooseRandom.this.getJMenuItemDiscret())
				connEtoM14(e);
			if (e.getSource() == ChooseRandom.this.getJButtonlUniformSelect11())
				connEtoC7(e);
			if (e.getSource() == ChooseRandom.this.getJButtonlUniformSelect11())
				connEtoM16(e);
			if (e.getSource() == ChooseRandom.this.getJMenuItemLinear())
				connEtoM17(e);
			if (e.getSource() == ChooseRandom.this.getJButtonlUniformSelect1())
				connEtoC8(e);
			if (e.getSource() == ChooseRandom.this.getJButtonlUniformSelect1())
				connEtoM19(e);
		};

		public void mouseClicked(java.awt.event.MouseEvent e) {
		};

		public void mouseEntered(java.awt.event.MouseEvent e) {
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
		};

		public void mousePressed(java.awt.event.MouseEvent e) {
			if (e.getSource() == ChooseRandom.this.getJMenu1())
				connEtoM20(e);
			if (e.getSource() == ChooseRandom.this.getJMenu1())
				connEtoM21(e);
			if (e.getSource() == ChooseRandom.this.getJMenu1())
				connEtoM22(e);
			if (e.getSource() == ChooseRandom.this.getJMenu1())
				connEtoM24(e);
			if (e.getSource() == ChooseRandom.this.getJMenu1())
				connEtoM23(e);
			if (e.getSource() == ChooseRandom.this.getJMenu1())
				connEtoM25(e);
			if (e.getSource() == ChooseRandom.this.getJMenu1())
				connEtoM26(e);
		};

		public void mouseReleased(java.awt.event.MouseEvent e) {
		};
	};

	/**
	 * ChooseRandom constructor comment.
	 */
	public ChooseRandom() {
		super();
		initialize();
	}

	/**
	 * ChooseRandom constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public ChooseRandom(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * ChooseRandom constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public ChooseRandom(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * ChooseRandom constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public ChooseRandom(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * Comment
	 */
	public void chooseRandomPane_ComponentShown(
			java.awt.event.ComponentEvent componentEvent) {
		this.getJTextFieldRandomAsString().setText(getRandom().toString());
		return;
	}

	/**
	 * connEtoC1:
	 * (JButtonNegexpSelect.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> ChooseRandom.jButtonNegexpSelect_ActionEvents(DZ)Ljava.lang.String;)
	 * 
	 * @return java.lang.String
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String connEtoC1(java.awt.event.ActionEvent arg1) {
		String connEtoC1Result = null;
		try {
			// user code begin {1}
			// user code end
			connEtoC1Result = this.jButtonNegexpSelect_ActionEvents(new Double(
					getJTextFieldNegexpM().getText()).doubleValue(),
					getJCheckBoxRound().isSelected());
			connEtoM3(connEtoC1Result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
		return connEtoC1Result;
	}

	/**
	 * connEtoC2:
	 * (JButtonErlangSelect.action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom.jButtonErlangSelect_ActionPerformed1(DIZ)Ljava.lang.String;)
	 * 
	 * @return java.lang.String
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String connEtoC2(java.awt.event.ActionEvent arg1) {
		String connEtoC2Result = null;
		try {
			// user code begin {1}
			// user code end
			connEtoC2Result = this.jButtonErlangSelect_ActionPerformed1(
					new Double(getJTextFieldErlangM().getText()).doubleValue(),
					Integer.parseInt(getJTextFieldErlangK().getText()),
					getJCheckBoxRound().isSelected());
			connEtoM6(connEtoC2Result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
		return connEtoC2Result;
	}

	/**
	 * connEtoC3:
	 * (JButtonlUniformSelect.action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom.jButtonlUniformSelect_ActionEvents(DDZ)Ljava.lang.String;)
	 * 
	 * @return java.lang.String
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String connEtoC3(java.awt.event.ActionEvent arg1) {
		String connEtoC3Result = null;
		try {
			// user code begin {1}
			// user code end
			connEtoC3Result = this.jButtonlUniformSelect_ActionEvents(
					new Double(getJTextFieldlUniformMin().getText())
							.doubleValue(),
					new Double(getJTextFieldlUniformMax().getText())
							.doubleValue(), getJCheckBoxRound().isSelected());
			connEtoM13(connEtoC3Result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
		return connEtoC3Result;
	}

	/**
	 * connEtoC4:
	 * (JButtonNormSelect.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * ChooseRandom.jButtonNormSelect_ActionEvents(DDZ)Ljava.lang.String;)
	 * 
	 * @return java.lang.String
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String connEtoC4(java.awt.event.ActionEvent arg1) {
		String connEtoC4Result = null;
		try {
			// user code begin {1}
			// user code end
			connEtoC4Result = this.jButtonNormSelect_ActionEvents(new Double(
					getJTextFieldNormM().getText()).doubleValue(), new Double(
					getJTextFieldErlangK1().getText()).doubleValue(),
					getJCheckBoxRound().isSelected());
			connEtoM11(connEtoC4Result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
		return connEtoC4Result;
	}

	/**
	 * connEtoC6: (ChooseRandomPane.component. -->
	 * ChooseRandom.chooseRandomPane_ComponentShown(Ljava.awt.event.ComponentEvent;)V)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoC6() {
		try {
			// user code begin {1}
			// user code end
			this.chooseRandomPane_ComponentShown(null);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoC7:
	 * (JButtonlUniformSelect11.action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom.jButtonDiscretSelect_ActionPerformed(Ljava.lang.String;Ljava.lang.String;Z)Ljava.lang.String;)
	 * 
	 * @return java.lang.String
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String connEtoC7(java.awt.event.ActionEvent arg1) {
		String connEtoC7Result = null;
		try {
			// user code begin {1}
			// user code end
			connEtoC7Result = this.jButtonDiscretSelect_ActionPerformed(
					getJTextFieldlUniformMin11().getText(),
					getJTextFieldlUniformMax11().getText(), getJCheckBoxRound()
							.isSelected());
			connEtoM15(connEtoC7Result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
		return connEtoC7Result;
	}

	/**
	 * connEtoC8:
	 * (JButtonlUniformSelect1.action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom.jButtonLinearSelect_ActionPerformed(Ljava.lang.String;Ljava.lang.String;Z)Ljava.lang.String;)
	 * 
	 * @return java.lang.String
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private java.lang.String connEtoC8(java.awt.event.ActionEvent arg1) {
		String connEtoC8Result = null;
		try {
			// user code begin {1}
			// user code end
			connEtoC8Result = this.jButtonLinearSelect_ActionPerformed(
					getJTextFieldlUniformMin1().getText(),
					getJTextFieldlUniformMax1().getText(), getJCheckBoxRound()
							.isSelected());
			connEtoM18(connEtoC8Result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
		return connEtoC8Result;
	}

	/**
	 * connEtoM1: (JButton1.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> JDialog1.show()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM1(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelNegexp().setVisible(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM10:
	 * (JMenuItemNorm.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * JPanelNorm.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM10(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelNorm().setVisible(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM11: (
	 * (JButtonNormSelect,action.actionPerformed(java.awt.event.ActionEvent) -->
	 * ChooseRandom,jButtonNormSelect_ActionEvents(DDZ)Ljava.lang.String;).normalResult
	 * --> JTextFieldRandomAsString.text)
	 * 
	 * @param result
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM11(java.lang.String result) {
		try {
			// user code begin {1}
			// user code end
			getJTextFieldRandomAsString().setText(result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM12:
	 * (JButtonNormSelect.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * JDialogChooseRandom.dispose()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM12(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJDialogChooseRandom().dispose();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM13: (
	 * (JButtonlUniformSelect,action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom,jButtonlUniformSelect_ActionEvents(DDZ)Ljava.lang.String;).normalResult
	 * --> JTextFieldRandomAsString.text)
	 * 
	 * @param result
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM13(java.lang.String result) {
		try {
			// user code begin {1}
			// user code end
			getJTextFieldRandomAsString().setText(result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM14:
	 * (JMenuItemDiscret.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * JPanelDiscret.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM14(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelDiscret().setVisible(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM15: (
	 * (JButtonlUniformSelect11,action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom,jButtonDiscretSelect_ActionPerformed(Ljava.lang.String;Ljava.lang.String;Z)Ljava.lang.String;).normalResult
	 * --> JTextFieldRandomAsString.text)
	 * 
	 * @param result
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM15(java.lang.String result) {
		try {
			// user code begin {1}
			// user code end
			getJTextFieldRandomAsString().setText(result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM16:
	 * (JButtonlUniformSelect11.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> JDialogChooseRandom.dispose()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM16(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJDialogChooseRandom().dispose();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM17:
	 * (JMenuItemLinear.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * JPanelLinear.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM17(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelLinear().setVisible(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM18: (
	 * (JButtonlUniformSelect1,action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom,jButtonLinearSelect_ActionPerformed(Ljava.lang.String;Ljava.lang.String;Z)Ljava.lang.String;).normalResult
	 * --> JTextFieldRandomAsString.text)
	 * 
	 * @param result
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM18(java.lang.String result) {
		try {
			// user code begin {1}
			// user code end
			getJTextFieldRandomAsString().setText(result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM19:
	 * (JButtonlUniformSelect1.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> JDialogChooseRandom.dispose()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM19(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJDialogChooseRandom().dispose();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM2:
	 * (JButtonChoose.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * JDialogChooseRandom.show()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM2(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJDialogChooseRandom().setVisible(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM20: (JMenu1.mouse.mouseClicked(java.awt.event.MouseEvent) -->
	 * JPanelNegexp.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM20(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelNegexp().setVisible(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM21: (JMenu1.mouse.mousePressed(java.awt.event.MouseEvent) -->
	 * JPanelErlang.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM21(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelErlang().setVisible(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM22: (JMenu1.mouse.mousePressed(java.awt.event.MouseEvent) -->
	 * JPanelNorm.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM22(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelNorm().setVisible(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM23: (JMenu1.mouse.mousePressed(java.awt.event.MouseEvent) -->
	 * JPanelUniform.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM23(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelUniform().setVisible(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM24: (JMenu1.mouse.mousePressed(java.awt.event.MouseEvent) -->
	 * JPanelLinear.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM24(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelLinear().setVisible(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM25: (JMenu1.mouse.mousePressed(java.awt.event.MouseEvent) -->
	 * JPanelUniform.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM25(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelUniform().setVisible(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM26: (JMenu1.mouse.mousePressed(java.awt.event.MouseEvent) -->
	 * JPanelDiscret.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.MouseEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM26(java.awt.event.MouseEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelDiscret().setVisible(false);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM3: (
	 * (JButtonNegexpSelect,action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom,jButtonNegexpSelect_ActionEvents(DZ)Ljava.lang.String;).normalResult
	 * --> JTextFieldRandomAsString.text)
	 * 
	 * @param result
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM3(java.lang.String result) {
		try {
			// user code begin {1}
			// user code end
			getJTextFieldRandomAsString().setText(result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM4:
	 * (JButtonNegexpSelect.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> JDialogChooseRandom.defaultCloseOperation)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM4(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJDialogChooseRandom().dispose();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM5:
	 * (JMenuItemErlang.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * JPanelErlang.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM5(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelErlang().setVisible(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM6: (
	 * (JButtonErlangSelect,action.actionPerformed(java.awt.event.ActionEvent)
	 * -->
	 * ChooseRandom,jButtonErlangSelect_ActionPerformed1(DIZ)Ljava.lang.String;).normalResult
	 * --> JTextFieldRandomAsString.text)
	 * 
	 * @param result
	 *            java.lang.String
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM6(java.lang.String result) {
		try {
			// user code begin {1}
			// user code end
			getJTextFieldRandomAsString().setText(result);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM7:
	 * (JButtonErlangSelect.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> JDialogChooseRandom.dispose()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM7(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJDialogChooseRandom().dispose();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM8:
	 * (JMenuItemUniform.action.actionPerformed(java.awt.event.ActionEvent) -->
	 * JPanelUniform.visible)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM8(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJPanelUniform().setVisible(true);
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connEtoM9:
	 * (JButtonlUniformSelect.action.actionPerformed(java.awt.event.ActionEvent)
	 * --> JDialogChooseRandom.dispose()V)
	 * 
	 * @param arg1
	 *            java.awt.event.ActionEvent
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connEtoM9(java.awt.event.ActionEvent arg1) {
		try {
			// user code begin {1}
			// user code end
			getJDialogChooseRandom().dispose();
			// user code begin {2}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * connPtoP1SetTarget: (JDialogChooseRandom.location <-->
	 * ChooseRandomPane.location)
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void connPtoP1SetTarget() {
		/* Set the target from the source */
		try {
			this.setLocation(getJDialogChooseRandom().getLocation());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {3}
			// user code end
			handleException(ivjExc);
		}
	}

	/**
	 * Insert the method's description here. Creation date: (01.04.2005
	 * 20:07:17)
	 * 
	 * @return double[]
	 * @param str
	 *            java.lang.String
	 */
	public static double[] convertStringToDoubleArray(String str) {
		StringTokenizer st = new StringTokenizer(str);
		double[] array = new double[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			try {
				array[i] = Double.parseDouble(st.nextToken());
			} catch (NumberFormatException e) {
				System.out.println(str
						+ " It is impossible to convert into NumberArray");
				e.printStackTrace();
				array[i] = 0;
			}

			i++;
		}
		return array;
	}

	/**
	 * Return the JButton1 property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonChoose() {
		if (ivjJButtonChoose == null) {
			try {
				ivjJButtonChoose = new javax.swing.JButton();
				ivjJButtonChoose.setName("JButtonChoose");
				ivjJButtonChoose.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/widgets/open.gif")));
//				ivjJButtonChoose.setFont(new java.awt.Font("dialog", 1, 12));
//				ivjJButtonChoose.setText("");
//				ivjJButtonChoose.setContentAreaFilled(true);
				// user code begin {1}
//				int wpp = this.getWidth();
				ivjJButtonChoose.setMargin(new Insets(-4, 0, -6, 0));
//				int hpp = this.getHeight();
//		ivjJButtonChoose.setBounds(1, 1, hpp - 2, wpp - 2);
//						ivjJButtonChoose.setLocation(1, 1);
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}

				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonChoose;
	}

	/**
	 * Return the JButtonErlangSelect property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonErlangSelect() {
		if (ivjJButtonErlangSelect == null) {
			try {
				ivjJButtonErlangSelect = new javax.swing.JButton();
				ivjJButtonErlangSelect.setName("JButtonErlangSelect");
				ivjJButtonErlangSelect.setText("Вибір");
				ivjJButtonErlangSelect.setBounds(147, 92, 74, 25);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonErlangSelect;
	}

	/**
	 * Return the JButtonlUniformSelect property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonlUniformSelect() {
		if (ivjJButtonlUniformSelect == null) {
			try {
				ivjJButtonlUniformSelect = new javax.swing.JButton();
				ivjJButtonlUniformSelect.setName("JButtonlUniformSelect");
				ivjJButtonlUniformSelect.setText("Вибір");
				ivjJButtonlUniformSelect.setBounds(147, 92, 74, 25);
				ivjJButtonlUniformSelect.setVisible(true);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonlUniformSelect;
	}

	/**
	 * Return the JButtonlUniformSelect1 property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonlUniformSelect1() {
		if (ivjJButtonlUniformSelect1 == null) {
			try {
				ivjJButtonlUniformSelect1 = new javax.swing.JButton();
				ivjJButtonlUniformSelect1.setName("JButtonlUniformSelect1");
				ivjJButtonlUniformSelect1.setText("Вибір");
				ivjJButtonlUniformSelect1.setBounds(147, 92, 74, 25);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonlUniformSelect1;
	}

	/**
	 * Return the JButtonlUniformSelect11 property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonlUniformSelect11() {
		if (ivjJButtonlUniformSelect11 == null) {
			try {
				ivjJButtonlUniformSelect11 = new javax.swing.JButton();
				ivjJButtonlUniformSelect11.setName("JButtonlUniformSelect11");
				ivjJButtonlUniformSelect11.setText("Вибір");
				ivjJButtonlUniformSelect11.setBounds(147, 92, 74, 25);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonlUniformSelect11;
	}

	/**
	 * Return the JButton2 property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonNegexpSelect() {
		if (ivjJButtonNegexpSelect == null) {
			try {
				ivjJButtonNegexpSelect = new javax.swing.JButton();
				ivjJButtonNegexpSelect.setName("JButtonNegexpSelect");
				ivjJButtonNegexpSelect.setText("Вибір");
				ivjJButtonNegexpSelect.setBounds(148, 100, 74, 25);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonNegexpSelect;
	}

	/**
	 * Return the JButtonNormSelect property value.
	 * 
	 * @return javax.swing.JButton
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JButton getJButtonNormSelect() {
		if (ivjJButtonNormSelect == null) {
			try {
				ivjJButtonNormSelect = new javax.swing.JButton();
				ivjJButtonNormSelect.setName("JButtonNormSelect");
				ivjJButtonNormSelect.setText("Вибір");
				ivjJButtonNormSelect.setBounds(147, 92, 74, 25);
				ivjJButtonNormSelect.setVisible(true);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJButtonNormSelect;
	}

	/**
	 * Return the JCheckBox1 property value.
	 * 
	 * @return javax.swing.JCheckBox
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JCheckBox getJCheckBoxRound() {
		if (ivjJCheckBoxRound == null) {
			try {
				ivjJCheckBoxRound = new javax.swing.JCheckBox();
				ivjJCheckBoxRound.setName("JCheckBoxRound");
				ivjJCheckBoxRound.setSelected(false);
				ivjJCheckBoxRound.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJCheckBoxRound.setText("Округляти до цілого");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJCheckBoxRound;
	}

	/**
	 * Return the JDialog1 property value.
	 * 
	 * @return javax.swing.JDialog
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JDialog getJDialogChooseRandom() {
		if (ivjJDialogChooseRandom == null) {
			try {
				ivjJDialogChooseRandom = new javax.swing.JDialog();
				ivjJDialogChooseRandom.setName("JDialogChooseRandom");
				ivjJDialogChooseRandom
						.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				ivjJDialogChooseRandom.setBounds(24, 173, 388, 244);
				ivjJDialogChooseRandom
						.setJMenuBar(getJDialogChooseRandomJMenuBar());
				getJDialogChooseRandom()
						.setContentPane(getJDialogContentPane());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJDialogChooseRandom;
	}

	/**
	 * Return the JDialogChooseRandomJMenuBar property value.
	 * 
	 * @return javax.swing.JMenuBar
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuBar getJDialogChooseRandomJMenuBar() {
		if (ivjJDialogChooseRandomJMenuBar == null) {
			try {
				ivjJDialogChooseRandomJMenuBar = new javax.swing.JMenuBar();
				ivjJDialogChooseRandomJMenuBar
						.setName("JDialogChooseRandomJMenuBar");
				ivjJDialogChooseRandomJMenuBar.add(getJMenu1());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJDialogChooseRandomJMenuBar;
	}

	/**
	 * Return the JDialogContentPane property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJDialogContentPane() {
		if (ivjJDialogContentPane == null) {
			try {
				ivjJDialogContentPane = new javax.swing.JPanel();
				ivjJDialogContentPane.setName("JDialogContentPane");
				ivjJDialogContentPane.setLayout(new java.awt.GridBagLayout());

				java.awt.GridBagConstraints constraintsJCheckBoxRound = new java.awt.GridBagConstraints();
				constraintsJCheckBoxRound.gridx = 0;
				constraintsJCheckBoxRound.gridy = 0;
				constraintsJCheckBoxRound.ipadx = 24;
				constraintsJCheckBoxRound.insets = new java.awt.Insets(7, 109,
						3, 125);
				getJDialogContentPane().add(getJCheckBoxRound(),
						constraintsJCheckBoxRound);

				java.awt.GridBagConstraints constraintsJPanelNegexp = new java.awt.GridBagConstraints();
				constraintsJPanelNegexp.gridx = 0;
				constraintsJPanelNegexp.gridy = 2;
				constraintsJPanelNegexp.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJPanelNegexp.weightx = 1.0;
				constraintsJPanelNegexp.weighty = 1.0;
				constraintsJPanelNegexp.ipadx = 385;
				constraintsJPanelNegexp.ipady = 143;
				constraintsJPanelNegexp.insets = new java.awt.Insets(3, 7, 21,
						7);
				getJDialogContentPane().add(getJPanelNegexp(),
						constraintsJPanelNegexp);

				java.awt.GridBagConstraints constraintsJPanelErlang = new java.awt.GridBagConstraints();
				constraintsJPanelErlang.gridx = 0;
				constraintsJPanelErlang.gridy = 2;
				constraintsJPanelErlang.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJPanelErlang.weightx = 1.0;
				constraintsJPanelErlang.weighty = 1.0;
				constraintsJPanelErlang.ipadx = 369;
				constraintsJPanelErlang.ipady = 126;
				constraintsJPanelErlang.insets = new java.awt.Insets(3, 7, 38,
						23);
				getJDialogContentPane().add(getJPanelErlang(),
						constraintsJPanelErlang);

				java.awt.GridBagConstraints constraintsJPanelNorm = new java.awt.GridBagConstraints();
				constraintsJPanelNorm.gridx = 0;
				constraintsJPanelNorm.gridy = 2;
				constraintsJPanelNorm.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJPanelNorm.weightx = 1.0;
				constraintsJPanelNorm.weighty = 1.0;
				constraintsJPanelNorm.ipadx = 369;
				constraintsJPanelNorm.ipady = 126;
				constraintsJPanelNorm.insets = new java.awt.Insets(12, 7, 29,
						23);
				getJDialogContentPane().add(getJPanelNorm(),
						constraintsJPanelNorm);

				java.awt.GridBagConstraints constraintsJPanelUniform = new java.awt.GridBagConstraints();
				constraintsJPanelUniform.gridx = 0;
				constraintsJPanelUniform.gridy = 2;
				constraintsJPanelUniform.gridwidth = 2;
				constraintsJPanelUniform.gridheight = 2;
				constraintsJPanelUniform.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJPanelUniform.weightx = 1.0;
				constraintsJPanelUniform.weighty = 1.0;
				constraintsJPanelUniform.ipadx = 369;
				constraintsJPanelUniform.ipady = 126;
				constraintsJPanelUniform.insets = new java.awt.Insets(8, 7, 33,
						23);
				getJDialogContentPane().add(getJPanelUniform(),
						constraintsJPanelUniform);

				java.awt.GridBagConstraints constraintsJPanelLinear = new java.awt.GridBagConstraints();
				constraintsJPanelLinear.gridx = 0;
				constraintsJPanelLinear.gridy = 2;
				constraintsJPanelLinear.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJPanelLinear.weightx = 1.0;
				constraintsJPanelLinear.weighty = 1.0;
				constraintsJPanelLinear.ipadx = 369;
				constraintsJPanelLinear.ipady = 126;
				constraintsJPanelLinear.insets = new java.awt.Insets(6, 7, 35,
						23);
				getJDialogContentPane().add(getJPanelLinear(),
						constraintsJPanelLinear);

				java.awt.GridBagConstraints constraintsJPanelDiscret = new java.awt.GridBagConstraints();
				constraintsJPanelDiscret.gridx = 0;
				constraintsJPanelDiscret.gridy = 2;
				constraintsJPanelDiscret.fill = java.awt.GridBagConstraints.BOTH;
				constraintsJPanelDiscret.weightx = 1.0;
				constraintsJPanelDiscret.weighty = 1.0;
				constraintsJPanelDiscret.ipadx = 369;
				constraintsJPanelDiscret.ipady = 126;
				constraintsJPanelDiscret.insets = new java.awt.Insets(5, 7, 36,
						23);
				getJDialogContentPane().add(getJPanelDiscret(),
						constraintsJPanelDiscret);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJDialogContentPane;
	}

	/**
	 * Return the JLabel1 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabel1() {
		if (ivjJLabel1 == null) {
			try {
				ivjJLabel1 = new javax.swing.JLabel();
				ivjJLabel1.setName("JLabel1");
				ivjJLabel1.setText("Параметри експоненційного розподілу");
				ivjJLabel1.setBounds(39, 10, 291, 14);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabel1;
	}

	/**
	 * Return the JLabelErlangK property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelErlangK() {
		if (ivjJLabelErlangK == null) {
			try {
				ivjJLabelErlangK = new javax.swing.JLabel();
				ivjJLabelErlangK.setName("JLabelErlangK");
				ivjJLabelErlangK.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelErlangK.setText("Коефіцієнт Ерланга");
				ivjJLabelErlangK.setBounds(38, 60, 131, 14);
				ivjJLabelErlangK.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelErlangK;
	}

	/**
	 * Return the JLabelErlangM property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelErlangM() {
		if (ivjJLabelErlangM == null) {
			try {
				ivjJLabelErlangM = new javax.swing.JLabel();
				ivjJLabelErlangM.setName("JLabelErlangM");
				ivjJLabelErlangM.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelErlangM.setText("Середнє значення");
				ivjJLabelErlangM.setBounds(57, 34, 112, 14);
				ivjJLabelErlangM.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelErlangM;
	}

	/**
	 * Return the JLabelErlangTitle property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelErlangTitle() {
		if (ivjJLabelErlangTitle == null) {
			try {
				ivjJLabelErlangTitle = new javax.swing.JLabel();
				ivjJLabelErlangTitle.setName("JLabelErlangTitle");
				ivjJLabelErlangTitle.setText("Параметри розподілу Ерланга");
				ivjJLabelErlangTitle.setBounds(75, 4, 218, 14);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelErlangTitle;
	}

	/**
	 * Return the JLabelNrgexpM property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelNegexpM() {
		if (ivjJLabelNegexpM == null) {
			try {
				ivjJLabelNegexpM = new javax.swing.JLabel();
				ivjJLabelNegexpM.setName("JLabelNegexpM");
				ivjJLabelNegexpM.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelNegexpM.setText("Середнє значення");
				ivjJLabelNegexpM.setBounds(69, 45, 118, 14);
				ivjJLabelNegexpM.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelNegexpM;
	}

	/**
	 * Return the JLabelNormM property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelNormM() {
		if (ivjJLabelNormM == null) {
			try {
				ivjJLabelNormM = new javax.swing.JLabel();
				ivjJLabelNormM.setName("JLabelNormM");
				ivjJLabelNormM.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelNormM.setText("Середнє значення");
				ivjJLabelNormM.setBounds(85, 35, 112, 14);
				ivjJLabelNormM.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelNormM;
	}

	/**
	 * Return the JLabelNormSigma property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelNormSigma() {
		if (ivjJLabelNormSigma == null) {
			try {
				ivjJLabelNormSigma = new javax.swing.JLabel();
				ivjJLabelNormSigma.setName("JLabelNormSigma");
				ivjJLabelNormSigma.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelNormSigma.setText("Стандартне відхілення");
				ivjJLabelNormSigma.setBounds(29, 60, 168, 14);
				ivjJLabelNormSigma.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelNormSigma;
	}

	/**
	 * Return the JLabelNormTitle property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelNormTitle() {
		if (ivjJLabelNormTitle == null) {
			try {
				ivjJLabelNormTitle = new javax.swing.JLabel();
				ivjJLabelNormTitle.setName("JLabelNormTitle");
				ivjJLabelNormTitle
						.setText("Параметри нормального розподілу ");
				ivjJLabelNormTitle.setBounds(57, 4, 254, 14);
				ivjJLabelNormTitle.setVisible(true);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelNormTitle;
	}

	/**
	 * Return the JLabelUniformMax property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMax() {
		if (ivjJLabelUniformMax == null) {
			try {
				ivjJLabelUniformMax = new javax.swing.JLabel();
				ivjJLabelUniformMax.setName("JLabelUniformMax");
				ivjJLabelUniformMax.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelUniformMax.setText("Мінімальне значення");
				ivjJLabelUniformMax.setBounds(48, 35, 142, 14);
				ivjJLabelUniformMax.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMax;
	}

	/**
	 * Return the JLabelUniformMax1 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMax1() {
		if (ivjJLabelUniformMax1 == null) {
			try {
				ivjJLabelUniformMax1 = new javax.swing.JLabel();
				ivjJLabelUniformMax1.setName("JLabelUniformMax1");
				ivjJLabelUniformMax1
						.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelUniformMax1.setText("змінної в узлах");
				ivjJLabelUniformMax1.setBounds(18, 46, 119, 14);
				ivjJLabelUniformMax1.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMax1;
	}

	/**
	 * Return the JLabelUniformMax11 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMax11() {
		if (ivjJLabelUniformMax11 == null) {
			try {
				ivjJLabelUniformMax11 = new javax.swing.JLabel();
				ivjJLabelUniformMax11.setName("JLabelUniformMax11");
				ivjJLabelUniformMax11
						.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelUniformMax11.setText("Значення:");
				ivjJLabelUniformMax11.setBounds(44, 26, 64, 14);
				ivjJLabelUniformMax11.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMax11;
	}

	/**
	 * Return the JLabelUniformMax111 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMax111() {
		if (ivjJLabelUniformMax111 == null) {
			try {
				ivjJLabelUniformMax111 = new javax.swing.JLabel();
				ivjJLabelUniformMax111.setName("JLabelUniformMax111");
				ivjJLabelUniformMax111.setFont(new java.awt.Font("dialog", 0,
						12));
				ivjJLabelUniformMax111.setText("Значення:");
				ivjJLabelUniformMax111.setBounds(44, 26, 64, 14);
				ivjJLabelUniformMax111.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMax111;
	}

	/**
	 * Return the JLabelUniformMax12 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMax12() {
		if (ivjJLabelUniformMax12 == null) {
			try {
				ivjJLabelUniformMax12 = new javax.swing.JLabel();
				ivjJLabelUniformMax12.setName("JLabelUniformMax12");
				ivjJLabelUniformMax12
						.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelUniformMax12.setText("Значення змінної ");
				ivjJLabelUniformMax12.setBounds(7, 46, 134, 14);
				ivjJLabelUniformMax12.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMax12;
	}

	/**
	 * Return the JLabelUniformMin property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMin() {
		if (ivjJLabelUniformMin == null) {
			try {
				ivjJLabelUniformMin = new javax.swing.JLabel();
				ivjJLabelUniformMin.setName("JLabelUniformMin");
				ivjJLabelUniformMin.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelUniformMin.setText("Максимальне значення");
				ivjJLabelUniformMin.setBounds(47, 60, 150, 14);
				ivjJLabelUniformMin.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMin;
	}

	/**
	 * Return the JLabelUniformMin1 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMin1() {
		if (ivjJLabelUniformMin1 == null) {
			try {
				ivjJLabelUniformMin1 = new javax.swing.JLabel();
				ivjJLabelUniformMin1.setName("JLabelUniformMin1");
				ivjJLabelUniformMin1
						.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelUniformMin1.setText("інтегральної функції");
				ivjJLabelUniformMin1.setBounds(6, 71, 132, 14);
				ivjJLabelUniformMin1.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMin1;
	}

	/**
	 * Return the JLabelUniformMin11 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformMin11() {
		if (ivjJLabelUniformMin11 == null) {
			try {
				ivjJLabelUniformMin11 = new javax.swing.JLabel();
				ivjJLabelUniformMin11.setName("JLabelUniformMin11");
				ivjJLabelUniformMin11
						.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJLabelUniformMin11.setText("Ймовірності");
				ivjJLabelUniformMin11.setBounds(63, 72, 78, 14);
				ivjJLabelUniformMin11.setForeground(java.awt.Color.black);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformMin11;
	}

	/**
	 * Return the JLabelUniformTitle property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformTitle() {
		if (ivjJLabelUniformTitle == null) {
			try {
				ivjJLabelUniformTitle = new javax.swing.JLabel();
				ivjJLabelUniformTitle.setName("JLabelUniformTitle");
				ivjJLabelUniformTitle
						.setText("Параметри рівномірного розподілу ");
				ivjJLabelUniformTitle.setBounds(57, 4, 254, 14);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformTitle;
	}

	/**
	 * Return the JLabelUniformTitle1 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformTitle1() {
		if (ivjJLabelUniformTitle1 == null) {
			try {
				ivjJLabelUniformTitle1 = new javax.swing.JLabel();
				ivjJLabelUniformTitle1.setName("JLabelUniformTitle1");
				ivjJLabelUniformTitle1
						.setText("Параметри довільного розподілу ");
				ivjJLabelUniformTitle1.setBounds(54, 4, 261, 14);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformTitle1;
	}

	/**
	 * Return the JLabelUniformTitle11 property value.
	 * 
	 * @return javax.swing.JLabel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JLabel getJLabelUniformTitle11() {
		if (ivjJLabelUniformTitle11 == null) {
			try {
				ivjJLabelUniformTitle11 = new javax.swing.JLabel();
				ivjJLabelUniformTitle11.setName("JLabelUniformTitle11");
				ivjJLabelUniformTitle11
						.setText("Параметри дискретного розподілу ");
				ivjJLabelUniformTitle11.setBounds(54, 4, 261, 14);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJLabelUniformTitle11;
	}

	/**
	 * Return the JMenu1 property value.
	 * 
	 * @return javax.swing.JMenu
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenu getJMenu1() {
		if (ivjJMenu1 == null) {
			try {
				ivjJMenu1 = new javax.swing.JMenu();
				ivjJMenu1.setName("JMenu1");
				ivjJMenu1.setFont(new java.awt.Font("dialog", 1, 12));
				ivjJMenu1.setText("Виберіть розподіл");
				ivjJMenu1.add(getJMenuNegexp());
				ivjJMenu1.add(getJMenuItemErlang());
				ivjJMenu1.add(getJMenuItemNorm());
				ivjJMenu1.add(getJMenuItemUniform());
				ivjJMenu1.add(getJMenuItemLinear());
				ivjJMenu1.add(getJMenuItemDiscret());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJMenu1;
	}

	/**
	 * Return the JMenuItem14 property value.
	 * 
	 * @return javax.swing.JMenuItem
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuItem getJMenuItemDiscret() {
		if (ivjJMenuItemDiscret == null) {
			try {
				ivjJMenuItemDiscret = new javax.swing.JMenuItem();
				ivjJMenuItemDiscret.setName("JMenuItemDiscret");
				ivjJMenuItemDiscret.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJMenuItemDiscret.setText("Дискретний");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJMenuItemDiscret;
	}

	/**
	 * Return the JMenuItem12 property value.
	 * 
	 * @return javax.swing.JMenuItem
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuItem getJMenuItemErlang() {
		if (ivjJMenuItemErlang == null) {
			try {
				ivjJMenuItemErlang = new javax.swing.JMenuItem();
				ivjJMenuItemErlang.setName("JMenuItemErlang");
				ivjJMenuItemErlang.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJMenuItemErlang.setText("Ерланга");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJMenuItemErlang;
	}

	/**
	 * Return the JMenuItem13 property value.
	 * 
	 * @return javax.swing.JMenuItem
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuItem getJMenuItemLinear() {
		if (ivjJMenuItemLinear == null) {
			try {
				ivjJMenuItemLinear = new javax.swing.JMenuItem();
				ivjJMenuItemLinear.setName("JMenuItemLinear");
				ivjJMenuItemLinear.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJMenuItemLinear.setText("Довільний");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJMenuItemLinear;
	}

	/**
	 * Return the JMenuItem1 property value.
	 * 
	 * @return javax.swing.JMenuItem
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuItem getJMenuItemNorm() {
		if (ivjJMenuItemNorm == null) {
			try {
				ivjJMenuItemNorm = new javax.swing.JMenuItem();
				ivjJMenuItemNorm.setName("JMenuItemNorm");
				ivjJMenuItemNorm.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJMenuItemNorm.setText("Нормальний");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJMenuItemNorm;
	}

	/**
	 * Return the JMenuItemUniform property value.
	 * 
	 * @return javax.swing.JMenuItem
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuItem getJMenuItemUniform() {
		if (ivjJMenuItemUniform == null) {
			try {
				ivjJMenuItemUniform = new javax.swing.JMenuItem();
				ivjJMenuItemUniform.setName("JMenuItemUniform");
				ivjJMenuItemUniform.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJMenuItemUniform.setText("Рівномірний");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJMenuItemUniform;
	}

	/**
	 * Return the JMenuItem2 property value.
	 * 
	 * @return javax.swing.JMenuItem
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JMenuItem getJMenuNegexp() {
		if (ivjJMenuNegexp == null) {
			try {
				ivjJMenuNegexp = new javax.swing.JMenuItem();
				ivjJMenuNegexp.setName("JMenuNegexp");
				ivjJMenuNegexp.setFont(new java.awt.Font("dialog", 0, 12));
				ivjJMenuNegexp.setText("Експоненційний");
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJMenuNegexp;
	}

	/**
	 * Return the JPanelDiscret property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanelDiscret() {
		if (ivjJPanelDiscret == null) {
			try {
				ivjJPanelDiscret = new javax.swing.JPanel();
				ivjJPanelDiscret.setName("JPanelDiscret");
				ivjJPanelDiscret.setLayout(null);
				ivjJPanelDiscret.setVisible(false);
				getJPanelDiscret().add(getJLabelUniformMax12(),
						getJLabelUniformMax12().getName());
				getJPanelDiscret().add(getJTextFieldlUniformMin11(),
						getJTextFieldlUniformMin11().getName());
				getJPanelDiscret().add(getJButtonlUniformSelect11(),
						getJButtonlUniformSelect11().getName());
				getJPanelDiscret().add(getJLabelUniformMin11(),
						getJLabelUniformMin11().getName());
				getJPanelDiscret().add(getJTextFieldlUniformMax11(),
						getJTextFieldlUniformMax11().getName());
				getJPanelDiscret().add(getJLabelUniformTitle11(),
						getJLabelUniformTitle11().getName());
				getJPanelDiscret().add(getJLabelUniformMax111(),
						getJLabelUniformMax111().getName());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanelDiscret;
	}

	/**
	 * Return the JPanelErlang property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanelErlang() {
		if (ivjJPanelErlang == null) {
			try {
				ivjJPanelErlang = new javax.swing.JPanel();
				ivjJPanelErlang.setName("JPanelErlang");
				ivjJPanelErlang.setLayout(null);
				ivjJPanelErlang.setVisible(false);
				getJPanelErlang().add(getJLabelErlangM(),
						getJLabelErlangM().getName());
				getJPanelErlang().add(getJTextFieldErlangM(),
						getJTextFieldErlangM().getName());
				getJPanelErlang().add(getJButtonErlangSelect(),
						getJButtonErlangSelect().getName());
				getJPanelErlang().add(getJLabelErlangK(),
						getJLabelErlangK().getName());
				getJPanelErlang().add(getJTextFieldErlangK(),
						getJTextFieldErlangK().getName());
				getJPanelErlang().add(getJLabelErlangTitle(),
						getJLabelErlangTitle().getName());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanelErlang;
	}

	/**
	 * Return the JPanelLinear property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanelLinear() {
		if (ivjJPanelLinear == null) {
			try {
				ivjJPanelLinear = new javax.swing.JPanel();
				ivjJPanelLinear.setName("JPanelLinear");
				ivjJPanelLinear.setLayout(null);
				ivjJPanelLinear.setVisible(false);
				getJPanelLinear().add(getJLabelUniformMax1(),
						getJLabelUniformMax1().getName());
				getJPanelLinear().add(getJTextFieldlUniformMin1(),
						getJTextFieldlUniformMin1().getName());
				getJPanelLinear().add(getJButtonlUniformSelect1(),
						getJButtonlUniformSelect1().getName());
				getJPanelLinear().add(getJLabelUniformMin1(),
						getJLabelUniformMin1().getName());
				getJPanelLinear().add(getJTextFieldlUniformMax1(),
						getJTextFieldlUniformMax1().getName());
				getJPanelLinear().add(getJLabelUniformTitle1(),
						getJLabelUniformTitle1().getName());
				getJPanelLinear().add(getJLabelUniformMax11(),
						getJLabelUniformMax11().getName());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanelLinear;
	}

	/**
	 * Return the JPanel2 property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanelNegexp() {
		if (ivjJPanelNegexp == null) {
			try {
				ivjJPanelNegexp = new javax.swing.JPanel();
				ivjJPanelNegexp.setName("JPanelNegexp");
				ivjJPanelNegexp.setLayout(null);
				ivjJPanelNegexp.setVisible(true);
				getJPanelNegexp().add(getJLabelNegexpM(),
						getJLabelNegexpM().getName());
				getJPanelNegexp().add(getJTextFieldNegexpM(),
						getJTextFieldNegexpM().getName());
				getJPanelNegexp().add(getJButtonNegexpSelect(),
						getJButtonNegexpSelect().getName());
				getJPanelNegexp().add(getJLabel1(), getJLabel1().getName());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanelNegexp;
	}

	/**
	 * Return the JPanelNorm property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanelNorm() {
		if (ivjJPanelNorm == null) {
			try {
				ivjJPanelNorm = new javax.swing.JPanel();
				ivjJPanelNorm.setName("JPanelNorm");
				ivjJPanelNorm.setLayout(null);
				ivjJPanelNorm.setVisible(false);
				getJPanelNorm().add(getJLabelNormM(),
						getJLabelNormM().getName());
				getJPanelNorm().add(getJTextFieldNormM(),
						getJTextFieldNormM().getName());
				getJPanelNorm().add(getJButtonNormSelect(),
						getJButtonNormSelect().getName());
				getJPanelNorm().add(getJLabelNormSigma(),
						getJLabelNormSigma().getName());
				getJPanelNorm().add(getJTextFieldErlangK1(),
						getJTextFieldErlangK1().getName());
				getJPanelNorm().add(getJLabelNormTitle(),
						getJLabelNormTitle().getName());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanelNorm;
	}

	/**
	 * Return the JPanelUniform property value.
	 * 
	 * @return javax.swing.JPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JPanel getJPanelUniform() {
		if (ivjJPanelUniform == null) {
			try {
				ivjJPanelUniform = new javax.swing.JPanel();
				ivjJPanelUniform.setName("JPanelUniform");
				ivjJPanelUniform.setLayout(null);
				ivjJPanelUniform.setVisible(false);
				getJPanelUniform().add(getJLabelUniformMax(),
						getJLabelUniformMax().getName());
				getJPanelUniform().add(getJTextFieldlUniformMin(),
						getJTextFieldlUniformMin().getName());
				getJPanelUniform().add(getJButtonlUniformSelect(),
						getJButtonlUniformSelect().getName());
				getJPanelUniform().add(getJLabelUniformMin(),
						getJLabelUniformMin().getName());
				getJPanelUniform().add(getJTextFieldlUniformMax(),
						getJTextFieldlUniformMax().getName());
				getJPanelUniform().add(getJLabelUniformTitle(),
						getJLabelUniformTitle().getName());
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJPanelUniform;
	}

	/**
	 * Return the JTextFieldErlangK property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldErlangK() {
		if (ivjJTextFieldErlangK == null) {
			try {
				ivjJTextFieldErlangK = new javax.swing.JTextField();
				ivjJTextFieldErlangK.setName("JTextFieldErlangK");
				ivjJTextFieldErlangK.setBounds(180, 58, 93, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldErlangK;
	}

	/**
	 * Return the JTextFieldErlangK1 property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldErlangK1() {
		if (ivjJTextFieldErlangK1 == null) {
			try {
				ivjJTextFieldErlangK1 = new javax.swing.JTextField();
				ivjJTextFieldErlangK1.setName("JTextFieldErlangK1");
				ivjJTextFieldErlangK1.setBounds(205, 58, 93, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldErlangK1;
	}

	/**
	 * Return the JTextFieldErlangM property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldErlangM() {
		if (ivjJTextFieldErlangM == null) {
			try {
				ivjJTextFieldErlangM = new javax.swing.JTextField();
				ivjJTextFieldErlangM.setName("JTextFieldErlangM");
				ivjJTextFieldErlangM.setBounds(180, 32, 93, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldErlangM;
	}

	/**
	 * Return the JTextFieldlUniformMax property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldlUniformMax() {
		if (ivjJTextFieldlUniformMax == null) {
			try {
				ivjJTextFieldlUniformMax = new javax.swing.JTextField();
				ivjJTextFieldlUniformMax.setName("JTextFieldlUniformMax");
				ivjJTextFieldlUniformMax.setBounds(205, 58, 93, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldlUniformMax;
	}

	/**
	 * Return the JTextFieldlUniformMax1 property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldlUniformMax1() {
		if (ivjJTextFieldlUniformMax1 == null) {
			try {
				ivjJTextFieldlUniformMax1 = new javax.swing.JTextField();
				ivjJTextFieldlUniformMax1.setName("JTextFieldlUniformMax1");
				ivjJTextFieldlUniformMax1.setBounds(141, 69, 232, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldlUniformMax1;
	}

	/**
	 * Return the JTextFieldlUniformMax11 property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldlUniformMax11() {
		if (ivjJTextFieldlUniformMax11 == null) {
			try {
				ivjJTextFieldlUniformMax11 = new javax.swing.JTextField();
				ivjJTextFieldlUniformMax11.setName("JTextFieldlUniformMax11");
				ivjJTextFieldlUniformMax11.setBounds(148, 69, 225, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldlUniformMax11;
	}

	/**
	 * Return the JTextFieldlUniformMin property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldlUniformMin() {
		if (ivjJTextFieldlUniformMin == null) {
			try {
				ivjJTextFieldlUniformMin = new javax.swing.JTextField();
				ivjJTextFieldlUniformMin.setName("JTextFieldlUniformMin");
				ivjJTextFieldlUniformMin.setBounds(205, 33, 93, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldlUniformMin;
	}

	/**
	 * Return the JTextFieldlUniformMin1 property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldlUniformMin1() {
		if (ivjJTextFieldlUniformMin1 == null) {
			try {
				ivjJTextFieldlUniformMin1 = new javax.swing.JTextField();
				ivjJTextFieldlUniformMin1.setName("JTextFieldlUniformMin1");
				ivjJTextFieldlUniformMin1.setBounds(141, 44, 232, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldlUniformMin1;
	}

	/**
	 * Return the JTextFieldlUniformMin11 property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldlUniformMin11() {
		if (ivjJTextFieldlUniformMin11 == null) {
			try {
				ivjJTextFieldlUniformMin11 = new javax.swing.JTextField();
				ivjJTextFieldlUniformMin11.setName("JTextFieldlUniformMin11");
				ivjJTextFieldlUniformMin11.setBounds(148, 44, 225, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldlUniformMin11;
	}

	/**
	 * Return the JTextField2 property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldNegexpM() {
		if (ivjJTextFieldNegexpM == null) {
			try {
				ivjJTextFieldNegexpM = new javax.swing.JTextField();
				ivjJTextFieldNegexpM.setName("JTextFieldNegexpM");
				ivjJTextFieldNegexpM.setText("1");
				ivjJTextFieldNegexpM.setBounds(194, 43, 93, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldNegexpM;
	}

	/**
	 * Return the JTextFieldNormM property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldNormM() {
		if (ivjJTextFieldNormM == null) {
			try {
				ivjJTextFieldNormM = new javax.swing.JTextField();
				ivjJTextFieldNormM.setName("JTextFieldNormM");
				ivjJTextFieldNormM.setBounds(205, 33, 93, 18);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldNormM;
	}

	/**
	 * Return the JTextField1 property value.
	 * 
	 * @return javax.swing.JTextField
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private javax.swing.JTextField getJTextFieldRandomAsString() {
		if (ivjJTextFieldRandomAsString == null) {
			try {
				ivjJTextFieldRandomAsString = new javax.swing.JTextField();
				ivjJTextFieldRandomAsString.setName("JTextFieldRandomAsString");
				ivjJTextFieldRandomAsString
						.setDisabledTextColor(java.awt.Color.black);
				ivjJTextFieldRandomAsString.setCaretColor(java.awt.Color.gray);
				ivjJTextFieldRandomAsString.setEditable(false);
				ivjJTextFieldRandomAsString.setMargin(new Insets(0, 0, 0, 0));
				ivjJTextFieldRandomAsString.setEnabled(true);
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjJTextFieldRandomAsString;
	}

	/**
	 * Method generated to support the promotion of the
	 * JTextFieldRandomAsStringFont attribute.
	 * 
	 * @return java.awt.Font
	 */
	public java.awt.Font getJTextFieldRandomAsStringFont() {
		return getJTextFieldRandomAsString().getFont();
	}

	/**
	 * Insert the method's description here. Creation date: (27.03.2005
	 * 20:33:45)
	 * 
	 * @return rnd.RandomGenerators
	 */
	public RandomGenerators getRandom() {
		if (random == null) {
			random = new Negexp(1.0);
		}
		return random;
	}

	/**
	 * Called whenever the part throws an exception.
	 * 
	 * @param exception
	 *            java.lang.Throwable
	 */
	private void handleException(java.lang.Throwable exception) {

		/* Uncomment the following lines to print uncaught exceptions to stdout */
		// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
		// exception.printStackTrace(System.out);
	}

	/**
	 * Initializes connections
	 * 
	 * @exception java.lang.Exception
	 *                The exception description.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initConnections() throws java.lang.Exception {
		// user code begin {1}
		// user code end
		getJMenuNegexp().addActionListener(ivjEventHandler);
		getJButtonChoose().addActionListener(ivjEventHandler);
		getJButtonNegexpSelect().addActionListener(ivjEventHandler);
		getJMenuItemErlang().addActionListener(ivjEventHandler);
		getJButtonErlangSelect().addActionListener(ivjEventHandler);
		getJMenuItemUniform().addActionListener(ivjEventHandler);
		getJButtonlUniformSelect().addActionListener(ivjEventHandler);
		getJMenuItemNorm().addActionListener(ivjEventHandler);
		getJButtonNormSelect().addActionListener(ivjEventHandler);
		getJMenuItemDiscret().addActionListener(ivjEventHandler);
		getJButtonlUniformSelect11().addActionListener(ivjEventHandler);
		getJMenuItemLinear().addActionListener(ivjEventHandler);
		getJButtonlUniformSelect1().addActionListener(ivjEventHandler);
		getJMenu1().addMouseListener(ivjEventHandler);
		connPtoP1SetTarget();
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			this
			.setBorder(javax.swing.BorderFactory
					.createCompoundBorder(
							javax.swing.BorderFactory
									.createTitledBorder(
											null,
											title,
											javax.swing.border.TitledBorder.CENTER,
											javax.swing.border.TitledBorder.BELOW_TOP,
											null, null),
							javax.swing.BorderFactory
									.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));


			// user code end
			setName("ChooseRandomPane");
			//setBorder(new javax.swing.border.EtchedBorder());
			setLayout(new java.awt.GridBagLayout());
			//setBackground(java.awt.SystemColor.control);
			setSize(253, 54);

			java.awt.GridBagConstraints constraintsJButtonChoose = new java.awt.GridBagConstraints();
			constraintsJButtonChoose.gridx = 0;
			constraintsJButtonChoose.gridy = 0;
			constraintsJButtonChoose.ipadx = 0;//-17
			constraintsJButtonChoose.ipady = 10; //-2
			constraintsJButtonChoose.anchor = GridBagConstraints.NORTHWEST;
			constraintsJButtonChoose.insets = new java.awt.Insets(2, 2, 0, 0);
			java.awt.GridBagConstraints constraintsJTextFieldRandomAsString = new java.awt.GridBagConstraints();
			constraintsJTextFieldRandomAsString.gridx = 3;
			constraintsJTextFieldRandomAsString.gridy = 0;
			constraintsJTextFieldRandomAsString.gridwidth = 2;
			constraintsJTextFieldRandomAsString.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJTextFieldRandomAsString.weightx = 1.0;
			constraintsJTextFieldRandomAsString.ipadx = 149;
			constraintsJTextFieldRandomAsString.ipady = 7;
			constraintsJTextFieldRandomAsString.insets = new java.awt.Insets(0,
					2, 0, -2);
			this.add(getJButtonChoose(), constraintsJButtonChoose);
			add(getJTextFieldRandomAsString(),
					constraintsJTextFieldRandomAsString);
			initConnections();
			connEtoC6();
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		// user code end
	}

	/**
	 * Comment
	 */
	public String jButtonDiscretSelect_ActionPerformed(String xAsString,
			String pAsString, boolean round) {
		double[] x = ChooseRandom.convertStringToDoubleArray(xAsString);
		double[] p = ChooseRandom.convertStringToDoubleArray(pAsString);
		if (Discret.isCorrectParameters(x, p)) {
			random = new Discret(x, p, round);
		}
		;
		return random.toString();
	}

	/**
	 * Comment
	 */
	public String jButtonErlangSelect_ActionPerformed1(double m, int k,
			boolean round) {
		if (Erlang.isCorrectParameters(m, k)) {
			random = new Erlang(m, k, round);
		}
		;
		return random.toString();
	}

	/**
	 * Comment
	 */
	public String jButtonLinearSelect_ActionPerformed(String xAsString,
			String pAsString, boolean round) {
		double[] x = ChooseRandom.convertStringToDoubleArray(xAsString);
		double[] p = ChooseRandom.convertStringToDoubleArray(pAsString);
		if (Linear.isCorrectParameters(x, p)) {
			random = new Linear(x, p, round);
		}
		;
		return random.toString();
	}

	/**
	 * Comment
	 */
	public String jButtonlUniformSelect_ActionEvents(double min, double max,
			boolean round) {
		if (Uniform.isCorrectParameters(min, max)) {
			random = new Uniform(min, max, round);
		}
		;
		return random.toString();
	}

	/**
	 * Comment
	 */
	public String jButtonNegexpSelect_ActionEvents(double m, boolean round) {
		// double m = Double.parseDouble(mAsString);
		if (Negexp.isCorrectParameters(m)) {
			random = new Negexp(m, round);
		}
		;
		return random.toString();
	}

	/**
	 * Comment
	 */
	public String jButtonNormSelect_ActionEvents(double m, double sigma,
			boolean round) {
		// double m = Double.parseDouble(mAsString);
		// int k = Integer.parseInt(kAsString);
		if (Norm.isCorrectParameters(m, sigma)) {
			random = new Norm(m, sigma, round);
		}
		;
		return random.toString();
	}

	/**
	 * main entrypoint - starts the part when it is run as an application
	 * 
	 * @param args
	 *            java.lang.String[]
	 */
	public static void main(java.lang.String[] args) {
		try {
			javax.swing.JFrame frame = new javax.swing.JFrame();
			ChooseRandom aChooseRandom;
			aChooseRandom = new ChooseRandom();
			frame.setContentPane(aChooseRandom);
			frame.setSize(aChooseRandom.getSize());
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					System.exit(0);
				};
			});
			frame.show();
			java.awt.Insets insets = frame.getInsets();
			frame.setSize(frame.getWidth() + insets.left + insets.right, frame
					.getHeight()
					+ insets.top + insets.bottom);
			frame.setVisible(true);
		} catch (Throwable exception) {
			System.err
					.println("Exception occurred in main() of javax.swing.JPanel");
			exception.printStackTrace(System.out);
		}
	}

	/**
	 * Insert the method's description here. Creation date: (28.03.2005
	 * 18:52:58)
	 * 
	 * @return double
	 */
	public double next() {
		return getRandom().next();
	}

	/**
	 * Insert the method's description here. Creation date: (28.03.2005
	 * 18:54:53)
	 * 
	 * @return double
	 * @param aNumber
	 *            double
	 */
	public double probability(double aNumber) {
		return getRandom().probability(aNumber);
	}

	/**
	 * Insert the method's description here. Creation date: (28.03.2005
	 * 18:54:53)
	 * 
	 * @return double
	 * @param aNumber
	 *            double
	 */
	public double probability(double aNumber1, double aNumber2) {
		if (aNumber2 <= aNumber1) {
			return 0;
		}
		;
		return getRandom().probability(aNumber2)
				- getRandom().probability(aNumber1);
	}

	/**
	 * Comment
	 */
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		getJButtonChoose().setBounds(1, 1, height - 2, height - 2);
		getJTextFieldRandomAsString().setBounds(height, 1, width - height - 2,
				height - 2);
		return;
	}

	/**
	 * Method generated to support the promotion of the
	 * JTextFieldRandomAsStringFont attribute.
	 * 
	 * @param arg1
	 *            java.awt.Font
	 */
	public void setJTextFieldRandomAsStringFont(java.awt.Font arg1) {
		getJTextFieldRandomAsString().setFont(arg1);
	}

	/**
	 * Insert the method's description here. Creation date: (27.03.2005
	 * 20:33:45)
	 * 
	 * @param newRandom
	 *            rnd.RandomGenerators
	 */
	public void setRandom(RandomGenerators newRandom) {
		random = newRandom;
		getJTextFieldRandomAsString().setText(random.toString());
	}
	public double average(){
		return random.average();
		}
	public double max(){
		return random.max();
		}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this
				.setBorder(javax.swing.BorderFactory
						.createCompoundBorder(
								javax.swing.BorderFactory
										.createTitledBorder(
												null,
												title,
												javax.swing.border.TitledBorder.CENTER,
												javax.swing.border.TitledBorder.BELOW_TOP,
												new java.awt.Font(Font.DIALOG, Font.PLAIN, 12), null),
								javax.swing.BorderFactory
										.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
	}

	public boolean average(double m) {
		
		return random.average(m);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
