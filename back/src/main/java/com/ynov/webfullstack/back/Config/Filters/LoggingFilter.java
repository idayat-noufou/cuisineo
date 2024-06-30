package com.ynov.webfullstack.back.Config.Filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(wrappedRequest, wrappedResponse);
        long duration = System.currentTimeMillis() - startTime;

        String requestBody = new String(wrappedRequest.getContentAsByteArray());
        String responseBody = new String(wrappedResponse.getContentAsByteArray());

        // Collect headers
        String requestHeaders = Collections.list(wrappedRequest.getHeaderNames()).stream()
                .map(headerName -> headerName + ": " + Collections.list(wrappedRequest.getHeaders(headerName)))
                .collect(Collectors.joining(", "));

        logger.info("Request URI: " + wrappedRequest.getRequestURI() + " \n- Method: " + wrappedRequest.getMethod() +
                " \n- Headers: [" + requestHeaders + "] \n- Body: " + requestBody +
                " \n- Time taken: " + duration + " ms \n- Response Status: " + wrappedResponse.getStatus() +
                " \n- Response Body: " + responseBody);

        wrappedResponse.copyBodyToResponse();
    }

//    @Override
//
//    }
}
