package io.toast.examples.plan;

import io.toast.tk.runtime.AbstractTestPlanRunner;
import org.junit.Test;

import io.toast.tk.dao.domain.impl.test.block.ITestPlan;
import io.toast.tk.runtime.parse.TestPlanParser;

public class CITestPlanRunner extends AbstractTestPlanRunner {

    public CITestPlanRunner() throws Exception {
        super();
    }

    public static void main(String[] args) {
        CITestPlanRunner projectRunner;
        try {
            projectRunner = new CITestPlanRunner();
            TestPlanParser projectParser = new TestPlanParser();
            ITestPlan testPlan = projectParser.parse("suites/testsuite.example.script");
            projectRunner.execute(testPlan, false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runTest() {
        CITestPlanRunner.main(null);
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
