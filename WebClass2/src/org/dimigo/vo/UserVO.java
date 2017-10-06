/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *  |_ User
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 9. 21.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String nickname;
	
	// 기본생성자 만들기
	public UserVO() {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param nickName
	 */
	public UserVO(String id, String pwd, String name, String nickname) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the nickName
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname=" + nickname + "]";
	}


	
}
