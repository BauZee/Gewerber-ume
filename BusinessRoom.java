package rooms;

public abstract class BusinessRoom extends Room {
    public BusinessRoom() {
        this.name = "Geschäftsraum";
    }
}

class Office extends BusinessRoom {
    public Office() {
        this.name = "Büro";
    }
}

class Lounge extends BusinessRoom {
    public Lounge() {
        this.name = "Aufenthaltsraum";
    }
}
