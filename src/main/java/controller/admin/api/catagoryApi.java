package controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.catagoriesModel;
import service.iCatagoriesService;
import util.httpUtil;

@WebServlet(urlPatterns = "/api-admin-catagories")
public class catagoryApi extends HttpServlet {

	@Inject
	private iCatagoriesService catagoryService;

	private static final long serialVersionUID = -5925476720459467893L;

	protected void doPost(HttpServletRequest request, HttpServletResponse pesponse)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		pesponse.setContentType("aplication/json");
		catagoriesModel catagory = httpUtil.of(request.getReader()).toModel(catagoriesModel.class);
		catagory = catagoryService.save(catagory);
		System.out.println(catagory);
		mapper.writeValue(pesponse.getOutputStream(), catagory);
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse pesponse)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		pesponse.setContentType("aplication/json");
		catagoriesModel catagoryUpdate = httpUtil.of(request.getReader()).toModel(catagoriesModel.class);
		catagoryUpdate = catagoryService.update(catagoryUpdate);
		mapper.writeValue(pesponse.getOutputStream(), catagoryUpdate);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse pesponse)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		pesponse.setContentType("aplication/json");
		catagoriesModel catagoryDelete = httpUtil.of(request.getReader()).toModel(catagoriesModel.class);
		catagoryService.delete(catagoryDelete.getIds());
		mapper.writeValue(pesponse.getOutputStream(), "{}");
	}

}
