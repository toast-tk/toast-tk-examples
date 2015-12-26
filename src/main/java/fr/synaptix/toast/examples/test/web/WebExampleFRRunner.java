package fr.synaptix.toast.examples.test.web;

import com.synaptix.toast.runtime.AbstractScenarioRunner;

public class WebExampleFRRunner extends AbstractScenarioRunner {

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
		WebExampleFRRunner testRunner = new WebExampleFRRunner();
		testRunner.run("./scripts/web.example.fr.script");
	}

}
