package io.toast.examples.test.web;

import io.toast.tk.runtime.AbstractScenarioRunner;

public class WebTalanExample1Runner extends AbstractScenarioRunner {

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
		WebTalanExample1Runner testRunner = new WebTalanExample1Runner();
		testRunner.run("./scripts/web.talan.example.1.md");
	}

}
