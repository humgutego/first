 package jp.ken.shinsengumi.dao;

import jp.ken.shinsengumi.entity.Customer;

import jp.ken.shinsengumi.model.CustomerModel;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.loader.plan.exec.query.spi.QueryBuildingParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;


@Repository("CustomerDAO")
public class CustomerDAOImpl implements CustomerDAO<Customer> {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
/*	@Autowired
	  HttpSession session;*/
	

	
	//新規会員登録
	@Override
	public boolean insertCustomerData(Customer customer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(customer);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			return false;
		}finally {
			session.close();					
		}	
	}

	//ログイン
	@Override
	public Customer getByEmailAndPassword(String email,String password) {
		Session session = sessionFactory.openSession();
		//boolean userFound = false;
		System.out.println("false");
		Query query = session.createQuery("FROM Customer WHERE email=? AND password=?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		Customer csm = (Customer)query.uniqueResult();
		return csm;	
	}	
	
		//ログイン
	/*@Override
	public boolean getEmailAndPassword(String email,String password) {
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		System.out.println("false");
		Query query = session.createQuery("FROM Customer WHERE email=? AND password=?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		Customer csm = (Customer)query.uniqueResult();
		List list = query.list();
		
		if((list !=null) && (list.size()>0)) {
			userFound = true;
		}	
		System.out.println("kekka:" + userFound);
		return userFound;	
	}*/
	
	
	//マイﾍﾟｰｼﾞ表示
	@Override
	public Customer getByCustomer_no(int customer_no) {
		Session session = sessionFactory.openSession();
		//boolean userFound = false;
		System.out.println("false");
		Query query = session.createQuery("FROM Customer WHERE customer_no=?");
		query.setParameter(0, customer_no);
		Customer csm = (Customer)query.uniqueResult();
		return csm;	
	}	
	
	
	
	//マイページ会員情報変更
	@Override
	public boolean updataCustomerData01(Customer customer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(customer);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			return false;
		}finally {
			session.close();					
		}	
	}
	
	//マイページ会員情報変更
	@Override
	public boolean updataCustomerData02(Customer customer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(customer);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			return false;
		}finally {
			session.close();					
		}	
	}
	
	//マイページ会員情報削除
	public int deleteCustomerData(int customer_no) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("FROM Customer WHERE customer_no=?");
			  query.setParameter(0, customer_no);
			Customer csmd = (Customer)query.uniqueResult();
			session.delete(csmd);
			tx.commit();
			return 1;
		}catch(HibernateException e) {
			tx.rollback();
			return 0;
		}finally {
			session.close();					
		}	
	}
	
	
	
	
	
	
	
/*	public boolean getCustomerInfo
	(int customer_no,String name,String email,String address,String phone_number,String plan,String password) {
		Session session = sessionFactory.openSession();
		System.out.println("false");
		Query query = session.createQuery("FROM Customer WHERE email=? AND password=?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		//Customer csm = (Customer)query.uniqueResult();
		List list = query.list();
		return true;		
	}*/
	
	
	
	/*public Customer getCustomerInfomation
	(int customer_no,String name,String email,String address,String phone_number,String plan,String password) {
		Session session = sessionFactory.openSession();
		System.out.println("get");
		Query query = session.createQuery("FROM Customer WHERE email=? AND password=?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		Customer cstm = (Customer)query.uniqueResult();
		return cstm;	
	}
	*/
	
	
	
}
