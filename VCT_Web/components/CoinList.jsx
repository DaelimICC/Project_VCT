import React, { useState } from 'react';
import { StarIcon } from '@heroicons/react/solid';
import CoinData from '../pages/api/getData.json';
import CoinListBox from './common/CoinListBox';

const CoinList = ({ type, isToggle, pageType }) => {
  const [testList, setTsetList] = useState(CoinData);
  const [value, setValue] = useState(CoinData[0]);

  return (
    <>
      {pageType === 'Home' ? (
        testList
          .sort((a, b) => {
            return type === 'rise' ? b.range - a.range : a.range - b.range;
          })
          .filter((e) => {
            return type === 'rise' ? e.range > 0 : e.range < 0;
          })
          .map((v, i) => {
            let num = 0;
            if (isToggle === true) {
              num = 10;
            } else {
              num = 5;
            }
            if (i < num) {
              return (
                <div className="flex w-full mt-1 px-4" key={i}>
                  <h3 className="flex p-3 justify-center items-center font-bold">
                    {i + 1}
                  </h3>
                  <div className="flex w-full justify-between">
                    <div className="flex">
                      <div className="flex justify-center items-center ">
                        <div
                          className="w-[40px] h-[40px] flex p-3 justify-center items-center rounded-full"
                          style={{ backgroundColor: v.color }}
                        >
                          {/* {v.color} */}
                          {v.image}
                        </div>
                      </div>
                      <div className="flex flex-col p-3 justify-center items-left">
                        <h3 className="font-bold">{v.coinName}</h3>
                        <h5 className="text-gray-500">
                          {v.currentPrice.toLocaleString()}원
                          <span
                            className={`ml-[3px] ${
                              v.range > 0 ? 'text-red-600' : 'text-blue-600'
                            } font-bold`}
                          >
                            {v.range > 0 && '+'}
                            {v.range}%
                          </span>
                        </h5>
                      </div>
                    </div>
                    <div
                      className={`flex items-center text-gray-400 cursor-pointer ${
                        v.interests && 'text-black'
                      }  hover:text-black`}
                      // onClick={
                      //   () => {
                      //     setTsetList(() => {
                      //       const newData = [
                      //         {
                      //           ...testList,
                      //           [i]: {
                      //             ...v,
                      //             interests: true,
                      //           },
                      //         },
                      //       ];
                      //       return newData;
                      //     });
                      //   }
                      //   // setTsetList((pre) => {
                      //   //   return [{ ...pre, [i]: { interests: true } }];
                      //   // });
                      // }
                    >
                      <StarIcon className="w-[20px] h-[20px]" />
                    </div>
                  </div>
                </div>
              );
            }
          })
      ) : (
        <div className="flex w-full mt-1 px-4">
          <div className="flex w-full justify-between">
            <div className="flex">
              <div className="flex justify-center items-center ">
                <div
                  className="text-[30px] w-[60px] h-[60px] flex p-3 justify-center items-center rounded-full"
                  style={{ backgroundColor: value.color }}
                >
                  {value.image}
                </div>
              </div>
              <div className="flex flex-col p-3 justify-center items-left">
                <CoinListBox setValue={setValue} />
                <h5 className="text-gray-500">
                  {value.currentPrice.toLocaleString()}원
                  <span
                    className={`ml-[3px] ${
                      value.range > 0 ? 'text-red-600' : 'text-blue-600'
                    } font-bold`}
                  >
                    {value.range > 0 && '+'}
                    {value.range}%
                  </span>
                </h5>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default CoinList;
