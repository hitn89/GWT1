package ru.andrinn.gwt1.server;

import ru.andrinn.gwt1.client.GreetingService;
import ru.andrinn.gwt1.shared.FieldVerifier;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	
	
	private static final String url = "jdbc:mysql://localhost:3306/javap";
	private static final String user = "root";
	private static final String password = "";
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
				+ userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

	@Override
	public String getTime() {
		return escapeHtml(new Date().toString());
	}
	

		
	public List<String> getSelect() {

		String query = "select * from customs";
	
		List<String> customs = new ArrayList<String>();
		
		try {
			con = (Connection) DriverManager.getConnection(url, user, password);
			stmt = (Statement) con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				customs.add(rs.getString(2));
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {con.close();} catch (SQLException se) {}
			try {stmt.close();} catch (SQLException se) {}
			try {rs.close();} catch (SQLException se) {}
		}
		
		return customs;
	}


	@Override
	public List<String> generateSelect(int id, String name) throws IllegalArgumentException {
		List<String> select = new ArrayList<String>();
		select.add("blablabla");
		return select;
	}
	
	
	
}
