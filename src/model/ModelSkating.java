package model;

import java.util.ArrayList;
import java.util.Iterator;

import process.Actor;
import process.Dispatcher;
import process.QueueForTransactions;
import rnd.Randomable;
import widgets.experiments.IExperimentable;
import widgets.trans.ITransProcesable;

public class ModelSkating extends Actor implements IModel, IExperimentable,
		ITransProcesable {

	private MainForm gui;
	private Dispatcher dispatcher;
	private Skates skates;
	private Worker worker;
	public ArrayList<Molod> allTheSkating;

	private QueueForTransactions queueForShower;
	private QueueForTransactions queueForDress;
	private QueueForTransactions queueForShoesReturn;
	private QueueForTransactions queueForShoes;
	private QueueForTransactions queueForSize;

	private double finishTime;

	private int cntPlaceInShower;
	private int cntBusyPlaceInShower;
	private int cntPlaceInLockerRoom;
	private int cntBusyPlaceInLockerRoom;

	private Randomable comingTime;
	public int allSkiers;

	public ModelSkating(Dispatcher arg0) {
		setGui(MainForm.Skating);
		this.dispatcher = arg0;
		initModel();
	}

	private void initModel() {
		worker = new Worker(this);
		skates = new Skates();
		comingTime = getGui().getChooseRandomComingTime();
		allTheSkating = new ArrayList<Molod>();
		getSkates().setCountSkates(
				Integer.parseInt(getGui().getCountSkates().getText()));
		cntPlaceInLockerRoom = Integer.parseInt(getGui().getCountSeats()
				.getText());
		cntPlaceInShower = Integer.parseInt(getGui().getCountShowers()
				.getText());
	}

	public QueueForTransactions getQueueForShower() {
		if (queueForShower == null) {
			queueForShower = new QueueForTransactions();
			queueForShower.setNameForProtocol("Queue for shower");
			queueForShower.setDispatcher(dispatcher);
		}
		return queueForShower;
	}

	public QueueForTransactions getQueueForShoes() {
		if (queueForShoes == null) {
			queueForShoes = new QueueForTransactions();
			queueForShoes.setNameForProtocol("Queue for shoes");
			queueForShoes.setDispatcher(dispatcher);
		}
		return queueForShoes;
	}

	public QueueForTransactions getQueueForDress() {
		if (queueForDress == null) {
			queueForDress = new QueueForTransactions();
			queueForDress.setNameForProtocol("Queue for dress");
			queueForDress.setDispatcher(dispatcher);
		}
		return queueForDress;
	}

	public QueueForTransactions getQueueForShoesReturn() {
		if (queueForShoesReturn == null) {
			queueForShoesReturn = new QueueForTransactions();
			queueForShoesReturn.setNameForProtocol("Queue for shoes return");
			queueForShoesReturn.setDispatcher(dispatcher);
		}
		return queueForShoesReturn;
	}

	public QueueForTransactions getQueueForSize() {
		if (queueForSize == null) {
			queueForSize = new QueueForTransactions();
			queueForSize.setNameForProtocol("Queue for size");
			queueForSize.setDispatcher(dispatcher);
		}
		return queueForSize;
	}

	public Skates getSkates() {
		return skates;
	}

	private int calcSize() {
		double forSize = Math.random();
		if (forSize < 0.33) {
			return 1;
		} else {
			if ((forSize > 0.33) & (forSize < 0.66)) {
				return 2;
			} else {
				return 3;
			}
		}
	}

	@Override
	protected void rule() {
		dispatcher.addStartingActor(worker);
		double modelTime = Double
				.parseDouble(getGui().getModelTime().getText());
		int cnt = Integer.parseInt(getGui().getCountClients().getText());
		for (int i = 0; i < cnt; i++) {
			if (modelTime > dispatcher.getCurrentTime()) {
				Molod skate_man = new Molod(this, calcSize());
				allTheSkating.add(skate_man);
				skate_man.setNameForProtocol("vasya" + i);
				dispatcher.addStartingActor(skate_man);
				holdForTime(comingTime.next());
			}
		}
	}

	@Override
	public void initForTest() {
		getQueueForDress().setPainter(
				getGui().getDressingRoomQueueDiagram().getPainter());
		getQueueForShoes().setPainter(
				getGui().getSkatesQueueDiagram().getPainter());
		getQueueForShower().setPainter(
				getGui().getShowerQueueDiagram().getPainter());
	}

	@Override
	public void initForTrans(double finishTime) {
		// TODO Auto-generated method stub
		this.finishTime = finishTime;
		dispatcher.addStartingActor(this);
	}

	@Override
	public void resetTransAccum() {
		// TODO Auto-generated method stub
		getGui().histoTrans.init();

	}

	@Override
	public double getTransResult() {
		// TODO Auto-generated method stub
		return getGui().histoTrans.average();
	}

	@Override
	public void initForExperiment(double factor) {
		// TODO Auto-generated method stub
		if (getGui().getFactor() == 0) {
			getGui().setCountSkates(factor);
			getGui().histoFactor1.init();
			getGui().getTransDiagram().setHorizontalMaxText(
					String.valueOf((int) getGui().getExperimentControl()
							.getFactorsArray()[0]));
			getGui().getTransDiagram().setVerticalMaxText(
					String.valueOf((int) getGui().getExperimentControl()
							.getFactorsArray()[getGui().getExperimentControl().getComponentCount()]));
		}
		if (getGui().getFactor() == 1) {
			getGui().setCountShowers(factor);
			getGui().histofactor2.init();
		}
		dispatcher.addStartingActor(this);
	}

	@Override
	public double getResultOfExperiment() {
		// TODO Auto-generated method stub
		if (getGui().getFactor() == 0) {

			for (Iterator<Molod> iterator = allTheSkating.iterator(); iterator
					.hasNext();) {
				Molod type = (Molod) iterator.next();
				getGui().histoFactor1.add(type.getTime1());
			}
			return getGui().histoFactor1.average();
		}
		if (getGui().getFactor() == 1) {
			for (Iterator<Molod> iterator = allTheSkating.iterator(); iterator
					.hasNext();) {
				Molod type = (Molod) iterator.next();
				getGui().histofactor2.add(type.getTime2());
			}
			return getGui().histofactor2.average();
		}
		return 22.5;
	}

	public MainForm getGui() {
		return gui;
	}

	private void setGui(MainForm gui) {
		this.gui = gui;
	}

	public int getCntPlaceInLockerRoom() {
		return cntPlaceInLockerRoom;
	}

	public int getCntPlaceInShower() {
		return cntPlaceInShower;
	}

	public int getCntBusyPlaceInLockerRoom() {
		return cntBusyPlaceInLockerRoom;
	}

	public int getCntBusyPlaceInShower() {
		return cntBusyPlaceInShower;
	}

	public boolean gotoShower() {
		if (cntBusyPlaceInShower == cntPlaceInShower) {
			return false;
		} else {
			cntBusyPlaceInShower = cntBusyPlaceInShower + 1;
			return true;
		}
	}

	public void gofromShower() {
		cntBusyPlaceInShower--;
	}

	public boolean gotoDress() {
		if (cntBusyPlaceInLockerRoom == cntPlaceInLockerRoom) {
			return false;
		} else {
			cntBusyPlaceInLockerRoom = cntBusyPlaceInLockerRoom + 1;
			return true;
		}
	}

	public void gofromDress() {
		cntBusyPlaceInLockerRoom--;
	}

}
