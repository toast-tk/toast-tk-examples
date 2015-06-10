package fr.synaptix.test.fixtures;

import com.synaptix.toast.core.guice.AbstractActionAdapterModule;
import com.synpatix.toast.runtime.guice.EngineModule;

public class BootModule extends AbstractActionAdapterModule {

	@Override
	protected void configure() {
		install(new EngineModule());
		bindActionAdapter(SimpleActionAdapter.class);
	}
}
