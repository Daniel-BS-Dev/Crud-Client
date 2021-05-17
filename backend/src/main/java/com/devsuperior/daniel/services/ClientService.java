package com.devsuperior.daniel.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.daniel.dto.ClientDTO;
import com.devsuperior.daniel.entities.Client;
import com.devsuperior.daniel.repositories.ClientRepository;
import com.devsuperior.daniel.services.excptions.DatabaseException;
import com.devsuperior.daniel.services.excptions.ResourceEntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly =true)
	public Page<ClientDTO> findAllPage(PageRequest page){
		Page<Client> list =repository.findAll(page);
		return list.map(x -> new ClientDTO(x));
		
	}
	@Transactional(readOnly =true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(()-> new ResourceEntityNotFoundException("Entity not found"));
		return new ClientDTO(entity);
		
	}
	@Transactional()
	public ClientDTO insert(ClientDTO dto) {
	 Client entity = new Client();
	 copyClientDTO(entity, dto);
	 entity = repository.save(entity);
		return new ClientDTO(entity);
		
	}
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
		Client entity = repository.getOne(id);
		copyClientDTO(entity, dto);
		entity= repository.save(entity);
		return new ClientDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceEntityNotFoundException(" id not Found "+id);
		}
		
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceEntityNotFoundException("id not foud "+id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	private void copyClientDTO(Client entity, ClientDTO dto) {
	  entity.setName(dto.getName());
	  entity.setCpf(dto.getCpf());
      entity.setBirthDate(dto.getBirthDate());
	  entity.setIncome(dto.getIncome());
	  entity.setChildren(dto.getChildren());
		
	}
}
