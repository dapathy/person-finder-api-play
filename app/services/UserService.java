package services;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.service.AbstractUserService;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;

import javax.inject.Inject;

import Repositories.IUserRepository;

public class UserService extends AbstractUserService{

	private final IUserRepository userRepository;

	@Inject
	public UserService(final PlayAuthenticate auth, final IUserRepository userRepository) {
		super(auth);
		this.userRepository = userRepository;
	}

	@Override
	public Object save(AuthUser authUser) {
		return null;
	}

	@Override
	public Object getLocalIdentity(AuthUserIdentity identity) {
		return null;
	}

	@Override
	public AuthUser merge(AuthUser newUser, AuthUser oldUser) {
		return null;
	}

	@Override
	public AuthUser link(AuthUser oldUser, AuthUser newUser) {
		return null;
	}
}
