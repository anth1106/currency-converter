package proven.cat.currencyconverter.model;

import java.util.Objects;

/**
 *
 * @author Anthh
 */
public class Coin {
    //ATTRIBUTES
    private String name;
    private double dolarRatio;

    //CONSTRUCTORS
    public Coin() {
    }
    
    public Coin(String name, double dolarRatio) {
        this.name = name;
        this.dolarRatio = dolarRatio;
    }
    
    public Coin(String name) {
        this.name = name;
    }

    public Coin(Coin other) {
        this.name = other.name;
        this.dolarRatio = other.dolarRatio;
    }
    
    //SETTERS AND GETTERS
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dolarRatio
     */
    public double getDolarRatio() {
        return dolarRatio;
    }

    /**
     * @param dolarRatio the dolarRatio to set
     */
    public void setDolarRatio(double dolarRatio) {
        this.dolarRatio = dolarRatio;
    }

    //METHODS
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coin other = (Coin) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
}
