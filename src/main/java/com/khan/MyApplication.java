package com.khan;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khan.Entity.Certificate;
import com.khan.Entity.Employee;


public class MyApplication {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction txn = session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setName("Shujat");
		List<Employee> empList1=new ArrayList<Employee>();
		empList1.add(emp);
		
		
		Employee emp1=new Employee();
		emp1.setName("ravi");
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(emp1);
		
		Certificate certificate=new Certificate();
		certificate.setCertiName("Java J2EE");
		certificate.setDuration("6 Months");
		certificate.setEmployee(empList1);
		List<Certificate> CertificateList=new ArrayList<Certificate>();
		CertificateList.add(certificate);
		
		Certificate certificate1=new Certificate();
		certificate1.setCertiName("Android Programing");
		certificate1.setDuration("4 Months");
		certificate1.setEmployee(empList1);
		
		
		
		List<Certificate> CertificateList1=new ArrayList<Certificate>();
		CertificateList1.add(certificate1);
		
		emp.setCertificate(CertificateList1);
		emp.setCertificate(CertificateList);
		
		emp1.setCertificate(CertificateList1);
		emp1.setCertificate(CertificateList);
		
		session.save(emp);
		session.save(emp1);
		session.save(certificate);
		session.save(certificate1);
		txn.commit();
		session.close();
		factory.close();
		
		System.out.println("Data save successfully");
	}

}
