package taher.io.service;

/*import java.util.ArrayList;
import java.util.Arrays;*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taher.io.entity.Topic;
import taher.io.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired
	TopicRepository topicRepository;
	
	/*
	 * private List<Topic> topics = new ArrayList<Topic>( Arrays.asList(
	 * 
	 * new Topic("Exception", "Java Exception Handling", "It handles exception"),
	 * new Topic("DependencyInjection", "Spring dependency injection",
	 * "Injecting the dependency dynamically"), new Topic("JavaScript",
	 * "Javascript Tutorial", "JS in details") ));
	 */
	
	public List<Topic> getTopics() {
		
		List<Topic> topics = topicRepository.findAll();
		//topicRepository.findAll()
		//.forEach(t -> topics.add(t));
		//.forEach(topics::add);
		
		return topics;
		
	}
	
	public Topic getTopic(String topicId) {
		
		//return topics.stream().filter(topic-> topic.getId().equals(topicId) ).findFirst().get();
		
		return topicRepository.findById(topicId).get();
	}
	
	public void addTopic(Topic topic) {
		
		topicRepository.save(topic);
	}


}
