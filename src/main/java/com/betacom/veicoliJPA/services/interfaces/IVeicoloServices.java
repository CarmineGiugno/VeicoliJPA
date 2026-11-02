package com.betacom.veicoliJPA.services.interfaces;

import java.util.List;

import com.betacom.veicoliJPA.dto.input.BiciReq;
import com.betacom.veicoliJPA.dto.input.MacchinaReq;
import com.betacom.veicoliJPA.dto.input.MotoReq;
import com.betacom.veicoliJPA.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA.exceptions.VeicoloException;

public interface IVeicoloServices {

	VeicoloDTO createMacchina(MacchinaReq req) throws VeicoloException;

	VeicoloDTO createMoto(MotoReq req) throws VeicoloException;

	VeicoloDTO createBici(BiciReq req) throws VeicoloException;

	void delete(Integer id) throws VeicoloException;

	VeicoloDTO getById(Integer id) throws VeicoloException;

	List<VeicoloDTO> listAll();
}
