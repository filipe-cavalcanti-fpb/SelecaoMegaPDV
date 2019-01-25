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
package br.com.lefi.markethere.jdbc.tests;

import br.com.lefi.markethere.jdbc.dao.UserEvaluateMarketDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserEvaluateMarketBean;
import java.util.Calendar;

/**
 *
 * @author assert
 */
public class UserEvaluationMarketDaoTest {
    public static void main(String[] args) {
        UserEvaluateMarketBean beanTest = new UserEvaluateMarketBean(1, 1, "essa porra de maxxi é uma bosta", Calendar.getInstance());
        new UserEvaluateMarketDao().add(beanTest);
    }
}
