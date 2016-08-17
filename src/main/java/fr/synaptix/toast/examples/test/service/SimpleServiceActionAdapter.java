package fr.synaptix.toast.examples.test.service;

import com.google.gson.Gson;

import io.toast.examples.test.bean.User;
import io.toast.examples.test.service.HttpHelper;
import io.toast.tk.core.adapter.ActionAdapterKind;
import io.toast.tk.core.annotation.Action;
import io.toast.tk.core.annotation.ActionAdapter;
import io.toast.tk.dao.core.report.FailureResult;
import io.toast.tk.dao.core.report.SuccessResult;
import io.toast.tk.dao.domain.api.test.ITestResult;

@ActionAdapter(value = ActionAdapterKind.service, name = "service-adapter")
public class SimpleServiceActionAdapter {

	@Action(action = "GET {{value}}", description = "Get Request")
	public ITestResult getUrl(String url){
		try {
			int responseStatusCode = HttpHelper.GET(url);
			return new SuccessResult("Status Reponse Code: " + responseStatusCode);
		} catch (Exception e) {
			e.printStackTrace();
			return new FailureResult(e.getMessage());
		}
	}
	
	@Action(action = "POST {{fr.synaptix.toast.examples.test.bean.User:value:json}} to {{value}}", description = "Post json")
	public ITestResult postUrl(User user, String url){
		try {
			String json = new Gson().toJson(user);
			int responseStatusCode = HttpHelper.POST(url, json);
			return new SuccessResult("Status Reponse Code: " + responseStatusCode);
		} catch (Exception e) {
			e.printStackTrace();
			return new FailureResult(e.getMessage());
		}
	}


	@Action(action = "{{value}} = {{value}}", description = "Check if a value eq@uals another value ")
	public ITestResult simpleAssert(String firstValue, String secondValue)
			throws Exception {
		try {
			if (firstValue.equals(secondValue)) {
				return new SuccessResult();
			} else {
				return new FailureResult(firstValue
						+ " is not equal to " + secondValue);
			}
		} catch (final Exception e) {
			e.printStackTrace();
			return new FailureResult(e.getCause().getMessage());
		}
	}
}
