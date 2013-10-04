package net.declans.virgin.dao.impl;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import net.declans.virgin.dao.PizzaDao;
import net.declans.virgin.model.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
@Repository
public class PizzaDaoImpl implements PizzaDao {

    // Simple persistence method
    @Autowired
    private CacheManager cacheManager;

    private static AtomicInteger counter = new AtomicInteger(1);

    /**
     * Find the entity given the id
     *
     * @param id of the entity
     * @return the entity or null if not found
     */
    @Override
    public PizzaEntity findById(Integer id) {
        Assert.notNull(id, "Cannot locate with a null id");
        Cache cache = cacheManager.getCache("pizza");
        Cache.ValueWrapper wrapper = cache.get(id);
        return wrapper != null ? (PizzaEntity) wrapper.get() : null;
    }

    /**
     * Save or update a representation  of a pizza
     *
     * @param pizza the PizzaEntity to be created
     * @return the saved PizzaEntity including a new id if newly created
     */
    @Override
    public PizzaEntity saveOrUpdatePizza(PizzaEntity pizza) {
        Assert.notNull(pizza, "Cannot persist a null entity");
        Cache cache = cacheManager.getCache("pizza");
        if (pizza.getId() != null) {
            cache.put(pizza.getId(), pizza);
        } else {
            pizza.setId(counter.getAndIncrement());
            cache.put(pizza.getId(), pizza);
        }
        // Not great, but it validates that the pizza has been stored
        return (PizzaEntity) cache.get(pizza.getId()).get();
    }

    /**
     * Delete a PizzaEntity
     *
     * @param pizza the PizzaEntity to be deleted
     */
    @Override
    public void deletePizza(PizzaEntity pizza) {
        Assert.notNull(pizza, "Cannot delete a null entity");
        deletePizza(pizza.getId());
    }

    /**
     * Delete a PizzaEntity
     *
     * @param id the id of the PizzaEntity to be deleted
     */
    @Override
    public void deletePizza(Integer id) {
        Assert.notNull(id, "Cannot delete an entity with a null id");
        Cache cache = cacheManager.getCache("pizza");
        cache.evict(id);
    }
}
