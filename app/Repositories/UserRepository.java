package Repositories;

import com.feth.play.module.pa.user.AuthUserIdentity;

import java.util.concurrent.CompletionStage;

import models.User;
import play.db.jpa.JPAApi;

public class UserRepository extends Repository<User> implements IUserRepository {

	public UserRepository(JPAApi jpaApi, DatabaseExecutionContext databaseExecutionContext) {
		super(jpaApi, databaseExecutionContext);
	}

	public User findByAuthUserIdentity(AuthUserIdentity authUser) {
		// TODO implement and probably convert to ebeans
		return null;
	}

	@Override
	public CompletionStage<User> getUserByMacAddress(String macAddress) {
		return null;
	}
}
