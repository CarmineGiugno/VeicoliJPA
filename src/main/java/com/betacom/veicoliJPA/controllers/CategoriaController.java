package com.betacom.veicoliJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoliJPA.dto.input.CategoriaReq;
import com.betacom.veicoliJPA.dto.output.CategoriaDTO;
import com.betacom.veicoliJPA.exceptions.VeicoloException;
import com.betacom.veicoliJPA.services.interfaces.ICategoriaServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorie")
public class CategoriaController {

	@Autowired
	private ICategoriaServices categoriaS;

	@PostMapping("/create")
	public CategoriaDTO create(@RequestBody @Valid CategoriaReq req) throws VeicoloException {
		return categoriaS.create(req);
	}

	@GetMapping("/list")
	public List<CategoriaDTO> listAll() {
		return categoriaS.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws VeicoloException {
		categoriaS.delete(id);
	}
}
