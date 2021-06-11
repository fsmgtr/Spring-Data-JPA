package Projeto.SpringData;

import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Projeto.SpringData.dao.InterfaceSpringDataUser;
import Projeto.SpringData.dao.InterfaceTel;
import Projeto.SpringData.model.Telefone;
import Projeto.SpringData.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class appSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceUser;
	@Autowired
	private InterfaceTel interTel;
 
	@Ignore
	@Test
	public void testInsert() {
		Usuario u = new Usuario();

		u.setEmail("@hotmail");
		u.setIdade(28);
		u.setLogin("adm");
		u.setNome("filipe");
		u.setSenha("156734569");

		interfaceUser.save(u);

		//System.out.println("Usuarios" + interfaceUser.count());

	}

	@Ignore
	@Test
	public void consulta() {

		Optional<Usuario> usuario = interfaceUser.findById(1L);

		System.out.println(usuario.get().getNome());
		
		
		for (Telefone telefone : usuario.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			
		}
	}

	@Ignore
	@Test
	public void consultaTodos() {

		Iterable<Usuario> lista = interfaceUser.findAll();

		for (Usuario usuario : lista) {

			System.out.println(usuario.getId());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getIdade());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNome());
			System.out.println(usuario.getSenha());
			System.out.println("- -- - - - - - - -- - - - - - - - --");

		}

	}

	@Ignore
	@Test
	public void editU() {

		Optional<Usuario> user = interfaceUser.findById(1L);

		Usuario data = user.get();
		data.setNome("ALTERADOOOOOO 2222");
		interfaceUser.save(data);

	}
	
	@Ignore
	@Test
	public void delet() {
		interfaceUser.deleteById(4L);
		
	}
	
	@Ignore
	@Test
	public void delet2() {
		
		Optional<Usuario> u1 = interfaceUser.findById(3L);
		
		if(!u1.isEmpty()) {
			interfaceUser.delete(u1.get());
		} else {
			System.out.println("Não existe esse registro...");
		}
		
	}
	
	@Ignore
	@Test
	public void consultaCustomN() {
		
		List<Usuario> list = interfaceUser.buscaPorNome("filipe");
		
		for (Usuario usuario : list) {
			
			System.out.println(usuario.getId());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getIdade());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNome());
			System.out.println(usuario.getSenha());
			System.out.println("- -- - - - - - - -- - - - - - - - --");
			
		}
		
	}
	
	@Ignore
	@Test
	public void consultaCustomParametro() {
		
		
		Usuario usuario1 = interfaceUser.buscaPorNomeParametro("ALTERADOOOOOO");
		
	 
			
			System.out.println(usuario1.getId());
			System.out.println(usuario1.getEmail());
			System.out.println(usuario1.getIdade());
			System.out.println(usuario1.getLogin());
			System.out.println(usuario1.getNome());
			System.out.println(usuario1.getSenha());
			System.out.println("- -- - - - - - - -- - - - - - - - --");
		 
		
	}
	
	@Ignore
	@Test
	public void deletePorName() {
		interfaceUser.deletePorNome("filipe");
	}
	
	@Test
	@Ignore
	public void editarEmailPorNome() {
		interfaceUser.updateEmailPorNome("Filipe@dominioADMI.com.br", "ALTERADOOOOOO");
	}
	
	@Ignore
	@Test
	public void inserTel() {
	Optional<Usuario> usi = interfaceUser.findById(1L);
		
		Telefone t = new Telefone();
		t.setNumero("7199999999");
		t.setTipo("Numero maluco");
		t.setUsuario(usi.get());
		interTel.save(t);
		 
		
	}
	
	

}
