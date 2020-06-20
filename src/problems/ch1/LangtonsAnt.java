package problems.ch1;

import java.util.HashMap;
import java.util.Objects;

public class LangtonsAnt {

    enum Color {
        BLACK, WHITE;
    }

    enum Direction {
        RIGHT, LEFT, UP, DOWN;
    }

    HashMap<Point, Color> antMap;

    public LangtonsAnt() {
        this.antMap = new HashMap<>();
    }

    void printKMoves(int k) {

        int r = 0, c = 0;
        Direction d = Direction.RIGHT;    // current face direction, initially Ant is facing right
        int minR=0, minC=0, maxR=0, maxC=0;
        while ( k > 0 ) {
            Point p = new Point(r, c);

            // get current color if co-ordinate already in map
            Color color = this.antMap.getOrDefault(p, Color.WHITE);

            if( color == Color.WHITE ) {
                // flip color
                color = Color.BLACK;
                // go right
                switch (d) {
                    case RIGHT:
                        r++;
                        d = Direction.DOWN;
                        break;
                    case LEFT:
                        r--;
                        d = Direction.UP;
                        break;
                    case DOWN:
                        c--;
                        d = Direction.LEFT;
                        break;
                    case UP:
                        c++;
                        d = Direction.RIGHT;
                        break;
                }
            } else {
                // flip color
                color = Color.WHITE;
                // go left
                switch (d) {
                    case RIGHT:
                        r--;
                        d = Direction.UP;
                        break;
                    case LEFT:
                        r++;
                        d = Direction.DOWN;
                        break;
                    case DOWN:
                        c++;
                        d = Direction.RIGHT;
                        break;
                    case UP:
                        c--;
                        d = Direction.LEFT;
                        break;
                }
            }

            // put updated color in map
            this.antMap.put(p, color);

            // keep track of minimum and maximum
            minR = Math.min(r, minR);
            minC = Math.min(c, minC);
            maxR = Math.max(r, maxR);
            maxC = Math.max(c, maxC);

            k--;
        }

        int diffR = maxR - minR + 1;
        int diffC = maxC - minC + 1;

        for (int i = 0; i < diffR; i++) {
            for (int j = 0; j < diffC; j++) {
                Point p = new Point(i+minR, j+minC);
                Color color = antMap.getOrDefault(p, null);
                if(color == null) {
                    System.out.print("_");
                } else if (color == Color.BLACK) {
                    System.out.print("1");
                } else if (color ==Color.WHITE){
                    System.out.print("0");
                }
            }

            System.out.println();
        }



    }

    class Point {
        private int r;
        private int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r &&
                    c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

}


