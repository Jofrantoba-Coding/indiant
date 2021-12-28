/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.service;

import com.jofrantoba.indiant.server.model.beans.Colony;
import com.jofrantoba.indiant.server.model.beans.ColonyInterest;
import com.jofrantoba.indiant.server.model.beans.UserInterest;
import com.jofrantoba.indiant.server.model.daos.impl.DaoColony;
import com.jofrantoba.indiant.server.model.daos.impl.DaoUser;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoColony;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoUser;
import com.jofrantoba.indiant.spark.beans.Count;
import com.jofrantoba.indiant.spark.beans.Word;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.RelationalGroupedDataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.col;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author jona
 */
@Log4j2
@Service
public class ServiceCreateColony implements InterServiceCreateColony{
    
    @Autowired
    private SparkSession sparkSession;   

    @Override
    public ResponseEntity<String> taskCreateColony(Long idColony) {
        try{
        //sparkSession.sql("drop view IF EXISTS data_interest_colony");
        //sparkSession.sql("drop view IF EXISTS data_interest_user");
        sparkSession.catalog().dropTempView("data_interest_colony");
        sparkSession.catalog().dropTempView("data_interest_user");
        InterDaoColony daoColony=getDaoColony();
        Colony colony=daoColony.find(idColony);
        List<ColonyInterest> listaColonyInterest=new ArrayList(colony.getColonyInterest());
        Dataset<Row> datasetColonyInterest =sparkSession.createDataFrame(listaColonyInterest, ColonyInterest.class);               
        //log.info(datasetColonyInterest.count());
        log.info("Leyendo tabla de interes de colonia");
        datasetColonyInterest.show(1, false);  
        Dataset<Row> interestColony=datasetColonyInterest.select(datasetColonyInterest.col("interest"));
        //log.info(interestColony.count());
        interestColony.show(1, false);                        
        daoColony.closePm();
        datasetColonyInterest.createTempView("data_interest_colony");
        Dataset<Row> dataInterestColony=sparkSession.sql("select interest._id  from data_interest_colony");
        //log.info(dataInterestColony.count());
        dataInterestColony.show(1, false);         

        InterDaoUser daoUser=getDaoUser();
        List<UserInterest> listaUserInterest=new ArrayList(daoUser.find(colony.getCreaterIdUser()).getUserInterest());
        Dataset<Row> datasetUserInterest =sparkSession.createDataFrame(listaUserInterest, UserInterest.class);
        //log.info(datasetUserInterest.count());
        log.info("Leyendo tabla de interes de usuario");
        datasetUserInterest.show(1, false);                
        Dataset<Row> interestUser=datasetUserInterest.select(datasetUserInterest.col("interest"));                
        //log.info(interestUser.count());
        interestUser.show(1, false);                        
        daoUser.closePm();        
        datasetUserInterest.createTempView("data_interest_user");               
        
        Dataset<Row> dataInterestUser=sparkSession.sql("select interest._id  from data_interest_user");
        //log.info(dataInterestUser.count());
        dataInterestUser.show(1, false);
        
        /*Empieza algoritmo indiant*/        
        
        Dataset<Row> dataUser=sparkSession.sql("select data_interest_user._id,data_interest_colony.interest,coalesce(data_interest_user.fashionValue,0)+1 as fashionValue, case when data_interest_user._id is null then 'insert' else 'update' end as dmlOperation from data_interest_colony left join data_interest_user on data_interest_colony.interest._id=data_interest_user.interest._id");
        //dataUser.show(1, false);
        log.info("Tabla para actualizar intereses de usuario");
                
        
        Dataset<Row> dataMember=sparkSession.sql("select data_interest_colony.idColony,data_interest_colony.interest,1 as fashionValue, 'insert'as dmlOperation from data_interest_colony");
        //dataMember.show(1, false);
        log.info("Tabla para crear miembro de colonia");
        sparkSession.catalog().dropTempView("data_interest_colony");
        sparkSession.catalog().dropTempView("data_interest_user");
        log.info("FIN DE TAREA SPARK");
        //sparkSession.sql("drop view data_interest_colony");
        //sparkSession.sql("drop view data_interest_user");
        return new ResponseEntity<>("Background create colony:", HttpStatus.OK);        
        }catch(Exception ex){
            return new ResponseEntity<>("Fail create colony"+ex.getLocalizedMessage(), HttpStatus.OK);        
        }
    }   
    @Override
    public List<Count> count() {
        String input = "hello world hello hello hello";
        String[] _words = input.split(" ");
        List<Word> words = Arrays.stream(_words).map(Word::new).collect(Collectors.toList());
        Dataset<Row> dataFrame = sparkSession.createDataFrame(words, Word.class);
        dataFrame.show();
        //StructType structType = dataFrame.schema();

        RelationalGroupedDataset groupedDataset = dataFrame.groupBy(col("word"));
        groupedDataset.count().show();
        List<Row> rows = groupedDataset.count().collectAsList();//JavaConversions.asScalaBuffer(words)).count();
        return rows.stream().map(new Function<Row, Count>() {
            @Override
            public Count apply(Row row) {
                return new Count(row.getString(0), row.getLong(1));
            }
        }).collect(Collectors.toList());
    }
    
    @Bean
    private InterDaoColony getDaoColony(){
        InterDaoColony dao=new DaoColony();
        return dao;
    }
    
    @Bean
    private InterDaoUser getDaoUser(){
        InterDaoUser dao=new DaoUser();
        return dao;
    }
        
    
}
