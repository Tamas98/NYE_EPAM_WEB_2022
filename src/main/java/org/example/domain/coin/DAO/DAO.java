package org.example.domain.coin.DAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(Long id);
    List<T> getAll();
    void save(T toSave);
    void deleteById(Long id);
    void saveAll(List<T> toSave);
}
