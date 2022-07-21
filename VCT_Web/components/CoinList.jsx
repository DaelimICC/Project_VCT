import React from 'react';
import { StarIcon } from '@heroicons/react/solid';

const CoinList = () => {
  const testList = [
    {
      coinName: '옥수수',
      image: '🌽',
      currentPrice: 1500,
      range: 2.15,
    },
    {
      coinName: '오이',
      image: '🥒',
      currentPrice: 1200,
      range: 2.12,
    },
    {
      coinName: '토마토',
      image: '🍅',
      currentPrice: 2200,
      range: 1.92,
    },
    {
      coinName: '당근',
      image: '🥕',
      currentPrice: 1100,
      range: 1.79,
    },
    {
      coinName: '고구마',
      image: '🍠',
      currentPrice: 900,
      range: -1.66,
    },
  ];
  return (
    <>
      {testList.map((v, i) => {
        return (
          <div className="flex w-full border border-red-600 px-3" key={i}>
            <h3 className="flex p-3 justify-center items-center font-bold">
              {i + 1}
            </h3>
            <div className="flex w-full justify-between">
              <div className="flex">
                <div className="flex justify-center items-center ">
                  <div className="w-[40px] h-[40px] flex p-3 justify-center items-center rounded-full bg-yellow-100">
                    {v.image}
                  </div>
                </div>
                <div className="flex flex-col p-3 justify-center items-left">
                  <h3 className="font-bold">{v.coinName}</h3>
                  <h5 className="text-gray-500">
                    {v.currentPrice.toLocaleString()}원
                    <span
                      className={`${
                        v.range > 0 ? 'text-red-600' : 'text-blue-600'
                      } font-bold`}
                    >
                      {v.range > 0 && '+'}
                      {v.range}%
                    </span>
                  </h5>
                </div>
              </div>
              <div className="flex items-center">
                <StarIcon className="w-[20px] h-[20px]" />
              </div>
            </div>
          </div>
        );
      })}
    </>
  );
};

export default CoinList;
