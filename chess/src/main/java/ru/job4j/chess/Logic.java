package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        boolean employed = false;

        try {
            int index = this.findBy(source);
            if (index != -1) {
                Cell[] steps = this.figures[index].way(source, dest);

                employed = isEmployed(steps);

                if (!employed && steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rst;
    }

    public boolean isEmployed(Cell[] cell){
        boolean ismployed = false;
        for (int i = 0; i < cell.length; i++){
            if (this.findBy(cell[i]) != -1){
                    ismployed = true;
                    break;
             }
        }
    return ismployed;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures)
                + '}';
    }
}