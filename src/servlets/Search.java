package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Unit;
import db.UnitDao;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Unit> units = new ArrayList<Unit>();
		String activity = request.getParameter("do");
		String searchString = request.getParameter("searchString");
		
		if ("delete".equals(activity)) {
			try {
				new UnitDao().deleteByID(Integer.parseInt(request.getParameter("id")));
			} catch (SQLException e) {e.printStackTrace();}
		}
		
		if (searchString == null) {
			try {
				units = new UnitDao().getAllUnits();		
			} catch (SQLException e) {e.printStackTrace();}
		
		}
		else{
			try {
				units = new UnitDao().findUnitsByName(request.getParameter("searchString"));
			} catch (SQLException e) {e.printStackTrace();}
		}
		request.setAttribute("units", units);

		request.getRequestDispatcher("WEB-INF/Search.jsp").forward(request,
				response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
