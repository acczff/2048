package com.example.a23988.a2048;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final private int HUADONG_MIN_OFFSET = 50;
    private int[][] number_map = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    private TextView[] tv = new TextView[16];
    private Button bt;
    private int [] r_id = {R.id.tv1, R.id.tv2, R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9,R.id.tv10,R.id.tv11,R.id.tv12,R.id.tv13,R.id.tv14,R.id.tv15,R.id.tv16};
    private int [] background_color = new int[11];
    private float down_x = 0;
    private float down_y = 0;
    private float up_x = 0;
    private float up_y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        for(int i = 0;i < r_id.length;i++){
            tv[i] = findViewById(r_id[i]);
        }
       // numberchange(number_map,4);
        random(number_map, new OnChange() {
            @Override
            public void onchusheng(int index) {
                animation(index,0);
            }

            @Override
            public void onhebing(int index) {

            }
        });
        random(number_map, new OnChange() {
            @Override
            public void onchusheng(int index) {
                animation(index,0);
            }

            @Override
            public void onhebing(int index) {

            }
        });
        for (int i = 0;i < background_color.length;i++){
            background_color[i] = Color.argb(255,238,220 - i*17,0);
        }
        set_texts_color();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0;i < number_map.length;i++){
                    for(int ii = 0;ii < number_map[i].length;ii++){
                        number_map[i][ii] = 0;
                    }
                }
                random(number_map, new OnChange() {
                    @Override
                    public void onchusheng(int index) {
                        animation(index,0);
                    }

                    @Override
                    public void onhebing(int index) {

                    }
                });
                random(number_map, new OnChange() {
                    @Override
                    public void onchusheng(int index) {
                        animation(index,0);
                    }

                    @Override
                    public void onhebing(int index) {

                    }
                });
                set_texts_color();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            down_x = event.getX();
            down_y = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            up_x = event.getX();
            up_y = event.getY();
            float offsetX = Math.abs(up_x - down_x);
            float offsetY = Math.abs(up_y - down_y);
            int [][] a = new int[number_map.length][number_map[0].length];
            if (offsetX > offsetY) {
                if (down_x - up_x > HUADONG_MIN_OFFSET) {
                    //左滑
                    //ss();
                    boolean boo = true;
                    for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            a[i][ii] = number_map[i][ii];
                        }
                    }
                    numberchange(number_map, 1, new OnChange() {
                        @Override
                        public void onchusheng(int index) {

                        }

                        @Override
                        public void onhebing(int index) {
                            animation(index,1);
                        }
                    });
                    gll:for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            if(a[i][ii] != number_map[i][ii]){
                                boo = false;
                                break gll;
                            }
                        }
                    }
                    if(boo){
                        set_texts_color();
                    }else {
                        random(number_map, new OnChange() {
                            @Override
                            public void onchusheng(int index) {
                                animation(index,0);
                            }

                            @Override
                            public void onhebing(int index) {

                            }
                        });
                        set_texts_color();
                    }
                    //ss();
                    //Log.d("aaaaa", "onTouchEvent: 左滑");
                } else if (up_x - down_x > HUADONG_MIN_OFFSET) {
                    //右划
                    //ss();
                    boolean boo = true;
                    for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            a[i][ii] = number_map[i][ii];
                        }
                    }
                    numberchange(number_map, 2, new OnChange() {
                        @Override
                        public void onchusheng(int index) {

                        }

                        @Override
                        public void onhebing(int index) {
                            animation(index,1);
                        }
                    });
                    gll:for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            if(a[i][ii] != number_map[i][ii]){
                                boo = false;
                                break gll;
                            }
                        }
                    }
                    if(boo){
                        set_texts_color();
                    }else {
                        random(number_map, new OnChange() {
                            @Override
                            public void onchusheng(int index) {
                                animation(index,0);
                            }

                            @Override
                            public void onhebing(int index) {

                            }
                        });
                        set_texts_color();
                    }
                    //ss();
                    //Log.d("aaaaa", "onTouchEvent: 右滑");
                }
            } else {
                if (down_y - up_y > HUADONG_MIN_OFFSET) {
                    //上滑
                    //ss();
                    boolean boo = true;
                    for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            a[i][ii] = number_map[i][ii];
                        }
                    }
                    numberchange(number_map, 3, new OnChange() {
                        @Override
                        public void onchusheng(int index) {

                        }

                        @Override
                        public void onhebing(int index) {
                            animation(index,1);
                        }
                    });
                    gll:for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            if(a[i][ii] != number_map[i][ii]){
                                boo = false;
                                break gll;
                            }
                        }
                    }
                    if(boo){
                        set_texts_color();
                    }else {
                        random(number_map, new OnChange() {
                            @Override
                            public void onchusheng(int index) {
                                animation(index,0);
                            }

                            @Override
                            public void onhebing(int index) {

                            }
                        });
                        set_texts_color();
                    }
                    //ss();
                    //Log.d("aaaaa", "onTouchEvent: 上滑");
                } else if (up_y - down_y > HUADONG_MIN_OFFSET) {
                    //下滑
                    //ss();
                    boolean boo = true;
                    for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            a[i][ii] = number_map[i][ii];
                        }
                    }
                    numberchange(number_map, 4, new OnChange() {
                        @Override
                        public void onchusheng(int index) {

                        }

                        @Override
                        public void onhebing(int index) {
                            animation(index,1);
                        }
                    });
                    gll:for(int i = 0;i < number_map.length;i++){
                        for(int ii = 0;ii < number_map[i].length;ii++){
                            if(a[i][ii] != number_map[i][ii]){
                                boo = false;
                                break gll;
                            }
                        }
                    }
                    if(boo){
                        set_texts_color();
                    }else {
                        random(number_map, new OnChange() {
                            @Override
                            public void onchusheng(int index) {
                                animation(index,0);
                            }

                            @Override
                            public void onhebing(int index) {

                            }
                        });
                        set_texts_color();
                    }
                    //ss();
                    //Log.d("aaaaa", "onTouchEvent: 下滑");
                }
            }
        }
        return false;
    }

    public void numberchange(int[][] number_map,int huadong_state,OnChange onChange){
        int n = 0;
        int i = 0;
        switch (huadong_state){
            case 1://左
                for(int m = 0;m < number_map.length;m++){
                    //将数字重新排列
                    while(n < number_map[m].length){
                        if(number_map[m][n] != 0){
                            number_map[m][i] = number_map[m][n];
                            if(n != i){
                                number_map[m][n] = 0;
                            }
                            i++;
                        }
                        n++;
                    }
                    i = 0;
                    n = 0;
                    //合并并重新排列
                    for(int o = 0;o < number_map[m].length - 1;o++){
                        if(number_map[m][o] == number_map[m][o + 1]){
                            number_map[m][o] *= 2;
                            onChange.onhebing(m*4+o);
                            if(o == number_map[m].length - 1){
                                number_map[m][o + 1] = 0;
                            }else {
                                for(int p = o + 1;p < number_map[m].length - 1;p++){
                                    number_map[m][p] = number_map[m][p + 1];
                                }
                                number_map[m][number_map[m].length - 1] = 0;
                            }
                        }
                    }


                }

                break;
            case 2://右
                n = number_map[0].length - 1;
                i = number_map[0].length - 1;
                for(int m = 0;m < number_map.length;m++){
                    //将数字重新排列
                    while(n >= 0){
                        if(number_map[m][n] != 0){
                            number_map[m][i] = number_map[m][n];
                            if(n != i){
                                number_map[m][n] = 0;
                            }
                            i--;
                        }
                        n--;
                    }
                    i = number_map[0].length - 1;
                    n = number_map[0].length - 1;
                    //合并并重新排列
                    for(int o = number_map[m].length - 1;o > 0;o--){
                        if(number_map[m][o] == number_map[m][o - 1]){
                            onChange.onhebing(m*4+o);
                            number_map[m][o] *= 2;
                            if(o - 1 == number_map[m].length){
                                number_map[m][o - 1] = 0;
                            }else {
                                for(int p = o - 1;p > 0;p--){
                                    number_map[m][p] = number_map[m][p - 1];
                                }
                                number_map[m][0] = 0;
                            }
                        }
                    }
                }
                break;
            case 3://上
                for(int m = 0;m < number_map[0].length;m++){
                    //将数字重新排列
                    while(n < number_map.length){
                        if(number_map[n][m] != 0){
                            number_map[i][m] = number_map[n][m];
                            if(n != i){
                                number_map[n][m] = 0;
                            }
                            i++;
                        }
                        n++;
                    }
                    i = 0;
                    n = 0;
                    //合并并重新排列
                    for(int o = 0;o < number_map.length - 1;o++){
                        if(number_map[o][m] == number_map[o + 1][m]){
                            onChange.onhebing(o*4+m);
                            number_map[o][m] *= 2;
                            if(o == number_map.length - 1){
                                number_map[o + 1][m] = 0;
                            }else {
                                for(int p = o + 1;p < number_map.length - 1;p++){
                                    number_map[p][m] = number_map[p + 1][m];
                                }
                                number_map[number_map.length - 1][m] = 0;
                            }
                        }
                    }

                }
                break;
            case 4://下
                n = number_map.length - 1;
                i = number_map.length - 1;
                for(int m = number_map[0].length - 1;m >= 0;m--){
                    //将数字重新排列
                    while(n >= 0){
                        if(number_map[n][m] != 0){
                            number_map[i][m] = number_map[n][m];
                            if(n != i){
                                number_map[n][m] = 0;
                            }
                            i--;
                        }
                        n--;
                    }
                    n = number_map.length - 1;
                    i = number_map.length - 1;
                    //合并并重新排列
                    for(int o = number_map.length - 1;o > 0;o--){
                        if(number_map[o][m] == number_map[o - 1][m]){
                            onChange.onhebing(o*4+m);
                            number_map[o][m] *= 2;
                            if(o - 1 == 0){
                                number_map[o - 1][m] = 0;
                            }else {
                                for(int p = o - 1;p > 0;p--){
                                    number_map[p][m] = number_map[p - 1][m];
                                }
                                number_map[0][m] = 0;
                            }
                        }
                    }

                }
                break;
        }
    }

    public void random(int[][] number_map,OnChange onChange){
        int [] a = new int[2];
        Random ra = new Random();
        for(int m = 0;m <number_map.length;m++){
            for(int n = 0; n < number_map[m].length;n++){
                if(number_map[m][n] == 0){
                    do{
                        a[0] = ra.nextInt(4);
                        a[1] = ra.nextInt(4);
                    }while (number_map[a[0]][a[1]] != 0);
                    int [] b = {2,4};
                    number_map[a[0]][a[1]] = b[ra.nextInt(2)];
                    onChange.onchusheng(a[0]*4+a[1]);
                    return;
                }
            }
        }
    }

    public void set_texts_color(){
        for(int m = 0;m < 4;m++){
            for(int n = 0;n < 4;n++){

                if(number_map[m][n] != 0){
                    tv[m*4+n].setText(number_map[m][n]+"");
                    int  d = (int) (Math.log(number_map[m][n]) / Math.log(2));
                    Log.d("ddd", ""+ d);
                    GradientDrawable drawable = (GradientDrawable) tv[m*4+n].getBackground();
                    drawable.setColor(background_color[d - 1]);
                }else {
                    tv[m*4+n].setText(" ");
                    GradientDrawable drawable = (GradientDrawable) tv[m*4+n].getBackground();
                    drawable.setColor(0xeeeeeeee);
                }

            }
        }
    }

    public void animation(final int n,int i){
        final ScaleAnimation animator;
        switch (i){
            case 0:
                animator = new ScaleAnimation(0.05f,1.0f,0.05f,1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animator.setDuration(200);
                tv[n].startAnimation(animator);
                break;
            case 1:
                animator = new ScaleAnimation(1.0f,1.1f,1.0f,1.1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animator.setDuration(200);
                animator.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        animation =  new ScaleAnimation(1.1f,1.0f,1.1f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                        animation.setDuration(200);
                        tv[n].startAnimation(animation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                tv[n].startAnimation(animator);
                break;
        }
    }

    public void ss(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("  \n");
        for(int i = 0;i < 4;i++){
            sb.append(Arrays.toString(number_map[i]));
            sb.append("\n");
        }
        Log.d("aaaaa", sb.toString());
    }


}
interface OnChange{
    void onchusheng(int index);

    void onhebing(int index);
}
