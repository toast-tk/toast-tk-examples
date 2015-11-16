package fr.synaptix.toast.examples.test.json;

import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.TestResult;

import fr.synaptix.toast.examples.test.bean.ProjetFlux;


@ActionAdapter(name="json-adapter", value= ActionAdapterKind.service)
public class SimpleJsonActionAdapter {
	
	@Action(action="Integrate {{fr.synaptix.toast.examples.test.bean.ProjetFlux:value:json}}", description="Integrate json as java bean")
	public TestResult integrerJson(ProjetFlux fluxFromJson){
		return new TestResult();
	}

}
