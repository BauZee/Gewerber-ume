package inventory;

/**
 * Abstrakte Klasse, die ein Inventarobjekt repräsentiert.
 * Jedes Inventarobjekt hat einen Namen und eine eindeutige Seriennummer.
 */
public abstract class Item {
    /** Die fortlaufende Zählung für die Seriennummern der Objekte. */
    protected static int serialNumberCounter = 12000;

    /** Der Name des Inventarobjekts. */
    protected String name;

    /** Die eindeutige Seriennummer des Inventarobjekts im Format 00-XXXXX-S04. */
    protected String serialNumber;

    /**
     * Gibt den Namen des Inventarobjekts zurück.
     *
     * @return Der Name des Inventarobjekts.
     */
    public String getName() {

        return name;
    }

    /**
     * Gibt die Seriennummer des Inventarobjekts zurück.
     *
     * @return Die Seriennummer des Inventarobjekts im Format 00-XXXXX-S04.
     */
    public String getSerialNumber() {

        return serialNumber;
    }
}
