package jsp.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="EncodingFilter", urlPatterns={"/*"}, 
			initParams= {@WebInitParam(name="language", value="Java")})

public class EncodingFilter implements Filter {
	private String encoding="utf-8";
	static int count=0;

    public EncodingFilter() {   }

	public void init(FilterConfig filterConfig) throws ServletException {		
		// 得到过滤器的名字
        String filterName = filterConfig.getFilterName();
        // 得到在web.xml文件中配置的初始化参数
        String initParam1 = filterConfig.getInitParameter("language");
        String initParam2 = filterConfig.getInitParameter("encoding");
        
        System.out.println("--------启动"+filterName+"过滤器--------");
        System.out.println("language="+initParam1+", encoding="+initParam2);
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
			throws IOException, ServletException {		
		//过滤请求：设置所过滤请求的编码方式
		req.setCharacterEncoding(encoding);			
		//过滤响应：设置所过滤响应的编码方式
		resp.setCharacterEncoding(encoding);
		resp.setContentType("text/html; charset=utf-8");
		//将请求和响应传递到下一个filter
		chain.doFilter(req, resp);		
		System.out.println("--------第"+ (++count) +"次过滤---------");
	}
	
	public void destroy() {
		System.out.println("-------------end-----------");
		encoding=null;
	}
}
