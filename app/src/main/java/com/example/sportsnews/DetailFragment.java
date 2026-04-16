package com.example.sportsnews;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    public interface OnItemClickListener {
        void onItemClick(Newsitem item);
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String title, String description, int imageResId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("description", description);
        args.putInt("imageResId", imageResId);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
////    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ImageView imgDetail = view.findViewById(R.id.imgDetail);
        TextView txtDetailTitle = view.findViewById(R.id.txtDetailTitle);
        TextView txtDetailDescription = view.findViewById(R.id.txtDetailDescription);

        Button btnBookmark = view.findViewById(R.id.btnBookmark);
        RecyclerView rvRelatedStories = view.findViewById(R.id.rvRelatedStories);



        String title = "";
        String description = "";
        int imageResId = 0;

        if (getArguments() != null) {
            title = getArguments().getString("title");
            description = getArguments().getString("description");
            imageResId = getArguments().getInt("imageResId");

            txtDetailTitle.setText(title);
            txtDetailDescription.setText(description);
            imgDetail.setImageResource(imageResId);
        }


        String finalTitle = title;
        String finalDescription = description;
        int finalImageResId = imageResId;

        btnBookmark.setOnClickListener(v -> {
            Newsitem bookmarkedItem = new Newsitem(
                    finalTitle,
                    finalDescription,
                    "Bookmarked",
                    finalImageResId
            );

            boolean alreadyExists = false;

            for (Newsitem item : NewsStorage.bookmarkedList) {
                if (item.getTitle().equals(finalTitle)) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                NewsStorage.bookmarkedList.add(bookmarkedItem);
                Toast.makeText(getContext(), "News bookmarked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Already bookmarked", Toast.LENGTH_SHORT).show();
            }
        });

        rvRelatedStories.setLayoutManager(new GridLayoutManager(getContext(), 2));


        NewsStorage.initData();
        List<Newsitem> relatedList = NewsStorage.newsList;

        Newsadapter relatedAdapter = new Newsadapter(relatedList, item -> {
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

        rvRelatedStories.setAdapter(relatedAdapter);

        return view;
    }
}