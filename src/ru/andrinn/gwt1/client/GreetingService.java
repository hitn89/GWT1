package ru.andrinn.gwt1.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
//import com.google.gwt.user.client.ui.ListBox;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	String getTime();
	ArrayList<String> getSelect();
	//ListBox getSelect2();
}
