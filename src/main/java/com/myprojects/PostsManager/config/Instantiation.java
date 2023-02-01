package com.myprojects.PostsManager.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myprojects.PostsManager.domain.Post;
import com.myprojects.PostsManager.domain.User;
import com.myprojects.PostsManager.repositories.PostRepository;
import com.myprojects.PostsManager.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		//Tratar as data no post
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//Limpa a coleção no banco
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("01/02/2023"), "Partiu viagem", "Vou para SP, abraço", maria );
		Post post2 = new Post(null, sdf.parse("02/02/2023"), "Buenos dias", "Acordei feliz hoje", maria );

		
		//Salvar os usuários no banco
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
} 
