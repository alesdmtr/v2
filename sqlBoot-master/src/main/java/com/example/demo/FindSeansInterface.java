package com.example.demo;
import com.example.demo.Seans;
import java.util.List;

    public interface FindSeansInterface {

        List<Seans> findAll();
        Seans findById(Long id);
        void insertSeans(String name, String zal, String time);

        void deleteById(long parseLong);
    }

