//201802104065闫天意
package lifter;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter 2", urlPatterns = {"/*"})/*可以对所有资源进行过滤*/

public class Filter2_Session implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 2 - session begins");
        //将servletRequest强制类型转换为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //将servletResponse强制类型转换为HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        if (path.contains("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("执行其它过滤器或原请求" + "\n");
        } else {
            JSONObject message = new JSONObject();
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("currentUser") == null) {
                message.put("message", "请登录或重新登陆");
                response.getWriter().println(message);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        System.out.println("Filter 2 - session ends" + "\n");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
}
