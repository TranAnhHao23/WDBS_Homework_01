package cg.service;

import cg.model.Human;
import cg.repository.IHumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HumanServiceImpl implements IHumanService {

    @Autowired
    private IHumanRepository humanRepository;

    @Override
    public Page<Human> findAll(Pageable pageable) {
        return humanRepository.findAll(pageable);
    }

    @Override
    public Human save(Human human) {
        return humanRepository.save(human);
    }

    @Override
    public Human findById(Long id) {
        if (humanRepository.findById(id).isPresent()){
            return humanRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        humanRepository.deleteById(id);
    }

    @Override
    public Page<Human> findAllByNameContaining(String name, Pageable pageable) {
        return humanRepository.findAllByNameContaining(name, pageable);
    }
}
