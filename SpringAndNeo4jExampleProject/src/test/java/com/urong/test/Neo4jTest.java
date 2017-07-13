package com.urong.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.urong.test.dao.IngredientDao;
import com.urong.test.domain.Category;
import com.urong.test.domain.Ingredient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class Neo4jTest {

	@Autowired
	private IngredientDao ingredientDao;

	@Test
	public void testNeo4jQuery() {

		Category category = new Category("DairyByeon");
		Ingredient ingredient = new Ingredient("EmmentalByeon");
		ingredient.setCategory(category);

		ingredientDao.saveIngredient(ingredient);

		System.out.println("!");

	}

	@Test
	public void TestSelect() {
		List<Ingredient> ingredients = ingredientDao.findByName("EmmentalByeon");

		System.out.println("!");
	}

	@Test
	public void testUpdate() {
		List<Ingredient> ingredients = ingredientDao.findByName("EmmentalByeon");

		Ingredient ingredient = ingredients.get(0);
		ingredient.setName("ElementalYoungJun");

		ingredientDao.updateIngredient(ingredient);

		ingredients = ingredientDao.findByName("ElementalYoungJun");

		System.out.println("!");
	}

	@Test
	public void testDelete() {
		List<Ingredient> ingredients = ingredientDao.findByName("ElementalYoungJun");

		ingredientDao.deleteIngredient(ingredients.get(0).getId());

		ingredients = ingredientDao.findByName("ElementalYoungJun");

		System.out.println("!");

	}

}
