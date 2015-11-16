package fr.synaptix.toast.examples.test.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.synaptix.toast.runtime.AbstractScenarioRunner;

import fr.synaptix.toast.examples.boot.BootModule;

public class WebExampleRunner extends AbstractScenarioRunner {

	static Injector i = Guice.createInjector(new BootModule());

	protected WebExampleRunner() {
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
		WebExampleRunner testRunner = new WebExampleRunner();
		testRunner.run("./scripts/web.example.script");
	}

}
