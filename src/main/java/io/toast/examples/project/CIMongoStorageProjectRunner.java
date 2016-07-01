package io.toast.examples.project;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import com.synaptix.toast.dao.domain.impl.test.block.IProject;
import com.synaptix.toast.runtime.AbstractProjectRunner;
import com.synaptix.toast.runtime.parse.ProjectParser;

/**
 * To run this example, a mongoDB instance is required 
 *
 */
public class CIMongoStorageProjectRunner extends AbstractProjectRunner {

	private static final String MONGO_DB_REPORT_STORAGE_HOST = "localhost"; 

	private static final int MONGO_DB_REPORT_STORAGE_PORT = 27017;
	
    public CIMongoStorageProjectRunner(String mongoDbHost, int mongoDbPort) throws Exception {
        super(mongoDbHost, mongoDbPort);
    }

    public static void main(String[] args) {
        CIMongoStorageProjectRunner projectRunner;
        try {
            projectRunner = new CIMongoStorageProjectRunner(MONGO_DB_REPORT_STORAGE_HOST, MONGO_DB_REPORT_STORAGE_PORT);
            URL testFileUrl = CIMongoStorageProjectRunner.class.getClassLoader().getResource("suites/testsuite.example.script");
            Assert.assertNotNull(testFileUrl);
            String path = testFileUrl.getPath();
            ProjectParser projectParser = new ProjectParser();
            IProject project = projectParser.parse(path);
            projectRunner.testAndStore(project);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runTest() {
        CIMongoStorageProjectRunner.main(null);
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
