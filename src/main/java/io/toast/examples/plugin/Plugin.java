package io.toast.examples.plugin;

import java.util.Arrays;
import java.util.Collection;

import com.google.inject.Module;

import io.toast.examples.test.json.SimpleJsonActionAdapter;
import io.toast.examples.test.service.DynamicServiceActionAdapter;
import io.toast.examples.test.service.SimpleServiceActionAdapter;
import io.toast.examples.test.web.SimpleWebActionAdapter;
import io.toast.examples.test.xml.SimpleXmlActionAdapter;
import io.toast.tk.core.guice.AbstractActionAdapterModule;
import io.toast.tk.plugin.IAgentPlugin;

public class Plugin implements IAgentPlugin{

	@Override
	public void boot() {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Module> getModules() {
		Module module = new AbstractActionAdapterModule() {
			@Override
			protected void configure() {
				bindActionAdapter(SimpleWebActionAdapter.class);	
				bindActionAdapter(SimpleJsonActionAdapter.class);	
				bindActionAdapter(DynamicServiceActionAdapter.class);	
				bindActionAdapter(SimpleServiceActionAdapter.class);	
				bindActionAdapter(SimpleWebActionAdapter.class);
				bindActionAdapter(SimpleJsonActionAdapter.class);		
				bindActionAdapter(SimpleXmlActionAdapter.class);	
			}
		};
		return Arrays.asList(module);
	}

}
