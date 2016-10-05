package com.raywenderlich.alltherages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by miked on 10/4/2016.
 */
//RageComicDetailsFragment inherits attributes of Fragment class
public class RageComicDetailsFragment extends Fragment {

    private static final String ARGUMENT_IMAGE_RES_ID = "imageResId";
    private static final String ARGUMENT_NAME = "name";
    private static final String ARGUMENT_DESCRIPTION = "description";
    private static final String ARGUMENT_URL = "url";

    public static RageComicDetailsFragment newInstance(int imageResId, String name,
                                                       String description, String url) {
        //create a bundle of arguents(key-value pairs) for the image, name Textview, description
        //Textview, and url
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_IMAGE_RES_ID, imageResId);
        args.putString(ARGUMENT_NAME, name);
        args.putString(ARGUMENT_DESCRIPTION, description);
        args.putString(ARGUMENT_URL, url);
        //set arguments and return the RageComicDetails Fragment
        final RageComicDetailsFragment fragment = new RageComicDetailsFragment();
        //once you have an empty fragment, set the arguments
        fragment.setArguments(args);
        return fragment;

    }
    //used when fragment is re-created
    public RageComicDetailsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //set inflater to false, frgmanet manager will add the fragment to the container
        final View view = inflater.inflate(R.layout.fragment_rage_comic_details, container, false);
        //image and text views for the images, a neame display, and a description of each
        final ImageView imageView = (ImageView) view.findViewById(R.id.comic_image);
        final TextView nameTextView = (TextView) view.findViewById(R.id.name);
        final TextView descriptionTextView = (TextView) view.findViewById(R.id.description);
        //get the arguments for the view and return it
        final Bundle args = getArguments();
        imageView.setImageResource(args.getInt(ARGUMENT_IMAGE_RES_ID));
        nameTextView.setText(args.getString(ARGUMENT_NAME));
        final String text = String.format(getString(R.string.description_format), args.getString(
                ARGUMENT_DESCRIPTION), args.getString(ARGUMENT_URL));
        return view;


    }
}
