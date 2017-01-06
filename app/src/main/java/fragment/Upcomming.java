package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.timothysurvey.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Upcomming extends Fragment {


    TextView openingDate,closingDate,surveyTopic;

    public Upcomming() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_upcomming, container, false);
        openingDate= (TextView) v.findViewById(R.id.openingdate);
        closingDate= (TextView) v.findViewById(R.id.closingdate);
        surveyTopic= (TextView) v.findViewById(R.id.upcommingSurveyTitle);

        openingDate.setText(Html.fromHtml("<font color='#058908'><big><b>Jan 31, 2017 </b></big></font><small> at  </small><font color='#058908'><big><b>  2:00 pm</b></big></big>"));
        closingDate.setText(Html.fromHtml("<font color='#c50202'><big><b>Feb 15, 2017 </b></big></font><small> at  </small><font color='#c50202'><big><b>  2:00 pm</b></big></font><big> GMT</big>"));
        return v;

    }

}
