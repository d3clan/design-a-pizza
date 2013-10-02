package net.declans.virgin.dao;

import java.util.Collection;
import net.declans.virgin.model.PizzaSizeEntity;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
public interface PizzaSizeDao {

    /**
     * @return the set of all sizes
     */
    Collection<PizzaSizeEntity> findAllPizzaSizes();

    PizzaSizeEntity findById(Integer id);
}
