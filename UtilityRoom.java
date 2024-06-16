package rooms;

public abstract class UtilityRoom extends Room {
    public UtilityRoom() {
        this.name = "Wirtschaftsraum";
    }
}

class TeaKitchen extends UtilityRoom {
    public TeaKitchen() {
        this.name = "Teeküche";
    }
}

class SanitaryFacility extends UtilityRoom {
    public SanitaryFacility() {
        this.name = "Sanitäreinrichtung";
    }
}
