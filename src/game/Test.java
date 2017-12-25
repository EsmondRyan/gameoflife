package game;

//import java.util.Random;
import game.Cell;

public class Test {

	@org.junit.Before
	public void init() {
		/*Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (cells[i][j] == null)
					cells[i][j] = new Cell(i, j);
				if (probability >= rand.nextInt(100)) {
					cells[i][j].setStatus(Cell.LifeStatus.SURVIVAL);
				} else {
					cells[i][j].setStatus(Cell.LifeStatus.DEATH);
				}
			}
		}*/
	}

	@org.junit.Test
	public void test() {
		Game game = new Game(10, 10, 2000);
		game.randomInit(50);
		game.setCellListener((cells, run) -> {
			for (int i = 0; i < game.getWidth(); ++i) {
				for (int j = 0; j < game.getHeight(); ++j) {
					System.out.print(cells[i][j].getStatus() == Cell.LifeStatus.SURVIVAL ? "s" : " ");
				}
				System.out.println();
			}
			System.out.println("----------");
		});
		new Thread(game).start();
	}

	@org.junit.Test
	public void test2() {
		int width = 5;
		int height = 5;
		Cell[][] cells = new Cell[width][height];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				cells[i][j].setStatus(Cell.LifeStatus.SURVIVAL);
		}

		int x = 1, y = 1;

		int sum = 0;
		for (int i = x - 1; i <= x + 1; ++i) {
			for (int j = y - 1; j <= y + 1; ++j) {
				if (i >= 0 && i < width && j >= 0 && j < height && !(i == x && j == y)
						&& cells[i][j].getStatus() == Cell.LifeStatus.SURVIVAL) {
					++sum;
				}
			}
		}
		System.out.println(sum);
	}

}
