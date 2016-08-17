package io.toast.examples.test.web;

import com.google.inject.Inject;

import io.toast.tk.adapter.web.AbstractWebActionAdapter;
import io.toast.tk.core.adapter.ActionAdapterKind;
import io.toast.tk.core.annotation.Action;
import io.toast.tk.core.annotation.ActionAdapter;
import io.toast.tk.runtime.IActionItemRepository;

/**
 * A Web Action Adapter
 */

@ActionAdapter(name="web-adapter", value= ActionAdapterKind.web)
public class SimpleWebActionAdapter extends AbstractWebActionAdapter {

	@Inject
	public SimpleWebActionAdapter(IActionItemRepository repo) {
		super(repo);
	}

	@Action(action = "Upload my word document {{value:string}}", description = "upload")
	public String upload(String docName) {
		return "uploaded: " + docName;
	}

}
