package fr.synaptix.test.fixtures;

import com.synaptix.toast.core.guice.AbstractFixtureModule;
import com.synpatix.toast.runtime.guice.BackendModule;

public class BootModule extends AbstractFixtureModule {

	@Override
	protected void configure() {
		install(new BackendModule());
		bindFixture(SimpleFixture.class);
	}
}
