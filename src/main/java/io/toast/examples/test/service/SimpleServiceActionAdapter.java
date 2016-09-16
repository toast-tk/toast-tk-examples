package io.toast.examples.test.service;

import java.io.IOException;

import org.junit.Assert;

import com.google.gson.Gson;

import io.toast.examples.test.bean.User;
import io.toast.tk.core.adapter.ActionAdapterKind;
import io.toast.tk.core.annotation.Action;
import io.toast.tk.core.annotation.ActionAdapter;
import io.toast.tk.dao.core.report.FailureResult;
import io.toast.tk.dao.core.report.SuccessResult;
import io.toast.tk.dao.domain.api.test.ITestResult;


@ActionAdapter(value = ActionAdapterKind.service, name = "service-adapter")
public class SimpleServiceActionAdapter {

	@Action(action = "GET {{value}}", description = "Get Request")
	public String getUrl(String url) throws IOException, Exception{
		int responseStatusCode = HttpHelper.GET(url);
		return "Status Reponse Code: " + responseStatusCode;	
	}
	
	@Action(action = "POST {{io.toast.examples.test.bean.User:value:json}} to {{value}}", description = "Post json")
	public String postUrl(User user, String url) throws IOException, Exception{
		String json = new Gson().toJson(user);
		int responseStatusCode = HttpHelper.POST(url, json);
		return "Status Reponse Code: " + responseStatusCode;
	}


	@Action(action = "{{value}} = {{value}}", description = "Check if a value eq@uals another value ")
	public ITestResult simpleAssert(String firstValue, String secondValue) {
		if (firstValue.equals(secondValue)) {
			return new SuccessResult();
		} else {
			return new FailureResult(firstValue + " is not equal to " + secondValue);
		}
	}
	
	@Action(action = "{{value}} and {{value}}", description = "Add a value to another value")
	 public int add(String firstValue, String secondValue) {
	 	int a = Integer.parseInt(firstValue);
	 	int b = Integer.parseInt(secondValue);
	 	return a+b;
	}
	
	@Action(action = "assert {{value}} equals {{value}}", description = "Add a value to another value")
 	public void assertError(String firstValue, String secondValue) {
 		Assert.assertEquals(firstValue, secondValue);
	}
}
