package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = (source.getX() - dest.getX()) < 0 ? (source.getX() - dest.getX())*-1: (source.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() -  source.getX()) / size;
        int deltaY = (dest.getY() -  source.getY()) / size;
        for (int index = 0; index < size; index++) {
            int x = source.getX() + ((index+1) * deltaX);
            int y = (source.getY() + ((index+1) * deltaY));
            steps[index] = Cell.findBy(x,y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x = source.getX() - dest.getX();
        int y = source.getY() - dest.getY();

        x = x < 0 ? x * -1: x;
        y = y < 0 ? y * -1: y;

        return x == y ? true : false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
