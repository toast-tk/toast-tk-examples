package io.toast.examples.test.service;

import io.toast.tk.runtime.AbstractScenarioRunner;

public class DynamicServiceExampleRunner extends AbstractScenarioRunner {

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
		DynamicServiceExampleRunner testRunner = new DynamicServiceExampleRunner();
		testRunner.run("scripts/service.dynamic.md");
	}

}
