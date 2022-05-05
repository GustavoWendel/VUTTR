package com.br.app.vuttr.service;

import com.br.app.vuttr.domain.Tools;

import java.util.List;
import java.util.Optional;

public interface ToolsServiceCustom {
    Tools save(Tools tools);

    Optional<Tools> getById(Long id);

    void delete(Tools tools);

    Tools update(Tools tools);

    List<Tools> findByTag(String tag);
}
