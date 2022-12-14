package com.example.trlblzrs;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    ImageView imgGallery;
    ActivityResultLauncher<String> profilepic;
    TextView name;

//    private CircleImageView profilePic;
   private EditText full_name,email;
    private Button saveButton;
//    private ImageButton profileChangeBtn;

//    private DatabaseReference databaseReference;
//    private FirebaseAuth mAuth;

//    private Uri imageUri;
//    private String myUri = "";
//    private StorageTask uploadTask;
//    private StorageReference storageProfilePicsRef;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
//    private static final String NAME_KEY = "names";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//    private String mName;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
//     * @param names Parameter 3.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2
//            ,String names
    ) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
//        args.putString(NAME_KEY, names);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
//            mName = getArguments().getString(NAME_KEY);
//            name.setText(mName);
        }

//        mAuth = FirebaseAuth.getInstance();
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
//        storageProfilePicsRef = FirebaseStorage.getInstance().getReference().child("Profile Pic");

//        profilePic = getView().findViewById(R.id.cimgview);
//
//        saveButton = getView().findViewById(R.id.saveBtn);
//
//
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                uploadProfileImage();
//            }
//        });







    }
//    private void uploadProfileImage() {
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putCharSequence(NAME_KEY,name.getText());
//    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgGallery = view.findViewById(R.id.cimgview);
        full_name = view.findViewById(R.id.editName);
        name = view.findViewById(R.id.nameDisplay);
        saveButton = view.findViewById(R.id.saveBtn);
        name.setText(full_name.getText());
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText(full_name.getText());
            }
        });

        ImageView editImg = view.findViewById(R.id.imgEditBtn);

        profilepic = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {




                    @Override
                    public void onActivityResult(Uri result) {

                        if(result!=null) {
                            imgGallery.setImageURI((result));
                        }



                    }
                }
        );
        editImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                profilepic.launch("image/*");



            }
        });
    }
}