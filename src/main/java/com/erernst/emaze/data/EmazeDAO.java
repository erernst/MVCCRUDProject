package com.erernst.emaze.data;

import java.util.ArrayList;
import java.util.List;

public interface EmazeDAO {
	public Emaze getEmazeById(int id);


	public void addEmaze(Emaze emaze);

	public List<Emaze> getEmazes();

	public boolean removeEmaze(int id);

	public void setEmazes(List emazes);


}
