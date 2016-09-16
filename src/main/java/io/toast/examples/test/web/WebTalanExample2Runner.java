package io.toast.examples.test.web;

import io.toast.tk.runtime.AbstractScenarioRunner;

public class WebTalanExample2Runner extends AbstractScenarioRunner {

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
		WebTalanExample2Runner testRunner = new WebTalanExample2Runner();
		testRunner.run("./scripts/web.talan.example.2.md");
	}

}
