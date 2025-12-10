package io.github.cursodsousa.arquiteturaspring;

import io.github.cursodsousa.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;
import java.sql.Connection;

///Injeção de dependencia (LEGADO)
public class ExemploInjecaoDependencia{
    public static void main(String[] args) throws Exception {
        // ==============================
        // 1. CONFIGURANDO O DATA SOURCE
        // ==============================
        // Aqui criamos manualmente um DataSource.
        // Em frameworks modernos (como Spring), isso é configurado automaticamente.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("password");


        // Abre manualmente uma conexão com o banco de dados.
        // Em aplicações reais, conexões são gerenciadas por pools (HikariCP, etc.)
        Connection connection = dataSource.getConnection();


        // ==================================
        // 2. CRIAÇÃO MANUAL DO ENTITYMANAGER
        // ==================================
        // Aqui deveria ser criada a instância do EntityManager.
        // No entanto, está como null e o código não funcionaria na prática.
        // A intenção é apenas demonstrar que, no legado, o dev cria tudo manualmente.
        EntityManager entityManager = null;

        // =============================
        // 3. INSTÂNCIA MANUAL DO REPO
        // =============================
        // O Spring criaria esse repository automaticamente.
        // Aqui você está fazendo manualmente, sem injeção automática.
        // OBS: SimpleJpaRepository exige um EntityManager no construtor.
        // Aqui está sem, então isso não funcionaria de verdade.
        TodoRepository repository = null; // new SimpleJpaRepository<TodoEntity, Integer>();

        // ==========================================
        // 4. CRIAÇÃO MANUAL DAS OUTRAS DEPENDÊNCIAS
        // ==========================================
        // Criamos o validador passando o repository manualmente (injeção via construtor)
        TodoValidator todoValidator = new TodoValidator(repository);

        // Criamos o serviço de envio de email
        EmailSender sender = new EmailSender();

        // ================================================
        // 5. INJEÇÃO DE DEPENDÊNCIA MANUAL NO SERVIÇO
        // ================================================
        // Aquí está a injeção real acontecendo:
        // O TodoService DEPENDE de repository, validator e sender,
        // mas ele NÃO cria esses objetos. Você os fornece.
        TodoService todoService = new TodoService(repository,todoValidator, sender);
    }
}
