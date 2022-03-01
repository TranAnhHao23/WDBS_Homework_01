package cg.service;

import cg.model.Human;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHumanService {

    Page<Human> findAll(Pageable pageable);

    Human save(Human human);

    Human findById(Long id);

    void deleteById(Long id);

    Page<Human> findAllByNameContaining(String name, Pageable pageable);
}
