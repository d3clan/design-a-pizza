package net.declans.virgin.dao.impl;

import au.com.bytecode.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import net.declans.virgin.dao.PizzaSizeDao;
import net.declans.virgin.dao.ToppingDao;
import net.declans.virgin.model.PizzaSizeEntity;
import net.declans.virgin.model.ToppingEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * Project: design-a-pizza Date: 02/10/2013
 *
 * @author Declan Newman (declan)
 */
@Repository
public class ToppingDaoImpl implements ToppingDao, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(ToppingDaoImpl.class);

    @Value("classpath:/toppings-file.csv")
    private File toppingsFile;

    private ConcurrentHashMap<Integer, ToppingEntity> availableToppings = new ConcurrentHashMap<>();;

    /**
     * @return the set of all toppings
     */
    @Override
    public List<ToppingEntity> findAllToppings() {
        List<ToppingEntity> list =  new ArrayList<>(availableToppings.values());
        Collections.sort(list);
        return list;
    }

    @Override
    public ToppingEntity findById(Integer id) {
        Assert.notNull(id, "Cannot retrieve an item from a null id");
        return availableToppings.get(id);
    }


    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied (and satisfied BeanFactoryAware and
     * ApplicationContextAware). <p>This method allows the bean instance to perform initialization only possible when
     * all
     * bean properties have been set and to throw an exception in the event of misconfiguration.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an essential property) or if
     *                   initialization fails.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        CSVReader reader = new CSVReader(new FileReader(toppingsFile));
        List<String[]> toppingsStringArray = reader.readAll();
        for (String[] topping : toppingsStringArray) {
            // Could do with some validation
            logger.debug("Loading topping: {}, {}, {}, {}", topping);
            availableToppings.put(Integer.parseInt(topping[0]), new ToppingEntity(topping));
        }
    }

}
