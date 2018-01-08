package common;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import models.DatabaseExecutionContext;
import play.db.jpa.JPAApi;

public class Repository<T> implements IRepository<T> {

	private final JPAApi jpaApi;
	private final DatabaseExecutionContext databaseExecutionContext;

	public Repository(JPAApi jpaApi, DatabaseExecutionContext databaseExecutionContext) {
		this.jpaApi = jpaApi;
		this.databaseExecutionContext = databaseExecutionContext;
	}

	@Override
	public CompletionStage<T> add(T item) {
		return CompletableFuture.supplyAsync(() -> jpaApi.withTransaction(entityManager -> {
			entityManager.persist(item);
			return item;
		}), databaseExecutionContext);
	}

	@Override
	public CompletionStage<T> update(T item) {
		return CompletableFuture.supplyAsync(() -> jpaApi.withTransaction(entityManager -> {
			entityManager.merge(item);
			return item;
		}), databaseExecutionContext);
	}
}
