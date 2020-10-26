package jp.ken.shinsengumi.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.ken.shinsengumi.dao.CustomerDAO;
import jp.ken.shinsengumi.entity.Customer;
import jp.ken.shinsengumi.model.CustomerModel;
import jp.ken.shinsengumi.model.LoginModel;


@Controller
@RequestMapping("login")
//@SessionAttributes("loginModel")
public class LoginController {		//Spring教科書P137~参照
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static CustomerDAO<Customer> customerDAO = (CustomerDAO<Customer>)context.getBean("customerDAO");
	
	@Autowired
	  HttpSession session;
	
	//CustomerDAO<CustomerModel> cDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String tologin(Model model) {
		LoginModel lModel = new LoginModel();
		model.addAttribute("loginModel", lModel );
		return "loginForm";		
	}
	
	@RequestMapping(method=RequestMethod.POST,params="logins")
	public String login(@Validated @ModelAttribute LoginModel lModel,
			BindingResult result,Model model) {
		
		Customer cms=customerDAO.getByEmailAndPassword(lModel.getEmail(),lModel.getPassword());
		CustomerModel cModel = new CustomerModel();
		
		if(result.hasErrors()) {
			model.addAttribute("errorMessage", "emailアドレスまたはパスワードが間違っています");
			System.out.println("koko");
			return "loginForm";
		}else if(cms!=null) {
			
			model.addAttribute("loginModel", lModel );
			
			model.addAttribute("customerInfo", cms);
			
			BeanUtils.copyProperties(cms, cModel);
			//model.addAttribute("customerModel", cModel);
			System.out.println("kokodayo");
			return "mypage";
			
		}else {
			model.addAttribute("errorMessage", "emailアドレスまたはパスワードが間違っていますllll");
			return "loginForm";
		}
	}

/*	@RequestMapping(method=RequestMethod.POST,params="logins")
	public String logint(@Validated @ModelAttribute LoginModel lModel,
			BindingResult result,Model model) {
		
		boolean cms=customerDAO.getEmailAndPassword(lModel.getEmail(),lModel.getPassword());
		
		if(result.hasErrors()) {
			model.addAttribute("errorMessage", "emailアドレスまたはパスワードが間違っています");
			System.out.println("koko");
			return "loginForm";
		}else if(cms == true) {
			System.out.println("kokodayo");
			model.addAttribute("loginModel", lModel );
			
			//BeanUtils.copyProperties(ccust, cModel);
			//model.addAttribute("customerModel", cModel);
			
			List<Customer> list = null;
			list = new ArrayList<Customer>();
			list.add(cms);
			
			return "mypage";
		}else {
			model.addAttribute("errorMessage", "emailアドレスまたはパスワードが間違っています");
			return "loginForm";
		}				
	}
*/



}
	
	
	
	


	
	
	
	
	

