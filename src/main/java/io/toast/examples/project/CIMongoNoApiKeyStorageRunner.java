package io.toast.examples.project;

import org.junit.Test;

import io.toast.tk.runtime.AbstractProjectRunner;

/**
 * To run this example:
 * - a mongoDB instance is required  
 * - the project id the test plan belongs to (TestPlanImpl -> project attribute)
 */
public class CIMongoNoApiKeyStorageRunner extends AbstractProjectRunner {
	
	private static final String MONGO_DB_REPORT_STORAGE_HOST = "localhost"; 
	private static final int MONGO_DB_REPORT_STORAGE_PORT = 27017;
	private static final String TESTPLAN_MONGODB_PROJECT_OBJECT_ID = "581b4f7c30043cb1c8af8145"; 
	
    public CIMongoNoApiKeyStorageRunner(String mongoDbHost, int mongoDbPort, String db) throws Exception {
        super(mongoDbHost, mongoDbPort, db);
    }

    public static void main(String[] args) {
        CIMongoNoApiKeyStorageRunner projectRunner;
        try {
            projectRunner = new CIMongoNoApiKeyStorageRunner(MONGO_DB_REPORT_STORAGE_HOST, MONGO_DB_REPORT_STORAGE_PORT, "play_db");
            projectRunner.test("TestPlan Example", TESTPLAN_MONGODB_PROJECT_OBJECT_ID, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runTest() {
        CIMongoNoApiKeyStorageRunner.main(null);
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
