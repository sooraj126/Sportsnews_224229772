package com.example.sportsnews;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookmarksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookmarksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookmarksFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static BookmarksFragment newInstance(String param1, String param2) {
//        BookmarksFragment fragment = new BookmarksFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    public BookmarksFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bookmarks, container, false);

        RecyclerView rvBookmarks = view.findViewById(R.id.rvBookmarks);
        TextView txtEmpty = view.findViewById(R.id.txtEmpty);

        rvBookmarks.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Newsitem> bookmarkedList = NewsStorage.bookmarkedList;

        if (bookmarkedList.isEmpty()) {
            txtEmpty.setVisibility(View.VISIBLE);
            rvBookmarks.setVisibility(View.GONE);
        } else {
            txtEmpty.setVisibility(View.GONE);
            rvBookmarks.setVisibility(View.VISIBLE);

            Newsadapter bookmarksAdapter = new Newsadapter(bookmarkedList, item -> {
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

            rvBookmarks.setAdapter(bookmarksAdapter);
        }

        return view;
    }
}