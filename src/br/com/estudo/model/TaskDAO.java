package br.com.estudo.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import br.com.estudo.control.HibernateUtil;

public class TaskDAO {

	private Session session;

	public void add(TaskImp taskImp) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(taskImp);
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}

	public void alterar(TaskImp taskImp) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(taskImp);
			session.getTransaction().commit();
		} finally {
			session.close();

		}
	}

	public void excluir(TaskImp taskImp) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(taskImp);
			session.getTransaction().commit();

		} finally {
			session.close();

		}
	}

	@SuppressWarnings("unchecked")
	public List listar() {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria cri = session.createCriteria(TaskImp.class);
			return cri.list();
		} finally {
			session.close();

		}
	}

	/*
	 * public void salvarTask(TaskImp task){ Connection connect =
	 * FabricConnect.getConnect(); PreparedStatement ps; try { ps =
	 * connect.prepareStatement(
	 * "INSERT INTO `tasks` (`date_ini`,`description`, `status`, `date_end`) VALUES (?,?,?,?)"
	 * ); ps.setDate(1,new Date (task.getData_inicio().getTime()));
	 * ps.setString(2,task.getDescripition()); ps.setString(3,task.getStatus());
	 * ps.setDate(4,new Date (task.getData_fim().getTime())); ps.execute();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * FabricConnect.closeConect(); }
	 * 
	 * public List<TaskImp> find(){ Connection connect =
	 * FabricConnect.getConnect(); try { PreparedStatement ps =
	 * connect.prepareStatement("Select * from tasks"); ResultSet resultSet =
	 * ps.executeQuery(); List<TaskImp> tasks = new ArrayList<>();
	 * while(resultSet.next()){ TaskImp task = new TaskImp();
	 * task.setId(resultSet.getInt("id"));
	 * task.setData_inicio(resultSet.getDate("date_ini"));
	 * task.setDescripition(resultSet.getString("description"));
	 * task.setStatus(resultSet.getString("status"));
	 * task.setData_fim(resultSet.getDate("date_end")); tasks.add(task); }
	 * return tasks; } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } return null; }
	 */
}
