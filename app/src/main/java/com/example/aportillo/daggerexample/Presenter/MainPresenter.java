package com.example.aportillo.daggerexample.Presenter;

import com.example.aportillo.daggerexample.Models.Lenguages.Lenguages;
import com.example.aportillo.daggerexample.Models.Main.MainPresenterInterface;
import com.example.aportillo.daggerexample.Models.ServiceInterface;
import com.example.aportillo.daggerexample.Services.LenguagesServices;
import com.example.aportillo.daggerexample.Util.Logger;
import com.example.aportillo.daggerexample.ui.MainActivity;

import javax.inject.Inject;

/**
 * Created by aportillo on 18/08/2016.
 */
public class MainPresenter implements MainPresenterInterface {
    @Inject
    Logger logger;

    private LenguagesServices lenguagesServices;
    private MainActivity mainActivity;

    @Inject
    public MainPresenter(MainActivity mainActivity, LenguagesServices lenguagesServices) {
        this.mainActivity = mainActivity;
        this.lenguagesServices = lenguagesServices;
    }

    @Override
    public void onCreate(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


        @Override
    public void loadLenguages() {
       try {
           lenguagesServices.getLenguageServicesI(new ServiceInterface<Lenguages>() {
                @Override
                public void onSuccess(Lenguages value) {
               //     mainActivity.setTextView( String.valueOf(value));
                    logger.log("onSuccess.value" + String.valueOf(value));
                }
                @Override
                public void onError() {
                    logger.log("onError" + "onError");
                }
            }, Lenguages.class);
        } catch (Exception e) {
            logger.log(getClass().getSimpleName() + "loadPba - " + e.getMessage());
         //  mainActivity.setTextView( String.valueOf(e.getMessage()));
        }
    }

}