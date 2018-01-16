package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import Repositories.DeviceRepository;
import Repositories.IDeviceRepository;
import Repositories.IUserRepository;
import common.PlayAuthenticator;
import models.Device;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(PlayAuthenticator.class)
public class DeviceController extends Controller {

	private final PlayAuthenticate auth;
	private final IDeviceRepository deviceRepository;
	private final IUserRepository userRepository;

	@Inject
	public DeviceController(final PlayAuthenticate auth, final IDeviceRepository deviceRepository, final IUserRepository userRepository) {
		this.auth = auth;
		this.deviceRepository = deviceRepository;
		this.userRepository = userRepository;
	}

	public Result tryCreateDevice() {
		Device device = request().body().as(Device.class);
		AuthUser authUser = this.auth.getUser(session());
		User user = userRepository.findByAuthUserIdentity(authUser);
		device.user = user;
		deviceRepository.addIfNew(device);
		return ok();
	}
}
