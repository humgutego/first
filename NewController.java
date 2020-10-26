package jp.ken.shinsengumi.controller;

import org.springframework.beans.BeanUtils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.shinsengumi.dao.CustomerDAO;
import jp.ken.shinsengumi.entity.Customer;
import jp.ken.shinsengumi.model.CustomerModel;

@Controller
@RequestMapping("new")
public class NewController {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static CustomerDAO<Customer> customerDAO = (CustomerDAO<Customer>)context.getBean("customerDAO");
	
	//private CustomerDAO<CustomerModel>
	
	@RequestMapping(method = RequestMethod.GET)
	public String toRegist(Model model) {
		CustomerModel cModel = new CustomerModel();
		model.addAttribute("customerModel", cModel);
		return "new";
	}
	
	@RequestMapping(method=RequestMethod.POST,params="checking")
	public String check(
			@Validated @ModelAttribute CustomerModel cModel,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("errorMessage", "エラーが発生しています");
			return "new";
		}else {	
			
			model.addAttribute("name", cModel.getName());
			model.addAttribute("email", cModel.getEmail());
			model.addAttribute("password", cModel.getPassword());
			model.addAttribute("address", cModel.getAddress());
			model.addAttribute("phone_number", cModel.getPhone_number());
			
			return "check";
			/*}else {
				model.addAttribute("errorMessage", "このメールアドレスは使用できません");
				return "new";
			}
			
		}*/
	}
	}
}
		
		/*@RequestMapping(method=RequestMethod.POST,params="regist")
		public String regist(
				@Validated @ModelAttribute CustomerModel cModel,
				BindingResult result,Model model) {
			if(result.hasErrors()) {
				model.addAttribute("errorMessage", "エラーが発生しています");
				return "new";
			}else {		
				Customer cust = new Customer();
				BeanUtils.copyProperties(cModel, cust);
				if(customerDAO.insertCustomerData(cust)) {
					return "commit";
				}else {
					model.addAttribute("errorMessage", "このメールアドレスは使用できません");
					return "new";
				}
				
			}		
		
		
		
		
		
		
	}
	
	//@RequestMapping(method=RequestMethod.POST)
	
	 

}*/
