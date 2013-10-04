package net.declans.virgin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
public abstract class PizzaComponent<T extends PizzaComponent> implements Serializable, Comparable<T> {

    private Integer id;
    private String description;
    private BigDecimal price;

    public PizzaComponent() {
        super();
    }

    public PizzaComponent(Integer id, String description, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // TODO Should go into a utils class
    public String getFormattedPrice() {
        NumberFormat ukFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        ukFormat.setMinimumFractionDigits(2);
        ukFormat.setMaximumFractionDigits(2);
        return ukFormat.format(price.doubleValue());
    }

    /**
     * Primitive implementation of compareTo using only the id
     * @param o
     * @return
     */
    @Override
    public int compareTo(T o) {
        if (this.id.equals(o.getId())) {
            return 0;
        } else if (this.id < o.getId()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PizzaComponent)) {
            return false;
        }

        PizzaComponent that = (PizzaComponent) o;

        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        if (price != null ? !price.equals(that.price) : that.price != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
