package lifter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "Filter 1", urlPatterns = {"/*"})/*可以对所有资源进行过滤*/
public class Filter1_Time implements Filter {

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 1 - date begins");
        //将servletRequest强制类型转换为HttpServletRequest
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String path=request.getRequestURI();
        java.util.Calendar c=java.util.Calendar.getInstance();
        //yyyy表示年(year),MM表示月(month),HH表示24小时制(hour),如果换成hh表示12小时制 ,mm表示分钟(mintue),ss表示秒(second)
        //java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy年MM月dd日HH: mm");
        System.out.println(path+" @ "+ f.format(c.getTime()));
        //放行，执行其他过滤器，如过滤器已经执行完毕，则执行原请求
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter 1 - date ends");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
}
