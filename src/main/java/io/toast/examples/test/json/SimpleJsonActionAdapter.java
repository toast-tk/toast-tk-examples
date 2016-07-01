package io.toast.examples.test.json;

import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult;

import io.toast.examples.test.bean.ProjetFlux;


@ActionAdapter(name="json-adapter", value= ActionAdapterKind.service)
public class SimpleJsonActionAdapter {
	
	@Action(id="integrate",
			action="Integrate {{value:json}}", 
			description="Integrate json as java bean")
	public ITestResult integrerJson(ProjetFlux fluxFromJson){
		return new SuccessResult();
	}

}
