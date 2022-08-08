import { useState } from 'react';
import CoinList from '../components/CoinList';
import Nav from '../components/layout/nav';
import { ChevronUpIcon, ChevronDownIcon } from '@heroicons/react/outline';
import StockCalculator from '../components/StockCalculator';

const Order = () => {
  const [stock, setStock] = useState(1);
  const [stockPrice, setStockPrice] = useState(0);

  const getStock = (currentStock) => {
    setStockPrice(currentStock * stock);
  };

  const getCalcNum = (currNum) => {
    let copyStock = stock;
    copyStock.push(currNum);
    console.log(copyStock);
    setStock(copyStock);
  };

  const onIncrease = () => {
    const copyStock = stock;
    copyStock += 1;
    setStock(copyStock);
  };

  const onDecrease = () => {
    const copyStock = stock;
    copyStock > 1 ? setStock((copyStock -= 1)) : setStock(copyStock);
  };

  return (
    <>
      <Nav title="주문" />
      <div className="flex flex-col justify-center items-center">
        <h2 className="font-bold my-[15px]">시장가 주문</h2>
        <div className="flex flex-col">
          <div className="flex flex-col items-center">
            <div>
              <CoinList getStock={getStock} stock={stock} />
            </div>
            <div className="flex flex-col justify-center items-center my-[15px]">
              <div className="flex justify-center">
                <h1>{stock}</h1>
                <h1 className="ml-[5px]">주</h1>
                <div className="flex flex-col justify-center ml-[10px]">
                  <ChevronUpIcon
                    className="w-[15px] h-[15px] cursor-pointer"
                    onClick={() => {
                      onIncrease();
                    }}
                  />
                  <ChevronDownIcon
                    className="w-[15px] h-[15px] cursor-pointer"
                    onClick={() => {
                      onDecrease();
                    }}
                  />
                </div>
              </div>
              <h2>{stockPrice.toLocaleString()}원</h2>
            </div>
          </div>
          <StockCalculator getCalcNum={getCalcNum} />
        </div>
      </div>
    </>
  );
};

export default Order;
