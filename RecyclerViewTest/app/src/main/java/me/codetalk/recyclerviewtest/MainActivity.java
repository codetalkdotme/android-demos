package me.codetalk.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.codetalk.recyclerviewtest.adapter.FruitAdapter;
import me.codetalk.recyclerviewtest.vo.FruitVO;

public class MainActivity extends AppCompatActivity {

    private List<FruitVO> fruitList = new ArrayList<>();

    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }


    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            FruitVO apple = new FruitVO(getRandomLengthName("Apple"), R.drawable.apple_pic);
            fruitList.add(apple);
            FruitVO banana = new FruitVO(getRandomLengthName("Banana"), R.drawable.banana_pic);
            fruitList.add(banana);
            FruitVO orange = new FruitVO(getRandomLengthName("Orange"), R.drawable.orange_pic);
            fruitList.add(orange);
            FruitVO watermelon = new FruitVO(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            FruitVO pear = new FruitVO(getRandomLengthName("Pear"), R.drawable.pear_pic);
            fruitList.add(pear);
            FruitVO grape = new FruitVO(getRandomLengthName("Grape"), R.drawable.grape_pic);
            fruitList.add(grape);
            FruitVO pineapple = new FruitVO(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            FruitVO strawberry = new FruitVO(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            FruitVO cherry = new FruitVO(getRandomLengthName("Cherry"), R.drawable.cherry_pic);
            fruitList.add(cherry);
            FruitVO mango = new FruitVO(getRandomLengthName("Mango"), R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {
        StringBuffer buf = new StringBuffer();
        int len = rand.nextInt(10) + 1;
        for(int i = 0; i < len; i++) {
            buf.append(name);
        }

        return buf.toString();
    }

}
