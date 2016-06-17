package com.study.springrest.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.RestVO;
import com.study.springrest.service.RestService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/rest")
public class Rest {
	
	@Inject
	private RestService service;

	// /����/    ���
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView aaa = new ModelAndView();
		aaa.setViewName("list");
		List<RestVO> list = service.getList();
		aaa.addObject("list",list);
		return aaa;
	}
	
	// /����/�۹�ȣ    ��
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("board_no") Integer board_no) {
		ModelAndView aaa = new ModelAndView();
		aaa.setViewName("detail");
		RestVO vo = service.get(board_no);
		aaa.addObject("vo",vo);
		return aaa;
		
		//return new ModelAndView("redirect:/rest");
	}
	
	
	// /����/new �۾��� ������
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	// /����/��ȣ  ����
	@RequestMapping(value = "/{board_no}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("board_no") Integer board_no) {
		service.delete(board_no);
		return new ModelAndView("redirect:/rest");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
