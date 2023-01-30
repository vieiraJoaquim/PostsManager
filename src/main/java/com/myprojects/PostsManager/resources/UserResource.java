package com.myprojects.PostsManager.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.PostsManager.DTO.UserDTO;
import com.myprojects.PostsManager.domain.User;
import com.myprojects.PostsManager.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

//	@GetMapping
//	public ResponseEntity<List<User>> findAll() {
//
//		List<User> list = userService.findAll();
//		
//		//System.out.println(list);
//
//		return ResponseEntity.ok().body(list);
//
//		
////		 User maria = new User("1", "Maria Brown", "maria@gmail.com"); User alex = new
////		 User("2", "Alex Green", "alex@gmail.com");
////		 
////		 List<User> list = new ArrayList<>(); list.addAll(Arrays.asList(maria, alex));
////		 
////		 return ResponseEntity.ok().body(list);
//		 
//	}
	
	//Get users refatorado com o DTO
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		 
	}
	

}
