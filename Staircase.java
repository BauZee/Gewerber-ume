package rooms;

public class Staircase extends Room {
    public Staircase() {
        this.name = "Treppenhaus";
    }

    @Override
    public void enterRoom() {
        System.out.println("Betrete Treppenhaus.");
    }
}
