package com.conference.restful.api.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;

import com.conference.restful.api.auth.exceptions.JwtTokenMissingException;

public class JwtAuthFilter implements Filter{

	public JwtAuthFilter() {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		
		String header = request.getHeader("Authorization");
		if (header == null) {
			chain.doFilter(request, response);
			return;
		}
		if (!header.startsWith("Bearer ")) {
			SecurityContextHolder.clearContext();
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }
		String authToken = header.substring(7);
		JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
		SecurityContextHolder.getContext().setAuthentication(authRequest);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
