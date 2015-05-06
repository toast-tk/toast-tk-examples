package fr.synaptix.test.fixtures;

import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.TestResult;
import com.synaptix.toast.core.report.TestResult.ResultKind;

@ActionAdapter(value=ActionAdapterKind.service,name="SampleFixture")
public class SimpleActionAdapter {

    @Action(action = "([\\w\\W]+) = ([\\w\\W]+)", description = "Check if a value equals another value ")
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

