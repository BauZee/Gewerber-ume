package rooms;

import rooms.IRoom;
import rooms.IRoomFactory;
import rooms.SanitaryFacility;
import rooms.TeaKitchen;

import java.util.Random;

public class UtilityRoomFactory implements IRoomFactory {
    @Override
    public IRoom generateRoom() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new TeaKitchen();
        } else {
            return new SanitaryFacility();
        }
    }
}
