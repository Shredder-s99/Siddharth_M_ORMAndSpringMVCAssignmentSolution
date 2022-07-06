package com.greatlearning.crm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm.Model.CustomerRelationshipManager;
import com.greatlearning.crm.Service.CRMServiceImplementation;


@Controller
@RequestMapping("crm")
public class CRMController {
	
	  @Autowired 
	  CRMServiceImplementation crmServiceImplementation;
	 
	
	@RequestMapping("/list")
	public String list(Model model){
		  List<CustomerRelationshipManager> crm =
		  crmServiceImplementation.listAllData(); model.addAttribute("result",crm);
		return "list";
	}
	@RequestMapping("/add")
	public String save(Model model) {
		CustomerRelationshipManager crm = new CustomerRelationshipManager();
		model.addAttribute("result",crm);
		return "save";
	}
	@RequestMapping("/update")
	public String update(Model model,@RequestParam("id")int id) {
		CustomerRelationshipManager crm = crmServiceImplementation.getCustomer(id);
		model.addAttribute("result",crm);
		return "save";
	}
	@RequestMapping("/delete")
	public String delete(Model model,@RequestParam("id")int id) {
		CustomerRelationshipManager crm = crmServiceImplementation.delete(id);
		return "redirect:/crm/list";
	}
	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("emailId") String emailId) {
		CustomerRelationshipManager crm;
		if(id != 0) {
			crm = crmServiceImplementation.getCustomer(id);
		}else {
			crm = new CustomerRelationshipManager();
		}
		crm.setEmailId(emailId);
		crm.setFirstName(firstName);
		crm.setLastName(lastName);
		crmServiceImplementation.save(crm);
		return "redirect:/crm/list";
	}
}
