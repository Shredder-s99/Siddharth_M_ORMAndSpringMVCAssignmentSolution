package com.greatlearning.crm.Service;

import java.util.List;

import com.greatlearning.crm.Model.CustomerRelationshipManager;

public interface CRMService {
	public List<CustomerRelationshipManager> listAllData();
	public void save(CustomerRelationshipManager crm);
	public CustomerRelationshipManager delete(int id);
	public CustomerRelationshipManager getCustomer(int id);

}
