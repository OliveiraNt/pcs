package br.eic.sca.modules.smr.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Table(name = "smr_seminario")
@Entity(name = "Seminario")
public class Seminario implements Comparable<Seminario>
{
	//
	// Atributos Mapeados
	//

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String titulo;

	@Column
	private String palestrante;

	@Column
	private String local;

	@Column
	private Date data;

	@Column
	private String resumo;

	//
	// Métodos de Acesso
	//

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public String getPalestrante()
	{
		return palestrante;
	}

	public void setPalestrante(String palestrante)
	{
		this.palestrante = palestrante;
	}

	public String getLocal()
	{
		return local;
	}

	public void setLocal(String local)
	{
		this.local = local;
	}

	public Date getData()
	{
		return data;
	}

	public String getDataFormatada()
	{
		return new SimpleDateFormat("dd/MM/YYYY HH:mm").format(data);
	}

	public void setData(Date data)
	{
		this.data = data;
	}

	public String getResumo()
	{
		return resumo;
	}

	public void setResumo(String resumo)
	{
		this.resumo = resumo;
	}

	//
	// Métodos Auxiliares
	//

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Seminario seminario = (Seminario) o;
		return Objects.equals(id, seminario.id) && Objects.equals(titulo, seminario.titulo) && Objects.equals(palestrante, seminario.palestrante) && Objects.equals(local, seminario.local) && Objects.equals(data, seminario.data) && Objects.equals(resumo, seminario.resumo);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, titulo, palestrante, local, data, resumo);
	}

	@Override
	public int compareTo(Seminario o)
	{
		return id.compareTo(o.id);
	}

	@Override
	public String toString()
	{
		return "Seminario{" + "id=" + id + ", titulo='" + titulo + '\'' + ", palestrante='" + palestrante + '\'' + ", local='" + local + '\'' + ", data=" + data + ", resumo='" + resumo + '\'' + '}';
	}
}
