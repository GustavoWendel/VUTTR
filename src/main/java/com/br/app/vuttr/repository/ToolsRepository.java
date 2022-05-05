package com.br.app.vuttr.repository;

import com.br.app.vuttr.domain.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long> {
    List<Tools> findByTags(String tag);
}
