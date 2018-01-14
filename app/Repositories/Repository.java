package Repositories;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import javax.persistence.EntityManager;

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
		return performJpaOperation((entityManager -> {
			entityManager.persist(item);
			return item;
		}));
	}

	@Override
	public CompletionStage<T> update(T item) {
		return performJpaOperation((entityManager -> {
			entityManager.merge(item);
			return item;
		}));
	}

	@Override
	public CompletionStage<T> delete(T item) {
		return performJpaOperation((entityManager -> {
			entityManager.remove(item);
			return item;
		}));
	}

	protected CompletionStage<T> performJpaOperation(Function<EntityManager, T> operation) {
		return CompletableFuture.supplyAsync(() -> jpaApi.withTransaction(operation), databaseExecutionContext);
	}
}
