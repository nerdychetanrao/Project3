package com.chetan.project3_a2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements RestaurantList.RestaurantSelectedListener{

    public Boolean rotate_web_flag = false;
    private FragmentManager manager;
    private FrameLayout fc_layout, wfc_layout;

    public WebViewFragment mWebFrag = new WebViewFragment();
    public AttractionList attractions = new AttractionList();
    public RestaurantList restaurants = new RestaurantList();
    //private final Quotes mQuoteFragment = new Quotes();

    public ArrayList<ChicagoRestaurant> RestaurantList = new ArrayList<ChicagoRestaurant>();


    public static String[] mAttractionArray;
    public static String[] mURLArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRestaurants();

        mAttractionArray = getResources().getStringArray(R.array.Restaurants);
        mURLArray = getResources().getStringArray(R.array.Attractions_URL);

        fc_layout = (FrameLayout) findViewById(R.id.fragment_container);
        wfc_layout = (FrameLayout) findViewById(R.id.web_fragment_container);

        //clearBackStack();
        manager = getFragmentManager();
        manager.beginTransaction()
                .add(R.id.fragment_container, restaurants, "AttractionList")
                .addToBackStack(null)
                .commit();
        manager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (!rotate_web_flag) {
                    // Make the TitleFragment occupy the entire layout
                    fc_layout.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                    wfc_layout.setLayoutParams(new LinearLayout.LayoutParams(0,
                            LinearLayout.LayoutParams.MATCH_PARENT));
                } else {

                    // Make the TitleLayout take 1/3 of the layout's width
                    fc_layout.setLayoutParams(new LinearLayout.LayoutParams(0,
                            LinearLayout.LayoutParams.MATCH_PARENT, 1f));

                    // Make the QuoteLayout take 2/3's of the layout's width
                    wfc_layout.setLayoutParams(new LinearLayout.LayoutParams(0,
                            LinearLayout.LayoutParams.MATCH_PARENT, 2f));
                }
            }
        });

    }



    public void initRestaurants(){
        RestaurantList.add(new ChicagoRestaurant("Alinea","http://www.alinearestaurant.com/"));
        RestaurantList.add(new ChicagoRestaurant("Joe's Seafood, Prime SteakStone Crab","http://joes.net/"));
        RestaurantList.add(new ChicagoRestaurant("Oriole","http://www.oriolechicago.com/"));
        RestaurantList.add(new ChicagoRestaurant("Bavette's Bar and Boeuf","http://bavettessteakhouse.com/"));
        RestaurantList.add(new ChicagoRestaurant("The Chicago Diner", "http://www.veggiediner.com/"));
        RestaurantList.add(new ChicagoRestaurant("IO Godfrey Rooftop Lounge","http://iogodfrey.com/"));

    }

    public void onRestaurantSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
        Toast.makeText(this, "CALL BACK IN MAIN FROM : " + position, Toast.LENGTH_LONG).show();
        // If the QuoteFragment has not been added, add it now
        /*if (!mQuoteFragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = manager
                    .beginTransaction();

            // Add the QuoteFragment to the layout
            fragmentTransaction.add(R.id.web_fragment_container,
                    mQuoteFragment);

            // Add this FragmentTransaction to the backstack
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            manager.executePendingTransactions();
        }

        if (mQuoteFragment.getShownIndex() != position) {

            // Tell the QuoteFragment to show the quote string at position index
            mQuoteFragment.showQuoteAtIndex(position);

        }*/
        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            rotate_web_flag = true;
            Bundle args = new Bundle();
            args.putString("url_str", RestaurantList.get(position).url);
            WebViewFragment new_web_frag = new WebViewFragment();
            //clearBackStack();
            //Fragment fragment = manager.findFragmentByTag("WebFrag");
            //if(fragment != null)
            //manager.beginTransaction().remove(fragment).commit();
            args.putString("url_str", RestaurantList.get(position).url);
            new_web_frag.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.hide(restaurants);
            transaction.replace(R.id.web_fragment_container, new_web_frag);
            transaction.addToBackStack(null);
            transaction.commit();
            /*
            mWebFrag.setArguments(args);
                manager.beginTransaction()
                        .replace(R.id.fragment_container, attractions)
                        .replace(R.id.web_fragment_container, mWebFrag,"WebFrag")
                        .addToBackStack(null)
                        .commit();*/
        }
        else {
            // Portrait
            //updateFragment();
            //clearBackStack();
            rotate_web_flag = false;
            Bundle args = new Bundle();
            WebViewFragment new_webview_frag = new WebViewFragment();
            args.putString("url_str", RestaurantList.get(position).url);
            new_webview_frag.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new_webview_frag);

            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {

        super.onRestart();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onStop() {

        super.onStop();
    }
    private void clearBackStack() {
        manager = getFragmentManager();
        if (manager.getBackStackEntryCount() > 1) {
            System.out.println();
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Attractions:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.Restaurants:
                startActivity(new Intent(this, SecondActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
