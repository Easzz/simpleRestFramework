import com.easzz.handler.ResponseHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by easzz on 2017/11/18 19:35
 */
public class BasicServlet extends HttpServlet {
	private ComponentsLoader componentsLoader;

	@Override
	public void init() throws ServletException {
		//初始化装在bean
		componentsLoader = new ComponentsLoader();
		componentsLoader.init();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResponseHandler responseHandler=new ResponseHandler(req,resp);

		System.out.println();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
