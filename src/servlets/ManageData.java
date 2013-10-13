package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.SetupDao;
import db.UnitDao;

public class ManageData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		addTestData(request);
		response.sendRedirect("Search");
	}

	private void addTestData(HttpServletRequest request) {
		try {
			if(request.getParameter("do").equals("insert_data")){
				new SetupDao().createTestdata();
			} else if(request.getParameter("do").equals("clear_data")) {
					new UnitDao().deleteAllData();
			} else if (request.getParameter("do").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
					new UnitDao().deleteDataById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
