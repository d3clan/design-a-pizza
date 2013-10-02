package net.declans.virgin.model;

import java.io.Serializable;
import java.util.List;

/**
 * Project: design-a-pizza Date: 01/10/2013
 *
 * <p>
 *    Represents the pizza and hold all the information needed to display and calculate the price
 *
 * <p>
 *    In the real world this is likely to be a JPA entity
 *
 * @author Declan Newman (declan)
 */
public class PizzaEntity implements Serializable {

    private Integer id;
    private List<ToppingEntity> toppings;
    private PizzaSizeEntity baseSize;

    public PizzaEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PizzaSizeEntity getBaseSize() {
        return baseSize;
    }

    public void setBaseSize(PizzaSizeEntity baseSize) {
        this.baseSize = baseSize;
    }

    public List<ToppingEntity> getToppings() {
        return toppings;
    }

    public void setToppings(List<ToppingEntity> toppings) {
        this.toppings = toppings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PizzaEntity)) {
            return false;
        }

        PizzaEntity that = (PizzaEntity) o;

        if (baseSize != null ? !baseSize.equals(that.baseSize) : that.baseSize != null) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        if (toppings != null ? !toppings.equals(that.toppings) : that.toppings != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (toppings != null ? toppings.hashCode() : 0);
        result = 31 * result + (baseSize != null ? baseSize.hashCode() : 0);
        return result;
    }
}
