package it.engineering.springboot.application.customer.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer_license")
public class ManufacturerLicence {
	
	@Id
	private Long id;
	
	@Column(name= "accepted_date")
	private LocalDate accepted_date;
	
	@ManyToOne
	@JoinColumn(name="manufacturer_id")
	private ManufacturerEntity manufacturer;
	
	@ManyToOne
	@JoinColumn(name="licence_id")
	private LicenseEntity license;

}
