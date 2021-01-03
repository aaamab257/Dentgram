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

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MainApiInterface {

    //Auth
    @POST("Account/login")
    Observable<User<LoginData>> login(@Body RequestBody requestBody);

    @POST("Account/Register")
    Observable<User<RegisterData>> register(@Body RequestBody requestBody);


    @GET("DictionaryLocation/GetAllCountries")
    Observable<Countries> countries();

    @POST("DictionaryLocation/GetChildren")
    Observable<CitiesArray> cities(@Body RequestBody body);


    @GET("DictionaryCode/GetTitles")
    Observable<TitleArray> titles();

    @GET("DictionaryCode/GetSpecialities")
    Observable<SpecialitiesArray> specialities();

    @POST("Account/AccountVerification")
    Observable<VerificationResponse> verifications(@Body RequestBody body);


    //forget password api
    @POST("Account/ForgetPassword")
    Observable<ForgetObject<ForgetPasswordModel>> forgetPassword(@Body RequestBody body);

    //create new password
    @POST("Account/CreatePassword")
    Observable<CreateNewPasswordModel> createNewPass(@Body RequestBody body);


    //events Api


    //get All Events
    @POST("Event/GetAllEvents")
    Observable<EventsArray> events(@Body RequestBody body);

    // get Event By Id
    @POST("Event/GetEventById")
    Observable<EventObject<EventData>> getEvent(@Body RequestBody body);


    //get Featured Events
    @GET("Event/GetAllFeaturedEvents")
    Observable<FeaturedEventArray> getFeaturedEvents();

    //add to fav
    @POST("Favourite/AddFavourite")
    Observable<FavResponse> addFav(@Body RequestBody body);

}
