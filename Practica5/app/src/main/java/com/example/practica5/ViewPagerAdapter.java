package com.example.practica5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

// Adaptador que gestiona los fragments del ViewPager
public class ViewPagerAdapter extends FragmentPagerAdapter {

    // Lista de fragments
    private final List<Fragment> fragmentList = new ArrayList<>();

    // Lista de títulos de los fragments
    private final List<String> fragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    // Metodo para añadir fragment y su titulo
    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    // Devuelve el fragment según la posición
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    // Devuelve el número total de fragments
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    // Devuelve el título de cada pestaña
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
