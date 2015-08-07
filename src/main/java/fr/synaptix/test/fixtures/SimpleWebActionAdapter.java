package fr.synaptix.test.fixtures;

import com.google.inject.Inject;
import com.synaptix.toast.adapter.web.AbstractWebActionAdapter;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.runtime.IActionItemRepository;


@ActionAdapter(name="web-adapter", value= ActionAdapterKind.web)
public class SimpleWebActionAdapter extends AbstractWebActionAdapter{

	@Inject
	public SimpleWebActionAdapter(IActionItemRepository repo) {
		super(repo);
	}

}
