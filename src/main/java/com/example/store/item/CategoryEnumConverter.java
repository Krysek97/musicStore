package com.example.store.item;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryEnumConverter implements Converter <String,Category> {

    @Override
    public Category convert(String source) {
        return Category.valueOf(source.toUpperCase());
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Category, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
