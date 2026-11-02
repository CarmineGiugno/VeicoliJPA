package com.betacom.veicoliJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoliJPA.dto.input.BiciReq;
import com.betacom.veicoliJPA.dto.input.MacchinaReq;
import com.betacom.veicoliJPA.dto.input.MotoReq;
import com.betacom.veicoliJPA.dto.input.ValidationGroup.Create;
import com.betacom.veicoliJPA.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA.exceptions.VeicoloException;
import com.betacom.veicoliJPA.services.interfaces.IVeicoloServices;

@RestController
@RequestMapping("/veicoli")
public class VeicoloController {
	
	@Autowired
	private IVeicoloServices veicoloS;
	
	@PostMapping("/macchina")
	public VeicoloDTO createMacchina(@RequestBody @Validated(Create.class) MacchinaReq req) throws VeicoloException {
		return veicoloS.createMacchina(req);
	}
	
	@PostMapping("/moto")
	public VeicoloDTO createMoto(@RequestBody @Validated(Create.class) MotoReq req) throws VeicoloException {
		return veicoloS.createMoto(req);
	}
	
	@PostMapping("/bici")
	public VeicoloDTO createBici(@RequestBody @Validated(Create.class) BiciReq req) throws VeicoloException {
		return veicoloS.createBici(req);
	}

	@GetMapping("/{id}")
	public VeicoloDTO getById(@PathVariable Integer id) throws VeicoloException {
		return veicoloS.getById(id);
	}
	
	@GetMapping("/list")
	public List<VeicoloDTO> listAll() {
		return veicoloS.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws VeicoloException {
		veicoloS.delete(id);
	}
}
