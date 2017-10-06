/**
 * 
 */
package org.dimigo.service;

import org.dimigo.dao.UserDao;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.service
 *  |_ LoginService
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 5.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class LoginService {
	
	private static LoginService service = new LoginService();
	
	private LoginService() {
		
	}
	
	public static LoginService getInstance() {
		return service;
	}

	public UserVO login(UserVO user) throws Exception {
		// DB에서 id, pwd 조회
//		boolean result = true;
//		
//		if(result) {
//			user.setId(user.getId());
//	    	user.setName("홍길동");
//	    	user.setNickname("의적");
//	    } else {
//			throw new Exception("아이디 또는 비밀번호를 다시 확인하세요.");
//		}
		
		UserDao dao = UserDao.getInstance();
		UserVO result = dao.searchUser(user);
		
		if(result == null)
			throw new Exception("아이디 또는 비밀번호를 다시 확인하세요.");
		
		return result;
	}
	
}
