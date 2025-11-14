package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Service;
//Camada Service
@Service
public class TodoService {

    //injeção de dependdencia do Repository, para mais injeção incluir no construtor
    private   TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public  TodoEntity salvar(TodoEntity novoTodo){
        return repository.save(novoTodo);
    }

    public  void atualizarStatus(TodoEntity todo){
        repository.save(todo);
    }

    public  TodoEntity buscarPorId(Integer id){
        return  repository.findById(id).orElse(null);
    }
}
