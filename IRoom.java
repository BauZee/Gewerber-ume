package rooms;

import java.util.List;
import inventory.Item;

public interface IRoom {
    String getName();
    List<Item> getInventory();
    void enterRoom();
}
