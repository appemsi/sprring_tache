package ma.isga.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.isga.tasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
