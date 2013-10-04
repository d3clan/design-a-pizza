package net.declans.virgin.service.impl;

import java.util.List;
import net.declans.virgin.dao.PizzaSizeDao;
import net.declans.virgin.model.PizzaSizeEntity;
import net.declans.virgin.service.PizzaSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
@Service
public class PizzaSizeServiceImpl implements PizzaSizeService {

    @Autowired
    private PizzaSizeDao pizzaSizeDao;

    /**
     * @return the set of all sizes
     */
    @Override
    public List<PizzaSizeEntity> findAllPizzaSizes() {
        return pizzaSizeDao.findAllPizzaSizes();
    }

    @Override
    public PizzaSizeEntity findById(Integer id) {
        return pizzaSizeDao.findById(id);
    }
}
