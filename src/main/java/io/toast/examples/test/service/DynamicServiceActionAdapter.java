package io.toast.examples.test.service;

import com.google.inject.Inject;

import io.toast.tk.core.adapter.ActionAdapterKind;
import io.toast.tk.core.annotation.Action;
import io.toast.tk.core.annotation.ActionAdapter;
import io.toast.tk.dao.core.report.FailureResult;
import io.toast.tk.dao.core.report.SuccessResult;
import io.toast.tk.dao.domain.api.test.ITestResult;
import io.toast.tk.runtime.IActionItemRepository;

@ActionAdapter(value = ActionAdapterKind.service, name = "dynamic-service-adapter")
public class DynamicServiceActionAdapter {

	IActionItemRepository repo;

	@Inject
	public DynamicServiceActionAdapter(IActionItemRepository repo) {
		this.repo = repo;
	}

	@Action(action = "echo {{value}}", description = "echo")
	public String echo(String value) {
		return value;
	}

	@Action(id="sql", action = "Call SQL: {{value}}", description = "appel sql")
	public String sql(String request) {
		return callSql(request);
	}

	private String callSql(String request) {
		System.out.println("calling -> " + request);
		System.out.println("using -> " + repo.getUserVariables().get("$database.uri"));
		return "654";
	}

}
