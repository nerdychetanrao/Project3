package com.chetan.project3_a2;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantList extends ListFragment implements AdapterView.OnItemClickListener {
    RestaurantSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface RestaurantSelectedListener {
         void onRestaurantSelected(int position);
    }
    
    public ArrayList<RestaurantList> RestList = new ArrayList<RestaurantList>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain this Fragment across Activity reconfigurations
        setRetainInstance(true);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.attraction_list_fragment, container, false);
        //return view;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Restaurants, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (RestaurantSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement RestaurantSelectedListener");
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Send the event to the host activity
        mCallback.onRestaurantSelected(position);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        view.setSelected(true);
        view.getFocusables(position);
        mCallback.onRestaurantSelected(position);

    }
    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();

    }


    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void onStart() {

        super.onStart();
    }

    @Override
    public void onStop() {

        super.onStop();
    }

}
