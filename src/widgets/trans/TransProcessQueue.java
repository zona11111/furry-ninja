package widgets.trans;

import process.QueueForTransactions;


public class TransProcessQueue extends QueueForTransactions {
	private double sum;

	private double lastTime;

	private double accumTime;

	public void accum() {
		double dt = getDispatcher().getCurrentTime() - lastTime;
		sum += (dt * this.size());
		accumTime += dt;
		lastTime = getDispatcher().getCurrentTime();
	}

	public void beforeAdd() {
		super.beforeAdd();
		this.accum();
	}

	public void beforeRemove() {
		super.beforeRemove();
		this.accum();
	}

	public double getAvg() {
		this.accum();
		return sum / accumTime;
	}

	public double getSum() {
		return sum;
	}

	public void resetAccum() {
		lastTime = getDispatcher().getCurrentTime();
		sum = 0;
		accumTime = 0;
	}
}
