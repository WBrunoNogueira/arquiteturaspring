package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Service;
//Camada Service
@Service
public class TodoService {

    //injeção de dependdencia do Repository, para mais injeção incluir no construtor
    private   TodoRepository repository;
    private  TodoValidator validator;
    private EmailSender mailSender;


    public TodoService(TodoRepository repository, TodoValidator validator , EmailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
        this.validator = validator;
    }

    public  TodoEntity salvar(TodoEntity novoTodo){
        validator.validar((novoTodo));
        return repository.save(novoTodo);
    }

    public  void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status  = todo.getConcluido() == Boolean.TRUE ? "concluido" : "Não concluido";
        mailSender.encviar("Todo " + todo.getDescricao() + "foi " + status );
    }

    public  TodoEntity buscarPorId(Integer id){
        return  repository.findById(id).orElse(null);
    }
}
