package fr.synaptix.test.runners;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.synpatix.toast.runtime.core.runtime.AbstractRunner;
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
		}
		catch(final Exception e) {
			e.printStackTrace();
		}
	}
}
