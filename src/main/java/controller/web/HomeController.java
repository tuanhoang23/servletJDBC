package controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.newsModel;
import model.userModel;
import service.iUserService;
import util.formUtils;
import util.sessionUtil;


@WebServlet(urlPatterns = {"/home-page","/login","/logout"})
public class HomeController extends HttpServlet {

	@Inject
	private iUserService userService;

	private static final long serialVersionUID = 7051830843985824356L;
	ResourceBundle mrs = ResourceBundle.getBundle("message");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String action = request.getParameter("action");

		if(action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null){
				request.setAttribute("message",mrs.getString(message));
				request.setAttribute("alert",alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/Login.jsp");
			rd.forward(request,response);
		}else if(action != null && action.equals("logout")) {
			sessionUtil.getInstance().removeValue(request,"USERMODEL");
			response.sendRedirect(request.getContextPath()+"/home-page");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request,response); 
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String action = request.getParameter("action");
		
		if(action != null && action.equals("login")) {
			userModel model = formUtils.toModel(userModel.class, request);
			model = userService.findByUserNameAndPw(model.getUserName(), model.getPassword(), 1);
			if(model != null) {
				sessionUtil.getInstance().putValue(request,"USERMODEL",model);
				if(model.getRole().getCodeRole().equals("USER")) {
					response.sendRedirect(request.getContextPath()+"/home-page");
				}else if(model.getRole().getCodeRole().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath()+"/admin-home");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/login?action=login&message=userName_password_inValid&alert=danger");
			}
		}
	}

}
