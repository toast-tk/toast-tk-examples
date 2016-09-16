package io.toast.examples.test.json;

import io.toast.examples.test.bean.ProjetFlux;
import io.toast.tk.core.adapter.ActionAdapterKind;
import io.toast.tk.core.annotation.Action;
import io.toast.tk.core.annotation.ActionAdapter;
import io.toast.tk.dao.core.report.SuccessResult;
import io.toast.tk.dao.domain.api.test.ITestResult;


@ActionAdapter(name="json-adapter", value= ActionAdapterKind.service)
public class SimpleJsonActionAdapter {
	
	@Action(id="integrate",
			action="Integrate {{value:json}}", 
			description="Integrate json as java bean")
	public ITestResult integrerJson(ProjetFlux fluxFromJson){
		return new SuccessResult();
	}

}
