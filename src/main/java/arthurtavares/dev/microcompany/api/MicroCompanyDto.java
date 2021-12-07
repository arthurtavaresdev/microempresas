package arthurtavares.dev.microcompany.api;

import arthurtavares.dev.microcompany.domain.entity.MicroCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MicroCompanyDto {
    private String id;
    private String name;
    private String document;
    private String email;
    private LocalDate createdAt;

    public MicroCompanyDto(MicroCompany microEmpresa) {
        this.id = microEmpresa.getId();
        this.name = microEmpresa.getName();
        this.document = microEmpresa.getDocument();
        this.email = microEmpresa.getEmail();
        this.createdAt = LocalDate.now();
    }
}
