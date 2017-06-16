package io.toast.examples.plan;

import io.toast.tk.runtime.AbstractTestPlanRunner;
import org.junit.Test;

import io.toast.tk.dao.domain.impl.test.block.ITestPlan;
import io.toast.tk.runtime.parse.TestPlanParser;

/**
 * To run this example, a mongoDB instance is required 
 *
 */
public class CIMongoStorageTestPlanRunner extends AbstractTestPlanRunner {

	private static final String MONGO_DB_REPORT_STORAGE_HOST = "localhost"; 
	private static final String API_TOKEN = "4fYDkIAL0qrHXNxRKuK8yzUZAgNr9Ywf";
	private static final int MONGO_DB_REPORT_STORAGE_PORT = 27017;
	
	public CIMongoStorageTestPlanRunner(){
		super(MONGO_DB_REPORT_STORAGE_HOST, MONGO_DB_REPORT_STORAGE_PORT, "play_db");
	}
			
    public static void main(String[] args) {
        CIMongoStorageTestPlanRunner projectRunner;
        try {
            projectRunner = new CIMongoStorageTestPlanRunner();
            TestPlanParser projectParser = new TestPlanParser();
            ITestPlan testplan = projectParser.parse("suites/testsuite.example.script");
            testplan.setName("TestPlan Example");
            projectRunner.testAndStore(API_TOKEN, testplan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runTest() {
        CIMongoStorageTestPlanRunner.main(null);
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
