package inventory;

public class BusinessItem extends Item {
    private static final String[] ALLOWED_ITEMS = {"Stuhl", "Tisch"};

    public BusinessItem(String auswahl) throws Exception {
        if (!isAllowedItem(auswahl)) {
            throw new Exception("Dieser Gegenstand kann nicht in das Inventar dieses Raumes aufgenommen werden.");
        }

        this.name = auswahl;
        this.serialNumber = "00-" + String.valueOf(serialNumberCounter++) + "-S04";
    }

    private boolean isAllowedItem(String item) {
        for (String allowedItem : ALLOWED_ITEMS) {
            if (allowedItem.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
