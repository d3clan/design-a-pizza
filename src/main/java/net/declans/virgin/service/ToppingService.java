package net.declans.virgin.service;

import java.util.Collection;
import java.util.List;
import net.declans.virgin.model.PizzaSizeEntity;
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
    List<ToppingEntity> findAllToppings();

    /**
     * @return the List of all toppings that have a matching id in the toppingIds array
     */
    List<ToppingEntity> findByIds(Integer[] toppingIds);

    /**
     * Return a single ToppingEntity
     * @param id of the ToppingEntity to return
     * @return the ToppingEntity
     */
    ToppingEntity findById(Integer id);
}
