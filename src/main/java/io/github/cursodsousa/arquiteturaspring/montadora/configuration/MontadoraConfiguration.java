package io.github.cursodsousa.arquiteturaspring.montadora.configuration;

import io.github.cursodsousa.arquiteturaspring.montadora.Motor;
import io.github.cursodsousa.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration  //annotation responsavel por fazer reconhecer como
public class MontadoraConfiguration {

    //beans são componentes que podem ser utilizados na aplicação, pode ser usados vareas vezes - o bean é um metodo que cria um objeto e retorna ele.
   @Primary
    @Bean(name ="motorAspirado")
    public Motor motoraAspirado(){
        var motor = new Motor();
        motor.setCavalos(1200);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name ="motorEletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("th-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }
        @Bean(name ="motorTurbo")
        public Motor motorTurbo() {
            var motor = new Motor();
            motor.setCavalos(180);
            motor.setCilindros(4);
            motor.setModelo("xpz-0");
            motor.setLitragem(2.0);
            motor.setTipo(TipoMotor.TURBO);
            return motor;
        }
    }

