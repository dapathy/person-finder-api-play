package controllers;

import com.feth.play.module.pa.PlayAuthenticate;

import javax.inject.Inject;

import common.PlayAuthenticator;
import play.mvc.Controller;
import play.mvc.Security;

@Security.Authenticated(PlayAuthenticator.class)
public class DeviceController extends Controller {

	private final PlayAuthenticate auth;

	@Inject
	public DeviceController(final PlayAuthenticate auth) {
		this.auth = auth;
	}
}
