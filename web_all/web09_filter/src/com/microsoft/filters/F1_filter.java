package com.microsoft.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * filter的执行顺序: 如果是web.xml 配置 那么会根据filterMapping的顺序执行
 *                  如果是注解配置 那么会根据filter类名的字典序执行
 */
@WebFilter("/*")
public class F1_filter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
