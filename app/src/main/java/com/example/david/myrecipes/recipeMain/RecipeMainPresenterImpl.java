package com.example.david.myrecipes.recipeMain;

import com.example.david.myrecipes.entities.Recipe;
import com.example.david.myrecipes.recipeMain.events.RecipeMainEvent;
import com.example.david.myrecipes.recipeMain.ui.RecipeMainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by david on 18/1/17.
 */

public class RecipeMainPresenterImpl implements RecipeMainPresenter {

    private EventBus eventBus;
    private RecipeMainView view;
    SaveRecipeInteractor saveRecipeInteractor;
    GetNextRecipeInteractor getNextRecipeInteractor;

    public RecipeMainPresenterImpl(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveRecipeInteractor, GetNextRecipeInteractor getNextRecipeInteractor) {
        this.eventBus = eventBus;
        this.view = view;
        this.saveRecipeInteractor = saveRecipeInteractor;
        this.getNextRecipeInteractor = getNextRecipeInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void dismissRecipe() {
        if(view != null){
            view.dismissAnimation();
        }
        getNextRecipe();
    }

    @Override
    public void getNextRecipe() {
        if(view != null){
            view.hideUIElements();
            view.showProgressBar();
        }
        getNextRecipeInteractor.execute();
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        if(view != null){
            view.saveAnimation();
            view.hideUIElements();
            view.showProgressBar();
        }
        saveRecipeInteractor.execute(recipe);
    }

    @Override
    @Subscribe
    public void onEventMainThread(RecipeMainEvent event) {
        if(view != null){
            String error = event.getError();
            if(error != null){
                view.hideProgressBar();
                view.onGetRecipeError(error);
            }else{
                if(event.getType() == RecipeMainEvent.NEXT_EVENT){
                    view.setRecipe(event.getRecipe());
                }else if(event.getType() == RecipeMainEvent.SAVE_EVENT){
                    view.onRecipeSaved();
                    getNextRecipeInteractor.execute();
                }
            }
        }
    }

    @Override
    public void imageReady() {
        if(view != null){
            view.hideProgressBar();
            view.showUIElements();
        }
    }

    @Override
    public void imageError(String error) {
        if(view != null){
            view.onGetRecipeError(error);
        }
    }

    @Override
    public RecipeMainView getView() {
        return this.view;
    }
}
