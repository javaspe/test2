package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.RestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class RestDAOImplTest {

	@Inject
	private RestDAO dao;

	@Test
	public void test(){
		System.out.println("DAT = "+dao);
	}

	@Test
	public void insertTest() throws Exception{
		RestVO vo = new RestVO();
		vo.setContent("�׽�Ʈ����");
		vo.setTitle("�׽�ƮŸ��Ʋ");
		vo.setUser_name("�׽�Ʈ����");
		dao.insert(vo);
	}
	
	@Test
	public void getTest() throws Exception{
		int board_no = 11;
		RestVO vo = dao.get(board_no);
		System.out.println("�̸�:"+vo.getUser_name());
	}
	
	@Test
	public void getListTest() throws Exception{
		List<RestVO> list = dao.getList();
		Iterator<RestVO> it = list.iterator();
		while(it.hasNext()){
			RestVO vo = it.next();
			System.out.println("�̸�:"+vo.getUser_name());
		}
	}
	
	@Test
	public void updateTest() throws Exception{
		RestVO vo = new RestVO();

		vo.setContent("��������");
		vo.setTitle("����Ÿ��Ʋ");
		vo.setUser_name("��������");
		vo.setBoard_no(2);
		dao.update(vo);
	}
	
	@Test
	public void deleteTest() throws Exception{
		dao.delete(3);
	}
	
}
