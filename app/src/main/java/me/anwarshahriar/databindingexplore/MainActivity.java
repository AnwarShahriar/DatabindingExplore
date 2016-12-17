package me.anwarshahriar.databindingexplore;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.PropertyChangeRegistry;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import me.anwarshahriar.databindingexplore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        final Student aStudent = new Student("Shahriar Anwar", 999);
        aStudent.setImageUrl("https://lh3.googleusercontent.com/ET01Ksz0wvjTIZD-3pWezJNQvYABuhKY8XiujK4zFJHNBMPhBv7hXxrWSLLfyhPg0oLy3OfL=w1366-h768-rw-no");

        binding.setAStudent(aStudent);
    }

    public class Student implements Observable {
        private PropertyChangeRegistry registry = new PropertyChangeRegistry();
        private String name;
        private int age;
        private String imageUrl;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
            registry.notifyChange(this, BR.name);
        }

        @Bindable
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

        @Override
        public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
            registry.add(onPropertyChangedCallback);
        }

        @Override
        public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
            registry.remove(onPropertyChangedCallback);
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
