package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Insert the type's description here. Creation date: (12.04.2005 23:30:40)
 * 
 * @author: Administrator
 */
public class DiagramPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.awt.image.BufferedImage image;

	private int gridByX = 0;

	private int gridByY = 0;

	private java.awt.Color gridColor = java.awt.Color.darkGray;

	/**
	 * DiagramPanel constructor comment.
	 */
	public DiagramPanel() {
		super();
		initialize();
	}

	/**
	 * DiagramPanel constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 */
	public DiagramPanel(java.awt.LayoutManager layout) {
		super(layout);
	}

	/**
	 * DiagramPanel constructor comment.
	 * 
	 * @param layout
	 *            java.awt.LayoutManager
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public DiagramPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * DiagramPanel constructor comment.
	 * 
	 * @param isDoubleBuffered
	 *            boolean
	 */
	public DiagramPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * Insert the method's description here. Creation date: (04.05.2005
	 * 21:29:44)
	 */
	public void clear() {
		drawGrid();
		try {
			getGraphics().drawImage(image, 0, 0, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * Insert the method's description here. Creation date: (12.04.2005
	 * 23:40:12)
	 */

	public void drawGrid() {
		int w = getWidth();
		int h = getHeight();

		Graphics gc = image.getGraphics();
		gc.setColor(getBackground());
		gc.fillRect(0, 0, w, h);
		gc.setColor(getGridColor());

		for (int i = 1; i < getGridByX(); i++) {
			int x = Math.round((w * i) / getGridByX());
			gc.drawLine(x, 0, x, h); // Vertical Lines
		}

		for (int i = 1; i < getGridByY(); i++) {
			int y = Math.round((h * i) / getGridByY());
			gc.drawLine(0, y, w, y); // Horizontal Lines
		}

		int[] ax = { 0, w - 1, w - 1, 0 };
		int[] ay = { 0, 0, h - 1, h - 1 };
		gc.setColor(Color.darkGray);
		gc.drawPolygon(ax, ay, 4);
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 15:27:46)
	 * 
	 * @return int
	 */
	public int getGridByX() {
		if (gridByX < 1) {
			return 5;
		}
		return gridByX;
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 15:28:16)
	 * 
	 * @return int
	 */
	public int getGridByY() {
		if (gridByY < 1) {
			return 5;
		}
		return gridByY;
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 15:32:09)
	 * 
	 * @return java.awt.Color
	 */
	public java.awt.Color getGridColor() {
		return gridColor;
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 12:25:08)
	 * 
	 * @return java.awt.image.BufferedImage
	 */
	public java.awt.image.BufferedImage getImage() {
		return image;
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
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
			setName("DiagramPanel");
			setBorder(new javax.swing.border.EtchedBorder());
			setLayout(null);
			setBackground(new java.awt.Color(196, 239, 251));
			setSize(160, 120);
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}

		// user code end
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
			DiagramPanel aDiagramPanel;
			aDiagramPanel = new DiagramPanel();
			frame.setContentPane(aDiagramPanel);
			frame.setSize(aDiagramPanel.getSize());
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					System.exit(0);
				};
			});
			frame.setVisible(true);
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
	 * Insert the method's description here. Creation date: (12.04.2005
	 * 23:38:54)
	 * 
	 * @param gg
	 *            java.awt.Graphics
	 */
	public void paint(java.awt.Graphics gc) {
		super.paint(gc);
		if (image != null) {
			gc.drawImage(image, 0, 0, null);
		}

	}

	/**
	 * Insert the method's description here. Creation date: (12.04.2005
	 * 23:40:12)
	 */

	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		setImage(new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB));
		drawGrid();
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 15:27:46)
	 * 
	 * @param newGridByX
	 *            int
	 */
	public void setGridByX(int newGridByX) {
		gridByX = newGridByX;
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 15:28:16)
	 * 
	 * @param newGridByY
	 *            int
	 */
	public void setGridByY(int newGridByY) {
		gridByY = newGridByY;
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 15:32:09)
	 * 
	 * @param newGridColor
	 *            java.awt.Color
	 */
	public void setGridColor(java.awt.Color newGridColor) {
		gridColor = newGridColor;
	}

	/**
	 * Insert the method's description here. Creation date: (01.05.2005
	 * 12:25:08)
	 * 
	 * @return java.awt.image.BufferedImage
	 */
	public void setImage(java.awt.image.BufferedImage newImage) {
		image = newImage;
	}
}
