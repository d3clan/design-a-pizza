package net.declans.virgin.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class PizzaSizeEntity implements Serializable {

    private Integer id;
    private String description;
    private BigDecimal price;
    // Amount to multiply the toppings by
    private Double multiplier;

    public PizzaSizeEntity() {
        super();
    }

    public PizzaSizeEntity(String[] size) {
        this();
        this.id = Integer.parseInt(size[0]);
        this.description = size[1];
        this.price = new BigDecimal(size[2]);
        this.multiplier = Double.parseDouble(size[3]);
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

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PizzaSizeEntity)) {
            return false;
        }

        PizzaSizeEntity that = (PizzaSizeEntity) o;

        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        if (multiplier != null ? !multiplier.equals(that.multiplier) : that.multiplier != null) {
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
        result = 31 * result + (multiplier != null ? multiplier.hashCode() : 0);
        return result;
    }
}
