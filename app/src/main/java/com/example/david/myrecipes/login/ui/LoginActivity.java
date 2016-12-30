package com.example.david.myrecipes.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.example.david.myrecipes.FacebookRecipesApp;
import com.example.david.myrecipes.R;
import com.example.david.myrecipes.main.ui.RecipeMainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.btnLogin)
    LoginButton btnLogin;
    @Bind(R.id.container)
    RelativeLayout container;

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if(AccessToken.getCurrentAccessToken() != null){
            navigateToMainScreen();
        }

        setupCallbackManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //to manage the session
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void setupCallbackManager() {
        callbackManager = CallbackManager.Factory.create();
        btnLogin.setPublishPermissions(Arrays.asList("publish_actions"));
        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                navigateToMainScreen();
            }

            @Override
            public void onCancel() {
                Snackbar.make(container, R.string.login_cancel_error, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                String msgError = String.format(getString(R.string.login_error, error.getLocalizedMessage()));
                Snackbar.make(container, msgError, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToMainScreen() {
        Intent intent = new Intent(this, RecipeMainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
            | Intent.FLAG_ACTIVITY_NEW_TASK
            | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
