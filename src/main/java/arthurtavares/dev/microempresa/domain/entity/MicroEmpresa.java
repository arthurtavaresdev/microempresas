package arthurtavares.dev.microempresa.domain.entity;

import arthurtavares.dev.microempresa.api.MicroEmpresaDto;
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
public class MicroEmpresa
{
    @Id
    private String id;

    private String nome;
    private String cnpj;
    private String email;
    private LocalDate dataCadastro;

    public MicroEmpresa(MicroEmpresaDto microEmpresaDto)
    {
        this.nome = microEmpresaDto.getNome();
        this.cnpj = microEmpresaDto.getCnpj();
        this.email = microEmpresaDto.getEmail();
        this.dataCadastro = LocalDate.now();
    }
}
