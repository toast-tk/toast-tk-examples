package io.toast.examples.test.web;

import io.toast.tk.runtime.AbstractScenarioRunner;

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
		testRunner.run("scripts/web.example.md");
	}

}
