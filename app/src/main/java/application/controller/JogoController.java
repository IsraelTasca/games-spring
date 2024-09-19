package application.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Jogo;
import application.model.Plataforma;
import application.repository.CategoriaRepository;
import application.repository.JogoRepository;
import application.repository.PlataformaRepository;

@Controller
@RequestMapping("/jogo")
public class JogoController {
    @Autowired
    private JogoRepository jogoRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Autowired
    private PlataformaRepository plataformaRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("jogos", jogoRepo.findAll());
        return "jogo/list"; // Verifique se o arquivo está em src/main/resources/templates/jogo/list.html
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("categorias", categoriaRepo.findAll());
        model.addAttribute("plataformas", plataformaRepo.findAll());
        return "jogo/insert"; // Verifique se o arquivo está em src/main/resources/templates/jogo/insert.html
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("categoria") long idCategoria,
        @RequestParam("plataformas") long[] idsPlataformas) {

        Jogo jogo = new Jogo();
        jogo.setTitulo(titulo);
        
        // Verificar se a categoria existe
        categoriaRepo.findById(idCategoria).ifPresent(jogo::setCategoria);

        Set<Plataforma> plataformas = new HashSet<>();
        for (long p : idsPlataformas) {
            plataformaRepo.findById(p).ifPresent(plataformas::add);
        }
        jogo.setPlataformas(plataformas);
        jogoRepo.save(jogo);
        return "redirect:/jogo/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model model) {
        Optional<Jogo> jogo = jogoRepo.findById(id);
        if (jogo.isPresent()) {
            model.addAttribute("jogo", jogo.get());
            model.addAttribute("categorias", categoriaRepo.findAll());
            model.addAttribute("plataformas", plataformaRepo.findAll());
            return "jogo/update"; // Verifique se o arquivo está em src/main/resources/templates/jogo/update.html
        }
        return "redirect:/jogo/list"; // Redireciona se o jogo não for encontrado
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("titulo") String titulo,
        @RequestParam("categoria") long idCategoria,
        @RequestParam("plataformas") long[] idsPlataformas) {

        Optional<Jogo> jogo = jogoRepo.findById(id);
        if (jogo.isPresent()) {
            Jogo jogoAtual = jogo.get();
            jogoAtual.setTitulo(titulo);
            categoriaRepo.findById(idCategoria).ifPresent(jogoAtual::setCategoria);

            Set<Plataforma> plataformas = new HashSet<>();
            for (long p : idsPlataformas) {
                plataformaRepo.findById(p).ifPresent(plataformas::add);
            }
            jogoAtual.setPlataformas(plataformas);
            jogoRepo.save(jogoAtual);
        }
        return "redirect:/jogo/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id, Model model) {
        Optional<Jogo> jogo = jogoRepo.findById(id);
        if (jogo.isPresent()) {
            model.addAttribute("jogo", jogo.get());
            return "jogo/delete"; // Verifique se o arquivo está em src/main/resources/templates/jogo/delete.html
        }
        return "redirect:/jogo/list"; // Redireciona se o jogo não for encontrado
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        jogoRepo.deleteById(id);
        return "redirect:/jogo/list";
    }
}
