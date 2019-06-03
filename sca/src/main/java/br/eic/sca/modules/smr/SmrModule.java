package br.eic.sca.modules.smr;

import br.eic.sca.api.ScaModule;
import br.eic.sca.core.security.Permission;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;

@DependsOn("sieModule")
@ComponentScan("br.eic.sca.modules.smr")
public class SmrModule extends ScaModule
{
	@Override
	public String getName()
	{
		return "Seminário";
	}

	@Override
	public Permission[] providePermissions()
	{
		return new Permission[]{new Permission("Eventos", "Seminário", "/smr/seminario.jsf", "ADMIN")};
	}
}
