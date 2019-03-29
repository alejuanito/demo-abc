package pe.com.intercorp.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Your comment")
public class Client {
    @JsonIgnore
    private Integer id;
    @NotBlank
    @NotNull
    @ApiModelProperty(value = "Nombres del cliente", example = "Juan Alejandro")
    private String name;
    @NotBlank
    @NotNull
    @ApiModelProperty(value = "Apellido paterno", example = "Condori")
    private String lastName;
    @NotNull
    @Min(0)
    @Max(110)
    @ApiModelProperty(value = "Edad", example = "34")
    private Integer age;
    @NotBlank
    @NotNull
    @ApiModelProperty(value = "Fecha de nacimiento", example = "01/09/1984")
    private String birthday;
    private String deathDate;
}
