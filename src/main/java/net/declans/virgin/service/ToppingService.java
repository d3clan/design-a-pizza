package net.declans.virgin.service;

import java.util.Collection;
import net.declans.virgin.model.ToppingEntity;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
public interface ToppingService {

    /**
     * @return the set of all toppings
     */
    Collection<ToppingEntity> findAllToppings();

    /**
     * Return a single ToppingEntity
     * @param id of the ToppingEntity to return
     * @return the ToppingEntity
     */
    ToppingEntity findById(Integer id);
}
