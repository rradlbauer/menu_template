package at.spengergasse.ui;

public interface IInputOutput <T> {
    T input() throws Exception;
    String shortInfo(T t);
    String detailInfo(T t);
}
