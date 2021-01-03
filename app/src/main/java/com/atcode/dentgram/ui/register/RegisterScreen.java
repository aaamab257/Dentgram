package com.atcode.dentgram.ui.register;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.Cities.CitiesArray;
import com.atcode.dentgram.data.Cities.Cityitem;
import com.atcode.dentgram.data.Specialities.SpecialitiesArray;
import com.atcode.dentgram.data.Specialities.SpecialitiesItem;
import com.atcode.dentgram.data.User;
import com.atcode.dentgram.data.countries.Countries;
import com.atcode.dentgram.data.countries.CountryItem;
import com.atcode.dentgram.data.registerData.RegisterData;
import com.atcode.dentgram.data.titles.TitleArray;
import com.atcode.dentgram.data.titles.TitleItem;
import com.atcode.dentgram.databinding.FragmentRegisterScreenBinding;
import com.atcode.dentgram.utils.CustomDialog;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.ToastUtil;
import com.atcode.dentgram.utils.dialogs.DialogUtil;
import com.atcode.dentgram.utils.dialogs.DialogUtilResponse;
import com.atcode.dentgram.utils.network.MainApiBody;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;

import static android.content.ContentValues.TAG;


public class RegisterScreen extends Fragment implements RegisterListener, DialogUtilResponse {

    FragmentRegisterScreenBinding binding;
    View v;
    RegisterHandler handler;
    RegisterPresenter presenter;
    CustomDialog dialog;
    DialogUtil dialogUtil;
    boolean network;
    Countries countries;
    TitleArray titleArrays;
    SpecialitiesArray specialitiesArrays;
    CitiesArray citiesArray;
    int cityId, countryId, titleId, specialityId, phoneCodeId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_screen, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        network = StaticMethods.isConnectingToInternet(getActivity());
        if (!network) {
            binding.nested.setVisibility(View.GONE);
            binding.noNetwork.setVisibility(View.VISIBLE);
        }
        v = binding.getRoot();

        presenter = new RegisterPresenter(this, getActivity());
        dialogUtil = new DialogUtil(this);

        dialog = new CustomDialog(getActivity());

        handler = new RegisterHandler(getActivity());
        binding.setHandler(handler);


        //call api`s here
        dialog.ShowDialog();
        presenter.getCountries();
        presenter.getTitles();
        presenter.getSpecialities();
        // end


