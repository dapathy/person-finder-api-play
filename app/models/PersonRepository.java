package models;

import common.Repository;
import play.db.jpa.JPAApi;

public class PersonRepository extends Repository<Person> implements IPersonRepository{

	public PersonRepository(JPAApi jpaApi, DatabaseExecutionContext databaseExecutionContext) {
		super(jpaApi, databaseExecutionContext);
	}
}
