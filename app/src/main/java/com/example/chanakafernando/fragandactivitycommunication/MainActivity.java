package com.example.chanakafernando.fragandactivitycommunication;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private String dataToBeSent1 = "Chanaka => This String was passed from MainActivity";
    private String dataToBeSent2 = "Fenando => This String was passed from MainActivity";
    private RotateFragment rotateFragment ;
    private AdjustFragment adjustFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_rotate) {
                    if(rotateFragment == null) {
                        rotateFragment = RotateFragment.newInstance(dataToBeSent1, dataToBeSent2);
                    }
                    replaceFragment(rotateFragment, "RotateFragment");
                } else if(tabId == R.id.tab_account){
                    if(accountFragment == null){
                        accountFragment = new AccountFragment();
                    }
                    replaceFragment(accountFragment,"AccountFragment");
                } else {
                    if(adjustFragment == null){
                        adjustFragment = new AdjustFragment();
                    }
                    replaceFragment(adjustFragment,"Adjest Fragment");
                }

            }
        });
    }

    public void replaceFragment(Fragment fragment, String tag) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.contentContainer, fragment, tag).commit();

        } catch (Exception e) {
            Log.d("TAG", e.toString());
        }

    }
}
