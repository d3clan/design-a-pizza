package net.declans.virgin.dao;

import java.util.Set;
import net.declans.virgin.model.ToppingEntity;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
public interface ToppingsDao {

    /**
     * @return the set of all toppings
     */
    Set<ToppingEntity> findAllToppings();
}
