package fr.synaptix.toast.examples.test.xml;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.synaptix.toast.runtime.AbstractScenarioRunner;

import fr.synaptix.toast.examples.boot.BootModule;

public class XmlExampleRunner extends AbstractScenarioRunner {

	static Injector i = Guice.createInjector(new BootModule());

	protected XmlExampleRunner() {
		super(i);
	}

	@Override
	public void tearDownEnvironment() {
	}

	@Override
	public void beginTest() {
	}

	@Override
	public void endTest() {
	}

	@Override
	public void initEnvironment() {
	}

	public static void main(String[] args) throws Exception {
		XmlExampleRunner testRunner = new XmlExampleRunner();
		testRunner.run("./scripts/xml.example.script");
	}

}
