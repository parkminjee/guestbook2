package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.guestbookDao;
import com.sds.icto.guestbook.vo.guestbookVo;
import com.sds.icto.web.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String name = request.getParameter( "name" );
		String pwd = request.getParameter( "pwd" );
		String meg = request.getParameter( "meg" );

		guestbookVo vo = new guestbookVo();
		vo.setId( name );
		vo.setPwd(pwd);
		vo.setMeg(meg);


		guestbookDao dao = new guestbookDao();
		dao.insert( vo );

		response.sendRedirect("/guestbook2/gb");
	}

}