        return v;
    }

    @Override
    public void onRegisterSuccess(User<RegisterData> data) {
        dialog.DismissDialog();
        Bundle bundle = new Bundle();
        bundle.putString("userId", data.data.getId());
        Navigation.findNavController(v).navigate(R.id.action_registerScreen_to_verificationCode , bundle);
        ToastUtil.showSuccessToast(getActivity(), "Successfully");
    }

    @Override
    public void onRegisterFail(boolean error) {
        dialog.DismissDialog();
        ToastUtil.showErrorToast(getActivity(), "Server Error Please Try again");
    }

    @Override
    public void onConnection(boolean isConnection) {
        if (isConnection) {
            dialog.DismissDialog();
            ToastUtil.showErrorToast(getActivity(), "No Internet Connection");
        }
    }

    @Override
    public void onEmptyFields(boolean isEmpty) {

    }

    @Override
    public void onTitles(TitleArray array) {
        dialog.DismissDialog();
        this.titleArrays = array;

    }

    @Override
    public void onSpecialities(SpecialitiesArray specialitiesArray) {
        dialog.DismissDialog();
        this.specialitiesArrays = specialitiesArray;
    }

    @Override
    public void onCountries(Countries countries) {
        dialog.DismissDialog();
        this.countries = countries;
    }

    @Override
    public void onCities(CitiesArray cities) {
        dialog.DismissDialog();
        this.citiesArray = cities;
    }

    @Override
    public void selectedValueSingleChoice(int position) {

    }

    @Override
    public void selectedValueSingleChoice(int position, String arrayType) {
        if (arrayType.equals("country")) {
            countryId = countries.getCountries().get(position).getId();
            binding.edPhoneCode.setText(countries.getCountries().get(position).getCountryPhoneCode());
            binding.edCountry.setText(countries.getCountries().get(position).getTitle());
            Log.e(TAG, "selectedValueSingleChoice: "+countryId );
            RequestBody body = null;
            try {
                body = MainApiBody.cities(countryId);
            } catch (Exception e) {

            }
            dialog.ShowDialog();
            citiesArray = null ;
            presenter.getCities(body);
        } else if (arrayType.equals("cities")) {
            cityId = citiesArray.getCities().get(position).getId();
            binding.edCity.setText(citiesArray.getCities().get(position).getTitle());
        } else if (arrayType.equals("titles")) {
            binding.edTitle.setText(titleArrays.getTitles().get(position).getTitle());
            titleId = titleArrays.getTitles().get(position).getId();
        } else if (arrayType.equals("speciality")) {
            binding.edSpeciality.setText(specialitiesArrays.getSpecialities().get(position).getTitle());
            specialityId = specialitiesArrays.getSpecialities().get(position).getId();
        } else if (arrayType.equals("phoneCode")) {
            phoneCodeId = countries.getCountries().get(position).getId();
            binding.edPhoneCode.setText(countries.getCountries().get(position).getCountryPhoneCode());
        }
    }

    @Override
    public void selectedMultiChoicelang(ArrayList<String> choices, ArrayList<String> postions, String arrayType) {

    }

    public class RegisterHandler {
        Context context;

        public RegisterHandler(Context context) {
            this.context = context;
        }

        public void register(View v) {
            dialog.ShowDialog();
            RequestBody body = null;
            if (binding.edFirstName.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() , "Enter your first name");
            } else if (binding.edLastName.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() , "Enter your last name");
            } else if (binding.edPhone.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() , "Enter your phone");
            } else if (binding.edEmail.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() , "Enter your email");
            } else if (binding.edPass.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() , "Enter your password");
            } else if (binding.edCountry.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() , "Enter your Country");
            }  else {
                try {
                    body = MainApiBody.registerBody(binding.edEmail.getText().toString(), binding.edPhone.getText().toString(),
                            binding.edPass.getText().toString(), binding.edFirstName.getText().toString(),
                            binding.edLastName.getText().toString(), countryId, specialityId, titleId, phoneCodeId
                    );
                } catch (Exception e) {

                }
                presenter.register(body);
            }

        }

        public void login(View v) {
            Navigation.findNavController(v).navigate(R.id.action_registerScreen_to_loginScreen);
        }

        public void checkNetwork(View v) {
            boolean isNetwork = StaticMethods.isConnectingToInternet(getActivity());
            if (isNetwork) {
                binding.nested.setVisibility(View.VISIBLE);
                binding.noNetwork.setVisibility(View.GONE);
            }
        }

        public void selectCountry(View v) {
            ArrayList<String> country = new ArrayList<>();
            if (countries != null) {
                for (CountryItem item : countries.getCountries()) {
                    country.add(item.getTitle());
                }
                dialogUtil.showDialogSingleChooice(getContext(), "Select your Country", R.string.ok, country, "country");
            }

        }

        public void selectCity(View v) {
            ArrayList<String> citiesList = new ArrayList<>();
            if (citiesArray != null) {
                for (Cityitem item : citiesArray.getCities()) {
                    citiesList.add(item.getTitle());
                }
                dialogUtil.showDialogSingleChooice(getContext(), "Select your City", R.string.ok, citiesList, "cities");

            }
        }

        public void selectTitle(View v) {
            ArrayList<String> titlesList =  new ArrayList<>();
            if (titleArrays != null) {
                for (TitleItem item : titleArrays.getTitles()) {
                    titlesList.add(item.getTitle());
                }
                dialogUtil.showDialogSingleChooice(getContext(), "Select your title", R.string.ok, titlesList, "titles");

            }
        }

        public void selectSpeciality(View v) {
            ArrayList<String> specialitiesList =  new ArrayList<>();
            if (specialitiesArrays != null) {
                for (SpecialitiesItem item : specialitiesArrays.getSpecialities()) {
                    specialitiesList.add(item.getTitle());
                }
                dialogUtil.showDialogSingleChooice(getContext(), "Select your Speciality", R.string.ok, specialitiesList, "speciality");
            }

        }

        public void selectPhoneCode(View v) {
            ArrayList<String> countryCode = new ArrayList<>();
            if (countries != null) {
                for (CountryItem item : countries.getCountries()) {
                    countryCode.add(item.getCountryPhoneCode());
                }
                dialogUtil.showDialogSingleChooice(getContext(), "Phone code", R.string.ok, countryCode, "phoneCode");
            }

        }
    }
}