package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("jsp2/signup.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
	    
	    String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    String name = request.getParameter("name");
	    String nickname = request.getParameter("nickname");
	    System.out.printf("id : %s, pwd : %s, name : %s, nickname : %s\n", id, pwd, name, nickname);
	    
	    boolean result = true;
	    
	    if(result) {
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp2/login.jsp");
		    rd.forward(request, response);
	    } else {
	    	request.setAttribute("msg", "error");
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp2/signup.jsp");
		    rd.forward(request, response);
	    }    
	    
	}

	protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
	    
	    String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    String name = request.getParameter("name");
	    String nickname = request.getParameter("nickname");
	    System.out.printf("id : %s, pwd : %s, name : %s, nickname : %s\n", id, pwd, name, nickname);
	    
	    boolean result = false;
	    
	    Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		
	    if(result) {
	    	obj.addProperty("msg", "success");
	    } else {
	    	obj.addProperty("msg", "error");
	    	//obj.addProperty("detail", Message.getMessage("E0002", id));
	    }
	    
		out.write(gson.toJson(obj));
		out.close();
	}
	
}
