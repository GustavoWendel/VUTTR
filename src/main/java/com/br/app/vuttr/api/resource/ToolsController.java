package com.br.app.vuttr.api.resource;

import com.br.app.vuttr.api.dto.ToolsDTO;
import com.br.app.vuttr.domain.Tools;
import com.br.app.vuttr.service.ToolsServiceCustom;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tools")
public class ToolsController {
    private final ToolsServiceCustom service;
    private final ModelMapper mapper;

    public ToolsController(ToolsServiceCustom service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToolsDTO create(@RequestBody @Valid ToolsDTO dto) {
        Tools entity = mapper.map(dto, Tools.class);
        entity = service.save(entity);
        return mapper.map(entity, ToolsDTO.class);
    }

    @GetMapping("{id}")
    public ToolsDTO get(@PathVariable Long id) {
        return service
                .getById(id)
                .map(tools -> mapper.map(tools, ToolsDTO.class))
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        Tools tools = service.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        service.delete(tools);
    }

    @PutMapping("{id}")
    public ToolsDTO uptade(@PathVariable Long id, @RequestBody @Valid ToolsDTO dto) {
        return service.getById(id).map(tools -> {
            tools.setTitle(dto.getTitle());
            tools.setLink(dto.getLink());
            tools.setDescription(dto.getDescription());
            tools.setTags(dto.getTags());

            service.update(tools);

            return mapper.map(tools, ToolsDTO.class);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
