package net.declans.virgin.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class ToppingEntity implements Serializable {

    private Integer id;
    private String description;
    private BigDecimal price;

    public ToppingEntity() {
        super();
    }

    public ToppingEntity(String[] topping) {
        super();
        this.id = Integer.parseInt(topping[0]);
        this.description = topping[1];
        this.price = new BigDecimal(topping[2]);
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ToppingEntity)) {
            return false;
        }

        ToppingEntity that = (ToppingEntity) o;

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
