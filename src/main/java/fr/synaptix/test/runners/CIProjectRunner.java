package fr.synaptix.test.runners;

import org.junit.Test;

import com.google.inject.Guice;
import com.synaptix.toast.runtime.core.runtime.AbstractProjectRunner;

import fr.synaptix.test.fixtures.BootModule;

public class CIProjectRunner extends AbstractProjectRunner {

	public CIProjectRunner() throws Exception {
		super(Guice.createInjector(new BootModule()));
	}
	
	public static void main(String[] args) {
		CIProjectRunner projectRunner;
		try {
			projectRunner = new CIProjectRunner();
			projectRunner.test("project", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void runTest(){
		CIProjectRunner.main(null);
	}
	
	@Override
	public void tearDownEnvironment() {
		// TODO Auto-generated method stub
	}

	@Override
	public void initEnvironment() {
		// TODO Auto-generated method stub
	}

	@Override
	public void beginTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTest() {
		// TODO Auto-generated method stub
		
	}
}
