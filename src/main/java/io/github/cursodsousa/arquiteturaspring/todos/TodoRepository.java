package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CAMADA REPOSITORY
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

}
