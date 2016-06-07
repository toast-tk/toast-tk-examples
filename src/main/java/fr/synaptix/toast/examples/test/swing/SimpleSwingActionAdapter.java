package fr.synaptix.toast.examples.test.swing;

import java.util.Objects;

import org.openqa.selenium.WebElement;

import com.google.inject.Inject;
import com.synaptix.toast.adapter.swing.AbstractSwingActionAdapter;
import com.synaptix.toast.adapter.swing.SwingAutoElement;
import com.synaptix.toast.adapter.swing.component.SwingTableElement;
import com.synaptix.toast.adapter.web.AbstractWebActionAdapter;
import com.synaptix.toast.adapter.web.component.WebAutoElement;
import com.synaptix.toast.adapter.web.component.WebSelectElement;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.driver.IRemoteSwingAgentDriver;
import com.synaptix.toast.core.report.FailureResult;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.core.runtime.IWebAutoElement;
import com.synaptix.toast.dao.domain.api.test.ITestResult;
import com.synaptix.toast.runtime.IActionItemRepository;

import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.SWING_COMPONENT_REGEX;
import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.VALUE_REGEX;
import static com.synaptix.toast.core.adapter.ActionAdapterSentenceRef.WEB_COMPONENT;

/**
 * A Web Action Adapter, required firefox to be run
 */

@ActionAdapter(name = "swing-adapter", value = ActionAdapterKind.swing)
public class SimpleSwingActionAdapter extends AbstractSwingActionAdapter {

	@Inject
	public SimpleSwingActionAdapter(IActionItemRepository repo, IRemoteSwingAgentDriver driver) {
		super(repo, driver);
	}

	@Action(action = "Compter les lignes de la table " + SWING_COMPONENT_REGEX, description = "Compter le nombre de ligne dans un tableau")
	public ITestResult countLines(SwingAutoElement pageField) throws Exception {
		SwingTableElement table = (SwingTableElement) pageField;
		ITestResult countResult = table.count();
		return new SuccessResult(countResult.getMessage(), countResult.getScreenShot());
	}

}
