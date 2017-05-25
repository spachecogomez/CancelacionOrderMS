/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.modval.cancelacionordenapp.controllers;

import co.edu.javeriana.aes.modval.cancelacionordenapp.services.CancelarOrdenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebastianpacheco
 */
@RestController
public class CancelarOrderController {
    
    private Logger logger = LoggerFactory.getLogger(CancelarOrderController.class);
    
    @Autowired
    private CancelarOrdenService cancelarOrdenService;
    
    @RequestMapping(method = RequestMethod.GET, path = "/cancelar/{id}")
    public void test(@PathVariable Integer id){
        logger.debug(String.format("Id received %d", id));
        cancelarOrdenService.cancelarOrden(id);
    }
    
}
