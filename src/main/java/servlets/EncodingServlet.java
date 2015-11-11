package servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncodingServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dispatch(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dispatch(req, resp);
	}
	
	private void dispatch( HttpServletRequest req, HttpServletResponse resp){
		String action = req.getParameter("action");
		
		if(action.equalsIgnoreCase("formget")){
			formGet(req, resp);
		}
		
		if(action.equalsIgnoreCase("formpost")){
			try {
				formPost(req, resp);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(action.equalsIgnoreCase("link")){
			try {
				link(req, resp);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * form的GET提交
	 * @param req
	 * @param resp
	 */
	private void formGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			printEncoding(req, resp);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(name);
	}
	
	/**
	 * form的POST提交
	 * @throws UnsupportedEncodingException 
	 */
	private void formPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
		printEncoding(req, resp);
	}
	
	private void link(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
		printEncoding(req, resp);
	}
	private void printEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
		System.out.println("request encoding:"+req.getCharacterEncoding());
		String _name = req.getParameter("name");
		String name= new String(_name.getBytes("ISO-8859-1"),"ISO-8859-1");
		String name_1 = new String(_name.getBytes("UTF-8"), "UTF-8");
		String name_2 = new String(_name.getBytes("gb2312"), "gb2312");
		String name_3 = new String(_name.getBytes("ISO-8859-1"), "UTF-8");
		String name_4 = new String(_name.getBytes("ISO-8859-1"), "gb2312");
		
		System.out.println("ISO8859:"+name);
		System.out.println("UTF-8:"+name_1);
		System.out.println("gb2312:"+name_2);
		System.out.println("ISO8859  >>> UTF-8:"+name_3);
		System.out.println("ISO8859  >>> gb2312:"+name_4);
	}	
	private void printEncoding_1(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
		System.out.println("request encoding:"+req.getCharacterEncoding());
		String name = req.getParameter("name");
		String name_1 = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String name_2 = new String(name.getBytes("ISO-8859-1"), "gb2312");

		System.out.println("中文");

        System.out.println(Arrays.toString("中文".getBytes()) +"     "+"中文".getBytes());

        System.out.println(Arrays.toString("中文".getBytes("GB2312"))+"     "+"中文".getBytes("GB2312"));
        
        System.out.println(Arrays.toString("中文".getBytes("UTF-8"))+"		"+"     "+"中文".getBytes("UTF-8"));

        System.out.println(Arrays.toString("中文".getBytes("ISO8859_1"))+"     "+"中文".getBytes("ISO8859_1"));

        System.out.println(new String("中文".getBytes()));

        System.out.println(new String("中文".getBytes(), "GB2312"));
        System.out.println(new String("中文".getBytes(), "UTF-8"));

        System.out.println(new String("中文".getBytes(), "ISO8859_1"));

        System.out.println(new String("中文".getBytes("GB2312")));

        System.out.println(new String("中文".getBytes("GB2312"), "GB2312"));
        System.out.println(new String("中文".getBytes("UTF-8"), "UTF-8"));

        System.out.println(new String("中文".getBytes("GB2312"), "ISO8859_1"));

        System.out.println(new String("中文".getBytes("ISO8859_1")));

        System.out.println(new String("中文".getBytes("ISO8859_1"), "GB2312"));

        System.out.println(new String("中文".getBytes("ISO8859_1"), "ISO8859_1"));
		
		System.out.println("ori : "+name+"     "+ Arrays.toString(name.getBytes()));
		System.out.println("iso-8859-1 >>> gb2312  : "+name_2+"     "+ Arrays.toString(name_2.getBytes("gb2312")));
		
		System.out.println("iso-8859-1 >>> UTF-8 : "+name_1+"     "+ Arrays.toString(name_1.getBytes("UTF-8")));
			
	}
}
