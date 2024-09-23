package controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.systemconstant;
import model.newsModel;
import paging.pageRequest;
import paging.Pageable;
import service.iCatagoriesService;
import service.iNewsService;
import sort.Sorter;
import util.formUtils;


@WebServlet(urlPatterns = "/admin-news")
public class NewController extends HttpServlet {
	
	@Inject
	private iNewsService newService;

	@Inject
	private iCatagoriesService categoriesService;
	private static final long serialVersionUID = 5013983858232157090L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		newsModel model = formUtils.toModel(newsModel.class, request);
		String view = "";
		if(model.getType().equals(systemconstant.LIST)){
			Pageable pageable = new pageRequest(model.getPage(),model.getMaxPageItem(),new Sorter(model.getSortName(), model.getSortBy()));
			model.setResult(newService.findAll(pageable));
			model.setTotalItems(newService.countItem());
			model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItem()));
			view = "/views/admin/new/List.jsp";

		}else if(model.getType().equals(systemconstant.EDIT)){
			if(model.getId() != null){
				model = newService.findOne(model.getId());
			}else{

			}
			request.setAttribute("categories",categoriesService.findAll());
			view = "/views/admin/new/edit.jsp";
		}
		request.setAttribute(systemconstant.MODEL,model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
	}

}
