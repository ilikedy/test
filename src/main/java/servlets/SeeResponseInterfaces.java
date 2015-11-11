package servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeeResponseInterfaces
 */
public class SeeResponseInterfaces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeResponseInterfaces() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected long getLastModified(HttpServletRequest req) {
		return System.currentTimeMillis() ;
    	
    	//return 1445152972000L;
    };
    
    /**
     * 下载的测试 
     * @param request
     * @param response
     * @throws IOException
     */
    private void download(HttpServletRequest request, HttpServletResponse response) throws IOException{
		FileInputStream fis = new FileInputStream("/home/dy/src/python/fib.py");
		byte[] buf = new byte[1024];
		int len = fis.read(buf, 0,1024);
		
		fis.close();
		response.setContentType("application/octet-stream");
		response.setContentLength(len);
		response.setHeader("Content-Disposition", "attachment;filename=ha");
		OutputStream os = response.getOutputStream();
		os.write(buf, 0, 1024);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void headersTest(HttpServletRequest request, HttpServletResponse response) throws IOException{

		String  str_cn = "邓杨的测试";
		
		System.out.println("默认的字符集(getCharacterEncoding)：" + response.getCharacterEncoding());
		Locale locale = response.getLocale();
		System.out.println("locale(getLocale):"+locale.toString()+"   "+"lanauageTag:"+locale.getDisplayName());
		
		response.setContentType("text/html;charset=utf-8");
		System.out.println("调用setContentType后的字符集：" + response.getCharacterEncoding());
		
		response.setHeader("Content-Type", "text/html;charset=gbk");
		System.out.println("调用setHeader后的字符集：" + response.getCharacterEncoding());
		
		response.getWriter().write(str_cn);
    }

    private void cacheTest(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	String content = "contents..";
    	
    	long millis = System.currentTimeMillis();
    	
    	System.out.println("if-modified-since:"+request.getDateHeader("If-Modified-Since"));
    	
    	System.out.println("last-modified:"+getLastModified(request));
    	
    	response.setContentType("text/html;charset=utf-8");
    	response.setContentLength(content.length());
    	
    	//Cache-Control跟Expires同时存在时，浏览器优先使用Cache-Control
    	response.setHeader("Cache-Control", "max-age=6");
    	response.setDateHeader("Date", millis);
    	//response.setDateHeader("Expires", millis+10000);
    	//response.setDateHeader("Last-Modified", getLastModified(request));
    	response.setIntHeader("ETag", content.hashCode());
    	
    	response.getWriter().write(content);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String which = request.getParameter("which");
		boolean  isCaught = false;
		
		if(which.equals("headers")){
			isCaught = true;
			headersTest(request,response);
		}
		
		if(which.equals("download")){
			isCaught = true;
			download(request, response);
		}
		
		if(which.equals("cache")){
			isCaught = true;
			cacheTest(request, response);
		}

		if(!isCaught){
			response.getWriter().write("use params : which=?");
		}
		//response.getWriter().write("kaka");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
