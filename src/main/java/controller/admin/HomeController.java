package controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.newsModel;
import service.iCatagoriesService;
import service.iNewsService;


@WebServlet(urlPatterns = "/admin-home")
public class HomeController extends HttpServlet {

	@Inject
	private iCatagoriesService catagoryService;
	@Inject
	private iNewsService newsService;
	
	private static final long serialVersionUID = 5013983858232157090L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		Long catagoryId = 1L;
//		request.setAttribute("news",newsService.findByCatagoryId(catagoryId)
//		request.setAttribute("catagories",catagoryService.findAll());

		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
	}

}
