package arthurtavares.dev.microempresa.domain.repository;

import arthurtavares.dev.microempresa.domain.entity.MicroEmpresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MicroEmpresaRepository extends MongoRepository<MicroEmpresa, String> { }
