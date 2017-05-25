/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.modval.cancelacionordenapp.services;

import co.edu.javeriana.aes.modval.cancelacionordenapp.entities.OrderEntity;
import co.edu.javeriana.aes.modval.cancelacionordenapp.repositories.OrderRepository;
import java.util.Optional;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebastianpacheco
 */
@Service
public class CancelarOrdenService {
    
    private Logger logger = LoggerFactory.getLogger(CancelarOrdenService.class);
    
    @Autowired
    DataSource dataSource;
    
    @Autowired
    private OrderRepository orderRepository;
    
    public void cancelarOrden(Integer orderId){
        logger.debug(String.format("Queried %d", orderId));
        OrderEntity orderEntity = orderRepository.findOne(orderId);
        Optional<OrderEntity> optional = Optional.ofNullable(orderEntity);
        if(optional.isPresent()){
            orderEntity.setOrderStatus("CANCELADA");
        }
        orderRepository.save(orderEntity);
    }
    
}
