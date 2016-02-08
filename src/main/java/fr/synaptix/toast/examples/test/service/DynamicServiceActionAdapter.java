package fr.synaptix.toast.examples.test.service;

import com.google.inject.Inject;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.ErrorResult;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult;
import com.synaptix.toast.runtime.IActionItemRepository;

@ActionAdapter(value = ActionAdapterKind.service, name = "dynamic-service-adapter")
public class DynamicServiceActionAdapter {

	IActionItemRepository repo;

	@Inject
	public DynamicServiceActionAdapter(IActionItemRepository repo) {
		this.repo = repo;
	}

	@Action(action = "echo {{value}}", description = "echo")
	public ITestResult echo(String value) {
		try {
			return new SuccessResult(value);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorResult(e.getMessage());
		}
	}

	@Action(id="sql", action = "Appel SQL: {{value}} as {{value}}", description = "appel sql")
	public ITestResult sql(String request, String var) {
		String output = callSql(request);
		repo.getUserVariables().put(var, output);
		return new SuccessResult(output);
	}

	private String callSql(String request) {
		System.out.println("calling -> " + request);
		System.out.println("using -> " + repo.getUserVariables().get("$database.uri"));
		return "654";
	}

}
