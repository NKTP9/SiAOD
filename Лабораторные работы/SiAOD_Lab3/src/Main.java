public class Main {
    public static void main(String[] args) {
        int[][] blocks = new int[][]{{1, 2, 3}, {4, 0, 5}, {7, 8, 6}};
        Board initial = new Board(blocks);
        FifteenSolver solver = new FifteenSolver(initial);
        System.out.println("Минимальное количество ходов: " + solver.moves());
        for (Board board : solver.solution())
            System.out.println(board);
    }
}
