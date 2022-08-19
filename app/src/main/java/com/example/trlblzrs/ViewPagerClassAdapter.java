package com.example.trlblzrs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerClassAdapter extends FragmentStateAdapter {

    public ViewPagerClassAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new ClassOverviewFragment();
        }else if(position == 1){
            return  new ClassPeopleFragment();
        }else{
            return new ClassChatFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
