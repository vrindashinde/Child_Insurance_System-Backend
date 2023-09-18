package com.capstone.child.insurance.system.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.ParentRepository;
import com.capstone.child.insurance.system.entity.Parent;
import com.capstone.child.insurance.system.exceptions.ParentException;


@Service
public class ParentServiceImpl implements ParentService{
	@Autowired
	ParentRepository parentRepository;

	@Override
	public Parent addParent(Parent newParent) throws ParentException {
		
		return this.parentRepository.save(newParent);
		
	}

	@Override	
	public Parent getParentById(Integer id) throws ParentException {

		Optional<Parent> parentOpt = this.parentRepository.findById(id);
		if (!parentOpt.isPresent())
			throw new ParentException("Parent not found for id:" + id);
		Parent parent = parentOpt.get();
		if(parent.getAccountActive()!=true) {
		throw new ParentException("User Account is not active");}
		
		
		return parentOpt.get();
	}

	@Override
	public Parent updateParent(Parent newParent) throws ParentException {
		Optional<Parent> parentOpt = this.parentRepository.findById(newParent.getParentId());
		if(!parentOpt.isPresent())
			throw new ParentException("Parent does not exist");
		return this.parentRepository.save(newParent);
	}

	
	@Override
	public Collection<Parent> getAllParents() {
		
		return this.parentRepository.findAll();
	}

	
	@Override
	public boolean updateParentStatus(Integer parentId, boolean active) throws ParentException {
		Optional<Parent> parentOpt = parentRepository.findById(parentId);
		
		if(!parentOpt.isPresent())
		{
			throw  new ParentException("Parent with ID " + parentId + "not found.");
		}
		
		Parent parent = parentOpt.get();
		parent.setAccountActive(active);
		parentRepository.save(parent);
		return active;
	}

	
	@Override
	public void save(Parent parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parent login(Parent parent) throws ParentException {
		Optional<Parent> findParent = Optional.ofNullable(this.parentRepository.findByEmail(parent.getEmail()));
		if(!findParent.isPresent()) {
			throw new ParentException("User Not Found");
		}
		
		if(findParent.get().getPassword().equals(parent.getPassword())) {
			return findParent.get();

		}
		else {
			throw new ParentException("Incorrect Password");
		}
		
	}
	

}
