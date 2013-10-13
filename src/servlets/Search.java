package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.UnitDao;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		setSearchResults(request);
		request.getRequestDispatcher("Search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userInput = request.getParameter("searchString");
		response.sendRedirect("Search?searchString="+userInput);
	}

	private void setSearchResults(HttpServletRequest request) {

		String userInput = request.getParameter("searchString");
		UnitDao dao = new UnitDao();

		try {
			if(userInput == null) {
				request.setAttribute("searchResult", dao.findAllDepartments());
			} else {
				request.setAttribute("searchResult", dao.fullTextSearch(userInput));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
