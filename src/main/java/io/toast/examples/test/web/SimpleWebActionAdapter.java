package io.toast.examples.test.web;

import com.google.inject.Inject;
import com.synaptix.toast.adapter.web.AbstractWebActionAdapter;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.runtime.IActionItemRepository;


/**
 * A Web Action Adapter
 */

@ActionAdapter(name="web-adapter", value= ActionAdapterKind.web)
public class SimpleWebActionAdapter extends AbstractWebActionAdapter{

	@Inject
	public SimpleWebActionAdapter(IActionItemRepository repo) {
		super(repo);
	}

	@Action(action = "Upload my word document {{value:string}}", description = "upload")
	public String upload(String docName) {
		return "uploaded: " + docName;
	}

}
