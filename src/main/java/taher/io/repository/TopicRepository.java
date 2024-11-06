package taher.io.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import taher.io.entity.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String>{

	public List<Topic> findAll();
}
