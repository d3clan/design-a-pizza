package net.declans.virgin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * <p>
 *    Represents a pizza size, including how much toppings should be multiplied by
 *
 * <p>
 *    In the real world this would be a JPA entity (or similar)
 *
 * @author Declan Newman (declan)
 */
public class PizzaSizeEntity extends PizzaComponent<PizzaSizeEntity> {

    // Amount to multiply the toppings by
    private Double multiplier;

    public PizzaSizeEntity() {
        super();
    }

    public PizzaSizeEntity(String[] size) {
        super(Integer.parseInt(size[0]), size[1], new BigDecimal(size[2]));
        this.multiplier = Double.parseDouble(size[3]);
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PizzaSizeEntity)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        PizzaSizeEntity that = (PizzaSizeEntity) o;

        if (multiplier != null ? !multiplier.equals(that.multiplier) : that.multiplier != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (multiplier != null ? multiplier.hashCode() : 0);
        return result;
    }
}
