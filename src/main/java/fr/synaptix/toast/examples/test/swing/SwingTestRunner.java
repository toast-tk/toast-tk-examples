package fr.synaptix.toast.examples.test.swing;

import com.google.inject.Module;
import com.synaptix.toast.runtime.AbstractScenarioRunner;

public class SwingTestRunner extends AbstractScenarioRunner {

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

	public SwingTestRunner(Module m){
		super(m);
	}

	public static void main(String[] args) throws Exception {
		SwingTestRunner swingTestRunner = new SwingTestRunner(new ToastModule());
		swingTestRunner.run("scripts/swing.example.script");
	}

}
