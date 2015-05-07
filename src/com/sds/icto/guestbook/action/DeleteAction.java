package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.guestbookDao;
import com.sds.icto.guestbook.vo.guestbookVo;
import com.sds.icto.web.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String pwd = request.getParameter("pwd");
		int no = Integer.parseInt(request.getParameter("no"));

		guestbookVo vo = new guestbookVo();
		guestbookDao dao = new guestbookDao();

		vo.setPwd(pwd);
		vo.setNo(no);

		if (pwd.equals(vo.getPwd())) {
			dao.delete(no, pwd);
		}

		response.sendRedirect("/guestbook2/gb");
	}

}
