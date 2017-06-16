package io.toast.examples.test.json;

import io.toast.tk.runtime.AbstractScenarioRunner;

public class JsonExampleRunner extends AbstractScenarioRunner {

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
		testRunner.run("scripts/json.example.md");
	}

}
