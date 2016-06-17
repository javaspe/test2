package com.study.springrest.service;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;
import com.study.springrest.persistence.ReplyDAO;
import com.study.springrest.persistence.RestDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyServiceImplTest {

	@Inject
	private ReplyDAO replyDao;
	
	@Inject
	private RestDAO restDao;

	@Test
	public void test(){
		System.out.println("service = "+restDao);
	}

	@Transactional
	@Test
	public void increaseTest() throws Exception{
		restDao.increaseReply(8);
		
		ReplyVO vo = new ReplyVO();
		vo.setReply_no(11);
		vo.setContent("�׽�Ʈ����fromJUNIT");
		vo.setUser_name("�׽�Ʈ����fromJUNIT");
		vo.setBoard_no(8);
		replyDao.insert(vo);
	}
}
