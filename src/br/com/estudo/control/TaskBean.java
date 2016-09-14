package br.com.estudo.control;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import br.com.estudo.model.TaskDAO;
import br.com.estudo.model.TaskImp;


@ViewScoped
@ManagedBean
public class TaskBean {

	private TaskImp taskImp = new TaskImp();
	private List<TaskImp> tasks = new ArrayList<>();
	
	
	// construtor
	public TaskBean() {
		tasks = new TaskDAO().listar();
		taskImp = new TaskImp();
	}

	// Metodos dos Bot�es
	public void insert(ActionEvent actionEvent) {
		new TaskDAO().add(taskImp);
		tasks = new TaskDAO().listar();
		taskImp = new TaskImp();

	}

	public void update(ActionEvent actionEvent) {
		new TaskDAO().alterar(taskImp);
		tasks = new TaskDAO().listar();
		taskImp = new TaskImp();

	}

	public void delete(ActionEvent actionEvent) {
		new TaskDAO().excluir(taskImp);
		tasks = new TaskDAO().listar();
		taskImp = new TaskImp();

	}

	/*
	 * public void adicionar(){ tasks.add(task); taskDAO.salvarTask(task); task
	 * = new TaskImp();
	 * 
	 * System.out.println("Executado Adicionar"); }
	 * 
	 * public void listar(){ tasks = taskDAO.find();
	 * 
	 * System.out.println("Executado Listar"); }
	 */
	public TaskImp getTask() {
		return taskImp;
	}

	public void setTask(TaskImp task) {
		this.taskImp = task;
	}

	public List<TaskImp> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskImp> tasks) {
		this.tasks = tasks;
	}

}
