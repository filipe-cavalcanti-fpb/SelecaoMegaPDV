/*
 * Copyright (C) 2018 assert
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

import java.util.Calendar;

/**
 *
 * @author assert
 */
public class UserEvaluateMarketBean extends AbstractBeanObject{
    private int fkIdUser;
    private int fkIdMarket;
    private String evaluation;
    private Calendar dataEvaluation;

    public UserEvaluateMarketBean(int fkIdUser, int fkIdMarket, String evaluation, Calendar dataEvaluation) {
        this.fkIdUser = fkIdUser;
        this.fkIdMarket = fkIdMarket;
        this.evaluation = evaluation;
        this.dataEvaluation = dataEvaluation;
    }
    
    public UserEvaluateMarketBean(){
        
    }

    public int getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(int fkIdUser) {
        this.fkIdUser = fkIdUser;
    }

    public int getFkIdMarket() {
        return fkIdMarket;
    }

    public void setFkIdMarket(int fkIdMarket) {
        this.fkIdMarket = fkIdMarket;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Calendar getDataEvaluation() {
        return dataEvaluation;
    }

    public void setDataEvaluation(Calendar dataEvaluation) {
        this.dataEvaluation = dataEvaluation;
    }
    
    
}
