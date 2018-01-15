package controllers;

import com.feth.play.module.pa.PlayAuthenticate;

import javax.inject.Inject;

import Repositories.DeviceRepository;
import common.PlayAuthenticator;
import models.Device;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(PlayAuthenticator.class)
public class DeviceController extends Controller {

	private final PlayAuthenticate auth;
	private final DeviceRepository deviceRepository;

	@Inject
	public DeviceController(final PlayAuthenticate auth, final DeviceRepository deviceRepository) {
		this.auth = auth;
		this.deviceRepository = deviceRepository;
	}

	public Result tryCreateDevice() {
		Device device = request().body().as(Device.class);
		// TODO: add user id
		deviceRepository.addIfNew(device);
		return ok();
	}
}
