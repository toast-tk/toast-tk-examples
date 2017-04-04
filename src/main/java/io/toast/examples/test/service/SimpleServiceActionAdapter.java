package io.toast.examples.test.service;

import java.io.IOException;

import io.toast.examples.test.bean.Product;
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

	@Action(action = "GET {{value}}", description = "Get Request body response")
	public String getUrl(String url) throws IOException, Exception{
		String response = HttpHelper.GETResponseBody(url);
		Assert.assertNotNull(response);
		return response;
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

	@Action(action = "{{value:json}} equals {{value:json}}", description = "Get Request body response")
	public String compare(Product one, Product two) throws IOException, Exception{
		Assert.assertEquals(one, two);
		return "OK";
	}


	@Action(action = "assert {{value}} equals {{value}}", description = "Add a value to another value")
 	public void assertError(String firstValue, String secondValue) {
 		Assert.assertEquals(firstValue, secondValue);
	}
}
