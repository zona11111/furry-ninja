package process;

import java.util.ArrayList;
import java.util.Vector;

import stat.DiscretHisto;

public class QueueForTransactions implements Cloneable {
	public ArrayList<Object> 	queue = new ArrayList<Object>();

	private int maxSize = Integer.MAX_VALUE;

	private String nameForProtocol = "Черга";

	private paint.Painter painter;

	private Vector<QueueOverflowListener> queueOverflowListeners;

	private double lastTime = 0;

	private DiscretHisto discretHisto = null;

	private Dispatcher dispatcher;

	public QueueForTransactions() {
		super();
	
	}

	public Object clone() {
		try {
			QueueForTransactions clon = new QueueForTransactions();
			clon = (QueueForTransactions) super.clone();
			ArrayList<Object> clone = (ArrayList<Object>) queue.clone();
			clon.queue = clone;

			return clon;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean add(Object o) {
		return this.addLast(o);
	}

	public synchronized boolean addLast(Object o) {
		boolean result = false;
		this.beforeAdd();
		if (queue.size() < maxSize) {
			result = queue.add(o);
			if (result)
				getDispatcher().printToProtocol(
						"  " + nameForProtocol + " приймає танзакцію.");
		} else {
			QueueOverflowEvent evt = new QueueOverflowEvent(this, o);
			fireQueueOverflowEvent(evt);
			getDispatcher().printToProtocol(
					"  " + nameForProtocol
							+ " Танзакцію втрачено. Нема місця у черзі ");
		}
		this.afterAdd();
		return result;
	}

	public synchronized void addQueueOverflowListener(
			QueueOverflowListener listener) {
		if (queueOverflowListeners == null) {
			queueOverflowListeners = new java.util.Vector();
		}
		queueOverflowListeners.addElement(listener);
	}

	protected void afterAdd() {
		drawDiagram();
		getDispatcher().printToProtocol(
				"  " + nameForProtocol + ". Стало "
						+ Integer.toString(queue.size()));
	}

	protected void afterRemove() {
		drawDiagram();
		getDispatcher().printToProtocol(
				"  " + nameForProtocol + ". Стало "
						+ Integer.toString(queue.size()));
	}

	protected void beforeAdd() {
		drawDiagram();
		accum();
	}

	protected void beforeRemove() {
		drawDiagram();
		accum();
	}

	private void accum() {
		if (discretHisto != null) {
			try {
				double dt=getDispatcher().getCurrentTime()- lastTime;
				discretHisto.addFrequencyForValue(dt, queue.size());
				lastTime = getDispatcher().getCurrentTime();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}

	/**
	 * Insert the method's description here. Creation date: (14.05.2005
	 * 13:46:58)
	 */
	private void drawDiagram() {
		if (painter != null && painter.getDiagram() != null) {

				painter.drawToXY((float) getDispatcher().getCurrentTime(),
						(float) queue.size());
		}
	}

	protected Dispatcher getDispatcher() {
		if(dispatcher==null)
			try {
				throw new Exception("Диспетчер не определен для "+this.nameForProtocol);
			} catch (Exception e) {
				System.out.println("Диспетчер не определен для "+this.nameForProtocol);
				e.printStackTrace();
			}
		return dispatcher;
	}

	private void fireQueueOverflowEvent(QueueOverflowEvent evt) {
		Vector<QueueOverflowListener> targets = null;
		synchronized (this) {
			if (queueOverflowListeners != null) {
				targets = (Vector<QueueOverflowListener>) queueOverflowListeners.clone();
			}
		}
		if (targets != null) {
			for (int i = 0; i < targets.size(); i++) {
				QueueOverflowListener target = (QueueOverflowListener) targets
						.elementAt(i);
				target.onQueueOverflow(evt);
			}
		}

	}

	public int getMaxSize() {
		return maxSize;
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
		queue.clear();
		if (painter != null) {
			if (painter.getDiagram() != null)
				painter.placeToXY(0, 0);
		}
		lastTime = 0;
	}

	public synchronized boolean contains(Object o) {
		return queue.contains(o);
	}

	public synchronized boolean remove(Object o) {
		this.beforeRemove();
		boolean result = queue.remove(o);
		this.afterRemove();
		return result;
	}

	public synchronized Object peekFirst() {
		return queue.get(0);
	}

	public synchronized Object removeFirst() {
		this.beforeRemove();
		Object o = queue.remove(0);
		this.afterRemove();
		return o;
	}

	public synchronized void removeQueueOverflowListener(
			QueueOverflowListener listener) {
		if (queueOverflowListeners == null) {
			return;
		}
		queueOverflowListeners.removeElement(listener);
	}

	public int size() {
		return queue.size();
	}

	public void setMaxSize(int newMaxSize) {
		maxSize = newMaxSize;
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

	public DiscretHisto getDiscretHisto() {
		return discretHisto;
	}

	public void setDiscretHisto(DiscretHisto aDiscretHisto) {
		discretHisto = aDiscretHisto;
	}

	public void setDispatcher(Dispatcher disp) {
		dispatcher = disp;
	dispatcher.addDispatcherFinishListener(new DispatcherFinishListener() {
		
		public void onDispatcherFinish() {
			accum();
			drawDiagram();
		}
	});
		

	}

}
