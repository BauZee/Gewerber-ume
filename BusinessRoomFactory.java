package rooms;

import java.util.Random;

public class BusinessRoomFactory implements IRoomFactory {
    @Override
    public IRoom generateRoom() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new Office();
        } else {
            return new Lounge();
        }
    }
}
