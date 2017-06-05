package cmu.edu.hw2rajatdem;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Title1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Title1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Title1 extends Fragment {
    private OnFragmentInteractionListener mListener;
    private TextView aboutMe;
    private TextView currTime;
    private TextView aboutDevice;
    private SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");

    public Title1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Title1.
     */
    public static Title1 newInstance() {
        Title1 fragment = new Title1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        View view = inflater.inflate(R.layout.fragment_title1, container, false);
        aboutMe = (TextView) view.findViewById(R.id.textView10);
        currTime = (TextView) view.findViewById(R.id.textView11);
        aboutDevice = (TextView) view.findViewById(R.id.textView12);

        aboutMe.setText("rajatdem");
        currTime.setText(sdf.format(new Date()));
        aboutDevice.setText("Version " + Build.VERSION.RELEASE + " API Level " + Build.VERSION.SDK_INT);

        //Loggers
        Log.i("DateTime", "["+currTime.getText()+"]");
        Log.i("Version", "Version " + Build.VERSION.RELEASE +
                " API Level " + Build.VERSION.SDK_INT);
        Log.i("Fragment1", "onCreateView successful");
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
