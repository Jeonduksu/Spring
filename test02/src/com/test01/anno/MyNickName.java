package com.test01.anno;

import org.springframework.stereotype.Component;

@Component
public class MyNickName {
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "MyNickName [nickName=" + nickName + "]";
	}
	
	
}
