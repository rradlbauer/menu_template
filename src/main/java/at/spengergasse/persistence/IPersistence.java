package at.spengergasse.persistence;

import java.util.List;

public interface IPersistence <T>{
    void save(List<T> list) throws Exception;
    List<T> load() throws Exception;
}
