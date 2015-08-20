package mx.com.alex.crazycards.fragments;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import mx.com.alex.crazycards.R;
import mx.com.alex.crazycards.models.Verb;


public class GameFragment extends Fragment {

    private ArrayList<Verb> verbs;
    TextView verbEnglish;
    LinearLayout layoutOne;
    LinearLayout layoutTwo;
    LinearLayout layoutThree;
    LinearLayout layoutFour;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verbs = Verb.getVerbs(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        verbEnglish = (TextView) view.findViewById(R.id.txtVerb);
        layoutOne = (LinearLayout) view.findViewById(R.id.layoutOne);
        layoutTwo = (LinearLayout) view.findViewById(R.id.layoutTwo);
        layoutThree = (LinearLayout) view.findViewById(R.id.layoutThree);
        layoutFour= (LinearLayout) view.findViewById(R.id.layoutFour);




        return view;
    }

    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    private void showVerb () throws IOException {
        // Random number from 1 to 15
        Random r = new Random();
        int i1 = r.nextInt(1 - 1) + 1;

        Verb verb = verbs.get(i1);
        verbEnglish.setText(verb.getVerbEnglish());
        Drawable imagen = new BitmapDrawable(getActivity().getResources(),Picasso.with(getActivity()).load(verb.getUrlImgTrue()).get());
        layoutOne.setBackgroundDrawable(imagen);


    }
}
