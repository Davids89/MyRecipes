package com.example.david.myrecipes.recipeMain;

import com.example.david.myrecipes.entities.Recipe;

/**
 * Created by david on 4/1/17.
 */

public interface RecipeMainRepository {

    public final static int COUNT = 1;
    public final static String RECENT_SORT = "r";
    public final static int RECIPE_RANGE = 100000;

    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void setRecipePage(int recipePage);
}
