package org.jeecgframework.web.system.manager;

import java.util.Comparator;

import org.jeecgframework.web.system.base.Client;

public class ClientSort implements Comparator<Client> {

	
	public int compare(Client prev, Client now) {
		return (int) (now.getLogindatetime().getTime()-prev.getLogindatetime().getTime());
	}

}
