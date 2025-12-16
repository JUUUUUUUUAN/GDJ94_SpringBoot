package com.winter.app.config.security.jwt;

import java.io.IOException;
import java.security.SignatureException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
	// 요청을 보낸 클라이언트의 쿠키 정보에서 토큰이 유효한지 확인
	private JwtTokenManager jwtTokenManager;
	
	public JwtAuthenticationFilter(JwtTokenManager manager ,AuthenticationManager authenticationManager) {
		super(authenticationManager);
		this.jwtTokenManager = manager;
	}
	
	//Token 검증
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		String token = "";
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("access-token")) {
					token = c.getValue();
					break;
				}
			}
		}
		
		if(token != null && token.length() > 0) {
			try {
				Authentication authentication = this.jwtTokenManager.getAuthenticationByToken(token);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (Exception e) {
				// SecurityException malformedException SignatureException 
				// expriredException : 기간이 만료된 Token
				// UnsupportedJwtException : 지원되지 않는 Token
				// IllegalArgumentException : 잘못된 Token
				System.out.println(e.getMessage());
				if(e instanceof ExpiredJwtException ) {
					// RefreshToken으로 AccessToken 생성
					// DB에서 조회 또는 저장소에서 가져오기
					String refresh="";
					for(Cookie c : cookies) {
						if(c.getName().equals("refresh-token")) {
							refresh = c.getValue();
							break;
						}
					}
					
					//refresh token을 검증
					try {
						Authentication authentication = jwtTokenManager.getAuthenticationByToken(refresh);
						SecurityContextHolder.getContext().setAuthentication(authentication);
						// access token 생성
						String newtoken = jwtTokenManager.makeAccessToken(authentication);
						Cookie c = new Cookie("access-token", newtoken);
						c.setPath("/");
						c.setMaxAge(60);
						c.setHttpOnly(true);
						
						response.addCookie(c);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
		chain.doFilter(request, response);
	}
}
