package model;

import process.Actor;
import process.DispatcherFinishException;
import process.DispatcherFinishListener;
import process.IWaitCondition;
import rnd.Randomable;

public class Molod extends Actor {
	private ModelSkating model;

	private double timeSkating;
	private double timeShower;
	private double timeDressing;
	private Integer shoeSize;
	private boolean isProcessed;
	private double birthTime;
	private double deadTime;
	private double t11;
	private double t12;
	private double t21;
	private double t22;

	public Molod(ModelSkating model, int shoeSize) {
		super();
		this.model = model;

		if (model == null)
			System.out.println("Intialisation is unsuccessfull");
		this.shoeSize = shoeSize;
		isProcessed = false;
		timeDressing = model.getGui().getChooseRandomDressTime().next();
		timeSkating = model.getGui().getChooseRandomSkatingTime().next();
		timeShower = model.getGui().getChooseRandomShowerTime().next();

		model.getDispatcher().addDispatcherFinishListener(
				new DispatcherFinishListener() {
					@Override
					public void onDispatcherFinish() {
						deadTime = getDispatcher().getCurrentTime();
					}
				});
	}

	public double getTimeSkating() {
		return timeSkating;
	}

	public double getLiveTime() {
		return deadTime - birthTime;
	}
	
	public double getTime1(){
		return t12 - t11;
	}
	
	public double getTime2(){
		return t22 - t21;
	}

	@Override
	protected void rule() {
		IWaitCondition proc = new IWaitCondition() {

			@Override
			public boolean testCondition() {
				return isProcessed();
			}
		};
		System.out.println(getNameForProtocol() + " get in line for skates");
		birthTime = getDispatcher().getCurrentTime();
		t11 = getDispatcher().getCurrentTime();
		model.getQueueForShoes().addLast(this);
		
		try {
			waitForCondition(proc);// konki
		} catch (DispatcherFinishException e) {
			return;
		}
		isProcessed = false;
		
		model.gotoDress();
		holdForTime(timeDressing);
		model.gofromDress();
		t12 = getDispatcher().getCurrentTime();

		System.out.println(getNameForProtocol() + " go skating");
		model.allSkiers++;
		model.getGui().histoTrans.add(model.allSkiers);
		holdForTime(timeSkating);
		model.allSkiers--;
		model.getGui().histoTrans.add(model.allSkiers);
		System.out.println(getNameForProtocol() + " wants to take skates");
		model.getQueueForShoesReturn().addLast(this);
		isProcessed = false;

		try {
			waitForCondition(proc);
		} catch (DispatcherFinishException e) {
			return;
		}

		System.out.println(getNameForProtocol() + " go to locker room");
		model.getQueueForDress().addLast(this);

		try {
			waitForCondition(proc);
		} catch (DispatcherFinishException e) {
			return;
		}

		isProcessed = false;
		if (isShower()) {
			t21 = getDispatcher().getCurrentTime();
			System.out.println(getNameForProtocol() + " go shower");
			model.getQueueForShower().addLast(this);

			try {
				waitForCondition(proc);
			} catch (DispatcherFinishException e) {
				return;
			}

			model.gotoShower();
			System.out.println(getNameForProtocol() + " is shower");
			holdForTime(timeShower);
			model.gofromShower();
			t22 = getDispatcher().getCurrentTime();
			deadTime = getDispatcher().getCurrentTime();
			isProcessed = false;// shower
			System.out.println(getNameForProtocol() + " is dead");
			return;
		}
		deadTime = getDispatcher().getCurrentTime();
		System.out.println(getNameForProtocol() + " is dead");
		return;
	}

	public Integer getShoeSize() {
		return shoeSize;
	}

	public void setProcessed() {
		this.isProcessed = true;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public boolean isShower() {
		if (Math.random() < 0.5) {
			return true;
		}
		return false;
	}

}
