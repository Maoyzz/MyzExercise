package com.myz.myzexercise.Practice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myz.myzexercise.R;

import java.util.Hashtable;

public class Fragment_test1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test1,container,false);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        return view;
    }

    private void test(){

    }
}
