package fr.synaptix.toast.examples.boot;

import com.synaptix.toast.core.guice.AbstractActionAdapterModule;
import com.synaptix.toast.runtime.module.EngineModule;

import fr.synaptix.toast.examples.test.json.SimpleJsonActionAdapter;
import fr.synaptix.toast.examples.test.service.SimpleServiceActionAdapter;
import fr.synaptix.toast.examples.test.web.SimpleWebActionAdapter;
import fr.synaptix.toast.examples.test.xml.SimpleXmlActionAdapter;

public class BootModule extends AbstractActionAdapterModule {

	@Override
	protected void configure() {
		install(new EngineModule());
		bindActionAdapter(SimpleServiceActionAdapter.class);
		bindActionAdapter(SimpleWebActionAdapter.class);
		bindActionAdapter(SimpleXmlActionAdapter.class);
		bindActionAdapter(SimpleJsonActionAdapter.class);
	}
}
