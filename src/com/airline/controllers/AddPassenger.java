package com.airline.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Gender;
import com.airline.models.Passenger;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPassenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errors", false);

		Passenger p = new Passenger();

		String firstName = request.getParameter("first-name");
		System.out.println("firstName: " + firstName);

		if (firstName.length() == 0) {
			System.out.println("Invalid first name");
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);
		} else {
			p.setFirstName(firstName);
		}

		String lastName = request.getParameter("last-name");
		System.out.println("lastName: " + lastName);

		if (lastName.length() == 0) {
			System.out.println("Invalid last name");
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);
		} else {
			p.setLastName(lastName);
		}

		String birthDateString = request.getParameter("birth-date");
		String birthDateArray[] = birthDateString.split("\\/");

		String pattern = "^\\d{4}\\/\\d{1,2}\\/\\d{1,2}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(birthDateString);

		if (m.find()) {
			String year = birthDateArray[0];
			String month = birthDateArray[1];
			String day = birthDateArray[2];

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.parseInt(year));
			calendar.set(Calendar.MONTH, Integer.parseInt(month));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

			Date birthDate = calendar.getTime();

			System.out.println("birthDate: " + birthDate);

			p.setBirth(birthDate);

		} else {
			System.out.println("Invalid birthdate");
			request.setAttribute("errors", true);
			request.setAttribute("date_format_error", true);
		}

		String gender = request.getParameter("gender");
		System.out.println("Gender: " + gender);
		p.setGender(Gender.valueOf(gender));

		if ((Boolean) request.getAttribute("errors")) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
			view.forward(request, response);
		} else {
			ServletContext sc = this.getServletContext();
			ArrayList<Passenger> passengers = (ArrayList<Passenger>) sc.getAttribute("passengers");
			passengers.add(p);
			sc.setAttribute("passengers", passengers);
			response.sendRedirect("");
		}

	}

}
