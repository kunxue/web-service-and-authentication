package demo;


import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Main Class 
public class DemoServlet extends javax.servlet.http.HttpServlet {

	public final static String FS = System.getProperty("file.separator");

	// *****************************************************************
	// Approach 1: Using an input file and writing to the output file *
	// and outputting the results *
	// *****************************************************************

	// Respond to HTTP GET requests from browsers.
	public void doGet(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		// Set the printer object
		java.io.PrintWriter out = response.getWriter();

		// processing the user's input query

		String sql_query = request.getParameter("query");

		AccessJDBCTest test = new AccessJDBCTest();
		String result = new String();
		try {
			result = test.run(sql_query);

		} catch (SQLException s) {
			System.out.println(s);
		}
		response.setContentType("text/html");

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n" + "<HTML>\n"
				+ "<HEAD><TITLE>DB</TITLE></HEAD>\n" + "<BODY>\n"
				+ "<H1>DB Demo</H1>\n");

		out.println(result);

		out.println("</BODY></HTML>");

	}

}
