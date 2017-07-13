package com.urong.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.urong.test.domain.Ingredient;
import com.urong.test.repository.IngredientRepository;

@Transactional
@Repository
public class IngredientDaoImpl implements IngredientDao {

	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Iterable<Ingredient> getIngredientNames() {
		return ingredientRepository.findAll(0);
	}

	@Override
	public void saveIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	@Override
	public List<Ingredient> findByName(String name) {
		return ingredientRepository.findByName(name);
	}

	@Override
	public void updateIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	@Override
	public void deleteIngredient(long id) {
		ingredientRepository.delete(id);
	}

}
