package com.betacom.veicoliJPA.services.interfaces;

import java.util.List;

import com.betacom.veicoliJPA.dto.input.CategoriaReq;
import com.betacom.veicoliJPA.dto.output.CategoriaDTO;
import com.betacom.veicoliJPA.exceptions.VeicoloException;

public interface ICategoriaServices {

	CategoriaDTO create(CategoriaReq req) throws VeicoloException;

	List<CategoriaDTO> listAll();

	void delete(Integer id) throws VeicoloException;
}
