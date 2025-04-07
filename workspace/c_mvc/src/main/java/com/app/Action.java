package com.app;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
	// 이 인터페이스는 여러 클래스에서 공통으로 사용될 메소드를 정의합니다.
	// 이 메소드들은 인터페이스로만 선언되어 있으며 구현되지 않았습니다.
	// 특정 클래스가 이 인터페이스를 구현하고 메소드를 정의하지 않으면 컴파일 오류를 발생시킵니다.
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
