package com.example.david.myrecipes.recipeMain;

import java.util.Random;

/**
 * Created by david on 18/1/17.
 */

public class GetNextRecipeInteractorImpl implements GetNextRecipeInteractor {

    RecipeMainRepository repository;

    public GetNextRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.setRecipePage(recipePage);
        repository.getNextRecipe();
    }
}
