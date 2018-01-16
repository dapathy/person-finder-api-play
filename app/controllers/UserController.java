package controllers;

import com.feth.play.module.pa.PlayAuthenticate;

import java.util.concurrent.CompletionStage;

import Repositories.IUserRepository;
import common.PlayAuthenticator;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(PlayAuthenticator.class)
public class UserController extends Controller {

	private final PlayAuthenticate auth;
	private final IUserRepository userRepository;

	public UserController(final PlayAuthenticate auth, IUserRepository userRepository) {
		this.auth = auth;
		this.userRepository = userRepository;
	}

	public CompletionStage<User> getUserByMacAddress(final String macAddress) {
		return this.userRepository.getUserByMacAddress(macAddress);
	}
}
