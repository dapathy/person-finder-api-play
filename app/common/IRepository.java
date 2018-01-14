package common;

import java.util.concurrent.CompletionStage;

public interface IRepository<T> {
	CompletionStage<T> add(T item);

	CompletionStage<T> update(T item);

	CompletionStage<T> delete(T item);
}
