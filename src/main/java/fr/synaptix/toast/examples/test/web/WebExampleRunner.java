package fr.synaptix.toast.examples.test.web;

import com.synaptix.toast.runtime.AbstractScenarioRunner;

public class WebExampleRunner extends AbstractScenarioRunner {

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
