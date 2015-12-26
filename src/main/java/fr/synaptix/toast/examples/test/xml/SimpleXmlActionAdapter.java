package fr.synaptix.toast.examples.test.xml;

import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.TestResult;
import com.synaptix.toast.core.report.TestResult.ResultKind;

import fr.synaptix.toast.examples.test.bean.ProjetFlux;

@ActionAdapter(name="xml-adapter", value= ActionAdapterKind.service)
public class SimpleXmlActionAdapter {

	@Action(
			id="integrate",
			action="Integrate {{value:xml}}", 
			description="Integrate an xml as a Java Bean to the object dictionnary"
			)
	public TestResult integrerXml(ProjetFlux fluxFromXml){
		int formerId = fluxFromXml.getId();
		
		//simulate an object state mutation
		fluxFromXml.setId(0);
		fluxFromXml.setStatus(20); 
		
		return new TestResult("Flux integrated with former id -> " + formerId, ResultKind.SUCCESS);
	}
	
	@Action(
			action="{{value:xml}} equal to {{value:xml}}",
			description="Comparaison to the status on a given instance"
			)
	public TestResult integrerXml(ProjetFlux fluxFromXml, ProjetFlux instanceAttendue){
		if(fluxFromXml.getStatus() == instanceAttendue.getStatus()){
			return new TestResult();
		}
		return new TestResult("Status de l'instance incorrect: " + fluxFromXml.getStatus());
	}
}
