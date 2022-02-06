package services;

public interface AbstractFactory<T, S> {
    T create(S s);
}
