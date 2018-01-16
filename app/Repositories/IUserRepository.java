package Repositories;

import com.feth.play.module.pa.user.AuthUserIdentity;

import java.util.concurrent.CompletionStage;

import models.User;

public interface IUserRepository extends IRepository<User>{
	CompletionStage<User> getUserByMacAddress(String macAddress);
	User findByAuthUserIdentity(AuthUserIdentity authUser);
}