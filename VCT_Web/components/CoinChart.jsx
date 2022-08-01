import dynamic from 'next/dynamic';
import React, { useEffect, useState } from 'react';
// const Victorys = dynamic(
//   import('victory').then((mod) => mod.victory),
//   { ssr: false }
// );
import {
  VictoryChart,
  VictoryZoomContainer,
  VictoryLine,
  VictoryBrushContainer,
  VictoryAxis,
  VictoryCandlestick,
  VictoryBar,
  VictoryTooltip,
} from 'victory';

function CoinChart(props) {
  const [state, setState] = useState();

  const handleZoom = (domain) => {
    setState({ x: domain.x });
  };

  const handleBrush = (domain) => {
    setState({ x: domain.x });
  };
  // console.log(state);
  const data = [
    {
      x: new Date(2022, 7, 22),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 300140, //거래량
    },
    {
      x: new Date(2022, 7, 23),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 210140, //거래량
    },
    {
      x: new Date(2022, 7, 24),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 411140, //거래량
    },
    {
      x: new Date(2022, 7, 25),
      open: 25580, //시가
      close: 24940, //종가
      high: 25600,
      low: 24620, // 저가
      volume: 109140, //거래량
    },
    {
      x: new Date(2022, 7, 26),
      open: 24620, //시가
      close: 24680, //종가
      high: 25160, // 고가
      low: 24420, // 저가
      volume: 986755, //거래량
    },
    {
      x: new Date(2022, 7, 27),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 713455, //거래량
    },
    {
      x: new Date(2022, 7, 28),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 1513455, //거래량
    },
    {
      x: new Date(2022, 7, 29),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 623455, //거래량
    },
    {
      x: new Date(2022, 7, 30),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 713455, //거래량
    },
    {
      x: new Date(2022, 7, 31),
      open: 24720, //시가
      close: 24020, //종가
      high: 24740, // 고가
      low: 22360, // 저가
      volume: 913455, //거래량
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
          candleColors={{ positive: '#df6050', negative: '#4c81eb' }}
          data={data}
          style={{
            data: {
              stroke: (d) => (d.close < d.open ? '#dd2c15' : '#0042c7'),
              strokeWidth: 2,
            },
          }}
          labels={({ datum }) =>
            `시가: ${datum.open}
            고가: ${datum.high}
            저가: ${datum.low}
            종가: ${datum.close}
            거래량: ${datum.volume}`
          }
          labelComponent={
            <VictoryTooltip
              // flyoutWidth={95}
              // flyoutHeight={35}
              // cornerRadius={10}
              // pointerLength={40}
              flyoutStyle={{
                stroke: '#868C97',
                strokeWidth: 2,
                fill: '#FFFFFF',
              }}
              style={{
                fill: '#868C97',
                fontSize: 12,
                fontWeight: 400,
                textAnchor: 'middle',
              }}
            />
          }
          events={[
            {
              target: 'data',
              eventHandlers: {
                onMouseOver: () => {
                  return [
                    {
                      target: 'data',
                      mutation: () => ({
                        style: {
                          fill: (d) =>
                            d.close < d.open ? '#dd2c15' : '#0042c7',
                          stroke: (d) =>
                            d.close < d.open ? '#dd2c15' : '#0042c7',
                          strokeWidth: 3,
                        },
                      }),
                    },
                    {
                      target: 'labels',
                      mutation: () => ({ active: true }),
                    },
                  ];
                },
                onMouseOut: () => {
                  return [
                    {
                      target: 'data',
                      mutation: () => {},
                    },
                    {
                      target: 'labels',
                      mutation: () => ({ active: false }),
                    },
                  ];
                },
              },
            },
          ]}
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
          style={{
            data: {
              fill: ({ datum }) =>
                datum.close > datum.open ? '#dd2c15' : '#0042c7',
            },
          }}
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
