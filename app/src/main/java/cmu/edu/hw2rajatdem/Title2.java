package cmu.edu.hw2rajatdem;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Title2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Title2 extends Fragment {
    private ListView mListView;
    private ArrayAdapter mAdapter;
    private static ArrayList<String> eventList = new ArrayList();

    static {
        eventList.add(0, "Kick-Off Rallye \n"+
                "Sunday, July 2" + " at TBD");
        eventList.add(1, "Blacktie & Tailpipes Gala \n" +
                "Friday, July 7"+" at TBD");
        eventList.add(2, "Historics at Pitt Race\n" +
                "Weekend, July 7-9" +" at Pittsburgh International Race Complex");
        eventList.add(3, "Walnut Street Car Show\n" +
                "Monday, July 10 at Walnut Street");
        eventList.add(4, "Waterfront Car Cruise\n" +
                "Tuesday, July 11 at Waterfront");
        eventList.add(5, "Downtown Parade & Car Display\n" +
                "Wednesday, July 12 at Downtown");
        eventList.add(6, "Tune-Up Party @ Atria's\n" +
                "Wednesday, July 12 at Downtown");
        eventList.add(7, "Countryside Tour\n" +
                "Thursday, July 13 at TBD");
        eventList.add(8, "Forbes Ave of Speed Race Car Parade" +
                "Thursday, July 14 Forbes Avenue to Squirrel Hill");
    }

    private OnFragmentInteractionListener mListener;

    public Title2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, eventList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int position;
        View view = inflater.inflate(R.layout.fragment_title2, container, false);
        //set the Adapter
        mListView = (ListView) view.findViewById(android.R.id.list);
        position = mListView.getPositionForView(view);
        if (position % 2 == 1){
            view.setBackgroundColor(Color.GRAY);
        } else{
            view.setBackgroundColor(Color.WHITE);
        }
        mListView.setAdapter(mAdapter);
        Log.i("Fragment2", "onCreateView successful");
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
