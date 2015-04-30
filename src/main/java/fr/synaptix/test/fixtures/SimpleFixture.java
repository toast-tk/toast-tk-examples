package fr.synaptix.test.fixtures;

import com.synaptix.toast.core.annotation.Check;
import com.synaptix.toast.core.annotation.Fixture;
import com.synaptix.toast.core.annotation.FixtureKind;
import com.synaptix.toast.core.setup.TestResult;
import com.synaptix.toast.core.setup.TestResult.ResultKind;

@Fixture(value=FixtureKind.service,name="SampleFixture")
public class SimpleFixture {

    @Check("([\\w\\W]+) = ([\\w\\W]+)")
    public TestResult setCenterCellsPanel(
            String firstValue,
            String secondValue
    ) throws Exception {
        try {
            if (firstValue.equals(secondValue)) {
                return new TestResult();
            } else {
                return new TestResult("test failure " + firstValue + " is not equal to " + secondValue);
            }
        } catch (final Exception e) {
            e.printStackTrace();
            return new TestResult(e.getCause().getMessage(), ResultKind.ERROR);
        }
    }
}

