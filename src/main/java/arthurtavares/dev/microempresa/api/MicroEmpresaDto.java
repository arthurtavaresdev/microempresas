package arthurtavares.dev.microempresa.api;

import arthurtavares.dev.microempresa.domain.entity.MicroEmpresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MicroEmpresaDto {
    private String id;
    private String nome;
    private String cnpj;
    private String email;
    private LocalDate dataCadastro;

    public MicroEmpresaDto(MicroEmpresa microEmpresa) {
        this.id = microEmpresa.getId();
        this.nome = microEmpresa.getNome();
        this.cnpj = microEmpresa.getCnpj();
        this.email = microEmpresa.getEmail();
        this.dataCadastro = microEmpresa.getDataCadastro();
    }
}
