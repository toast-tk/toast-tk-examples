package fr.synaptix.toast.examples.project;

import com.synaptix.toast.dao.domain.impl.test.block.IProject;
import com.synaptix.toast.runtime.parse.ScenarioParser;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.synaptix.toast.runtime.AbstractProjectRunner;

import fr.synaptix.toast.examples.boot.BootModule;

import java.net.URL;

public class CIProjectRunner extends AbstractProjectRunner {

    public CIProjectRunner() throws Exception {
        super(Guice.createInjector(new BootModule()));
    }

    public static void main(String[] args) {
        CIProjectRunner projectRunner;
        try {
            projectRunner = new CIProjectRunner();
            URL testFileUrl = CIProjectRunner.class.getClassLoader().getResource("campaigns/project1.test");
            Assert.assertNotNull(testFileUrl);
            String path = testFileUrl.getPath();
            ScenarioParser scenarioParser = new ScenarioParser();
            IProject project = scenarioParser.parse(path);
            projectRunner.execute(project, false);
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
