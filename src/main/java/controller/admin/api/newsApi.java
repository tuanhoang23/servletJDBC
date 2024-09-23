package controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.newsModel;
import model.userModel;
import service.iNewsService;
import util.httpUtil;
import util.sessionUtil;

@WebServlet(urlPatterns = "/api-admin-news")
public class newsApi extends HttpServlet {
	
	@Inject
	private iNewsService newsService;

	private static final long serialVersionUID = -5423916245520356128L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		newsModel news = httpUtil.of(request.getReader()).toModel(newsModel.class);
		news.setCreateBy(((userModel) sessionUtil.getInstance().getValue(request,"USERMODEL")).getUserName());
		news = newsService.save(news);
//		System.out.println(this.news);
		mapper.writeValue(response.getOutputStream(), news);//bai4 api
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		newsModel updateNews = httpUtil.of(request.getReader()).toModel(newsModel.class);
		updateNews.setModifileBy(((userModel) sessionUtil.getInstance().getValue(request,"USERMODEL")).getUserName());
		updateNews = newsService.update(updateNews);
		mapper.writeValue(response.getOutputStream(), updateNews );
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		newsModel removeNews = httpUtil.of(request.getReader()).toModel(newsModel.class);
		newsService.delete(removeNews.getIds());
		mapper.writeValue(response.getOutputStream(),"{}");
	}


}
