package me.codetalk.customlistviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.codetalk.customlistviewtest.adapter.FruitAdapter;
import me.codetalk.customlistviewtest.vo.FruitVO;

public class MainActivity extends AppCompatActivity {

    private List<FruitVO> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();

        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FruitVO fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            FruitVO apple = new FruitVO("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            FruitVO banana = new FruitVO("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            FruitVO orange = new FruitVO("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            FruitVO watermelon = new FruitVO("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            FruitVO pear = new FruitVO("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            FruitVO grape = new FruitVO("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            FruitVO pineapple = new FruitVO("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            FruitVO strawberry = new FruitVO("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            FruitVO cherry = new FruitVO("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            FruitVO mango = new FruitVO("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

}
