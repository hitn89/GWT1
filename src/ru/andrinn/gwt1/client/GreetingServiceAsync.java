package ru.andrinn.gwt1.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

	void getTime(AsyncCallback<String> callback);

	void getSelect(AsyncCallback<ArrayList<String>> callback);

	void generateSelect(int id, String name, AsyncCallback<List<String>> callback);

}
