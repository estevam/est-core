package com.est.observer.property.change;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Observable {
	private String news;

	private PropertyChangeSupport support;

	public Observable() {
		support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
		
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public void setNews(String value) {
		support.firePropertyChange("news 2", this.news, value);
		this.news = value;
	}
}
