package arthurtavares.dev.microcompany.domain.entity;

import arthurtavares.dev.microcompany.api.MicroCompanyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;

@Data
@With // builder pattern
@AllArgsConstructor
@NoArgsConstructor
public class MicroCompany
{
    @Id
    private String id;

    private String name;
    private String document;
    private String email;
    private LocalDate createdAt;

    public MicroCompany(MicroCompanyDto microCompanyto)
    {
        this.name = microCompanyto.getName();
        this.document = microCompanyto.getDocument();
        this.email = microCompanyto.getEmail();
        this.createdAt = LocalDate.now();
    }
}
