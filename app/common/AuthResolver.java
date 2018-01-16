package common;

import com.feth.play.module.pa.Resolver;

import play.mvc.Call;

public class AuthResolver extends Resolver{
	@Override
	public Call login() {
		return null;
	}

	@Override
	public Call afterAuth() {
		return null;
	}

	@Override
	public Call auth(final String provider) {
		// You can provide your own authentication implementation,
		// however the default should be sufficient for most cases
		return com.feth.play.module.pa.controllers.Authenticate.authenticate(provider);
	}

	@Override
	public Call askMerge() {
		return null;
	}

	@Override
	public Call askLink() {
		return null;
	}

	@Override
	public Call afterLogout() {
		return null;
	}
}
