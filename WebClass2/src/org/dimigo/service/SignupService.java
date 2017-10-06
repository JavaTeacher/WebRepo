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
public class SignupService {

	private static SignupService service = new SignupService();
	
	private SignupService() {
		
	}
	
	public static SignupService getInstance() {
		return service;
	}
	
	public void signup(UserVO user) throws Exception {

		UserDao dao = UserDao.getInstance();
		
		// 사용중인 아이디인지 먼저 체크
		UserVO result = dao.searchUserById(user);
		if(result != null) {
			throw new Exception("이미 사용중인 아이디입니다.");
		}
		
		// DB에 사용자정보 등록
		dao.insertUser(user);
		
//		boolean result = true;
//		
//		if(!result) {
//			throw new Exception("이미 사용중인 아이디입니다.");
//		}
	}
}
