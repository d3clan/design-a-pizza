package net.declans.virgin.dao;

import net.declans.virgin.model.PizzaEntity;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 *
 * @author Declan Newman (declan)
 */
public interface PizzaDao {

    /**
     * Save or update a representation  of a pizza
     * @param pizza the PizzaEntity to be created
     * @return the saved PizzaEntity including a new id if newly created
     */
    PizzaEntity saveOrUpdatePizza(PizzaEntity pizza);

    /**
     * Delete a PizzaEntity
     * @param pizza the PizzaEntity to be deleted
     */
    void deletePizza(PizzaEntity pizza);

    /**
     * Delete a PizzaEntity
     * @param id the id of the PizzaEntity to be deleted
     */
    void deletePizza(Integer id);

}
