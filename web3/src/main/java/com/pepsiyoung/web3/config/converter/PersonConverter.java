package com.pepsiyoung.web3.config.converter;

import com.pepsiyoung.web3.entity.Bar;
import com.pepsiyoung.web3.entity.Foo;
import com.pepsiyoung.web3.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.NonNull;

public class PersonConverter implements ConverterFactory<String, Person> {

    @NonNull
    @Override
    public <T extends Person> Converter<String, T> getConverter(@NonNull Class<T> targetType) {
        return new StringToPerson<>(targetType);
    }

    private static final class StringToPerson<T extends Person> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToPerson(Class<T> targetType) {
            this.targetType = targetType;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T convert(String source) {
            String[] split = source.split("-");
            if (Foo.class == targetType) {
                return (T) new Foo(split[0], Integer.valueOf(split[1]));
            } else if (Bar.class == targetType) {
                return (T) new Bar(split[0], Integer.valueOf(split[1]));
            }
            return null;
        }
    }
}
