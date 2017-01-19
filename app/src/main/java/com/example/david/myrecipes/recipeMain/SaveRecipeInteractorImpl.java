package com.example.david.myrecipes.recipeMain;

import com.example.david.myrecipes.entities.Recipe;

/**
 * Created by david on 18/1/17.
 */

public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {

    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
