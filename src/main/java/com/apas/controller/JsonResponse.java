/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.controller;

import com.apas.model.PasMember;
import java.util.List;

/**
 *
 * @author ekaranja
 */
public class JsonResponse {
    private List<PasMember> data;
    private int totalCount;

    public List<PasMember> getData() {
        return data;
    }

    public void setData(List<PasMember> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    
    
}
