package Player;

import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    @Test
    public void lose_when_dice_number_is_too_low() {
        //Se crea un mock de la clase dice para simular el dado
        Dice dice= Mockito.mock(Dice.class);

        //Cuando se ejecute el método roll, devolverá el 2
        Mockito.when(dice.roll()).thenReturn(2);

        Player player= new Player(dice, 5);
        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_too_big() {
        //Se crea un mock de la clase dice para simular el dado
        Dice dice= Mockito.mock(Dice.class);

        //Cuando se ejecute el método roll, devolverá el 2
        Mockito.when(dice.roll()).thenReturn(4);

        Player player= new Player(dice, 3);
        assertTrue(player.play());
    }
}