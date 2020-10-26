package jp.ken.shinsengumi.dao;

import jp.ken.shinsengumi.entity.Customer;


public interface CustomerDAO <T> {
	
	//public List<T> allList();
	
	public boolean insertCustomerData(Customer cusutomer); 
	
	public Customer getByEmailAndPassword(String email,String password);

	//public boolean getEmailAndPassword(String email,String password);
	
	public boolean updataCustomerData01(Customer customer);
	
	public boolean updataCustomerData02(Customer customer);
	
	public int deleteCustomerData(int customer_no);
	
	public Customer getByCustomer_no(int customer_no);
	
	//public boolean getCustomerInfo
	//(int customer_no,String name,String email,String address,String phone_number,String plan,String password);
	
	//public Customer getCustomerInfomation
	//(int customer_no,String name,String email,String address,String phone_number,String plan,String password);
	
}
