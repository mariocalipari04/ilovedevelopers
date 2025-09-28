package com.unimib.ilovedevelopers.ui.welcome.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.ui.welcome.LoginActivity;

import org.apache.commons.validator.routines.EmailValidator;

public class LoginFragment extends Fragment {


    public static final String TAG = LoginActivity.class.getName();
    private TextInputEditText editTextEmail, editTextPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextEmail = view.findViewById(R.id.filledEmail);
        editTextPassword = view.findViewById(R.id.fillePassword);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            if (true) {
                if(true){
                    Log.d(TAG, " Email: " + editTextEmail.getText() + " Password: " + editTextPassword.getText());
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_pickCountryFragment);
                }else {
                    Log.d(TAG, "errore nell'autenticazione");
                    editTextPassword.setError("Tha password must have at least 8 chars");
                    Snackbar.make(view.findViewById(android.R.id.content), "Check your password", Snackbar.LENGTH_SHORT).show();
                }
            }else {
                Log.d(TAG, "errore nell'autenticazione");
                Snackbar.make(view.findViewById(android.R.id.content), "Check your email", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isEmailOk(String email){
        return  EmailValidator.getInstance().isValid(email);
    }

    private boolean isPasswordOk(String password){
        return password.length() > 7;
    }

}