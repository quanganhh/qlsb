/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.payload;

import static com.apt.project4.constant.MessageKeys.REQUIRED_MSG;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author toanngo92
 */
public class ScPtichAddNewRequest {
    @NotBlank(message = REQUIRED_MSG)
    private String name;
    
    private String address;
    
    private String description;
    
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
