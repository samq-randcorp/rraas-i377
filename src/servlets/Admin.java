package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.SetupDao;
import db.UnitDao;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String activity = request.getParameter("do");
		
		  if("clear_data".equals(activity)){
				try {
					new UnitDao().deleteList();
				} catch (SQLException e) {e.printStackTrace();}
		}
		  
		 else if("insert_data".equals(activity))
		  		new SetupDao().addTestdata();
		  
		response.sendRedirect("Search");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
