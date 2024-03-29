package br.eic.sca.modules.smr.control;

import br.eic.sca.api.control._Bean;
import br.eic.sca.modules.smr.domain.Seminario;
import br.eic.sca.modules.smr.service.SeminarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
public class SeminarioBean extends _Bean
{
	//
	// Dependências
	//
	@Autowired
	SeminarioService seminarioService;

	//
	// Dados da Página
	//
	private List<Seminario> seminarios = new ArrayList<>();
	private Seminario seminarioEditable = new Seminario();

	//
	// Inicialização dos Dados (Roda na construção do bean e no recarregamento da página)
	//

	@PostConstruct
	public void refresh()
	{
		seminarios = seminarioService.retrieveAll();
	}

	//
	// Operações da Página
	//

	public void create()
	{
		// Cria uma instância limpa para edição
		this.seminarioEditable = new Seminario();

		// Apresenta o diálogo
		showDialog("seminarioEditDialog");
	}

	public void show(Seminario seminario)
	{
		// Guarda a instância que será exibida
		this.seminarioEditable = seminario;

		// Apresenta o diálogo
		showDialog("seminarioDetailsDialog");
	}
	public void update(Seminario seminarioEditable)
	{
		// Guarda a instância que será editada
		this.seminarioEditable = seminarioEditable;

		// Apresenta o diálogo
		showDialog("seminarioEditDialog");
	}

	public void delete(Seminario seminario)
	{
		try
		{
			seminarioService.delete(seminario);
			refresh();
		}
		catch (Exception e)
		{
			handleError(e);
		}
	}

	public void persist()
	{
		try
		{
			// Periste o objeto
			seminarioService.persist(seminarioEditable);

			// Atualizações de interface
			hideDialog("seminarioEditDialog");
			popInfo("Registro Atualizado com Sucesso");
			refresh();
		}
		catch (Exception e)
		{
			handleError(e);
		}
	}


	//
	// Métodos de Acesso
	//

	public List<Seminario> getSeminarios()
	{
		return seminarios;
	}

	public void setSeminarios(List<Seminario> seminarios)
	{
		this.seminarios = seminarios;
	}

	public Seminario getSeminarioEditable()
	{
		return seminarioEditable;
	}

	public void setSeminarioEditable(Seminario seminarioEditable)
	{
		this.seminarioEditable = seminarioEditable;
	}
}
