package net.declans.virgin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * <p>
 *    Represents a pizza topping
 *
 * <p>
 *    In the real world this would be a JPA entity (or similar)
 *
 * @author Declan Newman (declan)
 */
public class ToppingEntity extends PizzaComponent<ToppingEntity> {

    private String type;
    // Default to 1
    @JsonIgnore
    private Double multiplier = 1.00D;

    public ToppingEntity() {
        super();
    }

    public ToppingEntity(String[] topping) {
        super(Integer.parseInt(topping[0]), topping[1], new BigDecimal(topping[2]));
        this.type = topping[3];
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().multiply(BigDecimal.valueOf(multiplier));
    }

    // TODO Should go into a utils class
    @Override
    public String getFormattedPrice() {
        NumberFormat ukFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        ukFormat.setMinimumFractionDigits(2);
        ukFormat.setMaximumFractionDigits(2);
        return ukFormat.format(getPrice().doubleValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ToppingEntity)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        ToppingEntity that = (ToppingEntity) o;

        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
