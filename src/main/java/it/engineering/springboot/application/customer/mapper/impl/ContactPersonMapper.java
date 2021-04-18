package it.engineering.springboot.application.customer.mapper.impl;


import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.entity.ContactPersonEntity;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;

public class ContactPersonMapper implements EntityDtoMapper<ContactPersonDto, ContactPersonEntity> {

	@Override
	public ContactPersonDto toDto(ContactPersonEntity entity) {
		return new ContactPersonDto(entity.getId(),entity.getFirstname(), entity.getLastname());
	}

	@Override
	public ContactPersonEntity toEntity(ContactPersonDto dto) {
		return new ContactPersonEntity(dto.getId(),
				dto.getFirstname(),
				dto.getLastname(), null);
	}

}
