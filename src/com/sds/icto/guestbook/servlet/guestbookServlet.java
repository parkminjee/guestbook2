package com.sds.icto.guestbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.action.DeleteAction;
import com.sds.icto.guestbook.action.IndexAction;
import com.sds.icto.guestbook.action.InsertAction;
import com.sds.icto.web.Action;

/**
 * Servlet implementation class guestbookServlet
 */
@WebServlet("/gb")
public class guestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestbookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{	
			request.setCharacterEncoding( "utf-8" );
			String a = request.getParameter( "a" );
			
			Action action = null;
			if( "delete".equals( a ) ) {
				action = new DeleteAction();
				
			}else if("add".equals(a)){
				action = new InsertAction();
				
			}
			if(action == null){
				action = new IndexAction();
			}
			action.execute(request, response);

			
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
		
	}
	

}
