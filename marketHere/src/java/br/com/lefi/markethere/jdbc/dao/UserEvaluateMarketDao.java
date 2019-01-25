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
package br.com.lefi.markethere.jdbc.dao;

import br.com.lefi.markethere.jdbc.dao.javaBean.UserEvaluateMarketBean;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author assert
 */
public class UserEvaluateMarketDao extends AbastractDao{
    private String sqlInsert = "insert into markethere_sch1.user_evaluate_market"
            + "(fk_id_user, fk_id_market, evaluation, date_evaluation) values (?,?,?,?);";
    
    public UserEvaluateMarketDao(){
        super();
    }
    
    public void add(UserEvaluateMarketBean userEvaluateMarketBeanObject){
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(sqlInsert);
            super.sqlCompiler.setInt(1, userEvaluateMarketBeanObject.getFkIdUser());
            super.sqlCompiler.setInt(2, userEvaluateMarketBeanObject.getFkIdMarket());
            super.sqlCompiler.setString(3, userEvaluateMarketBeanObject.getEvaluation());
            super.sqlCompiler.setDate(4, new Date(userEvaluateMarketBeanObject.getDataEvaluation().getTimeInMillis()));
            super.sqlCompiler.execute();
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "Error in insert UserEvaluateMarket on database");
        }
    }
    
}
