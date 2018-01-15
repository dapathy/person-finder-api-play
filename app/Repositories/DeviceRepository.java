package Repositories;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import models.Device;
import play.db.jpa.JPAApi;

public class DeviceRepository extends Repository<Device> implements IDeviceRepository{

	public DeviceRepository(JPAApi jpaApi, DatabaseExecutionContext databaseExecutionContext) {
		super(jpaApi, databaseExecutionContext);
	}

	public void addIfNew(Device item) {
		isNewDevice(item.macAddress).thenApply((isNew) -> {
			if (isNew) {
				return add(item);
			}
			return CompletableFuture.supplyAsync(() -> item);
		});
	}

	public CompletionStage<Boolean> isNewDevice(String macAddress) {
		String query = "SELECT id FROM devices WHERE macAddress = :value1";
		return CompletableFuture.supplyAsync(() -> jpaApi.withTransaction((entityManager -> {
			 List<Device> results = entityManager.createQuery(query, Device.class)
			 	.setParameter("value1", macAddress)
			 	.getResultList();
			 return results.isEmpty();
		})), databaseExecutionContext);
	}
}
