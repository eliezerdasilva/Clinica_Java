package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;

public class loginDao implements InterfaceLogin {

	private Conexao con;

	@Override
	public Usuario consularLogin(Usuario usuario) {

		try {
			con = Conexao.getInstacia();
			Connection c = con.conectar();
			ResultSet rs = null;
			String query = "Select * from usuario where login = ? and senha ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, usuario.getUsuario());
			stm.setString(2, usuario.getSenha());

			ResultSet rss = stm.executeQuery();

			while (rss.next()) {

				int id = rss.getInt("idusuario");
				String login = rss.getString("usuario");
				String senha = rss.getString("senha");
				int nivel = rss.getInt("tipo_usuario");

				usuario.setUsuario(login);
				usuario.setId(id);
				usuario.setSenha(senha);
				usuario.setNivelAcesso(nivel);

				return usuario;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			con.fecharConexao();

		}
		return null;

	}

	@Override
	public Boolean preenchido(Usuario usuario) {

		if (usuario.getUsuario() != null && usuario.getSenha() != null) {

			return true;
		} else {
			return false;
		}

	}

}
