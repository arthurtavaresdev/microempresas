package arthurtavares.dev.microcompany.service;

import arthurtavares.dev.microcompany.exception.NotFoundException;
import arthurtavares.dev.microcompany.domain.entity.MicroCompany;
import arthurtavares.dev.microcompany.domain.repository.MicroCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicroCompanyService {
    private final MicroCompanyRepository microCompanyRepository;

    public MicroCompanyService(MicroCompanyRepository microCompanyRepository){
        this.microCompanyRepository = microCompanyRepository;
    }

    public MicroCompany create(MicroCompany microcompany){
        microCompanyRepository.save(microcompany);
        return microcompany;
    }

    public MicroCompany update(String id, MicroCompany microcompany) {
        var existing = get(id);

        existing.setId(microcompany.getId());
        existing.setEmail(microcompany.getEmail());
        existing.setDocument(microcompany.getDocument());
        existing.setCreatedAt(microcompany.getCreatedAt());

        microCompanyRepository.save(existing);

        return existing;
    }

    public MicroCompany get(String id) {
        var microcompany = microCompanyRepository.findById(id);

        if (microcompany.isEmpty()) {
            throw new NotFoundException("MicroCompany com ID " + id + " não encontrado");
        }

        return microcompany.get();
    }

    public List<MicroCompany> getAll() {
        return microCompanyRepository.findAll();
    }

    public void delete(String id) {
        get(id);
        microCompanyRepository.deleteById(id);
    }
}
