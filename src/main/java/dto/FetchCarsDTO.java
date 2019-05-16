/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Cars;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import rest.RequestURL;

/**
 *
 * @author caspe
 */
public class FetchCarsDTO {
    
    RequestURL ru = new RequestURL();
    
    
    public List<CarsDTO> fetchedCars() throws InterruptedException, ExecutionException{
        
        List<String> ruList = ru.runParallelCharacters();
        for (String car : ruList) {
            Collection<Cars> cList =  new ArrayList();
            //cList.add(car);
            
        }
        
        
        return null;
    }
    
}
