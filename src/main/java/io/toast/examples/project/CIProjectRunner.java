package io.toast.examples.project;

import io.toast.tk.runtime.AbstractTestPlanRunner;
import org.junit.Test;

import io.toast.tk.dao.domain.impl.test.block.ITestPlan;
import io.toast.tk.runtime.parse.ProjectParser;

public class CIProjectRunner extends AbstractTestPlanRunner {

    public CIProjectRunner() throws Exception {
        super();
    }

    public static void main(String[] args) {
        CIProjectRunner projectRunner;
        try {
            projectRunner = new CIProjectRunner();
            ProjectParser projectParser = new ProjectParser();
            ITestPlan testPlan = projectParser.parse("suites/testsuite.example.script");
            projectRunner.execute(testPlan, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runTest() {
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
