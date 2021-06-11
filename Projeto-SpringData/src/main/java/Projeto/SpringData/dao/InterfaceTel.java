package Projeto.SpringData.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Projeto.SpringData.model.Telefone;

@Repository
public interface InterfaceTel extends CrudRepository<Telefone, Long>{

}
