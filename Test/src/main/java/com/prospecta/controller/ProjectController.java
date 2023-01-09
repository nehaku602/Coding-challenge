package com.prospecta.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.model.Entry;
import com.prospecta.model.Project;
import com.prospecta.model.ProjectDescription;
import com.prospecta.respository.ProjectDao;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProjectDao projectDao;
	
	@GetMapping("/{category}")
	public List<Entry> findByCategory(@PathVariable("category") String category){
		
		String url = "https://api.publicapis.org/entries";
		
		ResponseEntity<ProjectDescription> desc = restTemplate.getForEntity(url, ProjectDescription.class);
		
		if(desc.getStatusCodeValue()==200) {
			
			ProjectDescription data = desc.getBody();
			
			return data.getEntries().stream().filter((e)->e.getCategory().equals(category)).collect(Collectors.toList());
			
		}
		
		return null;
	}
	
	@PostMapping("/category")
    public String saveByCategory(@PathVariable("category") String category){
		
		String url ="https://api.publicapis.org/entries";
		
		ResponseEntity<ProjectDescription> desc = restTemplate.getForEntity(url, ProjectDescription.class);
		
		if(desc.getStatusCodeValue()==200) {
			
			ProjectDescription data = desc.getBody();

			List<Entry> list =  data.getEntries().stream().filter((e)->e.getCategory().equals(category)).collect(Collectors.toList());

			for(Entry item:list) {
				Project newProject = new Project(item.getApi(), item.getDescription(), item.getAuth(), item.isHttps(), item.getCors(), item.getLink(), item.getCategory());
			    projectDao.save(newProject);
			}
			
			return "Saved";
		}
		
		return "Not Saved";
		
	}
	
}
