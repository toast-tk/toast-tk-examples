package fr.synaptix.toast.examples.test.service;

import java.io.IOException;

import com.google.gson.Gson;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.FailureResult;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult;

import fr.synaptix.toast.examples.test.bean.User;

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

	@Action(action = "{{value}} and {{value}}", description = "Add a value to another value")
	public int add(String firstValue, String secondValue)
			throws Exception {
		int a=Integer.parseInt(firstValue);
		int b=Integer.parseInt(secondValue);
		return a+b;
	}
}
