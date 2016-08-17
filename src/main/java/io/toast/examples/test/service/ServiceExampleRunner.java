package io.toast.examples.test.service;

import io.toast.tk.runtime.AbstractScenarioRunner;

public class ServiceExampleRunner extends AbstractScenarioRunner {

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
		ServiceExampleRunner testRunner = new ServiceExampleRunner();
		testRunner.run("./scripts/service.example.md");
	}

}
