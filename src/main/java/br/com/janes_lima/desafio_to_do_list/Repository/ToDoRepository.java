package br.com.janes_lima.desafio_to_do_list.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.janes_lima.desafio_to_do_list.Model.To_Do;

@Repository
public interface ToDoRepository extends JpaRepository<To_Do, Long>{
    
}
