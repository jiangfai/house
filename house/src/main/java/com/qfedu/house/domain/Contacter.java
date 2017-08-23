package com.qfedu.house.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contacter {
	@Column(nullable = false)
	private String name;
	@Column(columnDefinition = "char(11)", nullable = false)
	private String tel;
	@Column(length = 12)
	private String qq;
	private String email;

	public Contacter() {
	}

	public Contacter(String name, String tel, String qq, String email) {
		this.name = name;
		this.tel = tel;
		this.qq = qq;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
