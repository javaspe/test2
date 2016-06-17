package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOImplTest {

	@Inject
	private ReplyDAO dao;

	@Test
	public void test(){
		System.out.println("DAT = "+dao);
	}

	@Test
	public void insertTest() throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setContent("�׽�Ʈ����");
		vo.setUser_name("�׽�Ʈ����");
		vo.setBoard_no(7);
		dao.insert(vo);
	}

	@Test
	public void getTest() throws Exception{
		int board_no = 11;
		ReplyVO vo = dao.get(board_no);
		System.out.println("�̸�:"+vo.getUser_name());
	}
	
	@Test
	public void getListTest() throws Exception{
		List<ReplyVO> list = dao.getList(6);
		Iterator<ReplyVO> it = list.iterator();
		while(it.hasNext()){
			ReplyVO vo = it.next();
			System.out.println("�̸�:"+vo.getUser_name());
		}
	}
	
	@Test
	public void updateTest() throws Exception{
		ReplyVO vo = new ReplyVO();

		vo.setContent("��������");
		vo.setUser_name("��������");
		vo.setBoard_no(2);
		dao.update(vo);
	}
	
	@Test
	public void deleteTest() throws Exception{
		dao.delete(3);
	}
	
}
