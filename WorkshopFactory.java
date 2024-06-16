package rooms;

import java.util.Random;

public class WorkshopFactory implements IRoomFactory {
    @Override
    public IRoom generateRoom() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new MetalWorkShop();
        } else {
            return new WoodWorkShop();
        }
    }
}
