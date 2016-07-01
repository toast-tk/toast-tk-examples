package io.toast.examples.test.web;

import com.synaptix.toast.runtime.AbstractScenarioRunner;

public class WebExampleAliasRunner extends AbstractScenarioRunner {

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
		WebExampleAliasRunner testRunner = new WebExampleAliasRunner();
		testRunner.run("./scripts/web.example.alias.md");
	}

}
