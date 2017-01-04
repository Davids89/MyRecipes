package com.example.david.myrecipes.recipeMain.ui;

import com.example.david.myrecipes.entities.Recipe;

/**
 * Created by david on 4/1/17.
 */

public interface RecipeMainView {
    void showProgressBar();
    void hideProgressBar();
    void showUIElements();
    void hideUIElements();
    void saveAnimation();
    void DismissAnimation();

    void onRecipeSaved();
    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);
}
