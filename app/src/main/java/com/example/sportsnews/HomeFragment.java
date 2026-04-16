package com.example.sportsnews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Newsitem> newsList;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rvFeatured = view.findViewById(R.id.rvFeatured);
        RecyclerView rvNews = view.findViewById(R.id.rvNews);

        EditText edtSearch = view.findViewById(R.id.edtSearch);

        rvFeatured.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        rvNews.setLayoutManager(
                new GridLayoutManager(getContext(), 2)
        );

        NewsStorage.initData();
        newsList = NewsStorage.newsList;


        List<Newsitem> featuredList = new ArrayList<>();
        for (int i = 0; i < Math.min(3, newsList.size()); i++) {
            featuredList.add(newsList.get(i));
        }



        Newsadapter featuredAdapter = new Newsadapter(featuredList, item -> {
            DetailFragment detailFragment = DetailFragment.newInstance(
                    item.getTitle(),
                    item.getDescription(),
                    item.getImageResId()
            );

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .addToBackStack(null)
                    .commit();
        });


        Newsadapter newsAdapter = new Newsadapter(newsList, item -> {
            DetailFragment detailFragment = DetailFragment.newInstance(
                    item.getTitle(),
                    item.getDescription(),
                    item.getImageResId()
            );

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .addToBackStack(null)
                    .commit();
        });

        rvFeatured.setAdapter(featuredAdapter);
        rvNews.setAdapter(newsAdapter);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toLowerCase().trim();

                List<Newsitem> filteredList = new ArrayList<>();

                for (Newsitem item : NewsStorage.newsList) {
                    if (item.getCategory().toLowerCase().contains(query) ||
                            item.getTitle().toLowerCase().contains(query)) {
                        filteredList.add(item);
                    }
                }

                featuredAdapter.updateList(filteredList);
                newsAdapter.updateList(filteredList);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return view;
    }
}