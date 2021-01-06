package com.example.groceryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

//    private int[] nimaages=new int[]{
//            R.drawable.fruit3,R.drawable.veg1,R.drawable.gro1,R.drawable.gro2,R.drawable.snack1
//    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        //for carousal view
//        CarouselView carouselView=view.findViewById(R.id.home_page_carouselview);
//        carouselView.setPageCount(nimaages.length);
//        carouselView.setImageListener(new ImageListener() {
//            @Override
//            public void setImageForPosition(int position, ImageView imageView) {
//                imageView.setImageResource(nimaages[position]);
//            }
//        });

        return view;

    }
}