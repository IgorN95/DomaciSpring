package it.engineering.springboot.application.customer.dto;

import java.util.ArrayList;
import java.util.List;

import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.dto.CityDto;

public class ManufacturerDto implements MyDto {
	private Long id;
	private String name;
	private CityDto city;
	private List<ContactPersonDto> contactPersons;
	
	public ManufacturerDto() {
		city = new CityDto();
		contactPersons = new ArrayList<ContactPersonDto>();
	}

	public ManufacturerDto(Long id, String name, CityDto city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		contactPersons = new ArrayList<ContactPersonDto>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

	public CityDto getCityDto() {
		return city;
	}

	public void setCityDto(CityDto cityDto) {
		this.city = cityDto;
	}
	
	@Override
	public String toString() {
		return "ManufacturerDto [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManufacturerDto other = (ManufacturerDto) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public List<ContactPersonDto> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPersonDto> contactPersons) {
		this.contactPersons = contactPersons;
	}
	
}
