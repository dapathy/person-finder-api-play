package Repositories;

import models.Device;
import play.db.jpa.JPAApi;

public class DeviceRepository extends Repository<Device> implements IDeviceRepository{

	public DeviceRepository(JPAApi jpaApi, DatabaseExecutionContext databaseExecutionContext) {
		super(jpaApi, databaseExecutionContext);
	}
}
