package rooms;

public abstract class WorkShop extends Room {
    public WorkShop() {
        this.name = "Werkstatt";
    }
}

class MetalWorkShop extends WorkShop {
    public MetalWorkShop() {
        this.name = "Metallwerkstatt";
    }
}

class WoodWorkShop extends WorkShop {
    public WoodWorkShop() {
        this.name = "Holzwerkstatt";
    }
}
