package Repositories;

import models.Device;

public interface IDeviceRepository extends IRepository<Device>{
	void addIfNew(Device item);
}
