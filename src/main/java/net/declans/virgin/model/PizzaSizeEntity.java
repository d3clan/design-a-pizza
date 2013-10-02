package net.declans.virgin.model;

import java.io.Serializable;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * <p>
 *    Represents a pizza size, including how much toppings should be multiplied by
 *
 * <p>
 *    In the real world this would be a JPA entity
 *
 * @author Declan Newman (declan)
 */
public class PizzaSizeEntity implements Serializable {

    private Integer id;
    private String description;
    // Amount to multiply the toppings by
    private Double multiplier;

    public PizzaSizeEntity() {
        super();
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (multiplier != null ? multiplier.hashCode() : 0);
        return result;
    }
}
