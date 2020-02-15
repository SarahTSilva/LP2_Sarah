package ifba.cotas.modelo;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;


public class CotasDAO {	
	
	public void cadastrar(Cotas c1) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(c1);
		s.getTransaction().commit();
		s.close();
	}
	
	/**
	 * Método para excluir um estado 
	 * @param est - Um objeto do tipo Estado
	 */
	public void excluir(Cotas cid) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.delete(cid);
		s.getTransaction().commit();
		s.close();
	}

	public void excluir(int idCotas) {
		Cotas c = consultar(idCotas);
		if( c != null )
			excluir(c);
	}
	
	public void alterar(Cotas cid) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.update(cid);
		s.getTransaction().commit();
		s.close();
	}
	
	public Cotas consultar(int idCotas) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from Cotas where cd_Cotas = :idCotas");
		query.addEntity(Cotas.class);
		query.setParameter("idCotas", idCotas);
		Cotas c = (Cotas) query.uniqueResult();
		s.close();
		return c;
	}
	
	public List<Cotas> consultarByEstado(String idEstado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from Cotas where sigla_estado = :idEstado");
		query.addEntity(Cotas.class);
		query.setParameter("idEstado", idEstado);
		List<Cotas> list = query.list();
		s.close();
		return list;
	}

	public List<Cotas> consultar() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from Cotas");
		query.addEntity(Cotas.class);
		List<Cotas> lista = query.list();
		s.close();
		return lista;
	}
	
	public int getNumeroCotassCadastradas() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select count(*) from Cotas");
		int qtd = (int) query.uniqueResult();
		s.close();
		return qtd;
	}
}
