package com.example.foodrecipe.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.TextView;

import com.example.foodrecipe.R;
import com.example.foodrecipe.model.UserInfo;
import com.example.foodrecipe.repos.UserViewModel;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    UserViewModel userViewModel;
    UserInfo userInfo;
    TextView txtName, txtMail, txtInfo;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ConstraintLayout constraintLayout = findViewById(R.id.layout_profile);
        txtName = findViewById(R.id.txtName);
        txtInfo=  findViewById(R.id.txtInfo);
        txtMail = findViewById(R.id.txtMail);
        anim = (AnimationDrawable) constraintLayout.getBackground();
        anim.setEnterFadeDuration(2000);
        anim.setExitFadeDuration(1000);
        userInfo = new UserInfo();
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUserInfo().observe(this, new Observer<List<UserInfo>>() {
            @Override
            public void onChanged(List<UserInfo> userInfos) {
                if (userInfos.size() >= 1){
                    userInfo = userInfos.get(0);
                    txtName.setText(userInfo.getName());
                    txtMail.setText(userInfo.getLastName());
                    txtInfo.setText(userInfo.getPhoto());
                }

            }
        });
    }
}
