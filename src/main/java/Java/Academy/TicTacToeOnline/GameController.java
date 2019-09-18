package Java.Academy.TicTacToeOnline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    static TicTacToe ticTacToe = new TicTacToe();

    @RequestMapping(value = "/play")
    public TicTacToe getGame() {
        return   ticTacToe;
    }

    @RequestMapping(value = "/turn")
    public String turn(int x,int y) {
        ticTacToe.turn(x,y);
        return ticTacToe.toString() + ticTacToe.winner();
    }
}
