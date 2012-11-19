package process;

import paint.Painter;
import stat.Histo;

public class Store implements Cloneable {
	private double size = 0;

	private Dispatcher dispatcher;

	private String nameForProtocol ;

	private Painter painter;

	protected Histo histo;

	protected double lastTime;

	public Store() {
		 super();
		 nameForProtocol = "Накпичувач";
	}

	public Object clone() {
		try {
			Store	clon = (Store) super.clone();
			return clon;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void add(double z) {
		beforeAdd();
		size+=z;
		afterAdd();
	}

	protected void afterAdd() {
		drawDiagram();
		dispatcher.printToProtocol("  "+nameForProtocol + ". Стало "
				+ Double.toString(getSize()));
	}

	protected void afterRemove() {
		drawDiagram();
		dispatcher.printToProtocol("  "+nameForProtocol + ". Стало "
				+ Double.toString(getSize()));
	}

	protected void beforeAdd() {
		accum();
		drawDiagram();
	}

	protected void beforeRemove() {
		accum();
		drawDiagram();
	}

	private void accum() {
		double dt = getDispatcher().getCurrentTime() - lastTime;
		lastTime = getDispatcher().getCurrentTime();
		if (histo!=null)histo.addFrequencyForValue(dt,this.getSize());
	}

		
	/**
	 * Insert the method's description here. Creation date: (14.05.2005
	 * 13:46:58)
	 */
	private void drawDiagram() {
		if (painter != null && painter.getDiagram() != null) {
			painter.drawToXY((float) dispatcher.getCurrentTime(), (float)getSize());
		}
	}

	public process.Dispatcher getDispatcher() {
		if(dispatcher==null)
			try {
				throw new Exception("Диспетчер не определен для "+this.nameForProtocol);
			} catch (Exception e) {
				System.out.println("Диспетчер не определен для "+this.nameForProtocol);
				e.printStackTrace();
			}
		return dispatcher;
	}

	public double getSize() {
		return size;
	}

	/**
	 * Insert the method's description here. Creation date: (13.05.2005
	 * 21:38:55)
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNameForProtocol() {
		return nameForProtocol;
	}

	/**
	 * Insert the method's description here. Creation date: (14.05.2005
	 * 13:42:30)
	 * 
	 * @return paint.Painter
	 */
	public paint.Painter getPainter() {
		return painter;
	}

	public synchronized void init() {
		size=0;
		lastTime=0;
		if (painter != null) {
			if (painter.getDiagram() != null)
				painter.placeToXY(0, 0);
		}
	}

	public double remove(double z) {
		if (z>size) z=size;
		this.beforeRemove();
		size-=z;
		this.afterRemove();
		return z;
	}


	/**
	 * Insert the method's description here. Creation date: (13.05.2005
	 * 21:38:55)
	 * 
	 * @param newNameForProtocol
	 *            java.lang.String
	 */
	public void setNameForProtocol(java.lang.String newNameForProtocol) {
		nameForProtocol = newNameForProtocol;
	}

	/**
	 * Insert the method's description here. Creation date: (14.05.2005
	 * 13:42:30)
	 * 
	 * @param newPainter
	 *            paint.Painter
	 */
	public void setPainter(paint.Painter newPainter) {
		painter = newPainter;
	}

	public Histo getHisto() {
		return histo;
	}

	public void setHisto(Histo histo) {
		this.histo = histo;
	}

	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
//		dispatcher.addDispatcherStartListener(new DispatcherStartListener(){
//
//			public void onDispatcherStart(EventObject evt) {
//				Store.this.init();
//				
//			}
//			
//		});
	}
}
