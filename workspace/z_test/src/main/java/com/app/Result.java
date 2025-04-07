package com.app;

public class Result {
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
