package com.technifysoft.bookapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.technifysoft.bookapp.BooksUserFragment;
import com.technifysoft.bookapp.R;
import com.technifysoft.bookapp.databinding.ActivityDashboardUserBinding;
import com.technifysoft.bookapp.models.ModelCategory;

import java.util.ArrayList;

public class dashboard_userActivity extends AppCompatActivity {

    //to show in tabs
    public ArrayList<ModelCategory> categoryArrayList;
    public ViewPagerAdapter viewPagerAdapter;

    //view binding
    private ActivityDashboardUserBinding binding;

    //firebase auth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        setupViewPagerAdapter(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        //handle click, logout
        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(dashboard_userActivity.this, MainActivity.class));
                finish();
            }
        });

        //לחיצה שתפתח את הפרופיל
        binding.profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_userActivity.this, ProfileActivity.class));
            }
        });
    }

    private void setupViewPagerAdapter(ViewPager viewPager){
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, this);

        categoryArrayList = new ArrayList<>();

        //load categories from firebase
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Categories");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //clear before adding to list
                categoryArrayList.clear();

                /*  קטגוריות עומס - סטטי, למשל. הכל, הכי נצפה וכו..,*/
                //הוסף נתונים לדגמים
                ModelCategory modelAll = new ModelCategory("01", "הכל", "", 1);
                ModelCategory modelMostViewed = new ModelCategory("02", "הכי נצפה", "", 1);
                ModelCategory modelMostDownloaded = new ModelCategory("03", "רוב ההורדות", "", 1);
                //add models to list
                categoryArrayList.add(modelAll);
                categoryArrayList.add(modelMostViewed);
                categoryArrayList.add(modelMostDownloaded);
                //הוסף נתונים כדי להציג את מתאם הביפר
                viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                        ""+modelAll.getId(),
                        ""+modelAll.getCategory(),
                        ""+modelAll.getUid()
                ), modelAll.getCategory());
                viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                        ""+modelMostViewed.getId(),
                        ""+modelMostViewed.getCategory(),
                        ""+modelMostViewed.getUid()
                ), modelMostViewed.getCategory());
                viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                        ""+modelMostDownloaded.getId(),
                        ""+modelMostDownloaded.getCategory(),
                        ""+modelMostDownloaded.getUid()
                ), modelMostDownloaded.getCategory());
                //refresh list
                viewPagerAdapter.notifyDataSetChanged();

                //כעת טען מ-firebase
                for (DataSnapshot ds: snapshot.getChildren()){
                    //get data
                    ModelCategory model = ds.getValue(ModelCategory.class);
                    //הוספה לרשימה
                    categoryArrayList.add(model);
                    //add data to viewPagerAdapter
                    viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                            ""+model.getId(),
                            ""+model.getCategory(),
                            ""+model.getUid()), model.getCategory());
                    //רשימה לרענון
                    viewPagerAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        //הגדר מתאם לצפייה בביפר
        viewPager.setAdapter(viewPagerAdapter);

    }

    public class ViewPagerAdapter extends FragmentPagerAdapter{

        private ArrayList<BooksUserFragment> fragmentList = new ArrayList<>();
        private ArrayList<String> fragmentTitleList = new ArrayList<>();
        private Context context;

        public ViewPagerAdapter(FragmentManager fm, int behavior, Context context) {
            super(fm, behavior);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        private void addFragment(BooksUserFragment fragment, String title){
            //הוסף fragment שהועבר כפרמטר ב-fragmentList
            fragmentList.add(fragment);
            //הוסף כותרת שהועבר כפרמטר ב-fragmentTitleList
            fragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }


    private void checkUser() {
        //get current user
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser==null){
            //not logged in
            binding.subTitleTv.setText("לא מחובר");
        }
        else {
            //logged in, get user info
            String email = firebaseUser.getEmail();
            //set in textview of toolbar
            binding.subTitleTv.setText(email);
        }
    }

}

