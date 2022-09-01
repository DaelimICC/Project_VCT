package com.daelimicc.server.vct.mg.chart.repository;

import com.daelimicc.server.vct.mg.chart.domain.RealTimeChart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RealTimeChartRepository extends MongoRepository<RealTimeChart, String> {
}
