package arthurtavares.dev.microcompany.domain.repository;

import arthurtavares.dev.microcompany.domain.entity.MicroCompany;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MicroCompanyRepository extends MongoRepository<MicroCompany, String> { }
