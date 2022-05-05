package com.br.app.vuttr.service.impl;

import com.br.app.vuttr.domain.Tools;
import com.br.app.vuttr.exception.NotFoundException;
import com.br.app.vuttr.repository.ToolsRepository;
import com.br.app.vuttr.service.ToolsServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToolsServiceImpl implements ToolsServiceCustom {
    private final ToolsRepository repository;

    @Autowired
    public ToolsServiceImpl(ToolsRepository repository) {
        this.repository = repository;
    }

    public Tools save(Tools tools) {
        return this.repository.save(tools);
    }

    @Override
    public Optional<Tools> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Tools tools) {
        if(tools == null || tools.getId() == null) {
            throw new IllegalArgumentException("Book id can't be null.");
        }
        this.repository.delete(tools);
    }

    @Override
    public Tools update(Tools tools) {
        if(tools == null || tools.getId() == null) {
            throw new IllegalArgumentException("Book id can't be null.");
        }
       return this.repository.save(tools);
    }

    @Override
    public List<Tools> findByTag(String tag) {
        List<Tools> tags = repository.findByTags(tag);
        if (tags.isEmpty()){
            throw new NotFoundException("Tag not found");
        }
        return tags;
    }
}
