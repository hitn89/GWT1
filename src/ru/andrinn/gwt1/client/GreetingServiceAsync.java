package ru.andrinn.gwt1.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.ListBox;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

	void getTime(AsyncCallback<String> callback);

	void getSelect(AsyncCallback<ArrayList<String>> callback);

//	void getSelect2(AsyncCallback<ListBox> callback);
}
