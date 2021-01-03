package com.atcode.dentgram.utils.network;

import android.util.Log;

import androidx.annotation.NonNull;


import com.atcode.dentgram.utils.StaticMethods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import static android.content.ContentValues.TAG;

public class MainApiBody {
    private static final String JSON_TYPE = "application/json";

    @NonNull
    private static RequestBody requestBody(JSONObject jsonBody) {
        return RequestBody.create(MediaType.parse(JSON_TYPE), jsonBody.toString());
    }

    public static RequestBody loginBody(String userName, String pass) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("Username", userName);
        params.put("Password", pass);
        //params.put("FirebaseToken", fireToken);
        return requestBody(params);
    }



    public static RequestBody registerBody(String Email, String Phone,
                                           String Password, String fName, String lName, int LocationId,
                                           int SpecialityId, int TitleId , int PhoneCodeId) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("Email", Email);
        params.put("PhoneNumber", Phone);
        params.put("Password", Password);
        params.put("FirstName", fName);
        params.put("LastName", lName);
        params.put("LocationId", LocationId);
        params.put("SpecialityId", SpecialityId);
        params.put("TitleId", TitleId);
        params.put("PhoneCodeId", PhoneCodeId);
        return requestBody(params);
    }

    public static RequestBody verificationCode(String UserId, String Code) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("UserId", UserId);
        params.put("Code", Code);
        //params.put("FirebaseToken", fireToken);
        return requestBody(params);
    }

    public static RequestBody cities(int countryID) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("Id", countryID);
        return requestBody(params);
    }

    public static RequestBody verification(String UserID , String code ) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("UserId", UserID);
        params.put("Code", code);
        return requestBody(params);
    }

    public static RequestBody forgetPassword(String Email , String PhoneNumber ) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("Email", Email);
        params.put("PhoneNumber", PhoneNumber);
        return requestBody(params);
    }

    public static RequestBody createPassword(String UserId , String Password ) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("UserId", UserId);
        params.put("Password", Password);
        return requestBody(params);
    }


    public static RequestBody eventsBody(int sortedId ) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("SortBy", sortedId);
        params.put("From", "");
        params.put("To", "");
        params.put("CategoryIds", "");
        params.put("Providers", "");
        params.put("EventName", "");
        params.put("LocationName", "");
        return requestBody(params);
    }

    public static RequestBody eventById(int EventId) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("Id", EventId);
        return requestBody(params);
    }




    public static RequestBody addEventToFav(int favId) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("FavouriteType", 1);
        params.put("FavouriteId", favId);
        params.put("UserId", StaticMethods.userData.getId());
        return requestBody(params);
    }
}
