package br.com.iteris.itc.minishop.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class StoreProductRequest {
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    private MultipartFile image;
    @NotBlank
    private String supplierId;
}
