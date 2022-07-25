// import {
//   VictoryBar,
//   VictoryChart,
//   VictoryAxis,
//   VictoryTheme,
//   VictoryStack,
//   VictoryCandlestick,
// } from 'victory';

// const data = [
//   {
//     x: new Date(2022, 7, 22),
//     open: 25580, //시가
//     close: 24940, //종가
//     high: 25600,
//     low: 24620, // 저가
//     volume: 110140, //거래량
//   },
//   {
//     x: new Date(2022, 7, 23),
//     open: 25580, //시가
//     close: 24940, //종가
//     high: 25600,
//     low: 24620, // 저가
//     volume: 110140, //거래량
//   },
//   {
//     x: new Date(2022, 7, 24),
//     open: 25580, //시가
//     close: 24940, //종가
//     high: 25600,
//     low: 24620, // 저가
//     volume: 110140, //거래량
//   },
//   {
//     x: new Date(2022, 7, 25),
//     open: 25580, //시가
//     close: 24940, //종가
//     high: 25600,
//     low: 24620, // 저가
//     volume: 110140, //거래량
//   },
//   {
//     x: new Date(2022, 7, 26),
//     open: 24620, //시가
//     close: 24680, //종가
//     high: 25160, // 고가
//     low: 24420, // 저가
//     volume: 1186755, //거래량
//   },
//   {
//     x: new Date(2022, 7, 27),
//     open: 24720, //시가
//     close: 24020, //종가
//     high: 24740, // 고가
//     low: 22360, // 저가
//     volume: 1313455, //거래량
//   },
//   {
//     x: new Date(2022, 7, 28),
//     open: 24720, //시가
//     close: 24020, //종가
//     high: 24740, // 고가
//     low: 22360, // 저가
//     volume: 1313455, //거래량
//   },
//   {
//     x: new Date(2022, 7, 29),
//     open: 24720, //시가
//     close: 24020, //종가
//     high: 24740, // 고가
//     low: 22360, // 저가
//     volume: 1313455, //거래량
//   },
//   {
//     x: new Date(2022, 7, 30),
//     open: 24720, //시가
//     close: 24020, //종가
//     high: 24740, // 고가
//     low: 22360, // 저가
//     volume: 1313455, //거래량
//   },
//   {
//     x: new Date(2022, 7, 31),
//     open: 24720, //시가
//     close: 24020, //종가
//     high: 24740, // 고가
//     low: 22360, // 저가
//     volume: 1313455, //거래량
//   },
// ];

// const CointChart = () => {
//   return (
//     <>
//       <VictoryChart
//         // width={00}
//         // height={300}
//         // theme={VictoryTheme.material}
//         domainPadding={{ x: 25 }}
//         scale={{ x: 'time' }}
//         // domain={{ y: [20000, 30000] }}
//       >
//         <VictoryCandlestick
//           candleRatio={1}
//           // candleWidth={50}
//           candleColors={{ positive: 'red', negative: 'blue' }}
//           data={data}
//           // domain={{ y: [20000, 30000] }}
//         />
//       </VictoryChart>
//     </>
//   );
// };

// export default CointChart;
import React, { useEffect, useState } from 'react';
import {
  VictoryChart,
  VictoryZoomContainer,
  VictoryLine,
  VictoryBrushContainer,
  VictoryAxis,
} from 'victory';

function CoinChart(props) {
  // const constructor = () => {
  //   super();
  //   this.state = {};
  // };
  const [state, setState] = useState(null);

  const handleZoom = (domain) => {
    // console.log(domain);
    setState(domain);
    // console.log(state);
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
  useEffect(() => {}, []);
  return (
    <div>
      <VictoryChart
        // width={550}
        // height={300}
        scale={{ x: 'time' }}
        containerComponent={
          <VictoryZoomContainer
            responsive={false}
            zoomDimension="x"
            zoomDomain={state}
            onZoomDomainChange={handleZoom.bind()}
          />
        }
      >
        <VictoryLine
          style={{
            data: { stroke: 'tomato' },
          }}
          data={[
            { x: new Date(1982, 1, 1), y: 125 },
            { x: new Date(1987, 1, 1), y: 257 },
            { x: new Date(1993, 1, 1), y: 345 },
            { x: new Date(1997, 1, 1), y: 515 },
            { x: new Date(2001, 1, 1), y: 132 },
            { x: new Date(2005, 1, 1), y: 305 },
            { x: new Date(2011, 1, 1), y: 270 },
            { x: new Date(2015, 1, 1), y: 470 },
          ]}
        />
      </VictoryChart>

      <VictoryChart
        // width={550}
        height={90}
        scale={{ x: 'time' }}
        padding={{ top: 0, left: 50, right: 50, bottom: 30 }}
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
          tickValues={[
            new Date(1985, 1, 1),
            new Date(1990, 1, 1),
            new Date(1995, 1, 1),
            new Date(2000, 1, 1),
            new Date(2005, 1, 1),
            new Date(2010, 1, 1),
            new Date(2015, 1, 1),
          ]}
          tickFormat={(x) => new Date(x).getFullYear()}
        />
        <VictoryLine
          style={{
            data: { stroke: 'tomato' },
          }}
          data={[
            { x: new Date(1982, 1, 1), y: 125 },
            { x: new Date(1987, 1, 1), y: 257 },
            { x: new Date(1993, 1, 1), y: 345 },
            { x: new Date(1997, 1, 1), y: 515 },
            { x: new Date(2001, 1, 1), y: 132 },
            { x: new Date(2005, 1, 1), y: 305 },
            { x: new Date(2011, 1, 1), y: 270 },
            { x: new Date(2015, 1, 1), y: 470 },
          ]}
        />
      </VictoryChart>
    </div>
  );
}

export default CoinChart;
