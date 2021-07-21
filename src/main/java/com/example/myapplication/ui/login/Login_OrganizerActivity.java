//package com.example.myapplication.ui.login;
//
//import android.app.Activity;
//
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.annotation.StringRes;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.inputmethod.EditorInfo;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.myapplication.R;
//import com.example.myapplication.ui.login.LoginViewModel;
//import com.example.myapplication.ui.login.LoginViewModelFactory;
//
//public class Login_OrganizerActivity extends AppCompatActivity {
//
//    private LoginViewModel loginViewModel;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_organizer_login);
//        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);
//
//        final EditText usernameEditText = findViewById(R.id.username);
//        final EditText passwordEditText = findViewById(R.id.password);
//        final Button loginButton = findViewById(R.id.signin);
//        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
//
//        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
//            @Override
//            public void onChanged(@Nullable LoginFormState loginFormState) {
//                if (loginFormState == null) {
//                    return;
//                }
//                loginButton.setEnabled(loginFormState.isDataValid());
//                if (loginFormState.getUsernameError() != null) {
//                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
//                }
//                if (loginFormState.getPasswordError() != null) {
//                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
//                }
//            }
//        });
//
//        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
//            @Override
//            public void onChanged(@Nullable LoginResult loginResult) {
//                if (loginResult == null) {
//                    return;
//                }
//                loadingProgressBar.setVisibility(View.GONE);
//                if (loginResult.getError() != null) {
//                    showLoginFailed(loginResult.getError());
//                }
//                if (loginResult.getSuccess() != null) {
//                    updateUiWithUser(loginResult.getSuccess());
//                }
//                setResult(Activity.RESULT_OK);
//
//                //Complete and destroy login activity once successful
//                finish();
//            }
//        });
//
//        TextWatcher afterTextChangedListener = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // ignore
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // ignore
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        };
//        usernameEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    loginViewModel.login(usernameEditText.getText().toString(),
//                            passwordEditText.getText().toString());
//                }
//                return false;
//            }
//        });
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingProgressBar.setVisibility(View.VISIBLE);
//                loginViewModel.login(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        });
//    }
//
//    private void updateUiWithUser(LoggedInUserView model) {
//        String welcome = getString(R.string.welcome) + model.getDisplayName();
//        // TODO : initiate successful logged in experience
//        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//    }
//
//    private void showLoginFailed(@StringRes Integer errorString) {
//        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
//    }
//}

package com.example.myapplication.ui.login;
//
//import android.app.Activity;
//
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.annotation.StringRes;
//import androidx.appcompat.app.AppCompatActivity;
//
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.OrganizerIndexActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Login_OrganizerActivity extends AppCompatActivity {
    public int organizerCount;
    public ArrayList<user_organizer> user_organizer_group;

    private TextView userid;
    private TextView password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_login);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user_organizer_group = (ArrayList<user_organizer>)bundle.getSerializable("organizerAccount");
        organizerCount = intent.getIntExtra("organizerCount", 0);

        userid = findViewById(R.id.username);
        password = findViewById(R.id.userpassword);
    }

    public void signin(View v)
    {
        int index = check();
        if(index >= 0)
        {
            user_organizer loginAccount = user_organizer_group.get(index);

            Intent intent = new Intent(Login_OrganizerActivity.this, OrganizerIndexActivity.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("organizerAccount", loginAccount);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "帳號密碼有誤，請重新輸入", Toast.LENGTH_SHORT).show();
    }

    private int check(){
        for(int i = 0; i < user_organizer_group.size(); i++)
        {
            if(userid.getText().toString().equals(user_organizer_group.get(i).userid) && password.getText().toString().equals(user_organizer_group.get(i).password))
                return i;
        }
        return -1;
    }

    public void gotosignup_o(View v){
        Intent intent = new Intent(Login_OrganizerActivity.this, Signup_OrganizerActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("organizerAccount", user_organizer_group);
        intent.putExtra("organizerCount", organizerCount);
        intent.putExtras(bundle);

        startActivity(intent);
    }

}