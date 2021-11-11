package com.kh.spring.exception;

public class BoardException extends RuntimeException {
	public BoardException() {}
	
	public BoardException(String msg) {
		super("[게시글 서비스] : " + msg);
		// super("게시글 ERROR :: 담당자 010-XXXX-XXXX");
	}
}
