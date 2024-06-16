package main;

import rooms.*;
import inventory.*;
import java.util.Random;

public class Gewerberäume {
    public Gewerberäume() {
        Room[][] floorPlan = createFloorPlan();
        Room[][] filledPlan = fillFloorPlan(floorPlan);
        printFloorPlan(filledPlan);
        printRoomDetails(filledPlan);
    }

    /**
     * Die Methode createFloorPlan() erstellt den Grundriss für eine Gewerbeeinheit mit den Maßen 3x3.
     *
     * @return Ein 2D-Array (floorPlan) mit Raumobjekten, das den Grundriss darstellt.
     */
    private Room[][] createFloorPlan() {
        Room[][] floorPlan = new Room[3][3];
        floorPlan[1][1] = new Staircase();
        return floorPlan;
    }

    private Room[][] fillFloorPlan(Room[][] floorPlan) {
        IRoomFactory[] factories = {
                new BusinessRoomFactory(),
                new UtilityRoomFactory(),
                new WorkshopFactory()
        };
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (floorPlan[i][j] == null) {
                    IRoomFactory factory = factories[rand.nextInt(factories.length)];
                    floorPlan[i][j] = (Room) factory.generateRoom();
                    addRandomInventory(floorPlan[i][j]);
                }
            }
        }
        return floorPlan;
    }

    private void printFloorPlan(Room[][] floorPlan) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Room room = floorPlan[i][j];
                System.out.print("[");
                if (room != null) {
                    System.out.print(roomTileRepresentation(room));
                } else {
                    System.out.print("       "); // Platzhalter für leere Räume
                }
                System.out.print("]\t");
            }
            System.out.println();
        }
    }

    private void printRoomDetails(Room[][] floorPlan) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Room room = floorPlan[i][j];
                System.out.println("Betritt Raum: " + room.getName());
                if (!(room instanceof Staircase)) {
                    System.out.println("Inventar:");
                    for (Item item : room.getInventory()) {
                        System.out.println("- " + item.getName() + " (" + item.getSerialNumber() + ")");
                    }
                } else {
                    System.out.println("Das Treppenhaus ist betretbar, enthält aber kein Inventar.");
                }
                System.out.println();
            }
        }
    }

    private String roomTileRepresentation(Room room) {
        if (room instanceof BusinessRoom) {
            return "Business";
        } else if (room instanceof UtilityRoom) {
            return "Utility";
        } else if (room instanceof WorkShop) {
            return "Workshop";
        } else if (room instanceof Staircase) {
            return "Staircase";
        } else {
            return "Unknown";
        }
    }


    private static void addRandomInventory(Room room) {
        Random rand = new Random();
        int inventoryCount = 3 + rand.nextInt(5);

        for (int i = 0; i < inventoryCount; i++) {
            try {
                if (room instanceof BusinessRoom) {
                    if (rand.nextBoolean()) {
                        room.getInventory().add(new BusinessItem("Stuhl"));
                    } else {
                        room.getInventory().add(new BusinessItem("Tisch"));
                    }
                } else if (room instanceof UtilityRoom) {
                    if (rand.nextBoolean()) {
                        room.getInventory().add(new SanitaryItem("Waschbecken"));
                    } else {
                        room.getInventory().add(new SanitaryItem("Handtuchspender"));
                    }
                } else if (room instanceof WorkShop) {
                    WorkShop workshop = (WorkShop) room;
                    String workshopName = workshop.getName();

                    if ("Holzwerkstatt".equals(workshopName)) {
                        if (rand.nextBoolean()) {
                            room.getInventory().add(new WoodWorkShopItem("Kreissäge"));
                        } else {
                            room.getInventory().add(new WoodWorkShopItem("Oberfräse"));
                        }
                    } else if ("Metallwerkstatt".equals(workshopName)) {
                        if (rand.nextBoolean()) {
                            room.getInventory().add(new MetalWorkShopItem("Schweißgerät"));
                        } else {
                            room.getInventory().add(new MetalWorkShopItem("Poliermaschine"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
