package com.erernst.emaze.data;

import java.util.ArrayList;
import java.util.List;

public interface EmazeDAO {
	public Emaze getEmazeByName(String name);


	public void addEmaze(Emaze emaze);

	public ArrayList<Emaze> getEmazes();

	public void removeEmaze(Emaze emaze);

	public void setEmazes(List emazes);

}
