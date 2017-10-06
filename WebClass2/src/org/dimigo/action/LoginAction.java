/**
 * 
 */
package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.LoginService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.action
 *  |_ LoginAction
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 5.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class LoginAction implements IAction {

	// 입력값 검증
	private void validate(String id, String pwd) throws Exception {
		if(CommonUtil.isEmpty(id)) throw new Exception("아이디를 입력하세요");
		if(CommonUtil.isEmpty(pwd)) throw new Exception("비밀번호를 입력하세요");
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			// 입력값 추출
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			// 입력값 검증
			validate(id, pwd);
			
			// VO 객체에 데이터 셋팅
			UserVO user = new UserVO();
			user.setId(id);
			user.setPwd(pwd);
			
			// 비지니스 로직 처리를 위한 Service 호출
			LoginService service = new LoginService();
			UserVO result = service.login(user);
			
			// 세션에 사용자정보 저장
			HttpSession session = request.getSession();
	    	session.setAttribute("user", result);
	    	
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		}
    	
	}

}
