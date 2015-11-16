package fr.synaptix.toast.examples.test.json;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.synaptix.toast.runtime.AbstractScenarioRunner;

import fr.synaptix.toast.examples.boot.BootModule;

public class JsonExampleRunner extends AbstractScenarioRunner {

	static Injector i = Guice.createInjector(new BootModule());

	protected JsonExampleRunner() {
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
		JsonExampleRunner testRunner = new JsonExampleRunner();
		testRunner.run("./scripts/json.example.script");
	}

}
