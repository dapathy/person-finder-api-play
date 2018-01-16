package modules;

import com.feth.play.module.pa.Resolver;
import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthProvider;

import common.AuthResolver;
import play.api.Configuration;
import play.api.Environment;
import play.api.inject.Binding;
import play.api.inject.Module;
import scala.collection.Seq;

public class OAuthModule extends Module {
	@Override
	public Seq<Binding<?>> bindings(Environment environment, Configuration configuration) {
		return seq(
				bind(Resolver.class).to(AuthResolver.class),
				bind(services.UserService.class).toSelf().eagerly(),
				bind(GoogleAuthProvider.class).toSelf().eagerly()
		);
	}
}
