package net.declans.virgin.dao;

import java.util.Collection;
import java.util.List;
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
    List<PizzaSizeEntity> findAllPizzaSizes();

    PizzaSizeEntity findById(Integer id);
}
