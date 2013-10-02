package net.declans.virgin.service.impl;

import net.declans.virgin.dao.PizzaDao;
import net.declans.virgin.model.PizzaEntity;
import net.declans.virgin.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaDao pizzaDao;
    /**
     * Save or update a representation  of a pizza
     *
     * @param pizza the PizzaEntity to be created
     * @return the saved PizzaEntity including a new id if newly created
     */
    @Override
    public PizzaEntity saveOrUpdatePizza(PizzaEntity pizza) {
        return pizzaDao.saveOrUpdatePizza(pizza);
    }

    /**
     * Delete a PizzaEntity
     *
     * @param pizza the PizzaEntity to be deleted
     */
    @Override
    public void deletePizza(PizzaEntity pizza) {
        pizzaDao.deletePizza(pizza);
    }

    /**
     * Delete a PizzaEntity
     *
     * @param id the id of the PizzaEntity to be deleted
     */
    @Override
    public void deletePizza(Integer id) {
        pizzaDao.deletePizza(id);
    }
}
