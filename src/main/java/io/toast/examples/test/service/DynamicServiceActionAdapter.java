package io.toast.examples.test.service;

import com.google.inject.Inject;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.runtime.IActionItemRepository;

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
