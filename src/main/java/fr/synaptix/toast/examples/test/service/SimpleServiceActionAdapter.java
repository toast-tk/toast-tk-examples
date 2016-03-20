package fr.synaptix.toast.examples.test.service;

import java.io.IOException;

import com.google.gson.Gson;
import com.synaptix.toast.core.adapter.ActionAdapterKind;
import com.synaptix.toast.core.annotation.Action;
import com.synaptix.toast.core.annotation.ActionAdapter;
import com.synaptix.toast.core.report.ErrorResult;
import com.synaptix.toast.core.report.SuccessResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult;
import com.synaptix.toast.dao.domain.api.test.ITestResult.ResultKind;

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
			return new ErrorResult(e.getMessage());
		}
	}
	
	@Action(action = "POST {{value:json}} to {{value}}", description = "Post json")
	public String postUrl(User user, String url) throws IOException, Exception{
		String json = new Gson().toJson(user);
		int responseStatusCode = HttpHelper.POST(url, json);
		return "Status Reponse Code: " + responseStatusCode;
	}


	@Action(action = "{{value}} = {{value}}", description = "Check if a value eq@uals another value ")
	public ITestResult simpleAssert(String firstValue, String secondValue)
			throws Exception {
		try {
			if (firstValue.equals(secondValue)) {
				return new SuccessResult();
			} else {
				return new ErrorResult(firstValue
						+ " is not equal to " + secondValue);
			}
		} catch (final Exception e) {
			e.printStackTrace();
			return new ErrorResult(e.getCause().getMessage());
		}
	}
}
