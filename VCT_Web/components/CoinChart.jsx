import React, { useEffect, useState } from 'react';
import {
  VictoryChart,
  VictoryZoomContainer,
  VictoryLine,
  VictoryBrushContainer,
  VictoryAxis,
  VictoryCandlestick,
  VictoryBar,
} from 'victory';

function CoinChart(props) {
  const [state, setState] = useState();

  const handleZoom = (domain) => {
    setState({ x: domain.x });
  };

  const handleBrush = (domain) => {
    setState({ x: domain.x });
  };

  const data = [
    {
      x: new Date(2022, 7, 22),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 110140, //거래량
    },
    {
      x: new Date(2022, 7, 23),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 110140, //거래량
    },
    {
      x: new Date(2022, 7, 24),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 110140, //거래량
    },
    {
      x: new Date(2022, 7, 25),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 110140, //거래량
    },
    {
      x: new Date(2022, 7, 26),
      open: 24620, //시가
      close: 24680, //종가
      high: 25160, // 고가
      low: 24420, // 저가
      volume: 1186755, //거래량
    },
    {
      x: new Date(2022, 7, 27),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 1313455, //거래량
    },
    {
      x: new Date(2022, 7, 28),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 1313455, //거래량
    },
    {
      x: new Date(2022, 7, 29),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 1313455, //거래량
    },
    {
      x: new Date(2022, 7, 30),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 1313455, //거래량
    },
    {
      x: new Date(2022, 7, 31),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 1313455, //거래량
    },
  ];
  return (
    <div>
      <VictoryChart
        scale={{ x: 'time' }}
        domainPadding={{ x: 25 }}
        containerComponent={
          <VictoryZoomContainer
            responsive={false}
            zoomDimension="x"
            zoomDomain={state}
            onZoomDomainChange={handleZoom.bind()}
          />
        }
      >
        <VictoryCandlestick
          candleRatio={1}
          candleColors={{ positive: 'red', negative: 'blue' }}
          data={data}
        />
      </VictoryChart>

      <VictoryChart
        height={90}
        scale={{ x: 'time' }}
        padding={{ top: 0, left: 50, right: 50, bottom: 30 }}
        domainPadding={{ x: 25 }}
        containerComponent={
          <VictoryBrushContainer
            responsive={false}
            brushDimension="x"
            brushDomain={state}
            onBrushDomainChange={handleBrush.bind()}
          />
        }
      >
        <VictoryAxis tickValues={data.x} tickFormat={data.x} />
        <VictoryBar
          style={{ data: { fill: '#c43a31' } }}
          data={data}
          barRatio={1}
          x="x"
          y="volume"
        />
      </VictoryChart>
    </div>
  );
}

export default CoinChart;
