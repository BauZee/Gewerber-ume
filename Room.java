package rooms;

import java.util.ArrayList;
import java.util.List;
import inventory.Item;

public abstract class Room implements IRoom {
    protected String name;
    protected List<Item> item = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Item> getInventory() {
        return item;
    }

    @Override
    public void enterRoom() {
        System.out.println("Betrete Raum: " + name);
        for (Item item : this.item) {
            System.out.println(item.getName() + ": " + item.getSerialNumber());
        }
    }
}
