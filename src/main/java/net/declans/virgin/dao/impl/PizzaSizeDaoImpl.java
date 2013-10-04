package net.declans.virgin.dao.impl;

import au.com.bytecode.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import net.declans.virgin.dao.PizzaSizeDao;
import net.declans.virgin.model.PizzaSizeEntity;
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
public class PizzaSizeDaoImpl implements PizzaSizeDao, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(PizzaSizeDaoImpl.class);

    @Value("classpath:/sizes-file.csv")
    private File sizesFile;

    private ConcurrentHashMap<Integer, PizzaSizeEntity> availableSizes = new ConcurrentHashMap<>();

    /**
     * @return the set of all sizes
     */
    @Override
    public List<PizzaSizeEntity> findAllPizzaSizes() {
        List<PizzaSizeEntity> list = new ArrayList<>(availableSizes.values());
        Collections.sort(list);
        return list;
    }

    @Override
    public PizzaSizeEntity findById(Integer id) {
        Assert.notNull(id, "Cannot retrieve an item from a null id");
        return availableSizes.get(id);
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
        CSVReader reader = new CSVReader(new FileReader(sizesFile));
        List<String[]> sizesStringArray = reader.readAll();
        for (String[] size : sizesStringArray) {
            // Could do with some validation
            logger.debug("Loading size: {}, {}, {}", size);
            availableSizes.put(Integer.parseInt(size[0]), new PizzaSizeEntity(size));
        }
    }
}
