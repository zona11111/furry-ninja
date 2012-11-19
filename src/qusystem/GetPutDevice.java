package qusystem;

import process.DispatcherFinishException;
import process.IWaitCondition;
import process.QueueForTransactions;

public class GetPutDevice extends FinishDevice {
	protected QueueForTransactions outputQueue;

	public GetPutDevice() {
		super();
	}

	/**
	 * Insert the method's description here. Creation date: (13.05.2005
	 * 22:40:27)
	 * 
	 * @return qusystem.QueueForTransactions
	 */
	public QueueForTransactions getOutputQueue() {
		if(outputQueue==null)
			System.out.println("Не визначено outputQueue для GetPutDevice .");

		return outputQueue;
	}

	public void rule() {
		while (getDispatcher().getCurrentTime()<=finishTime)  {
			try {
				waitForCondition(new IWaitCondition() {

					public String toString() {
						return "поки у " + inputQueue.getNameForProtocol()
								+ " зявиться транзакція";
					}

					public boolean testCondition() {
						return inputQueue.size() > 0;
					}

				});
			} catch (DispatcherFinishException e) {
				return;
			}
	
			transaction = inputQueue.removeFirst();
			beforeHold();
			holdForTime(getRandom().next());
			if (getDispatcher().getCurrentTime()>finishTime)break;
			try {
				waitForCondition(new IWaitCondition() {

					public String toString() {
						return "поки у " + inputQueue.getNameForProtocol()
								+ " зявиться місце для транзакції";
					}

					public boolean testCondition() {
						return outputQueue.size() < outputQueue.getMaxSize();
					}

				});
			} catch (DispatcherFinishException e) {
				return;
			}
			
			outputQueue.addLast(transaction);
			afterHold();
		}
	}

	public void setOutputQueue(QueueForTransactions newOutputQueue) {
		outputQueue = newOutputQueue;
	}
}
