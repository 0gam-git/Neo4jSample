package com.urong.test.dao;

import java.util.List;

import com.urong.test.domain.Ingredient;

public interface IngredientDao {

	public Iterable<Ingredient> getIngredientNames();

	public void saveIngredient(Ingredient ingredient);

	public List<Ingredient> findByName(String name);

	public void updateIngredient(Ingredient ingredient);

	public void deleteIngredient(long id);

}
