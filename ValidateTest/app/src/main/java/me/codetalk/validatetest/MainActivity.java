package me.codetalk.validatetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements Validator.ValidationListener, View.OnClickListener {

    @BindView(R.id.btn_validate)
    Button btnValidate;

    @BindView(R.id.input_email)
    @Email
    @NotEmpty
    EditText inputEmail;

    @BindView(R.id.input_passwd)
    @Password(min = 6, scheme = Password.Scheme.ALPHA_MIXED_CASE, messageResId = R.string.passwd_requirement)
    EditText inputPasswd;

    @BindView(R.id.input_passwd_confirm)
    @ConfirmPassword
    EditText inputPasswdConfirm;

    @BindView(R.id.chk_agree)
    @Checked(messageResId = R.string.agree_must)
    CheckBox chkAgree;

    Validator validator;
    private boolean validated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        validator = new Validator(this);
//        validator.setValidationMode(Validator.Mode.IMMEDIATE); // @Order must be used under this MODE
        validator.setValidationListener(this);

        // button
        btnValidate.setOnClickListener(this);
    }

    @Override
    public void onValidationSucceeded() {
        validated = true;
        Toast.makeText(this, "You made it!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        validated = false;
        for(ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if(view instanceof EditText) {
                ((EditText)view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        validator.validate();
        if(validated) {
//            Toast.makeText(this, "Hi Hi Hiiii, hi!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
