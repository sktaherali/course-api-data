package taher.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taher.io.entity.Topic;
import taher.io.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hii";
	}
	
	@Autowired
	private TopicService topicsService;
	
	@GetMapping("/getAlltopics")
	public List<Topic> getAllTopics() {
		
		return topicsService.getTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicsService.getTopic(id);
		
	}
	
	@PostMapping("/addTopic")
	public void addTopic(@RequestBody Topic topic) {
		topicsService.addTopic(topic);
	}
	
	public void updateTopic(@RequestBody Topic topic) {
		topicsService.addTopic(topic);
	}
}
