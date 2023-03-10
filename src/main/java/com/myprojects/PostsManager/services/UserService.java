package com.myprojects.PostsManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.PostsManager.DTO.UserDTO;
import com.myprojects.PostsManager.domain.User;
import com.myprojects.PostsManager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	//Aqui vai entrar o método findOne
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		userRepository.deleteById(id);
	}
	
//	public User update(User obj) {
//		User newObj = userRepository.findOne(obj.getId());
//		updateData(newObj, obj);
//		return userRepository.save(newObj);
//	}
//	
//	private void updateDataoO(User newObj, User obj) {
//		// TODO Auto-generated method stub
//		newObj.setEmail(obj.getEmail());
//		newObj.setName(obj.getName());
//	}

	//Implementando fromDTO na inserção de dados.
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
