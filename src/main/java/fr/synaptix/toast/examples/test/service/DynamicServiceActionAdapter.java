package fr.synaptix.toast.examples.test.service;

import com.google.inject.Inject;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.TestResult;
import com.synaptix.toast.core.report.TestResult.ResultKind;
import com.synaptix.toast.runtime.IActionItemRepository;

@ActionAdapter(value = ActionAdapterKind.service, name = "dynamic-service-adapter")
public class DynamicServiceActionAdapter {

	IActionItemRepository repo;

	@Inject
	public DynamicServiceActionAdapter(IActionItemRepository repo) {
		this.repo = repo;
	}

	@Action(action = "echo {{value}}", description = "echo")
	public TestResult echo(String value) {
		try {
			return new TestResult(value, ResultKind.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return new TestResult(e.getMessage());
		}
	}

	@Action(id="sql", action = "Appel SQL: {{value}} as {{value}}", description = "appel sql")
	public TestResult sql(String request, String var) {
		String output = callSql(request);
		repo.getUserVariables().put(var, output);
		return new TestResult(output, ResultKind.SUCCESS);
	}

	private String callSql(String request) {
		System.out.println("calling -> " + request);
		System.out.println("using -> " + repo.getUserVariables().get("$database.uri"));
		return "654";
	}

}
