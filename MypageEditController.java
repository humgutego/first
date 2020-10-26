package jp.ken.shinsengumi.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import jp.ken.shinsengumi.dao.CustomerDAO;
import jp.ken.shinsengumi.entity.Customer;
import jp.ken.shinsengumi.model.CustomerModel;

@Controller
@RequestMapping("edit")
public class MypageEditController {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static CustomerDAO<Customer> customerDAO = (CustomerDAO<Customer>)context.getBean("customerDAO");
	
	@Autowired
	  HttpSession session;

	@RequestMapping(method=RequestMethod.GET)
	public String toEdit
	(@ModelAttribute CustomerModel cModel, @RequestParam int paramCustomer_no, Model model) {
		System.out.println("toedit01");	
		
		Customer cust = customerDAO.getByCustomer_no(paramCustomer_no) ;
		//CustomerModel cModel = new CustomerModel();
		BeanUtils.copyProperties(cust,cModel);
		cModel.setCustomer_no(new Integer(paramCustomer_no).toString());
		model.addAttribute("customerModel", cModel);
System.out.println("toedit02");
		

		//customerデーブルのemailにUNIQUE制約がついているため、同一メールアドレスでのデータベースへの登録ができない。
		//以下のif(){}はcustomerテーブルから会員情報を削除するためのコード。
		//以下のコードを加えると一度会員情報を削除してから新たに会員情報を登録するため
		//新規登録と同じロジックになり会員番号が変更されてしまう。しかし、登録はできるようになる。

		/*if(customerDAO.deleteCustomerData(paramCustomer_no) == 1) {
			//return "mypage";
		}*/
		return "mypageEdit";
	}
	
	
/*	
	@RequestMapping(method=RequestMethod.POST,params="editing")
	public String delete
	(@RequestParam int paramCustomer_no, Model model) {
		if(customerDAO.deleteCustomerData(paramCustomer_no) == 1) {
			return "mypageEdit";
		}		
		else {
			//model.addAttribute("errorMessage", "何らかのエラーが発生しています");
			return "mypageDelete";
		}
	}

	*/
	
	
	

	@RequestMapping(method=RequestMethod.POST,params="editing")
	public String regist(
			@RequestParam int paramCustomer_no,
			@Validated @ModelAttribute CustomerModel cModel,
			BindingResult result,Model model) {
		

		
		
		if(result.hasErrors()) {
			cModel.setCustomer_no(new Integer(paramCustomer_no).toString());
			model.addAttribute("errorMessage", "エラーが発生しています");
			return "mypageEdit";
		}else {
			cModel.setCustomer_no(new Integer(paramCustomer_no).toString());
			Customer cust = new Customer();
			BeanUtils.copyProperties(cModel, cust);
			if(customerDAO.updataCustomerData02(cust)) {
				return "mypageCommit";
			}else {
				cModel.setCustomer_no(new Integer(paramCustomer_no).toString());
				model.addAttribute("errorMessage", "このメールアドレスは使用できません");
				return "mypageEdit";
			}
			
		}
		
	}
	
	
	/*@RequestMapping(method=RequestMethod.POST,params="editing")
	public String edit
	(@RequestParam int paramCustomer_no, @ModelAttribute CustomerModel cModel,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			//cModel.setCustomer_no(new Integer(paramCustomer_no).toString());
			model.addAttribute("errorMessage", "エラーが発生しています");
			return "mypageEdit";
		}
		else {
			cModel.setCustomer_no(new Integer(paramCustomer_no).toString());
			model.addAttribute("customerModel", cModel);
			return "mypageCheck";
		}	
	}
	
	@RequestMapping(method=RequestMethod.POST,params="editback")
	public String toBack(
		 @ModelAttribute CustomerModel cModel,Model model) {
		
		model.addAttribute("customerModel", cModel);
			return "mypageEdit";
		}

	@RequestMapping(method=RequestMethod.POST,params="editregist")
	public String regist(
			@RequestParam int paramCustomer_no,
			@Validated @ModelAttribute CustomerModel cModel,
			BindingResult result,Model model) {	
		//cModel.setCustomer_no(new Integer(paramCustomer_no).toString());
			Customer cust = new Customer ();
			BeanUtils.copyProperties(cModel, cust);
			if(customerDAO.updataCustomerData(cust)) {
				return "mypageCommit";
			}else {
				model.addAttribute("errorMessage", "このメールアドレスは使用できません");
				return "mypageEdit";
			}
	}		
	
	*/
	
	
	
	
	
	


	/*@RequestMapping(method=RequestMethod.GET)
	public String toEdit
	(@RequestParam String paramEmail, @RequestParam String paramPassword,Model model) {
		System.out.println("toedit01");		
		Customer cust = customerDAO.getByEmailAndPassword(paramEmail, paramPassword);
		CustomerModel cModel = new CustomerModel();
		BeanUtils.copyProperties(cust,cModel);
		model.addAttribute("customerModel", cModel);
System.out.println("toedit02");
		return "mypageEdit";
	}
	*/
	
}
