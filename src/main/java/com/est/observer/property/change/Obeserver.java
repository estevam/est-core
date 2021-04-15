package com.est.observer.property.change;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Obeserver implements PropertyChangeListener {
	private String news;
	Thread threadTest;
	public Obeserver(Thread test){
		threadTest = test;
	}

	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stubevt
		  this.setNews((String) evt.getNewValue());

		  System.out.print((String) evt.getNewValue());

		  threadTest.interrupt();
	
	}

}
