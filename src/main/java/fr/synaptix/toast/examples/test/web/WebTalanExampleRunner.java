package fr.synaptix.toast.examples.test.web;

import com.synaptix.toast.runtime.AbstractScenarioRunner;

public class WebTalanExampleRunner extends AbstractScenarioRunner {

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
		WebTalanExampleRunner testRunner = new WebTalanExampleRunner();
		testRunner.run("./scripts/web.talan.example.script");
	}

}
