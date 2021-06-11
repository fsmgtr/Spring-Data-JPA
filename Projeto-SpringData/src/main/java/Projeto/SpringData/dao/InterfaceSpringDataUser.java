package Projeto.SpringData.dao;

import java.util.List;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Projeto.SpringData.model.Usuario;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<Usuario, Long> {

	//Querys customizadas....
	//buscando onde tiver/conter o nome
	
	 @Lock(LockModeType.READ)//Não deixa atualiza duas pessoas ao mesmo tempo
	@Query(value = "select p from Usuario p Where p.nome like %?1%")
	public List<Usuario> buscaPorNome (String nome);
	
	@Query( value = "select p from Usuario p Where p.nome = :paranome")
	public Usuario buscaPorNomeParametro(@Param("paranome") String paranome);
	
	/*----------------------------------------------------------------------------*/
	
	//Delet's condicionais, por norme ou por e-mail.
	@Modifying
	@Transactional
	@Query( value = "DELETE FROM Usuario u WHERE u.nome = ?1")
	public void deletePorNome(String nome);
		
	/*----------------------------------------------------------------------------*/
	
	//update com condicional
	
	@Modifying
	@Transactional
	@Query( value = "UPDATE Usuario u set u.email = ?1 WHERE u.nome = ?2")
	public void updateEmailPorNome (String email, String nome);
	
	
}
