package net.declans.virgin.service.impl;

import java.util.Collection;
import net.declans.virgin.dao.ToppingDao;
import net.declans.virgin.model.ToppingEntity;
import net.declans.virgin.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
@Service
public class ToppingServiceImpl implements ToppingService {

    @Autowired
    private ToppingDao toppingDao;

    /**
     * @return the set of all toppings
     */
    @Override
    public Collection<ToppingEntity> findAllToppings() {
        return toppingDao.findAllToppings();
    }

    /**
     * Return a single ToppingEntity
     *
     * @param id of the ToppingEntity to return
     * @return the ToppingEntity
     */
    @Override
    public ToppingEntity findById(Integer id) {
        return toppingDao.findById(id);
    }
}
