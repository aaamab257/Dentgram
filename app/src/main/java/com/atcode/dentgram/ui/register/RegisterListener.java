package com.atcode.dentgram.ui.register;

import com.atcode.dentgram.data.Cities.CitiesArray;
import com.atcode.dentgram.data.Specialities.SpecialitiesArray;
import com.atcode.dentgram.data.User;
import com.atcode.dentgram.data.countries.Countries;
import com.atcode.dentgram.data.registerData.RegisterData;
import com.atcode.dentgram.data.titles.TitleArray;

public interface RegisterListener {
    void onRegisterSuccess(User<RegisterData> data);
    void onRegisterFail(boolean error);
    void onConnection(boolean isConnection);
    void onEmptyFields(boolean isEmpty);

    //other api's
    void onTitles(TitleArray array);
    void onSpecialities(SpecialitiesArray specialitiesArray);
    void onCountries(Countries countries);
    void onCities(CitiesArray cities);
}
