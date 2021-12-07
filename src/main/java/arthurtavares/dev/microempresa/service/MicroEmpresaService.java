package arthurtavares.dev.microempresa.service;

import arthurtavares.dev.microempresa.exception.NotFoundException;
import arthurtavares.dev.microempresa.domain.entity.MicroEmpresa;
import arthurtavares.dev.microempresa.domain.repository.MicroEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicroEmpresaService {
    private final MicroEmpresaRepository microempresaRepository;

    public MicroEmpresaService(MicroEmpresaRepository microempresaRepository){
        this.microempresaRepository = microempresaRepository;
    }

    public MicroEmpresa create(MicroEmpresa microempresa){
        microempresaRepository.save(microempresa);
        return microempresa;
    }

    public MicroEmpresa update(String id, MicroEmpresa microempresa) {
        var existing = get(id);

        existing.setId(microempresa.getId());
        existing.setEmail(microempresa.getEmail());
        existing.setCnpj(microempresa.getCnpj());
        existing.setDataCadastro(microempresa.getDataCadastro());

        microempresaRepository.save(existing);

        return existing;
    }

    public MicroEmpresa get(String id) {
        var microempresa = microempresaRepository.findById(id);

        if (microempresa.isEmpty()) {
            throw new NotFoundException("MicroEmpresa com ID " + id + " não encontrado");
        }

        return microempresa.get();
    }

    public List<MicroEmpresa> getAll() {
        return microempresaRepository.findAll();
    }

    public void delete(String id) {
        get(id);
        microempresaRepository.deleteById(id);
    }
}
