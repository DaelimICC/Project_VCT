package com.daelimicc.server.vct.mg.chart.repository;

import com.daelimicc.server.vct.mg.chart.domain.CandleChart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandleChartRepository extends MongoRepository<CandleChart, String> {


}
