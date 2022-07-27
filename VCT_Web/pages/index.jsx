import Head from 'next/head';
import Image from 'next/image';
import Header from '../components/layout/header';
import Nav from '../components/layout/nav';
import VegeIssue from '../components/vegeIssue';
import styles from '../styles/Home.module.css';
import CoinList from '../components/CoinList';
import { useEffect, useState } from 'react';

export default function Home() {
  const titleList = [
    { id: 0, title: '급상승', type: 'rise' },
    { id: 1, title: '급하락', type: 'fall' },
    // { id: 2, title: '거래량', type: 'voulme' },
  ];
  const [value, setValue] = useState(titleList[0].type);
  const [isToggle, setIsToggle] = useState(false);

  return (
    <div className="pb-[65px] bg-gray-100">
      <Nav
        title={titleList}
        defaultType={value}
        setValue={setValue}
        setIsToggle={setIsToggle}
      />
      <div className="border-b border-gray-400 bg-white  divide-y divide-slate-200">
        <CoinList type={value} isToggle={isToggle} />
      </div>
      <div
        className="flex justify-center items-center bg-white h-[50px] mb-[20px] cursor-pointer active:opacity-60"
        onClick={() => {
          setIsToggle(!isToggle);
        }}
      >
        <h3 className="text-orange-500">
          {isToggle === false ? '더보기' : '▲'}
        </h3>
      </div>
      <VegeIssue />
    </div>
  );
}
