package com.winter.app.config.security.jwt;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
	
	// Spring에서 만들어주는 객체
	private AuthenticationManager authenticationManager;
	
	private JwtTokenManager tokenManager;
	
	public JwtLoginFilter(JwtTokenManager jwtTokenManager, AuthenticationManager authenticationManager) {
		this.setFilterProcessesUrl("/users/loginProcess");
		this.tokenManager = jwtTokenManager;
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		System.out.println("login 시도");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		// UsernamePasswordAuthenticationToken에서 loadUserByUsername를 호출하기 때문에 1번째 인자값으로 String 값을 넣어주어도 문제 없음
		// UserDetailService의 loadUserByusername 메서드를 호출하고
		// 패스워드가 일치하는지 판별하고 Authentication객체를(UserDetail 객체)
		// SecurityContextHolder에 넣어줌
		
		return authenticationManager.authenticate(authenticationToken);
	}
	
	// 위 함수 성공 시 토큰 생성하기
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String accesstoken = tokenManager.makeAccessToken(authResult);
		String refreshToken = tokenManager.makeRefreshToken(authResult);
		
		Cookie cookie = new Cookie("access-token", accesstoken);
		cookie.setPath("/");
		cookie.setMaxAge(60);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
		cookie = new Cookie("refresh-token", refreshToken);
		cookie.setPath("/");
		cookie.setMaxAge(600);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
		response.sendRedirect("/");
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		System.out.println(failed.getMessage());
		// 로그인 실패
		String message = "로그인 실패";
		if(failed instanceof AccountExpiredException) {
			message = "로그인 유효 기간 만료";
		} else if(failed instanceof LockedException){
			message = "계정 잠김";
		} else if (failed instanceof CredentialsExpiredException) {
			message = "비번 유효 기간 만료";
		} else if(failed instanceof DisabledException) {
			message = "휴면 계정";
		} else if (failed instanceof BadCredentialsException) {
			message = "비번 틀림";
		} else if (failed instanceof InternalAuthenticationServiceException) {
			message = "아이디 틀림";
		}
		message = URLEncoder.encode(message,"UTF-8");
		response.sendRedirect("./login?message="+message);
	}
}
