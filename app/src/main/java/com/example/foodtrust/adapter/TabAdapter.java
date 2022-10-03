//package com.example.foodtrust.adapter;
//
//import android.content.Context;
//import android.widget.Switch;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//import com.example.foodtrust.Foodinfo_Fragment;
//import com.example.foodtrust.Needs_Fragment;
//
//public class TabAdapter extends FragmentPagerAdapter {
//    Context context;
//    int tabCount;
//
//    public TabAdapter(@NonNull FragmentManager fm, Context context, int tabCount) {
//        super(fm);
//        this.context = context;
//        this.tabCount = tabCount;
//    }
//
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position)
//        {
//            case 0:
//                Fragment f = new Foodinfo_Fragment();
//                return f;
//            case 1:
//                Fragment f = new Needs_Fragment();
//                return f ;
//        }
//        return new Needs_Fragment();
//    }
//
//    @Override
//    public int getCount() {
//        return this.tabCount;
//    }
//}
