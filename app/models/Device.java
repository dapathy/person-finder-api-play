package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	public String macAddress;

	@ManyToOne
	@JoinColumn(name = "person_id")
	public Person person;
}
