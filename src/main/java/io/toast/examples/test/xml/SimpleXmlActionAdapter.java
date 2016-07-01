package io.toast.examples.test.xml;

import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult;

import io.toast.examples.test.bean.ProjetFlux;

@ActionAdapter(name="xml-adapter", value= ActionAdapterKind.service)
public class SimpleXmlActionAdapter {

	@Action(
			id="integrate",
			action="Integrate {{value:xml}}", 
			description="Integrate an xml as a Java Bean to the object dictionnary"
			)
	public String integrerXml(ProjetFlux fluxFromXml){
		int formerId = fluxFromXml.getId();
		//simulate an object state mutation
		fluxFromXml.setId(0);
		fluxFromXml.setStatus(20); 
		return "stream integrated with former id -> " + formerId;
	}
	
	@Action(
			action="{{value:xml}} equal to {{value:xml}}",
			description="Comparaison to the status on a given instance"
			)
	public ITestResult integrerXml(ProjetFlux fluxFromXml, ProjetFlux instanceAttendue){
		if(fluxFromXml.getStatus() == instanceAttendue.getStatus()){
			return new SuccessResult();
		}
		return new SuccessResult("Status de l'instance incorrect: " + fluxFromXml.getStatus());
	}
}
