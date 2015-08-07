package fr.synaptix.test.runners;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.synaptix.toast.runtime.core.runtime.AbstractRunner;

import fr.synaptix.test.fixtures.BootModule;

public class TestRunner extends AbstractRunner {

	static Injector i = Guice.createInjector(new BootModule());
	
	protected TestRunner() {
		super(i);
	}
	
	public static void main(String[] args) {
		try {
			TestRunner testRunner = new TestRunner();
			testRunner.run("./scripts/trame.txt");
			testRunner.run("./scripts/web.script");
		}
		catch(final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tearDownEnvironment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initEnvironment() {
		// TODO Auto-generated method stub
		
	}
}
