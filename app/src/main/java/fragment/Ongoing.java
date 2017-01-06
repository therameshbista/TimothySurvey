package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.timothysurvey.R;
import com.example.user.timothysurvey.activity.Introduction;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ongoing extends Fragment {


    Button proceed;
    EditText email;
    TextView surveyTitle;

    public Ongoing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_ongoing, container, false);
        surveyTitle= (TextView) v.findViewById(R.id.surveyTitle);
        email= (EditText) v.findViewById(R.id.email);
        proceed= (Button) v.findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = email.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (emailAddress.matches(emailPattern)){
                    startActivity(new Intent(getContext(), Introduction.class));
                }else
                    email.setText("wrong email address");
            }
        });
        return v;
    }

}
