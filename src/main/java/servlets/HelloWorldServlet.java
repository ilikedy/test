package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Enumeration<String >  emAttr =  request.getAttributeNames();
		
		pw.write("=====================getAttributeNames=====================\r\n");
		while(emAttr.hasMoreElements()){
			pw.write(emAttr.nextElement());
		}	
		pw.write("=====================getAttributeNames=====================\r\n");
		pw.write("\r\n\r\n");
		
		pw.write("getCharacterEncoding :"+request.getCharacterEncoding()+"\r\n");
		
		pw.write("\r\n\r\n");
		pw.write("======================headers======================\r\n");
		@SuppressWarnings("unchecked")
		Enumeration< String> emheader =  request.getHeaderNames();
		while(emheader.hasMoreElements()){
			String header = emheader.nextElement();
			pw.write(header+":"+request.getHeader(header)+"\r\n");
		}
		pw.write("======================headers======================\r\n");
		pw.write("\r\n\r\n");
		
		pw.write("getPathInfo :"+request.getPathInfo()+"\r\n");
		pw.write("getServletPath :"+request.getServletPath()+"\r\n");
		
		pw.write("======================params======================\r\n");
		@SuppressWarnings("unchecked")
		Enumeration< String> emparam = request.getParameterNames();
		while(emparam.hasMoreElements()){
			String param = emparam.nextElement();
			String[] values = request.getParameterValues(param);
			pw.write(param+":");
			for(String str : values){
				pw.write("{"+str+"}    ");
			}
			pw.write("\r\n");
		}
		pw.write("======================params======================\r\n\r\n");
		
		pw.write("getAuthType :"+request.getAuthType()+"\r\n");
		pw.write("getQueryString :"+request.getQueryString().toString()+"\r\n");
		
		request.getLocale();
		
		Class<?> clazz = request.getClass();
		
		while(true){
			pw.write(clazz.getName()+"<<<<<<<<<<<<<<\r\n");
			if(!clazz.getName().matches(".*[rR]equest.*") && !clazz.getName().matches(".*[sS]ervlet.*"))
				break;
		Method[] methods = clazz.getMethods();
		request.getLocale();
		for(Method method : methods){
			//pw.write(method.getName()+":\r\n");
			if(
					method.getParameterCount() < 1 
					&& !method.getName().equalsIgnoreCase("init")
					&& !method.getName().equalsIgnoreCase("destroy") 
					&& !method.getName().equalsIgnoreCase("notify")
					&& !method.getName().equalsIgnoreCase("notifyAll")
					&& !method.getName().equalsIgnoreCase("wait")
					&& !method.getName().equalsIgnoreCase("equal")
					&& !method.getName().equalsIgnoreCase("tostring")){
				pw.write(method.getName()+":");
				try {
					Object obj = method.invoke(request, (Object[]) null);
					pw.write((obj==null)?"null":obj.toString());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw.write("\r\n");
			}
		}

		pw.write(clazz.getName()+":>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\r\n");
		clazz = clazz.getSuperclass();
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
