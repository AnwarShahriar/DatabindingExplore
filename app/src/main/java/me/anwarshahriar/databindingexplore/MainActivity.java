package me.anwarshahriar.databindingexplore;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import me.anwarshahriar.databindingexplore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        Student aStudent = new Student("Shahriar Anwar", 999);
        aStudent.setImageUrl("https://lh3.googleusercontent.com/ET01Ksz0wvjTIZD-3pWezJNQvYABuhKY8XiujK4zFJHNBMPhBv7hXxrWSLLfyhPg0oLy3OfL=w1366-h768-rw-no");

        binding.setAStudent(aStudent);
    }

    public class Student {
        private String name;
        private int age;
        private String imageUrl;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView iv, String url) {
        Glide.with(iv.getContext())
                .load(url)
                .fitCenter()
                .into(iv);
    }

}
