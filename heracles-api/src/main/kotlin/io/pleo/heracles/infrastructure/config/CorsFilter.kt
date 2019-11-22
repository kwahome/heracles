package io.pleo.heracles.infrastructure.config

import java.io.IOException
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CorsFilter : Filter {

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig?) {
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest?, servletResponse: ServletResponse, filterChain: FilterChain) {
        val response = servletResponse as HttpServletResponse
        val request = servletRequest as HttpServletRequest?
        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS")
        response.setHeader("Access-Control-Allow-Headers", "*")
        response.setHeader("Access-Control-Allow-Credentials", true.toString())
        response.setHeader("Access-Control-Max-Age", 180.toString())
        filterChain.doFilter(servletRequest as HttpServletRequest?, servletResponse)
    }

    override fun destroy() {}
}
