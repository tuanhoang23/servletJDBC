package filter;

import constant.systemconstant;
import model.userModel;
import util.sessionUtil;
import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




public class authorizationFilter implements Filter {

    private ServletContext svc ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.svc = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        userModel model = null;
        if(url.startsWith("/admin")){
            model = (userModel) sessionUtil.getInstance().getValue(request,"USERMODEL");
            if(model != null){
                if(model.getRole().getCodeRole().equals(systemconstant.ADMIN)){
                    chain.doFilter(request, response);
                }else if(model.getRole().getCodeRole().equals(systemconstant.USER)){
                    response.sendRedirect(request.getContextPath()+"/login?action=login&message=not_permission&alert=warning");
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/login?action=login&message=not_login&alert=warning");
            }

        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
