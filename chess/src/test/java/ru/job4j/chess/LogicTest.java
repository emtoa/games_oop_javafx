package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    public Logic firstStep(){
        Logic logic = new Logic();
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new PawnBlack(Cell.B7));
        logic.add(new PawnBlack(Cell.C7));
        logic.add(new PawnBlack(Cell.D7));
        logic.add(new PawnBlack(Cell.E7));
        logic.add(new PawnBlack(Cell.F7));
        logic.add(new PawnBlack(Cell.G7));
        logic.add(new PawnBlack(Cell.H7));
        logic.add(new RookBlack(Cell.A8));
        logic.add(new KnightBlack(Cell.B8));
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new QueenBlack(Cell.D8));
        logic.add(new KingBlack(Cell.E8));
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new KnightBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));

        logic.add(new PawnWhite(Cell.A2));
        logic.add(new PawnWhite(Cell.B2));
        logic.add(new PawnWhite(Cell.C2));
        logic.add(new PawnWhite(Cell.D2));
        logic.add(new PawnWhite(Cell.E2));
        logic.add(new PawnWhite(Cell.F2));
        logic.add(new PawnWhite(Cell.G2));
        logic.add(new PawnWhite(Cell.H2));
        logic.add(new RookWhite(Cell.A1));
        logic.add(new KnightWhite(Cell.B1));
        logic.add(new BishopWhite(Cell.C1));
        logic.add(new QueenWhite(Cell.D1));
        logic.add(new KingWhite(Cell.E1));
        logic.add(new BishopWhite(Cell.F1));
        logic.add(new KnightWhite(Cell.G1));
        logic.add(new RookWhite(Cell.H1));
        return logic;
    }

    @Test
    public void movePositiveResult() {

        Logic logic = firstStep();
        boolean rsl = logic.move(Cell.E7, Cell.E6);
        boolean rsl1 = logic.move(Cell.F8, Cell.A3);
        assertThat(rsl, is(true));
        assertThat(rsl1, is(true));
    }

    @Test
    public void movePositiveResult1() {

        Logic logic = firstStep();
        boolean rsl = logic.move(Cell.E7, Cell.E6);
        boolean rsl1 = logic.move(Cell.F8, Cell.B4);
        boolean rsl2 = logic.move(Cell.B4, Cell.A5);
        assertThat(rsl, is(true));
        assertThat(rsl1, is(true));
        assertThat(rsl2, is(true));
    }

    @Test
    public void moveNegativeResult() {

        Logic logic = firstStep();
        boolean rsl1 = logic.move(Cell.F8, Cell.A3);
        assertThat(rsl1, is(false));
    }

    @Test
    public void moveNegativeResult1() {

        Logic logic = firstStep();
        boolean rsl1 = logic.move(Cell.F8, Cell.E7);
        assertThat(rsl1, is(false));
    }
}