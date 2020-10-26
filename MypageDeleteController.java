package jp.ken.shinsengumi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ken.shinsengumi.dao.CustomerDAO;
import jp.ken.shinsengumi.entity.Customer;
import jp.ken.shinsengumi.model.CustomerModel;

@Controller
@RequestMapping("delete")
public class MypageDeleteController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static CustomerDAO<Customer> customerDAO = (CustomerDAO<Customer>)context.getBean("customerDAO");
	
	@Autowired
	  HttpSession session;

	@RequestMapping(method=RequestMethod.GET)
	public String toDelete
	(@RequestParam int paramCustomer_no, Model model) {	
		Customer cust = customerDAO.getByCustomer_no(paramCustomer_no) ;
		model.addAttribute("deleteCustomer", cust);
		return "mypageDelete";
	}


	@RequestMapping(method=RequestMethod.POST)
	public String delete
	(@RequestParam int paramCustomer_no, Model model) {
		if(customerDAO.deleteCustomerData(paramCustomer_no) == 1) {
			return "mypageDeleteCommit";
		}		
		else {
			//model.addAttribute("errorMessage", "何らかのエラーが発生しています");
			return "mypageDelete";
		}
	}

	
/*	@RequestMapping(method = RequestMethod.GET,params="mypageDelete")
	public String toDeleteComp(Model model) {
		return "mypageDeleteCommit";
	}
*/	
}
