package net.declans.virgin.service;

import java.util.List;
import junit.framework.Assert;
import net.declans.virgin.model.PizzaEntity;
import net.declans.virgin.model.PizzaSizeEntity;
import net.declans.virgin.model.ToppingEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Project: design-a-pizza Date: 04/10/2013
 *
 * @author Declan Newman (declan)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:/spring/servlet-context.xml", "classpath:/spring/root-context.xml"})
public class PizzaServiceImplTest {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaSizeService pizzaSizeService;

    @Autowired
    private ToppingService toppingService;

    @Test
    public void testSaveOrUpdatePizza() throws Exception {
        PizzaEntity pizza = buildPizzaEntity();
        assertNull("ID should be null at this point", pizza.getId());
        PizzaEntity pizzaEntity = pizzaService.saveOrUpdatePizza(pizza);
        assertNotNull("ID should NOT be null at this point", pizza.getId());
    }

    @Test
    public void testDeletePizzaById() throws Exception {
        PizzaEntity pizza = buildPizzaEntity();
        assertNull("ID should be null at this point", pizza.getId());
        PizzaEntity pizzaEntity = pizzaService.saveOrUpdatePizza(pizza);
        assertNotNull("ID should NOT be null at this point", pizzaEntity.getId());
        pizzaService.deletePizza(pizzaEntity.getId());
        PizzaEntity byId = pizzaService.findById(pizzaEntity.getId());
        assertNull("Should have been deleted", byId);
    }

    @Test
    public void testDeletePizzaByEntity() throws Exception {
        PizzaEntity pizza = buildPizzaEntity();
        assertNull("ID should be null at this point", pizza.getId());
        PizzaEntity pizzaEntity = pizzaService.saveOrUpdatePizza(pizza);
        assertNotNull("ID should NOT be null at this point", pizzaEntity.getId());
        pizzaService.deletePizza(pizzaEntity);
        PizzaEntity byId = pizzaService.findById(pizzaEntity.getId());
        assertNull("Should have been deleted", byId);
    }

    private PizzaEntity buildPizzaEntity() {
        PizzaSizeEntity sizeEntity = pizzaSizeService.findById(2);
        List<ToppingEntity> allToppings = toppingService.findAllToppings();
        PizzaEntity pizza = new PizzaEntity();
        pizza.setBaseSize(sizeEntity);
        pizza.setToppings(allToppings);
        return pizza;
    }
}
