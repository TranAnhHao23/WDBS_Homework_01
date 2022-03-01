package cg.repository;

import cg.model.Human;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IHumanRepository extends PagingAndSortingRepository<Human,Long> {

    Page<Human> findAllByNameContaining(String name, Pageable pageable);
}
