package com.demo.javaworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDetails extends HttpServlet {

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Handler for all GET requests. We simply dump out the requestheader
	 * information, followed by the body of the request.
	 * 
	 * @param request
	 *            the HTTP request submitted to the server for processing. It is
	 *            this object that contains the details of the requested URL,
	 *            and it is the details of this object that we output as a
	 *            response.
	 * @param response
	 *            the response object to be used to send a result back to the
	 *            client.
	 * @exception IOException
	 *                thrown if a communications error occurs.
	 * @exception ServletException
	 *                if the GET request could could not be handled
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		
		String parametro1 = request.getParameter("param1");
		String charEncoding = request.getCharacterEncoding();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Request Details Example</title>");
		out.println("</head>");

		out.println("<body>");

		out.println("<h3>HTTP Request Header</h3>");
		out.println("<table border='1'>");
		out.println(" <tr bgcolor=#e0e0e0>");
		out.println("  <td><strong>Name</strong></td>");
		out.println("  <td><strong>Value</strong></td>");
		out.println(" </tr>");

		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			out.println(" <tr>");
			out.println("  <td bgcolor=#e0e0e0>" + name + "</td>");
			out.println("  <td>" + value + "</td>");
			out.println(" </tr>");
		}
		out.println("</table>");
		
		
		out.println("<h3>HTTP Request Information</h3>");
		out.println("<table border='1'>");
		out.println(" <tr bgcolor=#e0e0e0>");
		out.println("  <td><strong>Name</strong></td>");
		out.println("  <td><strong>Value</strong></td>");
		out.println(" </tr>");
		out.println(" <tr>");
		out.println("  <td bgcolor=#e0e0e0>Method:</td>");
		out.println("  <td>" + request.getMethod() + "</td>");
		out.println(" </tr>");
		out.println(" <tr>");
		out.println("  <td bgcolor=#e0e0e0>Request URI:</td>");
		out.println("  <td>" + request.getRequestURI() + "</td>");
		out.println(" </tr>");
		out.println(" <tr>");
		out.println("  <td bgcolor=#e0e0e0>Protocol:</td>");
		out.println("  <td>" + request.getProtocol() + "</td>");
		out.println(" </tr>");
		out.println(" <tr>");
		out.println("  <td bgcolor=#e0e0e0>PathInfo:</td>");
		out.println("  <td>" + request.getPathInfo() + "</td>");
		out.println(" </tr>");
		out.println(" <tr>");
		out.println("  <td bgcolor=#e0e0e0>Remote Address:</td>");
		out.println("  <td>" + request.getRemoteAddr() + "</td>");
		out.println(" </tr>");
		out.println("</table>");
		
		
		out.println("<h3>Parameter received</h3>");
		out.println("<table border='1'>");
		
		out.println("<tr bgcolor=#e0e0e0>");
		out.println("<td><strong>Name Parameter</strong></td>");
		out.println("<td><strong>Value</strong></td>");
		out.println(" </tr>");
		out.println(" <tr>");
		out.println("  <td bgcolor=#e0e0e0>param1:</td>");
		out.println("  <td>" + parametro1 + "</td>");
		out.println(" </tr>");
		out.println("  <td bgcolor=#e0e0e0>CharEncoding:</td>");
		out.println("  <td>" + charEncoding + "</td>");
		out.println(" </tr>");
		out.println("</table>");

		
		
		
		out.println("<hr>");
		Date date = new Date();
		out.println("<p align=center>Page generated on " + date);
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

	/**
	 * For POST requests, we will simply perform the same operations as for GET
	 * requests. The best way to do this is to simply invoke the doGet() method
	 * with the appropriate parameters.
	 * 
	 * @param request
	 *            the HTTP request submitted to the server for processing. It is
	 *            this object that contains the details of the requested URL,
	 *            and it is the details of this object that we output as a
	 *            response.
	 * @param response
	 *            the response object to be used to send a result back to the
	 *            client.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		doGet(request, response);
	}
	
	
	
}
