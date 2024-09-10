package lastpencil;

import java.util.Random;

public class Bot extends Player {
    public Bot(String name) {
        super(name);
    }

    @Override
    public int getRemoveCount(String actualPencils) {
        if (actualPencils.length() % 4 == 0) {
            return 3;
        } else if (actualPencils.length() % 2 == 0) {
            return 1;
        } else if (actualPencils.length() % 4 == 1) {
            Random random = new Random();
            return random.nextInt(Math.min(4, actualPencils.length())) + 1;
        } else {
            return 2;
        }
    }
}
