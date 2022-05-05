package com.br.app.vuttr.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolsDTO {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String link;

    @NotEmpty
    private String description;

    @NotEmpty
    private List<String> tags;
}
