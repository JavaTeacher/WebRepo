package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.vo.UserVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "로그인 서블릿", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
	    rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		    
		    String id = request.getParameter("id");
		    String pwd = request.getParameter("pwd");
		    System.out.printf("id : %s, pwd : %s\n", id, pwd);
		    
		    if(id == null || "".equals(id)) throw new Exception("E0001");
		    if(pwd == null || "".equals(pwd)) throw new Exception("E0002");
		    
		    // id, pwd 정합성 체크
		    boolean isValid = true;
		    if(isValid) {
		    	// 세션 생성 (생략하면 true)
		    	// true : 세션이 있으면 있는 세션을, 없으면 새로 생성하여 리턴
		    	// false : 세션이 있으면 있는 세션을, 없으면 null을 리턴
		    	HttpSession session = request.getSession();
		    	UserVO user = new UserVO();
		    	user.setId(id);
		    	user.setName("홍길동");
		    	user.setNickName("의적");
		    	session.setAttribute("user", user);
		    	
		    	RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			    rd.forward(request, response);
		    } else {
		    	throw new Exception("E0003");
		    }
		} catch(Exception e) {
			request.setAttribute("msg", "error");
	    	//request.setAttribute("detail", Message.getMessage(e.getMessage()));
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
		    rd.forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
	    
	    PrintWriter out = response.getWriter();
	    
	    String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    System.out.printf("id : %s, pwd : %s\n", id, pwd);
	      
	    out.println("{");
	    out.println("\"id\":" + "\"" + id + "\"");
	    out.println("}");
        out.close();
        
	    // JSON Simple library
//	    JSONObject json = new JSONObject();
//	    json.put("id", id);
//	    System.out.println(json.toJSONString());
//	    out.write(json.toJSONString());
//	    out.close();
	    
	    // Gson library
//	    Gson gson = new Gson();
//		JsonObject obj = new JsonObject();
//	    obj.addProperty("id", id);	    
//	    Map<String, String> obj = new HashMap<>();
//		obj.put("id", id);	    
//		out.write(gson.toJson(obj));
//		System.out.println("result:" + gson.toJson(obj));
//	    out.close();
	    
	}

}
