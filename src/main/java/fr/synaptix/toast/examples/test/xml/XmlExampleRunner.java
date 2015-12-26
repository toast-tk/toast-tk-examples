package fr.synaptix.toast.examples.test.xml;

import com.synaptix.toast.runtime.AbstractScenarioRunner;

public class XmlExampleRunner extends AbstractScenarioRunner {

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
		XmlExampleRunner testRunner = new XmlExampleRunner();
		testRunner.run("./scripts/xml.example.script");
	}

}
