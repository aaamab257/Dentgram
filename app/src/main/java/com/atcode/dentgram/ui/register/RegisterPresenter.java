package com.atcode.dentgram.ui.register;

import android.content.Context;

import com.atcode.dentgram.data.Cities.CitiesArray;
import com.atcode.dentgram.data.Specialities.SpecialitiesArray;
import com.atcode.dentgram.data.User;
import com.atcode.dentgram.data.countries.Countries;
import com.atcode.dentgram.data.registerData.RegisterData;
import com.atcode.dentgram.data.titles.TitleArray;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;

import okhttp3.RequestBody;

public class RegisterPresenter {
    RegisterListener register ;
    Context context ;


    public RegisterPresenter(RegisterListener register,Context context) {
        this.register = register;
        this.context = context;
    }

    public void getCountries(){
        boolean network = StaticMethods.isConnectingToInternet(context) ;
        if(network){
            MainApi.getCountries(new ConnectionListener<Countries>() {
                @Override
                public void onSuccess(ConnectionResponse<Countries> connectionResponse) {
                    register.onCountries(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    register.onRegisterFail(true);
                }
            });
        }else {
            register.onConnection(true);
        }
    }

    public void getTitles(){
        boolean network = StaticMethods.isConnectingToInternet(context) ;
        if(network){
            MainApi.getTitles(new ConnectionListener<TitleArray>() {
                @Override
                public void onSuccess(ConnectionResponse<TitleArray> connectionResponse) {
                    register.onTitles(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    register.onRegisterFail(true);
                }
            });
        }else {
            register.onConnection(true);
        }
    }

    public void getSpecialities(){
        boolean network = StaticMethods.isConnectingToInternet(context) ;
        if(network){
            MainApi.getSpecialities(new ConnectionListener<SpecialitiesArray>() {
                @Override
                public void onSuccess(ConnectionResponse<SpecialitiesArray> connectionResponse) {
                    register.onSpecialities(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    register.onRegisterFail(true);
                }
            });
        }else {
            register.onConnection(true);
        }
    }

    public void getCities(RequestBody body){
        boolean network = StaticMethods.isConnectingToInternet(context) ;
        if(network){
            MainApi.getCities(body ,new ConnectionListener<CitiesArray>() {
                @Override
                public void onSuccess(ConnectionResponse<CitiesArray> connectionResponse) {
                    register.onCities(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    register.onRegisterFail(true);
                }
            });
        }else {
            register.onConnection(true);
        }
    }

    public void register(RequestBody body){
        boolean network = StaticMethods.isConnectingToInternet(context) ;
        if(network){
            MainApi.RegisterApi(body ,new ConnectionListener<User<RegisterData>>() {
                @Override
                public void onSuccess(ConnectionResponse<User<RegisterData>> connectionResponse) {
                    register.onRegisterSuccess(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    register.onRegisterFail(true);
                }
            });
        }else {
            register.onConnection(true);
        }
    }


}
