package model;

import process.Dispatcher;
import qusystem.IModelFactory;

public class ModelFactory implements IModelFactory{
	
	private static IModelFactory instance = new ModelFactory();
	
	private ModelFactory(){
		
	}

	@Override
	public ModelSkating createModel(Dispatcher arg0) {
		ModelSkating model = new ModelSkating(arg0);
		return model;
	}

	public static IModelFactory getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

}
