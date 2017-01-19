package com.example.david.myrecipes.recipeMain;

import com.example.david.myrecipes.entities.Recipe;
import com.example.david.myrecipes.recipeMain.events.RecipeMainEvent;
import com.example.david.myrecipes.recipeMain.ui.RecipeMainView;

/**
 * Created by david on 4/1/17.
 */

public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    void imageReady();
    void imageError(String error);

    RecipeMainView getView();
}
