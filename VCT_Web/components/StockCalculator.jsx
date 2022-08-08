import React from 'react';

const StockCalculator = ({ getCalcNum }) => {
  return (
    <div className="w-[450px] h-[400px] bg-gray-300 text-[30px] rounded-xl">
      <div className="flex w-full h-[100px]">
        <Number
          v={1}
          onClick={() => {
            getCalcNum(1);
          }}
        />
        <Number v={2} />
        <Number v={3} />
      </div>
      <div className="flex w-full h-[100px]">
        <Number v={4} />
        <Number v={5} />
        <Number v={6} />
      </div>
      <div className="flex w-full h-[100px]">
        <Number v={7} />
        <Number v={8} />
        <Number v={9} />
      </div>
      <div className="flex justify-center w-full h-[100px]">
        <div className="flex justify-center items-center w-[150px] cursor-pointer">
          <Number v={0} />
        </div>
      </div>
      <button className="w-[450px] h-[60px] bg-orange-600 rounded-[15px] text-white mt-[20px]">
        확인
      </button>
    </div>
  );
};

const Number = ({ v }) => {
  return (
    <div className="flex justify-center items-center w-[150px] cursor-pointer">
      {v}
    </div>
  );
};

export default StockCalculator;
