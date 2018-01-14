package common;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;

import javax.inject.Inject;

import controllers.routes;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

public class PlayAuthenticator extends Security.Authenticator {

	private final PlayAuthenticate auth;

	@Inject
	public PlayAuthenticator(final PlayAuthenticate auth) {
		this.auth = auth;
	}

	@Override
	public String getUsername(final Http.Context context) {
		AuthUser user = this.auth.getUser(context.session());
		return user == null ? null : user.getId();
	}

	@Override
	public Result onUnauthorized(final Http.Context context) {
		return redirect(routes.Application.index());
	}
}
