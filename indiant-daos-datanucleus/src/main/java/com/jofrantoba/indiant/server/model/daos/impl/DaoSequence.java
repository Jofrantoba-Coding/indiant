/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Sequence;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.model.jdo.daoentity.AbstractMongoJdoDao;
import com.jofrantoba.model.jdo.pmf.PMF;
import com.jofrantoba.model.jdo.shared.UnknownException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.jdo.PersistenceManager;
import lombok.extern.log4j.Log4j2;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jona
 */
@Log4j2
@Repository
public class DaoSequence extends AbstractMongoJdoDao<Sequence> 
        implements InterDaoSequence{
    JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();
    
    public DaoSequence(){
        super();
        setClazz(Sequence.class);
        this.setPmf(PMF.getClassPMF().getPMFStatic());
    }        

    @Override
    public Long getNextValueId(String idSequence)throws UnknownException{
        PersistenceManager pm=null;
        try{
        pm = this.getCurrentPm();
        MongoDatabase db=(MongoDatabase)pm.getDataStoreConnection().getNativeConnection();            
        MongoCollection<Document> collection = db.getCollection(clazz.getSimpleName());        
        Map<String,Bson> map=bsonUpdateNextValue(idSequence);
        Document oldVersion = collection.findOneAndUpdate(map.get("filter"), map.get("update"));
        //log.debug(oldVersion.toJson(prettyPrint));        
        return (Long)oldVersion.get("nextValue");
        }catch(Exception ex){
            throw throwsException(ex, true);
        }finally{
            closeConnection(pm);
        }
    }    

    private Map<String,Bson> bsonUpdateNextValue(String sequence){
        Bson filterBson = Filters.eq("_id", sequence);
        Bson update1 = Updates.inc("nextValue", 1);
        Bson update2 = Updates.set("version", (new Date()).getTime());
        Bson combineUpdates = Updates.combine(update1,update2);
        Map<String,Bson> map=new HashMap();
        map.put("filter", filterBson);
        map.put("update", combineUpdates);
        return map;
    }
    
}