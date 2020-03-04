/*
 * Copyright (c) 2010, Oracle. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of Oracle nor the names of its contributors
 *   may be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.me.calculator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sortandmixmodel.SortAndMix;

    /**
     * Class connecting with database 
     * @version 6.0
     * @author Paulina Urbas
     */
@WebService()
public class CalculatorWS {
    /**
     * Persistance Context
     * @version 6.0
     * @author Paulina Urbas
     *
     */
    @PersistenceContext(unitName = "CalculatorAppPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    /**
     * Model class
     * @version 6.0
     * @author Paulina Urbas
     *
     */
    SortAndMix sortandmix = new SortAndMix(); 
    /**
     * Web service operation sorting and mixing sentence 
     * @version 6.0
     * @author Paulina Urbas
     * @param i
     * @param j
     * @return 
     *
     */
@WebMethod(operationName = "add")
 public String add(@WebParam(name = "i") String i, @WebParam(name = "j") String j) {
       sortandmix.setSentence(i);
       String outPutSentence = ""; 
       if(j.equals("Sort")){
            sortandmix.sortSentence();
            outPutSentence = sortandmix.getOutSentence();
       }
       else if(j.equals("Mix")){
            sortandmix.mixSentence();
           outPutSentence = sortandmix.getOutSentence();
       }
       else {
           outPutSentence = "Didn't choose operation!"; 
           return outPutSentence;
       }
       Data data = new Data();
       data.setId(0L);
       data.setSentenceBefore(i);
       data.setSentenceAfter(outPutSentence);
       this.persist(data);
       return outPutSentence;
 }
/**
     * Web service operation to select data from database
     * @version 6.0
     * @author Paulina Urbas
     *
*/
 @WebMethod(operationName = "history")
    public String History() {
        String out ="";
        List<Data> historyOfOperatoin=GetDataFromDataBase();
        for(Data data : historyOfOperatoin)
        {
           out += data.toString();
           out += "<br>";
        }
        return out;
 }
    
    
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    private List<Data> GetDataFromDataBase() {
       Query query = em.createQuery("SELECT d from Data d");
       return query.getResultList();
    }

}
