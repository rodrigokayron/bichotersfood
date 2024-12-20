package projeto.bichotersfood.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.bichotersfood.modelos.Usuario;
import projeto.bichotersfood.repositorios.UsuarioRepository;

@Controller
public class AuthController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}

	@PostMapping("/cadastro")
	public String cadastro(@ModelAttribute Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Usuario usuario, @RequestParam(required = false) String nomeFuncionario,
			Model model) {

		Usuario usuarioEncontrado = null;

		if (nomeFuncionario != null && !nomeFuncionario.isEmpty()) {
			usuarioEncontrado = usuarioRepository.findByNomeUsuario(nomeFuncionario);
			if (usuarioEncontrado != null && usuarioEncontrado.getPapel().equals("FUNCIONARIO")
					&& usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
				return "redirect:/dashboard";
			}
		} else {
			usuarioEncontrado = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario());
			if (usuarioEncontrado != null && usuarioEncontrado.getPapel().equals("USUARIO")
					&& usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
				return "redirect:/cardapio";
			}
		}

		model.addAttribute("erro", "Credenciais inválidas");
		return "login";
	}
}