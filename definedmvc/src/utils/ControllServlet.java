package utils;


import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionModel;
import model.ResultModel;

@WebServlet("/lele/*")
public class ControllServlet extends HttpServlet {

	private static final long serialVersionUID = -7160959678594567916L;
	
	private ActionMappingManager mapping;
	
	public void init(ServletConfig config) {
		mapping = new ActionMappingManager();
		mapping.init();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse responser) {

	
		try {
			String uri = request.getRequestURI();
			String path = uri.substring(uri.lastIndexOf("/") + 1);
			System.out.println(uri);
			String actionName = path.split("_")[0];
			String actionMethod = path.split("_")[1];
			ActionModel actionModel = mapping.getActionModel(actionName);
			String className = actionModel.getActionClass();
			Object obj = Class.forName(className).newInstance();
			Method method = obj.getClass().getMethod(actionMethod);
			
			String msg = (String) method.invoke(obj);
			ResultModel rm = actionModel.getMap().get(msg);
			request.getRequestDispatcher(rm.getResultPath()).forward(request, responser);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
