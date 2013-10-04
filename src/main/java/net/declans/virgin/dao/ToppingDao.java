package net.declans.virgin.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import net.declans.virgin.model.ToppingEntity;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
public interface ToppingDao {

    /**
     * @return the set of all toppings
     */
    List<ToppingEntity> findAllToppings();

    /**
     * Return a single ToppingEntity
     * @param id of the ToppingEntity to return
     * @return the ToppingEntity
     */
    ToppingEntity findById(Integer id);
}
