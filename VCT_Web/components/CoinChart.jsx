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
  // const constructor = () => {
  //   super();
  //   this.state = {};
  // };
  const [state, setState] = useState();

  const handleZoom = (domain) => {
    setState(domain);
  };

  const handleBrush = (domain) => {
    setState(domain);
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
  // console.log(new Date(2022, 7, 25));
  // useEffect(() => {}, []);
  return (
    <div>
      <VictoryChart
        // width={550}
        // height={300}
        scale={{ x: 'time' }}
        domainPadding={{ x: 25 }}
        // padding={{ top: 0, left: 50, right: 50, bottom: 30 }}
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
          // candleWidth={20}
          candleColors={{ positive: 'red', negative: 'blue' }}
          data={data}
          // candleWidth={({ index }) => index * 2 + 8}
          // domain={{ y: [20000, 30000] }}
        />
      </VictoryChart>

      <VictoryChart
        // width={550}
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
        <VictoryAxis
          tickValues={data.x}
          // padding={{ right: 200 }}
          tickFormat={data.x}
          // tickFormat={(x) => new Date(x).getFullYear()}
          // style={{ tickLabels: { padding: 5, fontSize: 12 } }}
        />
        <VictoryBar
          // barRatio={0.8}
          style={{ data: { fill: '#c43a31' } }}
          data={data}
          barRatio={1}
          // barWidth={20}
          // padding={{ right: 50 }}
          x="x"
          y="volume"
          // alignment="start"
        />
      </VictoryChart>
    </div>
  );
}

export default CoinChart;
