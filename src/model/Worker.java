package model;

import process.Actor;
import process.DispatcherFinishException;
import process.IWaitCondition;
import rnd.Randomable;

public class Worker extends Actor {

	private ModelSkating model;
	private Randomable serviceTime;

	public Worker(ModelSkating model) {
		this.model = model;
		serviceTime = model.getGui().getChooseRandomServiceTime();
	}

	@Override
	protected void rule() {
		// TODO Auto-generated method stub
		while (getDispatcher().getCurrentTime() < Double.parseDouble(model
				.getGui().getModelTime().getText())) {
			if (model.getQueueForShoesReturn().size() != 0) {
				Molod tmp = (Molod) model.getQueueForShoesReturn().peekFirst();
				holdForTime(serviceTime.next());
				model.getSkates().returnSkatesBySize(tmp.getShoeSize());
				System.out.println("Worker: " + tmp.getNameForProtocol()
						+ " returns skates");
				model.getQueueForShoesReturn().removeFirst();
				tmp.setProcessed();
			}

			if (model.getQueueForSize().size() != 0) {
				Molod tmp = (Molod) model.getQueueForSize().peekFirst();
				if (model.getSkates().peekSkatesBySize(tmp.getShoeSize())) {
					holdForTime(serviceTime.next());
					model.getSkates().getSkatesBySize(tmp.getShoeSize());
					System.out.println("Worker: " + tmp.getNameForProtocol()
							+ " waited for his size");
					model.getQueueForSize().removeFirst();
					tmp.setProcessed();
				}
			}

			if (model.getQueueForShoes().size() != 0) {
				Molod tmp = (Molod) model.getQueueForShoes().peekFirst();
				if (model.getSkates().peekSkatesBySize(tmp.getShoeSize())) {
					holdForTime(serviceTime.next());
					model.getSkates().getSkatesBySize(tmp.getShoeSize());
					model.getQueueForShoes().removeFirst();
					tmp.setProcessed();
				} else {
					model.getQueueForSize().add(tmp);
					model.getQueueForShoes().removeFirst();
					tmp.setProcessed();
				}
			}

			if (model.getQueueForDress().size() != 0) {
				if (model.getCntBusyPlaceInLockerRoom() < model
						.getCntPlaceInLockerRoom()) {
					Molod tmp = (Molod) model.getQueueForDress().peekFirst();
					model.getQueueForDress().removeFirst();
					holdForTime(serviceTime.next());
					tmp.setProcessed();
				}
			}

			if (model.getQueueForShower().size() != 0) {
				if (model.getCntBusyPlaceInShower() < model
						.getCntPlaceInShower()) {
					Molod tmp = (Molod) model.getQueueForShower().peekFirst();
					model.getQueueForShower().removeFirst();
					holdForTime(serviceTime.next());
					tmp.setProcessed();
				}

			}

			IWaitCondition ololo = new IWaitCondition() {

				@Override
				public boolean testCondition() {
					return (model.getQueueForShoes().size() > 0
							| model.getQueueForShoesReturn().size() > 0 | model
							.getQueueForSize().size() > 0);
				}
			};

			try {
				waitForCondition(ololo);
			} catch (DispatcherFinishException e) {
				return;
			}

		}
	}

}
