package paint;

/**
 * This is the event multicaster class to support the
 * paint.DiagramListenerEventMulticaster interface.
 */
public class DiagramListenerEventMulticaster extends
		java.awt.AWTEventMulticaster implements paint.DiagramListener {
	/**
	 * Constructor to support multicast events.
	 * 
	 * @param a
	 *            java.util.EventListener
	 * @param b
	 *            java.util.EventListener
	 */
	protected DiagramListenerEventMulticaster(java.util.EventListener a,
			java.util.EventListener b) {
		super(a, b);
	}

	/**
	 * Add new listener to support multicast events.
	 * 
	 * @return paint.DiagramListener
	 * @param a
	 *            paint.DiagramListener
	 * @param b
	 *            paint.DiagramListener
	 */
	public static paint.DiagramListener add(paint.DiagramListener a,
			paint.DiagramListener b) {
		return (paint.DiagramListener) addInternal(a, b);
	}

	/**
	 * Add new listener to support multicast events.
	 * 
	 * @return java.util.EventListener
	 * @param a
	 *            java.util.EventListener
	 * @param b
	 *            java.util.EventListener
	 */
	protected static java.util.EventListener addInternal(
			java.util.EventListener a, java.util.EventListener b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		return new DiagramListenerEventMulticaster(a, b);
	}

	/**
	 * 
	 * @return java.util.EventListener
	 * @param oldl
	 *            paint.DiagramListener
	 */
	protected java.util.EventListener remove(paint.DiagramListener oldl) {
		if (oldl == a)
			return b;
		if (oldl == b)
			return a;
		java.util.EventListener a2 = removeInternal(a, oldl);
		java.util.EventListener b2 = removeInternal(b, oldl);
		if (a2 == a && b2 == b)
			return this;
		return addInternal(a2, b2);
	}

	/**
	 * Remove listener to support multicast events.
	 * 
	 * @return paint.DiagramListener
	 * @param l
	 *            paint.DiagramListener
	 * @param oldl
	 *            paint.DiagramListener
	 */
	public static paint.DiagramListener remove(paint.DiagramListener l,
			paint.DiagramListener oldl) {
		if (l == oldl || l == null)
			return null;
		if (l instanceof DiagramListenerEventMulticaster)
			return (paint.DiagramListener) ((paint.DiagramListenerEventMulticaster) l)
					.remove(oldl);
		return l;
	}

	/**
	 * 
	 * @param newEvent
	 *            java.util.EventObject
	 */
	public void verticalMaxCaret_caretUpdate(java.util.EventObject newEvent) {
		((paint.DiagramListener) a).verticalMaxCaret_caretUpdate(newEvent);
		((paint.DiagramListener) b).verticalMaxCaret_caretUpdate(newEvent);
	}
}
