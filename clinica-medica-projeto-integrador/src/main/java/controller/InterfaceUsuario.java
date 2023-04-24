package controller;

import model.Usuario;

public interface InterfaceUsuario {

	public boolean inserirUsuario(Usuario usuario);
	
	public boolean deletarUsuario(Usuario usuario);
	 
	public boolean alterarUsuario(Usuario usuario);
	
	public boolean consultarUsuarioCadastrado(Usuario usuarioModelo);
	
	public Usuario selecionarUSuarioParaCadastrar(Usuario usuarioModelo);
	
	public Usuario consultarUsuario(Long id);
}
