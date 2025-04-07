package com.app;

import java.util.Objects;

public class Result {
//	여러값을 리턴하기 위해 만드는 클래스
//	path로 경로를 설정하고, isForward의 값으로 true일땐 forword, false일때는 redirect 여부를 알 수 있다.
//	boolean의 기본값은 false
	private String path;
	private boolean isForward;
	
	public Result() {;}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isForward() {
		return isForward;
	}

	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}

	@Override
	public String toString() {
		return "Result [path=" + path + ", isForward=" + isForward + "]";
	}

	
}
