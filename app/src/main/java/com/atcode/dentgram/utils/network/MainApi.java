package com.atcode.dentgram.utils.network;


import com.atcode.dentgram.data.Cities.CitiesArray;
import com.atcode.dentgram.data.CreateNewPassword.CreateNewPasswordModel;
import com.atcode.dentgram.data.EventById.EventData;
import com.atcode.dentgram.data.EventById.EventObject;
import com.atcode.dentgram.data.EventsData.EventsArray;
import com.atcode.dentgram.data.Favo.FavResponse;
import com.atcode.dentgram.data.FeaturedEvents.FeaturedEventArray;
import com.atcode.dentgram.data.ForgetPasswordData.ForgetObject;
import com.atcode.dentgram.data.ForgetPasswordData.ForgetPasswordModel;
import com.atcode.dentgram.data.Specialities.SpecialitiesArray;
import com.atcode.dentgram.data.User;
import com.atcode.dentgram.data.countries.Countries;
import com.atcode.dentgram.data.loginData.LoginData;
import com.atcode.dentgram.data.registerData.RegisterData;
import com.atcode.dentgram.data.titles.TitleArray;
import com.atcode.dentgram.data.verifications.VerificationResponse;
import com.atcode.dentgram.ui.verificationCode.VerificationCode;
import com.atcode.dentgram.utils.StaticMethods;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApi {
    private static MainApiInterface getApi() {
        return getApi(MainApiInterface.class  );
    }

    public static <T> T getApi(Class<T> aClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticMethods.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        return retrofit.create(aClass);
    }

    public static void LoginApi(RequestBody body, final ConnectionListener<User<LoginData>> connectionListener) {
        getApi().login(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User<LoginData>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(User<LoginData> userResponse) {
                        ConnectionResponse<User<LoginData>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void RegisterApi(RequestBody body, final ConnectionListener<User<RegisterData>> connectionListener) {
        getApi().register(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User<RegisterData>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(User<RegisterData> userResponse) {
                        ConnectionResponse<User<RegisterData>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void getCountries(final ConnectionListener<Countries> connectionListener) {
        getApi().countries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Countries>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Countries userResponse) {
                        ConnectionResponse<Countries> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void getTitles(final ConnectionListener<TitleArray> connectionListener) {
        getApi().titles().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TitleArray>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(TitleArray userResponse) {
                        ConnectionResponse<TitleArray> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void getSpecialities(final ConnectionListener<SpecialitiesArray> connectionListener) {
        getApi().specialities().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SpecialitiesArray>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SpecialitiesArray userResponse) {
                        ConnectionResponse<SpecialitiesArray> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void getCities(RequestBody body ,final ConnectionListener<CitiesArray> connectionListener) {
        getApi().cities(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CitiesArray>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CitiesArray userResponse) {
                        ConnectionResponse<CitiesArray> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }


    public static void verifyAccount(RequestBody body ,final ConnectionListener<VerificationResponse> connectionListener) {
        getApi().verifications(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationResponse>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(VerificationResponse userResponse) {
                        ConnectionResponse<VerificationResponse> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }
    public static void ForgetPassword(RequestBody body, final ConnectionListener<ForgetObject<ForgetPasswordModel>> connectionListener) {
        getApi().forgetPassword(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ForgetObject<ForgetPasswordModel>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ForgetObject<ForgetPasswordModel> userResponse) {
                        ConnectionResponse<ForgetObject<ForgetPasswordModel>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void CreatePassword(RequestBody body, final ConnectionListener<CreateNewPasswordModel> connectionListener) {
        getApi().createNewPass(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreateNewPasswordModel>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CreateNewPasswordModel userResponse) {
                        ConnectionResponse<CreateNewPasswordModel> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void GetAllEvents(RequestBody body, final ConnectionListener<EventsArray> connectionListener) {
        getApi().events(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EventsArray>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(EventsArray userResponse) {
                        ConnectionResponse<EventsArray> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void GetFeaturedEvents( final ConnectionListener<FeaturedEventArray> connectionListener) {
        getApi().getFeaturedEvents().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FeaturedEventArray>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FeaturedEventArray userResponse) {
                        ConnectionResponse<FeaturedEventArray> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }
    public static void getEventDetails(RequestBody body, final ConnectionListener<EventObject<EventData>> connectionListener) {
        getApi().getEvent(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EventObject<EventData>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(EventObject<EventData> userResponse) {
                        ConnectionResponse<EventObject<EventData>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }
    public static void addFav(RequestBody body, final ConnectionListener<FavResponse> connectionListener) {
        getApi().addFav(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FavResponse>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FavResponse userResponse) {
                        ConnectionResponse<FavResponse> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

}
