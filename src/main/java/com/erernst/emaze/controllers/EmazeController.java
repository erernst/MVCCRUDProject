package com.erernst.emaze.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.erernst.emaze.data.Emaze;
import com.erernst.emaze.data.EmazeDAO;

@Controller
@SessionAttributes({"emaze"})
public class EmazeController {
	@Autowired
	private EmazeDAO emazeDao;


	public EmazeDAO getEmazeDao() {
		return emazeDao;
	}

	public void setEmazeDao(EmazeDAO emazeDao) {
		this.emazeDao = emazeDao;
	}

	@RequestMapping(path = "GetStateData.do", params = "name", method = RequestMethod.GET)
	public String getByName(Model model, @RequestParam("name") String n) {
		model.addAttribute("emaze", emazeDao.getEmazeByName(n));
		return "result.jsp";
	}

	@RequestMapping(path = "index.do")
	public String indext() {
		return "index.jsp";
	}



	@RequestMapping(path = "start.do", method = RequestMethod.GET)
	public ModelAndView getMazes() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("mazelist.jsp");
	
		mv.addObject("mazes", emazeDao.getEmazes());
		return mv;
	}

	@RequestMapping(path = "remove.do", method = RequestMethod.GET)
	public ModelAndView removeMazes(@RequestParam("maze") String maze) {
		System.out.println(maze );
		Emaze emazeToRemove= null;
		for (Emaze emaze : emazeDao.getEmazes()) {
			if(emaze.getName().equals(maze)){
				emazeToRemove = emaze;
			}
		}
		emazeDao.removeEmaze(emazeToRemove);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mazelist.jsp");
		mv.addObject("mazes", emazeDao.getEmazes());
		return mv;
	}
	
	@RequestMapping(path = "change.do", method = RequestMethod.GET)
	public ModelAndView editMazeName(@RequestParam("name") String name) {

		Emaze emazeToRemove= null;
		for (Emaze emaze : emazeDao.getEmazes()) {
			if(emaze.getName().equals(name)){
				emazeToRemove = emaze;
			}
		}
		System.out.println(emazeToRemove);
		emazeDao.removeEmaze(emazeToRemove);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mazelist.jsp");
		mv.addObject("mazes", emazeDao.getEmazes());
		return mv;
	}

	@RequestMapping(path = "edit.do", method = RequestMethod.GET)
	public ModelAndView editMaze(@RequestParam("maze") String name) {
		Emaze emaze = emazeDao.getEmazeByName(name);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("medit.jsp");
		mv.addObject("maze", emaze);
		return mv;
	}

	@RequestMapping(path = "view.do", method = RequestMethod.GET)
	public ModelAndView viewMaze(@RequestParam("maze") String name) {
		Emaze emaze = emazeDao.getEmazeByName(name);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("maze.jsp");
		mv.addObject("maze", emaze);
		return mv;
	}

	@RequestMapping(path = "NewMaze.do", method = RequestMethod.POST)
	public ModelAndView newStateRedir(@RequestParam("name") String name, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("url") String url) {
		ModelAndView mv = new ModelAndView();
		Emaze emaze = new Emaze(name, city, state, url);
		emazeDao.addEmaze(emaze);
		mv.addObject("mazes", emazeDao.getEmazes());
		mv.setViewName("mazelist.jsp");
		return mv;
	}
	
	@RequestMapping(path = "editMaze.do", method = RequestMethod.POST)
	public ModelAndView editMaze(@RequestParam("oldname") String oldname,@RequestParam("name") String name, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("url") String url) {
		Emaze emazeToRemove= null;
		for (Emaze emaze : emazeDao.getEmazes()) {
			if (emaze.getName().equals(oldname)){
			emazeToRemove= emaze;}
		}
		emazeDao.removeEmaze(emazeToRemove);
		int i =1;
		for (Emaze emaze : emazeDao.getEmazes()) {
			i = (emaze.getName().equals(name))? 0: i;
		}
		ModelAndView mv = new ModelAndView();
		if (i>0) {
		Emaze emaze = new Emaze(name, city, state, url);
		emazeDao.addEmaze(emaze);}
		mv.addObject("mazes", emazeDao.getEmazes());
		mv.setViewName("mazelist.jsp");
		return mv;
	}

}
