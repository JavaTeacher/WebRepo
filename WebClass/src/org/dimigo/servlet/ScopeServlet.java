package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScopeServlet
 */
@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScopeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			System.out.printf("id : %s, pwd : %s\n", id, pwd);
			
			if(id == null || id.equals(""))
				throw new Exception("아이디는 필수항목입니다.");
			
			// request scope
			request.setAttribute("key", "rValue");
			// session scope
			request.getSession().setAttribute("key", "sValue");
			// application scope
			request.getServletContext().setAttribute("key", "aValue");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/scope.jsp");
		    rd.forward(request, response);
		    
		} catch(Exception e) {
			//request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/scope.jsp");
		    rd.forward(request, response);
		}
	}

}
