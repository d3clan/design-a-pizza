package net.declans.virgin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

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

    // TODO Should go into a utils class
    public String getFormattedPrice() {
        NumberFormat ukFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        ukFormat.setMinimumFractionDigits(2);
        ukFormat.setMaximumFractionDigits(2);
        BigDecimal result = new BigDecimal("0.00");
        if (baseSize != null) {
            result = baseSize.getPrice();
            Double multiplier = baseSize.getMultiplier();
            for (ToppingEntity topping : toppings) {
                topping.setMultiplier(multiplier);
                result = result.add(topping.getPrice());
            }
        }
        return ukFormat.format(result.doubleValue());
    }

    @Override
    public String toString() {
        return "PizzaEntity{" +
                "id=" + id +
                ", toppings=" + toppings +
                ", baseSize=" + baseSize +
                ", price=" + getFormattedPrice() +
                '}';
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
