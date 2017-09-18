package com.erernst.emaze.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class EmazeDAOImpl implements EmazeDAO {
	private static final String FILE_NAME = "/WEB-INF/mazes.csv";
	private ArrayList<Emaze> emazes = new ArrayList<>();
	private ServletContext context;

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String name = tokens[0];
				String city = tokens[1];
				String state = tokens[2];
				String course = tokens[3];
				emazes.add(new Emaze(name, city, state, course));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

	@Override
	public Emaze getEmazeByName(String name) {
		Emaze s = null;
		for (Emaze emaze : emazes) {
			if (emaze.getName().equalsIgnoreCase(name)) {
				s = emaze;
				break;
			}
		}
		return s;
	}

	@Override
	public void addEmaze(Emaze emaze) {
		emazes.add(emaze);
	}
	@Override
	public void removeEmaze(Emaze maze) {
		emazes.remove(maze);	
	}
	

	@Override
	public ArrayList<Emaze> getEmazes() {
		return emazes;
	}

	@Override
	public void setEmazes(List emazeTemp) {
		emazes = (ArrayList<Emaze>) emazeTemp;
	}


}

