package Java.Academy.TicTacToeOnline;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicContext {

    @Bean
    TicTacToe ticTacToe(){return new TicTacToe();}
}
