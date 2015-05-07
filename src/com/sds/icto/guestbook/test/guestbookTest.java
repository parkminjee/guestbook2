package com.sds.icto.guestbook.test;

import java.util.List;

import com.sds.icto.guestbook.dao.guestbookDao;
import com.sds.icto.guestbook.vo.guestbookVo;

public class guestbookTest {
	public static void main(String[] args) {
		try{
//			testInsert();
			testDelete();
			testFetchList();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void testDelete() throws Exception {
		guestbookDao dao = new guestbookDao();
		guestbookVo vo = new guestbookVo();

		dao.delete(22,"111");
	}

	public static void testFetchList() throws Exception {
		guestbookDao dao = new guestbookDao();
		List<guestbookVo> list = dao.fetchList();

		for (guestbookVo vo : list) {
			System.out.print(vo.getNo() + ":");
			System.out.print(vo.getId() + ":");
			System.out.print(vo.getPwd() + ":");
			System.out.print(vo.getMeg() +":");
			System.out.println(vo.getDate());
			System.out.print("\n");
		}
	}

	public static void testInsert() throws Exception {
		guestbookDao dao = new guestbookDao();

		guestbookVo vo = new guestbookVo();
		vo.setId("민지");
		vo.setPwd("1515");
		vo.setMeg("hi");
		dao.insert(vo);

		vo = new guestbookVo();
		vo.setId("mj");
		vo.setPwd("hoho");
		vo.setMeg("hello");
		dao.insert(vo);

	}
}
