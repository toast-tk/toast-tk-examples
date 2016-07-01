package io.toast.examples.test.service;

import java.io.IOException;

import org.junit.Assert;

import com.google.gson.Gson;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.FailureResult;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult;

import io.toast.examples.test.bean.User;


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
