package ru.job4j.chess.firuges.black;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class BishopBlackTest {

    @Test
    public void wayBlackPositiveResult() {

        BishopBlack bb = new BishopBlack(Cell.F8);

        Cell[] result = bb.way(Cell.F8, Cell.A3);

        assertThat(result[4].getX(), is(0));
        assertThat(result[4].getY(), is(2));
    }

}
