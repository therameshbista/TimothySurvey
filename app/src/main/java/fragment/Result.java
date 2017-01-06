package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.timothysurvey.R;

import java.lang.reflect.Array;

/**
 * A simple {@link Fragment} subclass.
 */
public class Result extends Fragment {

    private ListView listView;


    public Result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_result, container, false);
        listView= (ListView) v.findViewById(R.id.list_result);

        return v;
    }

}
