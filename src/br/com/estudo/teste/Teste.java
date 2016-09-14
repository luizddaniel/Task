package br.com.estudo.teste;

import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import br.com.estudo.control.HibernateUtil;
import br.com.estudo.control.TaskBean;
import br.com.estudo.model.TaskImp;

public class Teste {

	private static ActionEvent actionEvent;
	
	public static void main(String[] args) {
		
		Session session =  HibernateUtil.getSessionFactory().openSession();
	
       
		
		TaskImp  taskImp = new TaskImp();
		TaskBean taskBean = new TaskBean();
		
		//taskImp.setDescripition("Teste de Descripition 2");
		//taskImp.setStatus("Pending");
 
		taskBean.insert(actionEvent);
		
		//realizando operação para salvar no banco
		session.beginTransaction();
		
		
		
		//session.save(taskImp);
		session.getTransaction().commit();
		session.close();
	}

}
