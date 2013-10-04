package net.declans.virgin.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.declans.virgin.dao.ToppingDao;
import net.declans.virgin.model.PizzaSizeEntity;
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
    public List<ToppingEntity> findAllToppings() {
        return toppingDao.findAllToppings();
    }

    /**
     * @return the List of all toppings that have a matching id in the toppingIds array
     */
    @Override
    public List<ToppingEntity> findByIds(Integer[] toppingIds) {
        List<ToppingEntity> allToppings = findAllToppings();
        List<ToppingEntity> matches = new ArrayList<>();
        for (ToppingEntity topping : allToppings) {
            for (Integer toppingId : toppingIds) {
                if (topping.getId().equals(toppingId)) {
                    matches.add(topping);
                }
            }
        }
        return matches;
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
