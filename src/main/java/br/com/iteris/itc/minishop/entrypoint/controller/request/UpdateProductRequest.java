package br.com.iteris.itc.minishop.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UpdateProductRequest {
    private UUID id;
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    private MultipartFile image;
    private String deleteImage;
    @NotBlank
    private String supplierId;
    @NotNull
    private Boolean isDiscontinued;
}
