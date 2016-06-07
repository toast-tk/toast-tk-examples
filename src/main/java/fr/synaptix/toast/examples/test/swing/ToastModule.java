package fr.synaptix.toast.examples.test.swing;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.synaptix.toast.automation.driver.swing.RemoteSwingAgentDriverImpl;
import com.synaptix.toast.core.annotation.EngineEventBus;
import com.synaptix.toast.core.driver.IRemoteSwingAgentDriver;
import com.synaptix.toast.runtime.report.IHTMLReportGenerator;

/**
 * Created by e413544 on 08/04/2016.
 */
public class ToastModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IRemoteSwingAgentDriver.class).to(RemoteSwingAgentDriverImpl.class);
		bindConstant().annotatedWith(Names.named("host")).to("localhost");
	}
}
