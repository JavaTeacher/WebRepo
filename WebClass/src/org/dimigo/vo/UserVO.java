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
	private String name;
	private String nickName;
	
	// 기본생성자 만들기
	public UserVO() {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param nickName
	 */
	public UserVO(String id, String name, String nickName) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
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
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}
