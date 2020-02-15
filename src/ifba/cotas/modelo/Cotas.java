package ifba.cotas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cotas")
public class Cotas {

	@Id
	@Column(name="matricula")
	private int matricula;
	
	@Column(name="nm_pessoa")
	private String nm_pessoa;
	
	@Column(name="especial")
	private String especial;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNm_pessoa() {
		return nm_pessoa;
	}

	public void setNm_pessoa(String nm_pessoa) {
		this.nm_pessoa = nm_pessoa;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}

	public Cotas(int matricula, String nm_pessoa, String especial) {
		super();
		this.matricula = matricula;
		this.nm_pessoa = nm_pessoa;
		this.especial = especial;
	}

	public Cotas() {
		super();
		// TODO Auto-generated constructor stub
	}
}
