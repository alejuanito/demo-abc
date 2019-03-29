package pe.com.intercorp.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity implements Serializable {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    @Temporal(TemporalType.DATE)
    private Date birthday;
}
