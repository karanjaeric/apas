/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.ui;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ekaranja
 */
@Service
public class CarImpl implements CarDao  {

    @Override
    public List<String> getCarDetails() {
        List<String> cars = new ArrayList<>();

		cars.add(0, "Santro");
		cars.add(1, "Zen");
		cars.add(2, "Alto");
		cars.add(3, "Qualis");
		cars.add(4, "Innova");

		for (String c : cars) {
			System.out.println(c);
		}

		return cars;
        
        
    }
    
}
