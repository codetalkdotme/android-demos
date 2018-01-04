package me.codetalk.databindtest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.codetalk.databindtest.databinding.ActivityMainBinding;
import me.codetalk.databindtest.entity.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        User user = new User();
        user.setName("Wang Wu");
        user.setNickName("小狗子");
        user.setEmail("wangwu@gmail.com");

        binding.setUser(user);
    }

}
