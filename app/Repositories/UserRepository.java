package Repositories;

import models.User;
import play.db.jpa.JPAApi;

public class UserRepository extends Repository<User> implements IUserRepository {

	public UserRepository(JPAApi jpaApi, DatabaseExecutionContext databaseExecutionContext) {
		super(jpaApi, databaseExecutionContext);
	}
}
