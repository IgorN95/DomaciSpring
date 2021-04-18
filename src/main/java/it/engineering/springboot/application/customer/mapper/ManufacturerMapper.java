package it.engineering.springboot.application.customer.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.entity.ContactPersonEntity;
import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.entity.ManufacturerEntity;
import it.engineering.springboot.application.customer.mapper.impl.CityMapper;
import it.engineering.springboot.application.customer.mapper.impl.ContactPersonMapper;

@Component
public class ManufacturerMapper implements EntityDtoMapper<ManufacturerDto, ManufacturerEntity> {
	private CityMapper cityMapper;
	private ContactPersonMapper contactPersonMapper;

	@Autowired
	public ManufacturerMapper(CityMapper cityMapper, ContactPersonMapper contactPersonMapper) {
		this.cityMapper = cityMapper;
		this.contactPersonMapper = contactPersonMapper;
	}

	@Override
	public ManufacturerDto toDto(ManufacturerEntity e) {
		ManufacturerDto manufacturerDto = new ManufacturerDto(e.getId(), e.getName(), cityMapper.toDto(e.getCity()));

		List<ContactPersonEntity> contactPersons = e.getContactPersons();

		List<ContactPersonDto> contactPersonsDto = contactPersons.stream().map(entity -> {
			ContactPersonDto contactPersonDto = contactPersonMapper.toDto(entity);
			return contactPersonDto;
		}).collect(Collectors.toList());

		manufacturerDto.setContactPersons(contactPersonsDto);
		return manufacturerDto;
	}

	@Override
	public ManufacturerEntity toEntity(ManufacturerDto dto) {
		ManufacturerEntity manufacturerEntity = new ManufacturerEntity(dto.getId(), dto.getName(),
				cityMapper.toEntity(dto.getCityDto()));

		List<ContactPersonDto> dtos = dto.getContactPersons();
		List<ContactPersonEntity> contactPersonEntities = dtos.stream().map((personDto) -> {
			ContactPersonEntity contactPersonEntity = contactPersonMapper.toEntity(personDto);
			contactPersonEntity.setManufacturer(manufacturerEntity);
			return contactPersonEntity;
		}).collect(Collectors.toList());

		manufacturerEntity.setContactPersons(contactPersonEntities);

		return manufacturerEntity;
	}

}
