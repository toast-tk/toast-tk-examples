package fr.synaptix.toast.examples.test.service;

import javax.ws.rs.core.Response;

import org.apache.http.client.methods.HttpGet;

import com.google.gson.Gson;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.TestResult;
import com.synaptix.toast.core.report.TestResult.ResultKind;

import fr.synaptix.toast.examples.test.bean.User;

@ActionAdapter(value = ActionAdapterKind.service, name = "service-adapter")
public class SimpleServiceActionAdapter {

	@Action(action = "GET {{value}}", description = "Get Request")
	public TestResult getUrl(String url){
		try {
			int responseStatusCode = HttpHelper.GET(url);
			return new TestResult("Status Reponse Code: " + responseStatusCode, ResultKind.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return new TestResult(e.getMessage());
		}
	}
	
	@Action(action = "POST {{fr.synaptix.toast.examples.test.bean.User:value:json}} to {{value}}", description = "Post json")
	public TestResult postUrl(User user, String url){
		try {
			String json = new Gson().toJson(user);
			int responseStatusCode = HttpHelper.POST(url, json);
			return new TestResult("Status Reponse Code: " + responseStatusCode, ResultKind.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return new TestResult(e.getMessage());
		}
	}


	@Action(action = "{{value:string}} = {{value:string}}", description = "Check if a value equals another value ")
	public TestResult simpleAssert(String firstValue, String secondValue)
			throws Exception {
		try {
			if (firstValue.equals(secondValue)) {
				return new TestResult();
			} else {
				return new TestResult(firstValue
						+ " is not equal to " + secondValue);
			}
		} catch (final Exception e) {
			e.printStackTrace();
			return new TestResult(e.getCause().getMessage(), ResultKind.ERROR);
		}
	}
}
